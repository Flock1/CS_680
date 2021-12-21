package hw09.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;


class apfsTest {

    static LocalDateTime now = LocalDateTime.now();

    @Test
    public void testEqual(){

        apfs apfs1 = apfs.getAPFSFileSystem();
        apfs apfs2 = apfs.getAPFSFileSystem();

        assertEquals(apfs1, apfs2);
    }

    @Test
	public void capacityTest() {
		int expected = 3500;
		apfs FilesystemofApfs = apfs.getAPFSFileSystem();
		FilesystemofApfs.initFS("root", 3500);
		int actual = FilesystemofApfs.getCapacity();
		assertEquals(expected, actual);
	}



    
}
