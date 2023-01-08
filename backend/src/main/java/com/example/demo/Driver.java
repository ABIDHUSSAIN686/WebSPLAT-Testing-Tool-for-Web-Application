package com.example.demo;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;


/****
 * 
 *  Driver class used to run the functionality
 * 
 * ****/
public class Driver {	
	
	
	/****
	 * 
	 *  starter function calls all function to get final desired output
	 * 
	 * ****/
	public void starter() throws IOException
	{

		WebPage obj =new WebPage();
		List<String> list2 = new ArrayList<String>();
//			obj.genrator("http://localhost/Version1/claroline/","Version1");
//			obj.genrator("http://localhost/Version2/vtwo/","Version2");
		DOM_Diffrence_Detector obj3 = new DOM_Diffrence_Detector();
		FeatureModel obj1 = new FeatureModel();
//			obj1.name_formator("Version1");
//			obj1.name_formator("Version2");
		Dictionary<String, String> map=obj1.feature_page_mapper("Version1", "Version2");
		Dictionary<Integer, String> feature_ids=obj1.model_processor("model3.xml");
		Enumeration<Integer> ids = feature_ids.keys();
		Enumeration<Integer> ids1 = feature_ids.keys();
		File folder1 = new File("Version1/");
		File folder2 = new File("Version2/");
		ArrayList<String> features=new ArrayList<String>();
		ArrayList<String> features_file=new ArrayList<String>();
		Comparisor obj2 =new Comparisor();
		while (ids.hasMoreElements()) {
			int n=ids.nextElement();
			System.out.println("------>"+n);
			String[] str=map.get("v1-"+n).split("-",0);
			features.add(feature_ids.get(n));
			features_file.add(obj1.getAllFiles1(folder1,n));

			list2=obj3.Formatting("Version1/"+obj1.getAllFiles1(folder1,n));
			String[] arr3 = list2.toArray(new String[0]);

			list2=obj3.Formatting("Version2/"+obj1.getAllFiles1(folder2,Integer.parseInt(str[1])));
			String[] arr4 = list2.toArray(new String[0]);

			obj3.sort_File(arr3,"Version1/"+obj1.getAllFiles1(folder1,n));
			obj3.sort_File(arr4,"Version1/"+obj1.getAllFiles1(folder2,Integer.parseInt(str[1])));
			obj3.createFolders(obj1.getAllFiles1(folder1,n));
			obj2.codeExecutor(obj1.getAllFiles1(folder1,n),obj1.getAllFiles1(folder2,Integer.parseInt(str[1])));
			obj2.codeExecutor1(obj1.getAllFiles1(folder1,n),obj1.getAllFiles1(folder2,Integer.parseInt(str[1])));
			System.out.println("\n\n");
		}
		while (ids1.hasMoreElements()) {
			int n=ids1.nextElement();
			File file = new File("J:/7 semester/FYP/frontend/public/Changes/"+obj1.getAllFiles1(folder1,n));
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			List<String> list1 = new ArrayList<String>();
			while ((st = br.readLine()) != null) {
				list1.add(st + "\n");
			}
			String[] arr = list1.toArray(new String[0]);
			obj3.intialize_Changes();
			obj3.Diffrence_Phrase(arr, obj1.getAllFiles1(folder1,n),"J:/7 semester/FYP/frontend/public/Changestxt/"+obj1.getAllFiles1(folder1,n)+".txt","J:/7 semester/FYP/frontend/public/Changes/");
			System.out.println(obj3.allChanges);
		}
		obj3.Write_Overall_changes();
		System.out.println(features);
		System.out.println(features_file);

		List<String> list = new ArrayList<String>();
		Map<String,String> map1=new HashMap<String,String>();
		int i=0;
		Gson gson2 = new Gson(); 
		String json2 = null;
		while(i<features.size())
		{
			map1.put("name",features.get(i));  
			map1.put("URL",features_file.get(i)); 
			Gson gson1 = new Gson(); 
			String json1 = gson1.toJson(map1); 
			list.add(json1);
			i++;
		}

		try {
			FileWriter file = new FileWriter("J:/7 semester/FYP/frontend/src/Pages/options.json");
			file.write(list.toString());
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("list\n"+list);
	}

	

	/****
	 * 
	 *  main function is the entry point to run the application
	 * 
	 * ****/
	public static void main(String[] args) throws IOException,Exception {
		Driver obj1 =new Driver();
		obj1.starter();
	}
}

