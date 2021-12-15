package hw7;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class DirectoryTest {

	static LocalDateTime localTime = LocalDateTime.now();
	
	
		Directory root = new Directory(null,"root",0, localTime);
		Directory applications = new Directory(root,"applications",0, localTime);
		Directory home = new Directory(root,"home",0, localTime);
		Directory code = new Directory(home,"code",0, localTime);
		Directory pics = new Directory(home,"pics",0, localTime);
			
		File a = new File(applications,"a",1,localTime);
		File b = new File(home,"b",1,localTime);
		File c = new File(code,"c",1,localTime);
		File d = new File(code,"d",1,localTime);
		File e = new File(pics,"e",1,localTime);
		File f = new File(pics,"f",1,localTime);
		
	
	private String[] dirToStringArray(Directory d) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(d.getParent());
		String[] dirInfo = {Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString(), Integer.toString(d.countChildren()), Integer.toString(d.getTotalSize()), optionalDirectory.isPresent()?d.getParent().getName():null};
		return dirInfo; 
	}
	
	@Test
    public void verifyDirectoryEqualityHome() {
		String[] expected={"true","home","0",localTime.toString(),"3","5","root"};
        assertArrayEquals(expected,dirToStringArray(home));
    }
	@Test
	public void verifyDirectoryEqualityRoot() {
		String expected[] = {"true", "root", "0", localTime.toString(), "2", "6",null};
		assertArrayEquals(expected, dirToStringArray(root));
	}
	@Test
	public void verifyDirectoryEqualityApplications() {
		String expected[] = {"true", "applications", "0", localTime.toString(), "1", "1", "root"};
		assertArrayEquals(expected, dirToStringArray(applications));
	}
	
	@Test 
	public void verifyDirectoryEqualityCode() {
		String expected[] = {"true", "code", "0", localTime.toString(), "2", "2", "home"};
		assertArrayEquals(expected, dirToStringArray(code));
	}
	
	@Test
	public void verifyDirectoryEqualityPics() {
		String expected[] = {"true", "pics", "0", localTime.toString(), "2", "2", "home"};
		assertArrayEquals(expected, dirToStringArray(pics));
	}
	
	@Test
	public void DirectoryFileTest() {
		assertTrue(applications.isDirectory());
		assertFalse(a.isDirectory());
		assertTrue(root.isDirectory());
		assertTrue(home.isDirectory());
		assertTrue(code.isDirectory());
		assertFalse(b.isDirectory());
	}
	
	@Test
	public void subFilesAndFolderNumberTest() {
		assertEquals(2,root.countChildren());
		assertEquals(2,code.countChildren());
		assertEquals(1,applications.countChildren());
		assertEquals(3,home.countChildren());
		assertEquals(2,pics.countChildren());
	}
}