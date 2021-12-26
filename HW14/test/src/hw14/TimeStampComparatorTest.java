package hw14.apfs;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TimeStampComparatorTest {
    static LocalDateTime localTime1 = LocalDateTime.of(2021, 04 , 10, 20, 20);
	static LocalDateTime localTime2 = LocalDateTime.of(2021, 04, 25, 11, 11);
	
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
		apfsDirectory applications = new apfsDirectory("applications",root, 0, localTime1, "sarvagya", localTime2);
		apfsDirectory home = new apfsDirectory("home",root, 0, localTime1, "sarvagya", localTime2);
		apfsDirectory code = new apfsDirectory("code",home, 0, localTime1, "sarvagya", localTime2);
		apfsDirectory pics = new apfsDirectory("pics",home, 0, localTime1, "sarvagya", localTime2);
		apfsFile a = new apfsFile(applications, "a", 350, localTime1, "sarvagya", localTime2);
		apfsFile b = new apfsFile(home, "b", 700, localTime1, "sarvagya", localTime2);
		apfsFile c = new apfsFile(code, "c", 800, localTime1, "sarvagya", localTime2);
		apfsFile d = new apfsFile(code, "d", 80, localTime1, "sarvagya", localTime2);
		apfsFile e = new apfsFile(pics, "e", 700, localTime1, "sarvagya", localTime2);
		apfsFile f = new apfsFile(pics, "f", 870, localTime1, "sarvagya", localTime2);
		apfsLink x = new apfsLink(home, "x", 0, localTime1, "sarvagya", localTime2, applications);
		apfsLink y = new apfsLink(code, "y", 0, localTime1, "sarvagya", localTime2, a);
    }

    @Test
	public void FilesInCodeTimeComparatorTest() {
		String[] expected = {"c","d"};
		apfs FileSystemApfs = apfs.getAPFSFileSystem();
		apfsDirectory root = (apfsDirectory) FileSystemApfs.getRoot();
		LinkedList<apfsFile> l = root.findDirectory("code").getFiles((apfsElement e1, apfsElement e2) -> e1.getCreationTime().toString().compareTo(e2.getCreationTime().toString()));
		System.out.println(l);
		assertArrayEquals(expected, apfsFileToString(l));
    }
}
