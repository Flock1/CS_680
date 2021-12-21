package hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class apfsCountingVisitorTest {

    static LocalDateTime localTime = LocalDateTime.now();

    @BeforeAll
    public static void setUpBeforeClass(){

        apfs FilesystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory)FilesystemApfs.initFS("root", 3500);
		apfsDirectory applications = new apfsDirectory("applications",root, 0, localTime, "sarvagya", localTime);
		apfsDirectory home = new apfsDirectory("home",root, 0, localTime, "sarvagya", localTime);
		apfsDirectory code = new apfsDirectory("code",home, 0, localTime, "sarvagya", localTime);
		apfsDirectory pics = new apfsDirectory("pics",home, 0, localTime, "sarvagya", localTime);
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
	public void checkNumberOfFilesCode() {
		apfs fileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory) fileSystemApfs.getRoot();
		apfsCountingVisitor visitor = new apfsCountingVisitor();
		root.findDirectory("code").accept(visitor);
		int expected = 2;
		int actual = visitor.getFileNum();
		assertSame(expected, actual);

	}
    
}
