package searchengine;

import java.util.Comparator;

import searchengine.Set_Mapping_Comp;

public class Set_Mapping_Comp implements Comparator<Set_Mapping_Comp>, Comparable<Set_Mapping_Comp> {

	private int coun;
	private String f1;

	public int get_Counter() {
		return coun;
	}

	public void set_Counter(int count_val) {
		this.coun = count_val;
	}

	public String get_File() {
		return f1;
	}

	public void set_File(String file) {
		this.f1 = file;
	}

	public int compareTo(Set_Mapping_Comp pm) {
		return (this.f1).compareTo(pm.f1);
	}

	public int compare(Set_Mapping_Comp p, Set_Mapping_Comp p1) {
		return (p.coun - p1.coun);

	}
}