package hw14.apfs;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReverseAlphabeticalComparatorTest {
	static LocalDateTime localTime = LocalDateTime.now();
	
	private String[] apfsEleToString(LinkedList<apfsElement> l) {
		String[] info = new String[l.size()];
		int i=0;
		for(apfsElement e: l) {
			info[i] = e.getName();
			//System.out.println(info[i]);
			i++;
		}
        return info;
		
	}
	
	private String[] apfsFileToString(LinkedList<apfsFile> l) {
		String[] info = new String[l.size()];
		int i=0;
		for(apfsFile e: l) {
			info[i] = e.getName();
			//System.out.println(info[i]);
			i++;
		}
        return info;
    }
	
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setUpFileStructure() {

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
    public void ChildrenHomeDiretoryComparatorTest() {
		String[] expected = {"x",  "pics", "code",  "b"};
		apfs FilesystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory)FilesystemApfs.getRoot();
		LinkedList<apfsElement> l = root.findDirectory("home").getChildren((apfsElement e1, apfsElement e2) -> -e1.getName().compareTo(e2.getName()));
		System.out.println(l);
		assertArrayEquals(expected, apfsEleToString(l));
	}
}
