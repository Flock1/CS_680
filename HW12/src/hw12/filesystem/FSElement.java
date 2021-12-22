package hw12.filesystem;


import java.time.LocalDateTime;
import hw12.apfs.apfsDirectory;

public abstract class FSElement {

    protected apfsDirectory parent;
    protected String name;
    protected LocalDateTime creationDate;
    protected int size;

    public FSElement(apfsDirectory parent, String name, int size, LocalDateTime creationDate) {
        this.name = name;
        this.parent = parent;
        this.size = size;
        this.creationDate = creationDate;
    }

    public apfsDirectory getParent() {
        return this.parent;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public LocalDateTime getCreationTime() {
        return this.creationDate;
    }
    
    
    public abstract Boolean isDirectory();
    
}
