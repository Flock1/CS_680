package hw7;

import java.time.LocalDateTime;

public abstract class FSElement {

    public String name;
    public int size;
    public LocalDateTime creationTime;
    public Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
        this.parent = parent;
    }

    public Directory getParent() {
        return parent;
    }

    public abstract Boolean isDirectory();
}
