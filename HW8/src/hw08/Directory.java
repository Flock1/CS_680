package hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;



public class Directory extends FSElement {
    private LinkedList<Directory> directories;
    private LinkedList<File> files;
    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, creationTime, size);
        if(parent != null) {
            parent.appendChild(this);
        }
    }

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }
    public void appendChild(FSElement element) {
        this.children.add(element);
    }
    public int countChildren() {
        int count = 0;
        for (FSElement f : this.children)
        {
                count+=1; // Directory counts as a file
            }
        return count;
    }

    public LinkedList<Directory> getSubDirectories() {

        for(FSElement f: this.children) {
            if(f instanceof Directory) {
                directories.add((Directory) f);
            }
        }
        return directories;
    }
    public LinkedList<File> getFiles() {
        return this.files;
    }

    public int getTotalSize() {
        int size = 0;
        for(FSElement f: getChildren()) {
            if(f instanceof Directory) {
                size += ((Directory) f).getTotalSize();
            }
        }
        return size;
    }

    @Override
    public Boolean isDirectory() {
        // TODO Auto-generated method stub
        if (this instanceof Directory) {
            return true;
        }
        return false;
    }
    
}


