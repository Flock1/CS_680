package hw08;


import java.time.LocalDateTime;

public abstract class FSElement {

    protected Directory parent;
    protected String name;
    protected LocalDateTime creationDate;
    protected int size;

    public FSElement(Directory parent, String name, LocalDateTime creationDate, int size) {
        this.name = name;
        this.parent = parent;
        this.size = size;
        this.creationDate = creationDate;
    }

    public Directory getParent() {
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
