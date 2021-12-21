package hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsDirectoryTest {

	static LocalDateTime localTime = LocalDateTime.now();
	
	private String[] dirToStringArray(apfsDirectory d) {
		Optional<apfsDirectory> optionalDirectory = Optional.ofNullable(d.getParent());
		String[] dirInfo = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString(), 
				optionalDirectory.isPresent()?d.getParent().getName():null, Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren()), d.getCurrentname(),d.lastModifiedTime().toString()};
		return dirInfo;
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
	}
	
	@Test
	public void isDirectoryTest() {
		apfs FilesystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory)FilesystemApfs.getRoot();
		assertTrue(root.isDirectory());
		assertTrue(root.findDirectory("home").isDirectory());
		assertTrue(root.findDirectory("applications").isDirectory());
		assertTrue(root.findDirectory("code").isDirectory());
		assertTrue(root.findDirectory("applications").isDirectory());
		assertTrue(root.findDirectory("pics").isDirectory());
		assertFalse(root.findFile("a").isDirectory());
		assertFalse(root.findFile("b").isDirectory());
		assertFalse(root.findFile("c").isDirectory());
		assertFalse(root.findFile("d").isDirectory());
		assertFalse(root.findFile("e").isDirectory());
		assertFalse(root.findFile("f").isDirectory());
	}
		
	@Test
	public void verifyApfsDirectoryEqualityHome() {
		apfs fileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory) fileSystemApfs.getRoot();
		String[] expected = {"true", "home", "0", localTime.toString(), "root", "3150", "4", "sarvagya", localTime.toString()};
		apfsDirectory actual = root.findDirectory("home");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	public void verifyApfsDirectoryEqualityApplications() {
		apfs fileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory) fileSystemApfs.getRoot();
		String[] expected = {"true", "applications", "0", localTime.toString(), "root", "350", "1", "sarvagya", localTime.toString()};
		apfsDirectory actual = root.findDirectory("applications");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	public void verifyApfsDirectoryEqualityCode() {
		apfs fileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory) fileSystemApfs.getRoot();
		String[] expected = {"true", "code", "0", localTime.toString(), "home", "880", "3", "sarvagya", localTime.toString()};
		apfsDirectory actual = root.findDirectory("code");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	public void verifyApfsDirectoryEqualityPics() {
		apfs fileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory) fileSystemApfs.getRoot();
		String[] expected = {"true", "pics", "0", localTime.toString(), "home", "1570", "2", "Shreyansh", localTime.toString()};
		apfsDirectory actual = root.findDirectory("pics");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	public void checkNamesOfFilesAndDirectories() {
		apfs fileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory) fileSystemApfs.getRoot();
		assertSame("home", root.findDirectory("home").getName());
		assertSame("applications", root.findDirectory("applications").getName());
		assertSame("code", root.findDirectory("code").getName());
		assertSame("pics", root.findDirectory("pics").getName());
		assertSame("a", root.findFile("a").getName());
		assertSame("b", root.findFile("b").getName());
		assertSame("c", root.findFile("c").getName());
		assertSame("d", root.findFile("d").getName());
		assertSame("e", root.findFile("e").getName());
		assertSame("f", root.findFile("f").getName());
	}
	
	@Test
	public void FileNamesInSubdirectoriesTest() {
		apfs fileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory) fileSystemApfs.getRoot();
		assertSame("a", root.findDirectory("applications").getFiles().get(0).getName());
		assertSame("b", root.findDirectory("home").getFiles().get(0).getName());
		assertSame("c", root.findDirectory("code").getFiles().get(0).getName());
		assertSame("d", root.findDirectory("code").getFiles().get(1).getName());
		assertSame("e", root.findDirectory("pics").getFiles().get(0).getName());
		assertSame("f", root.findDirectory("pics").getFiles().get(1).getName());
	}
	
	
	
}