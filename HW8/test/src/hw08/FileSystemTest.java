package hw08;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class FileSystemTest {

    static LocalDateTime time = LocalDateTime.now();

    private String[] StringArray(Directory d){

        String data[] = {null, d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString()};
        return data;
    }

    @Test
    public void checkFileSystem() {
        FileSystem fs = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertEquals(fs, fs2);
    }

    @Test
    public void checkRoot() {
        LocalDateTime date = LocalDateTime.now();
        FileSystem fs = FileSystem.getFileSystem();
        Directory root = new Directory(null, "root",0, date);
        assertEquals(root.getName(), "root");
        assertEquals(root.getParent(), null);
        assertEquals(root.getSize(), 0);
        assertEquals(root.getCreationTime(), time);
    }


}
