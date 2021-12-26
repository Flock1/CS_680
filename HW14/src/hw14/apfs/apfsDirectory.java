package hw14.apfs;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDateTime;

import hw14.filesystem.*;

public class apfsDirectory extends apfsElement{
    
    private LinkedList<apfsElement> elements = new LinkedList<>();
    private LinkedList<apfsDirectory> directories = new LinkedList<>();
    private LinkedList<apfsFile> files = new LinkedList<>();

    public apfsDirectory(String name, apfsDirectory parent, int size, LocalDateTime creationTime, String owner, LocalDateTime lastModifiedTime) {
        super(parent, name, owner, creationTime, lastModifiedTime, size);
        if (parent != null) {
            parent.addChild(this);
        }
    }

	public LinkedList<apfsElement> getChildren() {
		Collections.sort(this.elements, (apfsElement e1, apfsElement e2) -> e1.getName().compareTo(e2.getName()));
        return this.elements;
	}

    public int countChildren() {
     int count = 0;
     for (apfsElement f: getChildren()) {
         count+=1;
         }   
     return count;
    }

    public void addChild(apfsElement child) {
        this.elements.add(child);
    }

    public LinkedList<apfsDirectory> getSubDirectories() {
        for(FSElement f: getChildren()) {
            if (f instanceof apfsDirectory) {
                this.directories.add((apfsDirectory) f);
            }
        }
		Collections.sort(directories, (apfsDirectory d1, apfsDirectory d2) -> d1.getName().compareTo(d2.getName()));
        return this.directories;
    }

    public LinkedList<apfsFile> getFiles() {
        for(FSElement f: getChildren()) {
            if (f instanceof apfsFile) {
                this.files.add((apfsFile) f);
            }
        }
        Collections.sort(files, (apfsFile f1, apfsFile f2) -> f1.getName().compareTo(f2.getName()));
        return this.files;
    }

    public LinkedList<apfsLink> getLinks() {
        LinkedList<apfsLink> links = new LinkedList<apfsLink>();
        for(FSElement f: getChildren()) {
            if (f instanceof apfsLink) {
                links.add((apfsLink) f);
            }
        }
        return links;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for(apfsElement f: getChildren()) {
            totalSize += f.getSize();
        }
        return totalSize;
    }

	public apfsDirectory findDirectory(String name) {
		apfsDirectory directory = null;
		if(name.equals(getName())) {
			directory = this;
		}
		else {
			for(apfsDirectory d: getSubDirectories()) {
				if(directory == null) {
					directory = d.findDirectory(name);
					if(name.equals(d.getName())) {
						directory = d;
						break;
					}
				}			
			}
		}
		return directory;
	}

    public apfsLink findLink(String name) {
		apfsLink link = null;
		for(apfsLink l : getLinks()) {
			if(name.equals(l.getName()))
				link = l;
		}
		if(link == null) {
			for(apfsDirectory dir : getSubDirectories()) {
				link = dir.findLink(name);
				if(link != null)
					break;
			}
		}
		return link;
	}

    public apfsFile findFile(String name) {
		apfsFile file = null;
		for(apfsFile f: getFiles()) {
			if(name.equals(f.getName())) {
				file = f;
			}
		}
		if(file == null) {
			for(apfsDirectory d: getSubDirectories()) {
				file = d.findFile(name);
				if(file != null) {
					break;
				}
			}
		}
		
		return file;
	}  


    public LinkedList<apfsElement> getChildren(Comparator<apfsElement> compare) {
		LinkedList<apfsElement> f = getChildren();
		Collections.sort(f, compare);
		return f;
	}

    public LinkedList<apfsFile> getFiles(Comparator<apfsElement> compare){
		LinkedList<apfsFile> f = getFiles();
		Collections.sort(f, compare);
		return f;
	}

    @Override
    public Boolean isDirectory() {
        // TODO Auto-generated method stub
        return true;
    }

}
