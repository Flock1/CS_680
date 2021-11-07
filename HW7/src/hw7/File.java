package hw7;

import java.time.LocalDateTime;
public class File extends FSElement {
    
    public File(Directory parent, String name, int size, LocalDateTime lastModified) {
        super(parent, name, size, lastModified);
    } 

    @Override
    public Boolean isDirectory() {
        return false;
    }
}
