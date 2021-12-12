package hw08;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.TestClassOrder;

import org.junit.jupiter.api.Test;

public class LinkTest {
    
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

    Link link1 = new Link(home, "link1", 0, date, root);
    Link link2 = new Link(code, "link2", 0, date, file1);

    private String[] LinktoString(Link link) {
        Optional<Directory> parent = Optional.ofNullable(link.getParent());
        String[] result = {Boolean.toString(link.isDirectory()),
                           link.getName(),
                           Integer.toString(link.getSize()),
                           link.getCreationTime().toString()};
                           link.getName();
                        return result;
                        }

    @Test
    public void testLink() {
        assertEquals(true, link1.isDirectory());
        assertEquals("link1", link1.getName());
        assertEquals(0, link1.getSize());
        assertEquals(date.toString(), link1.getCreationTime().toString());
    }

    @Test
    public void testGetParent() {
        assertEquals(Optional.of(home), link1.getParent());
    }

    @Test
    public void testGetName() {
        assertEquals("link1", link1.getName());
    }    

}
