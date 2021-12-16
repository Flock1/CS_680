package hw09.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsFileTest {
	
	static LocalDateTime localTime = LocalDateTime.now();
	
	private String[] FileToStringArray(apfsFile d) {
		String[] FileInfo = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString(), 
				d.getParent().getName(), d.getCurrentname(),d.lastModifiedTime().toString()};
		return FileInfo;
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
	public void verifyApfsFileEqualityA() {
		apfs FilesystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory)FilesystemApfs.getRoot();
		String[] expected = {"false", "a", "350", localTime.toString(), "applications", "sarvagya", localTime.toString()};
		System.out.println(root.findFile("a").getParent().getName());
		apfsFile actual = root.findFile("a");
		assertArrayEquals(expected, FileToStringArray(actual));
	}
	
	@Test
	public void verifyApfsFileEqualityB() {
		apfs FilesystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory)FilesystemApfs.getRoot();
		String[] expected = {"false", "b", "700", localTime.toString(), "home", "sarvagya", localTime.toString()};
		//System.out.println(root.findFileByName("a").getParent().getName());
		apfsFile actual = root.findFile("b");
		assertArrayEquals(expected, FileToStringArray(actual));
	}
	
	@Test
	public void verifyApfsFileEqualityC() {
		apfs FilesystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory)FilesystemApfs.getRoot();
		String[] expected = {"false", "c", "800", localTime.toString(), "code", "sarvagya", localTime.toString()};
		//System.out.println(root.findFileByName("a").getParent().getName());
		apfsFile actual = root.findFile("c");
		assertArrayEquals(expected, FileToStringArray(actual));
	}
	
	@Test
	public void verifyApfsFileEqualityD() {
		apfs FilesystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory)FilesystemApfs.getRoot();
		String[] expected = {"false", "d", "80", localTime.toString(), "code", "sarvagya", localTime.toString()};
		//System.out.println(root.findFileByName("a").getParent().getName());
		apfsFile actual = root.findFile("d");
		assertArrayEquals(expected, FileToStringArray(actual));
	}
}