package hw7;

import java.util.LinkedList;

public class FileSystem {

    private FileSystem(){}

    private static FileSystem instance = null;

    public static FileSystem getFileSystem(){
        if(instance == null){
            instance = new FileSystem();
        }
        return instance;
    }

    LinkedList<Directory> directories = new LinkedList<Directory>();

    public LinkedList<Directory> getRootDirs(){
        return directories;
    }

    public void appendRootDir(Directory dir){
        directories.add(dir);
    }


}