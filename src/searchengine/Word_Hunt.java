package searchengine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

import searchengine.Set_Custom_Value;

public class Word_Hunt {
public Hashtable<String, Set_Custom_Value> dictionary_find() throws IOException {

		
		ArrayList<String> array_list = new ArrayList<>();
		String l;
		ArrayList<Set_Custom_Value> array_list_value = new ArrayList<>();

		Hashtable<String, Set_Custom_Value> hash_table = new Hashtable<String, Set_Custom_Value>();

		File path = new File("C:\\Users\\DELL\\workspace\\SearchEngine\\W3C Web Pages\\ConvertedTextFiles\\");
		File[] files = path.listFiles();
		for (File f : files) {

			BufferedReader buff = new BufferedReader(new FileReader(f));

			while ((l = buff.readLine()) != null) {

				StringTokenizer st = new StringTokenizer(l,
						",.:;<>/?[)({}]+-*&%=#@^'!|_$`~");

				while (st.hasMoreTokens()) {

					String string1 = st.nextToken().toLowerCase().replaceAll("\"","");
					String string2[] = string1.split(" ");

					for (int i = 0; i < string2.length; i++) {

						if (!hash_table.containsKey(string2[i])) {
							Set_Custom_Value Value_Custom = new Set_Custom_Value();
							ArrayList<String> array_List = new ArrayList<String>();
							int not = 1;
							array_List.add(f.getName());
							Value_Custom.set_Number_Of_Times(not);
							Value_Custom.set_Page_Name(array_List);
							hash_table.put(string2[i], Value_Custom);
						} else {

							Set_Custom_Value Value_Custom = hash_table.get(string2[i]);
							ArrayList<String> array_List = Value_Custom
									.getPageName();
							if (!array_List.contains(f.getName()))
								array_List.add(f.getName());

							Value_Custom.set_Number_Of_Times(Value_Custom
									.get_Number_Of_Times() + 1);
							Value_Custom.set_Page_Name(array_List);
							hash_table.put(string2[i], Value_Custom);
						}
					}
				}
			}
		}

		return hash_table;
	}

}
