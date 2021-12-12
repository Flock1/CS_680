package hw08;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class DirectoryTest {

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

    private String[] FileToStringArray(File f) {
		String fileInfo[] = {Boolean.toString(f.isDirectory()), f.getName(), Integer.toString(f.getSize()), f.getCreationTime().toString(), f.getParent().getName()};
		return fileInfo;
	}

    @Test
    public void testDirectory() {
        assertEquals(dirToStringArray(root), new String[]{"true", "root", "0", date.toString()});
        assertEquals(dirToStringArray(home), new String[]{"true", "home", "0", date.toString()});
        assertEquals(dirToStringArray(code), new String[]{"true", "code", "0", date.toString()});
        assertEquals(dirToStringArray(test), new String[]{"true", "test", "0", date.toString()});
        assertEquals(FileToStringArray(file1), new String[]{"false", "file1", "10", date.toString()});
        assertEquals(FileToStringArray(file2), new String[]{"false", "file2", "20", date.toString()});
        assertEquals(FileToStringArray(file3), new String[]{"false", "file3", "30", date.toString()});
        assertEquals(FileToStringArray(file4), new String[]{"false", "file4", "40", date.toString()});
        assertEquals(FileToStringArray(file5), new String[]{"false", "file5", "50", date.toString()});
    }

    @Test
    public void DirectoryFileTest(){

        assertTrue(root.isDirectory());
        assertTrue(home.isDirectory());
        assertTrue(code.isDirectory());
        assertTrue(test.isDirectory());
        assertFalse(file1.isDirectory());
        assertFalse(file2.isDirectory());
        assertFalse(file3.isDirectory());
        assertFalse(file4.isDirectory());
        assertFalse(file5.isDirectory());
        
    }

    @Test
    public void testGetName() {
        assertEquals(root.getName(), "root");
        assertEquals(home.getName(), "home");
        assertEquals(code.getName(), "code");
        assertEquals(test.getName(), "test");
        assertEquals(file1.getName(), "file1");
        assertEquals(file2.getName(), "file2");
        assertEquals(file3.getName(), "file3");
        assertEquals(file4.getName(), "file4");
        assertEquals(file5.getName(), "file5");
    }
    
}
