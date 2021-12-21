package hw10.apfs;

import java.util.LinkedList;

public class apfsFileSearchVisitor implements apfsVisitor {
    
    private String fileName;
    private LinkedList<apfsFile> files = new LinkedList<apfsFile>();

    @Override
    public void visit(apfsLink link) {
        // TODO Auto-generated method stub
        return;
    }

    @Override
    public void visit(apfsDirectory dir) {
        // TODO Auto-generated method stub
        return;
    }

    @Override
    public void visit(apfsFile file) {
        if (file.getName().equals(this.fileName)) {
            this.files.add(file);
        }
    }

    public LinkedList<apfsFile> getFiles() {
        return this.files;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }

}
