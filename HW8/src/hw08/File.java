package hw08;

import java.time.LocalDateTime;


public class File extends FSElement {

    public File(Directory parent, String name, int size, LocalDateTime creationDate) {
        super(parent, name, creationDate, size);
        parent.appendChild(this);
    }

    @Override
    public Boolean isDirectory() {
        return false;
    }
    
}
