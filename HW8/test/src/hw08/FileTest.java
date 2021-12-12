package hw08;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;


public class FileTest {

    static LocalDateTime date = LocalDateTime.now();

    Directory root = new Directory(null, "root",0, date);
    Directory home = new Directory(root, "home",0, date);
    Directory code = new Directory(home, "code",0, date);
    Directory test = new Directory(code, "test",0, date);

    File file1 = new File(code, "file1", 10, date);
    File file2 = new File(home, "file2", 20, date);
    File file3 = new File(home, "file3", 30, date);
    File file4 = new File(test, "file4", 40, date);
    File file5 = new File(test, "file5", 50, date);

    private String[] dirToStringArray(Directory d) {
        String[] dirInfo = {Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString()};
        return dirInfo;
    }

    public String[] filetoStrings(File file) {
        String[] strings = {Boolean.toString(file.isDirectory()), file.getName(), Integer.toString(file.getSize()),
                file.getCreationTime().toString(), file.getParent().getName()};
        return strings;
    }

    @Test
    public void testFile() {
        assertArrayEquals(filetoStrings(file1), file1.toString().split(","));
        assertArrayEquals(filetoStrings(file2), file2.toString().split(","));
        assertArrayEquals(filetoStrings(file3), file3.toString().split(","));
        assertArrayEquals(filetoStrings(file4), file4.toString().split(","));
        assertArrayEquals(filetoStrings(file5), file5.toString().split(","));
    }

    @Test
    public void testDirectory() {
        assertArrayEquals(dirToStringArray(code), code.toString().split(","));
        assertArrayEquals(dirToStringArray(home), home.toString().split(","));
        assertArrayEquals(dirToStringArray(root), root.toString().split(","));
    }


}
