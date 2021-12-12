package hw08;

import java.time.LocalDateTime;

public class Link extends FSElement{


    private FSElement next;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime,FSElement next) {
        super(parent, name, creationTime, size);
        this.next = next;
        parent.appendChild(this);
    }

    public FSElement getNext() {
        return this.next;
    }

    @Override
    public Boolean isDirectory() {
        return false;
    }

}