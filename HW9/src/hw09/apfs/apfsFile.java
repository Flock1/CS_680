package hw09.apfs;

import java.time.LocalDateTime;

public class apfsFile extends apfsElement{

    public apfsFile(apfsDirectory parent, String name, int size, LocalDateTime creationDate, String Currentname, LocalDateTime lastModifiedDate) {
        super(parent, name, Currentname, creationDate, lastModifiedDate, size);
        parent.addChild(this);
    }

    @Override
    public Boolean isDirectory() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
