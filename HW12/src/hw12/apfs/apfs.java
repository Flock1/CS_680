package hw12.apfs;

import java.time.LocalDateTime;

import hw12.filesystem.*;

public class apfs extends FileSystem{

	private static LocalDateTime time = LocalDateTime.now();
	private static apfs instance = null;
	private apfs() {}
	
	public static apfs getAPFSFileSystem() {
		if(instance == null) {
			instance = new apfs();
		}
		return instance;
	}
	
	@Override
	protected FSElement createDefaultRoot() {
		apfsDirectory root = new apfsDirectory("root",null, 0, time, "sarvagya", time);
		return root;
	}


}