package hw12.apfs;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<apfsElement>{

	@Override
	public int compare(apfsElement apfs1, apfsElement apfs2) {
		return apfs1.getCreationTime().toString().compareTo(apfs2.getCreationTime().toString());
	}

}
