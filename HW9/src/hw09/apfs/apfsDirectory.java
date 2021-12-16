package hw09.apfs;

import java.util.LinkedList;
import java.time.LocalDateTime;

import hw09.filesystem.*;

public class apfsDirectory extends apfsElement{
    
    private LinkedList<apfsElement> elements = new LinkedList<apfsElement>();
    private LinkedList<apfsDirectory> directories = new LinkedList<apfsDirectory>();
    private LinkedList<apfsFile> files = new LinkedList<apfsFile>();

    public apfsDirectory(String name, apfsDirectory parent, int size, LocalDateTime creationTime, String owner, LocalDateTime lastModifiedTime) {
        super(parent, name, owner, creationTime, lastModifiedTime, size);
        if (parent != null) {
            parent.addChild(this);
        }
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

    public LinkedList<apfsElement> getChildren() {
        return this.elements;    
    }

    public LinkedList<apfsDirectory> getSubDirectories() {
        for(FSElement f: getChildren()) {
            if (f instanceof apfsDirectory) {
                this.directories.add((apfsDirectory) f);
            }
        }
        return this.directories;
    }

    public LinkedList<apfsFile> getFiles() {
        for(FSElement f: getChildren()) {
            if (f instanceof apfsFile) {
                this.files.add((apfsFile) f);
            }
        }
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
        for(apfsElement f: getChildren()) {
            if (f instanceof apfsDirectory) {
                if (f.getName().equals(name)) {
                    return (apfsDirectory) f;
                }
            }
        }
        return null;
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


    @Override
    public Boolean isDirectory() {
        // TODO Auto-generated method stub
        return true;
    }







}
