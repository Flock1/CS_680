package hw10.apfs;

import java.util.LinkedList;

public class apfsFileCrawlingVisitor implements apfsVisitor{

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
        this.files.add(file);
    }
    
    public LinkedList<apfsFile> getFiles(){
        return this.files;
    }

    
}
