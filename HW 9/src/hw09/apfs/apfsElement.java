package hw09.apfs;

import hw09.filesystem.*;
import java.time.LocalDateTime;

public abstract class apfsElement extends FSElement{

    protected String Currentname;
    protected LocalDateTime creationTime;
    private LocalDateTime lastModifiedTime;

    apfsElement(apfsDirectory parent, String name, String Currentname, LocalDateTime creationTime, LocalDateTime lastModifiedDate, int size) {
        
        super(parent, name, size, creationTime);
        this.Currentname = Currentname;
        this.lastModifiedTime = lastModifiedDate;
    }

    public String getCurrentname() {
        return this.Currentname;
    }

    public LocalDateTime lastModifiedTime() {
        return this.lastModifiedTime;
    }
    
    public abstract Boolean isDirectory();
    
}
