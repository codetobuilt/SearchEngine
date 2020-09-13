package searchengine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;

import searchengine.Set_Custom_Value;

public class Dict_Jsoup {
public Hashtable<String, Set_Custom_Value> dictionary_find() throws IOException {

		
		ArrayList<String> array_list = new ArrayList<>();
		
		ArrayList<Set_Custom_Value> array_list_value = new ArrayList<>();
		String l;

		Hashtable<String, Set_Custom_Value> hash_table = new Hashtable<String, Set_Custom_Value>();

		File path = new File("C:\\Users\\DELL\\workspace\\SearchEngine\\W3C Web Pages\\");

		for (File f : path.listFiles()) {

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

	public static void convert() throws IOException,FileNotFoundException,NullPointerException {
		int Fnumber = 1;
		try {
			File directory = new File("C:\\Users\\DELL\\workspace\\SearchEngine\\W3C Web Pages\\");
			File[] a1 = directory.listFiles();
			File[] a2 = new File[101];
			int nFiles=0;
			for(int _i=0;_i<a1.length;_i++)
			{
				if(a1[_i].isFile())
				{
					a2[nFiles] = a1[_i];
					nFiles++;
				}
			}
			
			for(int i=0;i<100;i++)
			{
				convert_Html_To_Text(a2[i],Fnumber);
				Fnumber = Fnumber + 1;
			}
		} catch (Exception e) {
			System.out.println("Exception:"+e);
		}
		finally
		{
			
		}
	
	}
	
	public static void convert_Html_To_Text(File _resourceFile,int F_num) throws IOException,FileNotFoundException,NullPointerException
	{
		try {
			org.jsoup.nodes.Document _doc = Jsoup.parse(_resourceFile, "UTF-8");
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\DELL\\workspace\\SearchEngine\\W3C Web Pages\\ConvertedTextFiles\\"+_resourceFile.getName()+".txt"));
			out.write(_doc.text());
			out.close();
			System.out.println("File "+_resourceFile.getName()+"     --->     "+_resourceFile.getName()+".txt successfully");
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
