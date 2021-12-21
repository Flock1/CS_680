package hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class apfsFileSearchVisitorTest {

    static LocalDateTime localTime = LocalDateTime.now();

    @BeforeAll
    public static void setUpBeforeClass() {

        apfs FilesystemApfs = apfs.getAPFSFileSystem();
        apfsDirectory root = (apfsDirectory) FilesystemApfs.initFS("root", 3500);
        apfsDirectory applications = new apfsDirectory("applications",root, 0, localTime, "sarvagya", localTime);
        apfsDirectory home = new apfsDirectory("home",root, 0, localTime, "sarvagya", localTime);
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
    public void FileEqualVerify(){

        apfs FilesystemApfs = apfs.getAPFSFileSystem();
        apfsFileSearchVisitor visitor = new apfsFileSearchVisitor();
        FilesystemApfs.accept(visitor);
        assertEquals(visitor.getFiles().size(), 5);
    }

    @Test
    public void FileNotEqualVerify(){

        apfs FilesystemApfs = apfs.getAPFSFileSystem();
        apfsFileSearchVisitor visitor = new apfsFileSearchVisitor();
        FilesystemApfs.accept(visitor);
        assertNotEquals(visitor.getFiles().size(), 6);
    }

    @Test
    public void FileEqualVerify2(){

        apfs FilesystemApfs = apfs.getAPFSFileSystem();
        apfsFileSearchVisitor visitor = new apfsFileSearchVisitor();
        FilesystemApfs.accept(visitor);
        assertEquals(visitor.getFiles().get(0).getName(), "a");
    }
    
}
