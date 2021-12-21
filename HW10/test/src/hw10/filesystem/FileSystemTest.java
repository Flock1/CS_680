package hw10.filesystem;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import hw10.apfs.apfs;
import hw10.apfs.apfsDirectory;
import hw10.apfs.apfsFile;
import hw10.apfs.apfsLink;
import hw10.apfs.apfs;
import hw10.apfs.apfsDirectory;

class FileSystemTest {
	static LocalDateTime localTime = LocalDateTime.now();
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		apfs FilesystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory)FilesystemApfs.initFS("drive", 3500);
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
	public void testforrootinstance() {
		apfs fileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory) fileSystemApfs.getRoot();
		assertSame(root.getCurrentname(), "sarvagya");
	}
	
	private String[] dirToStringArray(apfsDirectory dir) {
		Optional<apfsDirectory> optionalDirectory = Optional.ofNullable(dir.getParent());
		String[] infofordirectory = { Boolean.toString(dir.isDirectory()), dir.getName(), Integer.toString(dir.getSize()),  
				optionalDirectory.isPresent()?dir.getParent().getName():null, Integer.toString(dir.getTotalSize()),
						Integer.toString(dir.countChildren()),dir.getCurrentname()};
		return infofordirectory;
	}
	
	@Test
	public void RootCheck() {
		apfs FileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory)FileSystemApfs.getRoot();
		String[] expected = { "true", "root", "0", null, "3500", "2", "sarvagya"};
		System.out.println(root.findDirectory("root"));
		apfsDirectory actual = root.findDirectory("root");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	

}