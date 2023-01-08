package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;



/****
 * 
 *  FeatureModel class is used to map
 *  feature in feature model to web pages
 *  and test suite
 * 
 * ****/

public class FeatureModel {
	protected String totalFeatures;

	public String getTotalFeatures() {
		return totalFeatures;
	}

	public void setTotalFeatures(String totalFeatures) {
		this.totalFeatures = totalFeatures;
	}

	public void createFolder(String name) {
		File f = new File("Feature_suite/" + name);
		FileWriter test = null;
		f.mkdir();
		try {
			test = new FileWriter("Feature_suite/" + name + "/test.txt");

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}


	
	/****
	 * 
	 *  feature_TestSuite_mapper function take feature model as input
	 *  and read the test suite from a static location and map the test
	 *  suite to features in feature model to their corresponding tests
	 *  cases.
	 * 
	 * ****/

	public void feature_TestSuite_mapper(String fm) throws IOException {
		FeatureModel obj2 = new FeatureModel();
		Dictionary<Integer, String> feature_ids=model_processor(fm);
		Enumeration<Integer> ids = feature_ids.keys();
		File folder1 = new File("Version1/");
		ArrayList<String> features=new ArrayList<String>();
		ArrayList<String> features_file=new ArrayList<String>();
		while (ids.hasMoreElements()) {
			int n=ids.nextElement();
			//  String[] str=map.get("v1-"+n).split("-",0);
			System.out.println(n+"  "+feature_ids.get(n));
			features.add(feature_ids.get(n));
			features_file.add(getAllFiles1(folder1,n));
			obj2.createFolder(getAllFiles1(folder1,n));
		}

		System.out.println(feature_ids.size());
		System.out.println(features);
		System.out.println(features_file);

		try {
			File myObj = new File("TestscriptNames.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] chunks1 = data.split("_", 0);

				int n1 = Integer.parseInt(chunks1[1]);
				System.out.println(chunks1[0]+"          "+n1);
				// System.out.println(features);

				FileWriter br1 = null;
				try {

					br1 = new FileWriter("Feature_suite/"+getAllFiles1(folder1,n1)+"/test.txt", true);

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

				br1.write(chunks1[0]+ "\n");

				br1.close();


			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
	

	/****
	 * 
	 *  reduce_links function take paths of txt file containing 
	 *  all links got from href attribute and reduce to unique
	 *  links to remove duplication
	 * 
	 * ****/
	public void reduce_links(HashSet<Integer> ids, String version) throws IOException {

		FileInputStream fs = new FileInputStream(version+"/links.txt");

		Scanner sc = new Scanner(fs);

		FileWriter fw = new FileWriter(version+"\\link.txt", true);


		String currentLine="";

		while(sc.hasNextLine()) {
			currentLine = sc.nextLine();
			String[] chunks = currentLine.split("-", 0);
			int n1 =Integer.parseInt(chunks[0]);
			if(ids.contains(n1))
			{
				fw.write(currentLine+"\n");

			}
		}
		fw.close(); 
		fs.close(); 
		File file1 = new File(version+"/links.txt"); 
		file1.delete();
		File file2= new File(version+"/links.txt"); 
		File rename1 = new File(version+"/link.txt");

		boolean successful = rename1.renameTo(file2);
		System.out.println(successful);
	}
	
	
	/****
	 * 
	 *editDistance function take two strings as input and return
	 *the count of index level difference character of strings(links)
	 * 
	 * ****/
	public  String editDistance(String s1, String file) {
		s1 = s1.toLowerCase();
		String s2="";
		double min_distance=500;
		String match_link="";

		try  
		{  

			FileInputStream fs=new FileInputStream(file);       
			Scanner sc=new Scanner(fs);   
			while(sc.hasNextLine())  
			{  
				s2 =sc.nextLine();
				String s3=s2;
				s2 = s2.toLowerCase();
				String[] chunks = s2.split("--->", 0);
				String[] chunks4 = chunks[1].split("/", 6);
				s2=chunks4[5];
				int[] arr = new int[s2.length() + 1];
				for (int i = 0; i <= s1.length(); i++) {
					int last_value = i;
					for (int j = 0; j <= s2.length(); j++) {
						if (i == 0)
							arr[j] = j;
						else {
							if (j > 0) {
								int new_value = arr[j - 1];
								if (s1.charAt(i - 1) != s2.charAt(j - 1))
									new_value = Math.min(Math.min(new_value, last_value),
											arr[j]) + 1;
								arr[j - 1] = last_value;
								last_value = new_value;
							}
						}
					}
					if (i > 0)
						arr[s2.length()] = last_value;
				}
				if(arr[s2.length()]<min_distance)
				{
					min_distance=arr[s2.length()];
					match_link=s3;
				}

			}  
			sc.close();     
		}  
		catch(IOException e)  
		{  
			e.printStackTrace();  
		}  


		return match_link;
	}

	
	/****
	 * 
	 *getAllFiles function takes folder and id of a file and 
	 *return the file name stored in the folder
	 * 
	 * ****/
	public String getAllFiles(final File folder,int n) {

		for (final File fname : folder.listFiles()) {
			if (fname.isDirectory()) {
				getAllFiles(fname,n);
			} else {
				String [] chunks = fname.getName().split("  ", 0);
				if(chunks[0].length()<4)
				{int n1 =Integer.parseInt(chunks[0]);
				if(n1==n)
				{ System.out.println("\n\n"+fname.getName());
				return fname.getName();
				}
				}
			}
		}
		return null;
	}
	
	
	/****
	 * 
	 *getAllFiles1 function takes folder and id of a file and 
	 *return the file name stored in the folder
	 * 
	 * ****/
	public String getAllFiles1(final File folder,int n) {

		for (final File fname : folder.listFiles()) {
			if (fname.isDirectory()) {
				getAllFiles(fname,n);
			} else {
				String [] chunks = fname.getName().split(" ", 0);
				if(chunks[0].length()<4)
				{int n1 =Integer.parseInt(chunks[0]);
				if(n1==n)
				{ 
					return fname.getName();
				}
				}
			}
		}
		return null;
	}


	/****
	 * 
	 *feature_page_mapper function takes two folders paths of variant1
	 *and variants two and map the web pages of both the variants to each
	 *other and to their corresponding feature of the feature model.
	 * 
	 * ****/
	public Dictionary<String, String> feature_page_mapper(String Version1, String Version2) throws IOException {

		int size1 = 0, size2 = 0;
		BufferedReader reader1 = new BufferedReader(new FileReader(Version1+"/link.txt"));
		while (reader1.readLine() != null)
			size1++;
		reader1.close();

		BufferedReader reader2 = new BufferedReader(new FileReader(Version2+"/link.txt"));
		while (reader2.readLine() != null)
			size2++;
		reader2.close();

		String newfile1 = "", newfile2 = "", version1 = "", version2 = "";
		if (size1 >= size2) {
			newfile1 = Version1+"/link.txt";
			version1 = "v1";
			newfile2 = Version2+"/link.txt";
			version2 = "v2";
		} else if (size2 > size1) {
			newfile1 = Version2+"/link.txt";
			version1 = "v2";
			newfile2 = Version1+"/link.txt";
			version2 = "v1";
		}

		FileInputStream fs = new FileInputStream(newfile1);
		Scanner sc = new Scanner(fs);
		String temp = "";
		Dictionary<String, String> map = new Hashtable<String, String>();
		while (sc.hasNextLine()) {

			temp = sc.nextLine();
			String[] chunks = temp.split("--->", 0);

			String[] chunks1 = chunks[0].split("-", 0);

			int n = Integer.parseInt(chunks1[0]);
			String new1="";
			String[] chunks4 = chunks[1].split("/", 6);
			String link = editDistance(chunks4[5], newfile2);
			String[] chunks2 = link.split("--->", 0);

			String[] chunks3 = chunks2[0].split("-", 0);
			int n1 = Integer.parseInt(chunks3[0]);
			map.put(version1 + "-" + n, version2 + "-" + n1);
		}
		System.out.println("The Dictionary is: " + map);
		sc.close();
		return map;
	}
	
	
	/****
	 * 
	 *name_formator function takes paths of all web pages file of
	 *a variants and the format name of each file according 
	 *to its functionality
	 * 
	 * ****/
	public void name_formator(String version) throws IOException
	{

		FileInputStream fs = new FileInputStream(version+"/Links.txt");
		Scanner sc = new Scanner(fs);
		String temp = "";
		HashSet<String> unique_name = new HashSet<String>();
		HashSet<Integer> ids = new HashSet<Integer>();
		while (sc.hasNextLine()) {

			String h1 = "", h2 = "", h3 = "", h4 = "",larger="",newname="";
			boolean flag1=true,flag2=true,flag3=true,flag4=true,flag5=false;
			temp = sc.nextLine();
			String[] chunks = temp.split("--->", 0);

			String[] chunks1 = chunks[0].split("-", 0);

			int n = Integer.parseInt(chunks1[0]);
			String new1="";
			File folder = new File(version+"/");
			String file_link = getAllFiles(folder, n);
			if (file_link != null) {
				File input1 = new File(version+"/" + file_link);
				Document doc1 = Jsoup.parse(input1, "UTF-8", "");
				Elements elements1 = doc1.getAllElements();

				for (Element element : elements1) { // unique tags

					if (element.tagName() == "h1") {
						larger=larger+"_"+element.text();
						newname=newname+"_"+element.text();
						System.out.println("h1: "+n+" "+element.text());
						if(flag1)
						{
							flag5=true;
							h1 = element.text();
							flag1=false;
						}
					}
					if (element.tagName() == "h3") {
						larger=larger+"_"+element.text();
						newname=newname+"_"+element.text();
						System.out.println("h3: "+n+" "+element.text());
						if(flag3)
						{
							flag5=true;
							h3 = element.text();
							flag3=false;
						}
					}
					if (element.tagName() == "h2") {
						larger=larger+"_"+element.text();
						newname=newname+"_"+element.text();
						System.out.println("h2: "+n+" "+element.text());
						if(flag2)
						{
							flag5=true;
							h2 = element.text();
							flag2=false;
						}
					}

					if (element.tagName() == "a"&&flag5) {
						if((!element.text().isEmpty()||!element.text().isBlank())&&element.text().length()>1)
						{
							if (element.text().equals("aqeel afzal")) {
								flag5=false;
							}
							else
								larger=larger+"_"+element.text();
						}

					}

				}
			}


			if (file_link != null) {
				System.out.println("h1: "+h1+"  h2: "+h2+"   h3: "+h3+"   h4: "+h4);
				if (!h1.isEmpty()) {
					String[] temp1 = file_link.split("-", 0);

					String[] temp2 = temp1[0].split("  ", 0);
					temp2[1] = temp2[1].trim();
					if (temp1.length == 2) {
						if (h1.contains(":")) {
							String[] temp3 = h1.split(":", 0);
							temp3[0] = temp3[0].trim();
							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[1];
							System.out.println("h1 21------------> " + new1);
						} else if (h1.contains("|")) {

							String[] temp3 = h1.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[1];
							System.out.println("h1 22------------> " + new1);
						} else {

							String[] temp3 = h1.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[1];
							System.out.println("h1 23------------> " + new1);
						}
					}
					if (temp1.length == 3) {
						if (h1.contains(":")) {
							String[] temp3 = h1.split(":", 0);
							temp3[0] = temp3[0].trim();
							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[2];
							System.out.println(" h1 31------------> " + new1);
						} else if (h1.contains("|")) {

							String[] temp3 = h1.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[2];
							System.out.println(" h1 32------------> " + new1);
						} else {

							String[] temp3 = h1.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[2];
							System.out.println("h1 33------------> " + new1);
						}
					}
					if (temp1.length == 1) {

						if (h1.contains(":")) {
							String[] temp3 = h1.split(":", 0);
							temp3[0] = temp3[0].trim();
							new1 = temp2[0] + "  " + temp3[0] + " - " + temp2[1];
							System.out.println(" h1 11------------> " + new1);
						} else if (h1.contains("|")) {

							String[] temp3 = h1.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " - " + temp2[1];
							System.out.println(" h1 12------------> " + new1);
						} else {

							String[] temp3 = h1.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " - " + temp2[1];
							System.out.println(" h1 13------------> " + new1);
						}
					}

					System.out.println("h1: " + h1);
				} else if (!h3.isEmpty()) {
					String[] temp1 = file_link.split("-", 0);

					String[] temp2 = temp1[0].split("  ", 0);
					temp2[1] = temp2[1].trim();
					if (temp1.length == 2) {
						if (h3.contains(":")) {
							String[] temp3 = h3.split(":", 0);
							temp3[0] = temp3[0].trim();
							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[1];
							System.out.println("h3 21------------> " + new1);
						} else if (h3.contains("|")) {

							String[] temp3 = h3.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[1];
							System.out.println("h3 22------------> " + new1);
						} else {

							String[] temp3 = h3.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[1];
							System.out.println(" h3 23------------> " + new1);
						}
					}
					if (temp1.length == 3) {
						if (h3.contains(":")) {
							String[] temp3 = h3.split(":", 0);
							temp3[0] = temp3[0].trim();
							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[2];
							System.out.println("h3 31------------> " + new1);
						} else if (h3.contains("|")) {

							String[] temp3 = h3.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[2];
							System.out.println("h3 32------------> " + new1);
						} else {

							String[] temp3 = h3.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[2];
							System.out.println("h3 33------------> " + new1);
						}
					}
					if (temp1.length == 1) {

						if (h3.contains(":")) {
							String[] temp3 = h3.split(":", 0);
							temp3[0] = temp3[0].trim();
							new1 = temp2[0] + "  " + temp3[0] + " - " + temp2[1];
							System.out.println("h3 11------------> " + new1);
						} else if (h3.contains("|")) {

							String[] temp3 = h3.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " - " + temp2[1];
							System.out.println("h3 12------------> " + new1);
						} else {

							String[] temp3 = h3.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " - " + temp2[1];
							System.out.println("h3 13------------> " + new1);
						}
					}
					System.out.println("h3: " + h3);
				} else if (!h2.isEmpty()) {
					String[] temp1 = file_link.split("-", 0);

					String[] temp2 = temp1[0].split("  ", 0);
					temp2[1] = temp2[1].trim();
					if (temp1.length == 2) {
						if (h2.contains(":")) {
							String[] temp3 = h2.split(":", 0);
							temp3[0] = temp3[0].trim();
							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[1];
							System.out.println(" h2 21------------> " + new1);
						} else if (h2.contains("|")) {

							String[] temp3 = h2.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[1];
							System.out.println("h2 22------------> " + new1);
						} else {

							String[] temp3 = h2.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[1];
							System.out.println("h2 23------------> " + new1);
						}
					}
					if (temp1.length == 3) {
						if (h2.contains(":")) {
							String[] temp3 = h2.split(":", 0);
							temp3[0] = temp3[0].trim();
							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[2];
							System.out.println("h2 31------------> " + new1);
						} else if (h2.contains("|")) {

							String[] temp3 = h2.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[2];
							System.out.println("h2 32------------> " + new1);
						} else {

							String[] temp3 = h2.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " -" + temp1[2];
							System.out.println("h2 33------------> " + new1);
						}
					}
					if (temp1.length == 1) {

						if (h2.contains(":")) {
							String[] temp3 = h2.split(":", 0);
							temp3[0] = temp3[0].trim();
							new1 = temp2[0] + "  " + temp3[0] + " - " + temp2[1];
							System.out.println("h2 11------------> " + new1);
						} else if (h2.contains("|")) {

							String[] temp3 = h2.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " - " + temp2[1];
							System.out.println("h2 12------------> " + new1);
						} else {

							String[] temp3 = h2.split("\\|", 0);
							temp3[0] = temp3[0].trim();

							new1 = temp2[0] + "  " + temp3[0] + " - " + temp2[1];
							System.out.println("h2 13------------> " + new1);
						}
					}
					System.out.println("h2: " + h2);
				}
				File file = new File(version+"/" + file_link); 
				if(unique_name.add(newname))
				{
					larger=n+" "+larger;
					newname=n+" "+newname+" - Claroline.html";
					ids.add(n);
					FileWriter fw = new FileWriter(version+"\\filedata.txt", true);
					fw.write(newname+ "\n");
					fw.close();
					File rename = new File(version+"/" +newname); 
					file.renameTo(rename); 
				}
				else
				{
					System.out.println(n+larger+"........................................................................");

					file.delete();
				}
				h1 = "";
				h2 = "";
				h3 = "";
				h4 = "";
				flag1=false;
				flag2=false;
				flag3=false;
				flag4=false;
				flag5=false;
				larger="";


			}

		}
		reduce_links(ids,version);
		System.out.println("done");
	}
	

	/****
	 * 
	 *model_processor function takes path of feature model 
	 *of whole software product line and extract 
	 *all the features parent in the feature model.
	 * 
	 * ****/
	public Dictionary<Integer, String> model_processor(String filename) throws IOException {
		File input1 = new File(filename);
		Document doc1 = Jsoup.parse(input1, "UTF-8", "");
		Dictionary<Integer, String> map = new Hashtable<Integer, String>();
		Elements elements1 = doc1.getAllElements();

		for (Element element : elements1) {                                           //unique tags

			Attributes attributes = element.attributes();
			for(Attribute attr:attributes)
			{
				if(attr.getKey().equals("name"))
				{
					String[] chunks=attr.getValue().split("_",0);
					String fea="";
					for(int i= 0;i<chunks.length-1;i++)
					{
						fea=fea+" "+chunks[i];
					}
					map.put(Integer.parseInt(chunks[chunks.length-1]),fea);
				}

			}

		}
		return map;
	}

	
	
	/****
	 * 
	 *config_processor function takes path of feature
	 * model of a single variant and extract 
	 *all the features parent in the feature model.
	 * 
	 * ****/
	public Dictionary<Integer, String> config_processor(String filename) throws IOException {
		File input1 = new File(filename);
		Document doc1 = Jsoup.parse(input1, "UTF-8", "");
		Dictionary<Integer, String> map = new Hashtable<Integer, String>();
		Elements elements1 = doc1.getAllElements();

		for (Element element : elements1) {                                           //unique tags

			Attributes attributes = element.attributes();
			for(Attribute attr:attributes)
			{
				if(attr.getKey().equals("name"))
				{
					String[] chunks=attr.getValue().split("_",0);
					String fea="";
					for(int i= 0;i<chunks.length-1;i++)
					{
						fea=fea+" "+chunks[i];
					}
					map.put(Integer.parseInt(chunks[chunks.length-1]),fea);
				}
			}
		}
		return map;
	}
}
