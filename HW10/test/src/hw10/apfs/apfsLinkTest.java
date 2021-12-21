package hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsLinkTest {
	
static LocalDateTime localTime = LocalDateTime.now();
	
	private String[] LinkToStringArray(apfsLink d) {
		String[] LinkInfo = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString(), 
				d.getParent().getName(), d.getCurrentname(),d.lastModifiedTime().toString(), d.getTarget().getName()};
		return LinkInfo;
	}
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		apfs FilesystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory)FilesystemApfs.initFS("root", 3500);
		apfsDirectory applications = new apfsDirectory("applications", root, 0, localTime, "sarvagya", localTime);
		apfsDirectory home = new apfsDirectory("home", root, 0, localTime, "sarvagya", localTime);
		apfsDirectory code = new apfsDirectory("code", home, 0, localTime, "sarvagya", localTime);
		apfsDirectory pics = new apfsDirectory("pics", home, 0, localTime, "sarvagya", localTime);
		apfsFile a = new apfsFile(applications, "a", 350, localTime, "sarvagya", localTime);
		apfsFile b = new apfsFile(home, "b", 700, localTime, "sarvagya", localTime);
		apfsFile c = new apfsFile(code, "c", 800, localTime, "sarvagya", localTime);
		apfsFile d = new apfsFile(code, "d", 80, localTime, "sarvagya", localTime);
		apfsFile e = new apfsFile(pics, "e", 700, localTime, "sarvagya", localTime);
		apfsFile f = new apfsFile(pics, "f", 870, localTime, "sarvagya", localTime);
		apfsLink x = new apfsLink(home, "x", 0, localTime, "sarvagya", localTime, applications);
		apfsLink y = new apfsLink(code, "y", 0, localTime, "sarvagya", localTime, a);
	}
	
	@Test
	public void verifyLinkEqualityX() {
		apfs fileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory) fileSystemApfs.getRoot();
		String[] expected = {"false", "x", "0", localTime.toString(), "home", "sarvagya", localTime.toString(), "applications"};
		apfsLink actual = root.findLink("x");
		assertArrayEquals(expected, LinkToStringArray(actual));
	}
	
	@Test
	public void verifyLinkEqualityY() {
		apfs fileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory) fileSystemApfs.getRoot();
		String[] expected = {"false", "y", "0", localTime.toString(), "code", "sarvagya", localTime.toString(), "a"};
		apfsLink actual = root.findLink("y");
		assertArrayEquals(expected, LinkToStringArray(actual));
	}
	
	@Test
	public void checkSizeOfTarget() {
		apfs fileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory) fileSystemApfs.getRoot();
		assertEquals(0, root.findLink("x").getTarget().getSize());
		assertEquals(350, root.findLink("y").getTarget().getSize());
	}
	
}