package searchengine;

import java.util.ArrayList;

import searchengine.Set_Counter_Name;

public class Set_Custom_Value {
	private ArrayList<Set_Counter_Name> page_name_count;
	private ArrayList<String> page_name;
	public ArrayList<String> getPageName() {
		return page_name;
	}
	public void set_Page_Name(ArrayList<String> page_name1) {
		page_name = page_name1;
	}
	private int no_oft;
	
	public int get_Number_Of_Times() {
		return no_oft;
	}
	public void set_Number_Of_Times(int number_Of_Times) {
		no_oft = number_Of_Times;
	}
	public ArrayList<Set_Counter_Name> get_Page_Name_Counters() {
		return page_name_count;
	}
	public void set_Page_Name_Counters(ArrayList<Set_Counter_Name> page_Name_Counters) {
		this.page_name_count = page_Name_Counters;
	}
	private String occurences;
	
	private int Edit_Distance=0;
	public int getEditDistance() {
		return Edit_Distance;
	}
	public void set_Edit_Distance(int edit_Distance) {
		Edit_Distance = edit_Distance;
	}
	
	public String get_Occurence() {
		return occurences;
	}
	public void set_Occurence(String occurence) {
		this.occurences = occurence;
	}
}
