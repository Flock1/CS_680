package hw12.apfs;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<apfsElement>{
    
	@Override
	public int compare(apfsElement apfs1, apfsElement apfs2) {
		return apfs1.getName().toString().compareToIgnoreCase(apfs2.getName().toString());
	}

}