package hw10.apfs;

public interface apfsVisitor {
	
	public void visit(apfsLink link) ;
	public void visit(apfsDirectory dir);
	public void visit(apfsFile file);
	
}
