package hw10.apfs;


import hw10.filesystem.FileSystem;

import java.util.LinkedList;

public class apfsCountingVisitor implements apfsVisitor {
    
    private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;
    
    @Override
    public void visit(apfsLink link) {
        linkNum++;
    }

    @Override
    public void visit(apfsDirectory dir) {
        dirNum++;
    }

    @Override
    public void visit(apfsFile file) {
        fileNum++;
    }

    public int getDirNum() {
        return dirNum;
    }

    public int getFileNum() {
        return fileNum;
    }

    public int getLinkNum() {
        return linkNum;
    }
}

    

