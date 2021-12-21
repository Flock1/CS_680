package hw10.apfs;

import java.time.LocalDateTime;

public class apfsLink extends apfsElement{
	
	private apfsElement target;
	public apfsLink(apfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner, LocalDateTime lastModifiedTime, apfsElement target) {
		super(parent, name, owner, creationTime, lastModifiedTime, size);
		this.target = target;
		parent.addChild(this);
	}
	
	public apfsElement getTarget() {
		return this.target;
	}
	
	@Override
	public Boolean isDirectory() {
		return false;
	}

	@Override
	public void accept(apfsVisitor v) {
		// TODO Auto-generated method stub
		v.visit(this);
		
	}
}