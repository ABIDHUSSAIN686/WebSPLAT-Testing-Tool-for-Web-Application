package com.example.demo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

import com.google.gson.Gson;


/****
 * 
 * DOM_Diffrence_Detector class used to manipulate html files
 * 
 * ****/
public class DOM_Diffrence_Detector {

	protected static WebDriver driver;
	protected Map<String, Integer> allChanges;
	protected int AutoID;
	protected int ManualID;
	protected int Href_attri;
	protected int AlternativeText_attri;
	protected int Name_attri;
	protected int Type_attri;
	protected int Value_attri;
	protected int Class_attri;
	protected int OnClick_attri;
	protected int Hierarchy_Based_Locator;
	protected int Index_Based_Locator;
	protected int Invalid_Text_Field;
	protected int Missing_Value;
	protected int Value_Absent_Dropdown_List;
	protected int Unexpected_Assertion_Value;
	protected int Element_text;
	
	
	
	/****
	 * 
	 * DOM_Diffrence_Detector constractor
	 * 
	 * ****/
	public DOM_Diffrence_Detector() {
		super();
		AutoID = 0;
		ManualID = 0;
		Href_attri = 0;
		AlternativeText_attri = 0;
		Name_attri = 0;
		Type_attri = 0;
		Value_attri = 0;
		Class_attri = 0;
		OnClick_attri = 0;
		Hierarchy_Based_Locator = 0;
		Index_Based_Locator = 0;
		Invalid_Text_Field = 0;
		Missing_Value = 0;
		Value_Absent_Dropdown_List = 0;
		Unexpected_Assertion_Value = 0;
		Element_text = 0;
	}
	
	/****
	 * 
	 * similarity function takes two string as input and 
	 * return the similarity index of the string
	 * 
	 * ****/
	public double similarity(String s1, String s2) {
		String longer = s1, shorter = s2;
		if (s1.length() < s2.length()) {
			longer = s2;
			shorter = s1;
		}
		int longerLength = longer.length();
		if (longerLength == 0) {
			return 1.0;
		}
		return (longerLength - editDistance(longer, shorter)) / (double) longerLength;

	}
	

	/****
	 * 
	 * createFolders function takes folder name as input and 
	 * return create a folder at a static path and then create 
	 * 16 txt files to store 16 taxonomy changes of both the variants
	 * 
	 * ****/
	public void createFolders(String name) {
		String ChangeSidebySidePath="J:/7 semester/FYP/frontend/public/ChangesSidebySide/";
		File f = new File(ChangeSidebySidePath + name);
		FileWriter alt_text = null;
		FileWriter auto_id = null;
		FileWriter Class = null;
		FileWriter hierar_based = null;
		FileWriter href = null;
		FileWriter index_based = null;
		FileWriter invalid_text = null;
		FileWriter manual_id = null;
		FileWriter missing_value = null;
		FileWriter missing_value_dropdown = null;
		FileWriter Name = null;
		FileWriter onclick = null;
		FileWriter type = null;
		FileWriter unexpected_assertion = null;
		FileWriter value = null;
		FileWriter text = null;
		FileWriter allchanges = null;

		f.mkdir();
		try {
			alt_text = new FileWriter(ChangeSidebySidePath + name + "/1_alt_text.txt");
			auto_id = new FileWriter(ChangeSidebySidePath + name + "/1_auto_id.txt");
			Class = new FileWriter(ChangeSidebySidePath + name + "/1_Class.txt");
			hierar_based = new FileWriter(ChangeSidebySidePath + name + "/1_hierar_based.txt");
			href = new FileWriter(ChangeSidebySidePath + name + "/1_href.txt");
			index_based = new FileWriter(ChangeSidebySidePath + name + "/1_index_based.txt");
			invalid_text = new FileWriter(ChangeSidebySidePath + name + "/1_invalid_text.txt");
			manual_id = new FileWriter(ChangeSidebySidePath + name + "/1_manual_id.txt");
			missing_value = new FileWriter(ChangeSidebySidePath + name + "/1_missing_value.txt");
			missing_value_dropdown = new FileWriter(ChangeSidebySidePath + name + "/1_missing_value_dropdown.txt");
			Name = new FileWriter(ChangeSidebySidePath + name + "/1_Name.txt");
			onclick = new FileWriter(ChangeSidebySidePath + name + "/1_onclick.txt");
			type = new FileWriter(ChangeSidebySidePath + name + "/1_type.txt");
			unexpected_assertion = new FileWriter(ChangeSidebySidePath + name + "/1_unexpected_assertion.txt");
			value = new FileWriter(ChangeSidebySidePath + name + "/1_value.txt");
			text = new FileWriter(ChangeSidebySidePath + name + "/1_element_text.txt");
			allchanges = new FileWriter(ChangeSidebySidePath + name + "/1_allchanges.txt");

			alt_text = new FileWriter(ChangeSidebySidePath + name + "/2_alt_text.txt");
			auto_id = new FileWriter(ChangeSidebySidePath + name + "/2_auto_id.txt");
			Class = new FileWriter(ChangeSidebySidePath + name + "/2_Class.txt");
			hierar_based = new FileWriter(ChangeSidebySidePath + name + "/2_hierar_based.txt");
			href = new FileWriter(ChangeSidebySidePath + name + "/2_href.txt");
			index_based = new FileWriter(ChangeSidebySidePath + name + "/2_index_based.txt");
			invalid_text = new FileWriter(ChangeSidebySidePath + name + "/2_invalid_text.txt");
			manual_id = new FileWriter(ChangeSidebySidePath + name + "/2_manual_id.txt");
			missing_value = new FileWriter(ChangeSidebySidePath + name + "/2_missing_value.txt");
			missing_value_dropdown = new FileWriter(ChangeSidebySidePath + name + "/2_missing_value_dropdown.txt");
			Name = new FileWriter(ChangeSidebySidePath + name + "/2_Name.txt");
			onclick = new FileWriter(ChangeSidebySidePath + name + "/2_onclick.txt");
			type = new FileWriter(ChangeSidebySidePath + name + "/2_type.txt");
			unexpected_assertion = new FileWriter(ChangeSidebySidePath + name + "/2_unexpected_assertion.txt");
			value = new FileWriter(ChangeSidebySidePath + name + "/2_value.txt");
			text = new FileWriter(ChangeSidebySidePath + name + "/2_element_text.txt");
			allchanges = new FileWriter(ChangeSidebySidePath + name + "/2_allchanges.txt");

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	
	/****
	 * 
	 * intialize_Changes set allchanges map attribute to zero 
	 * this allchanges map stores all the taxonomy changes counts
	 * of each feature 
	 * 
	 * ****/
	
	public void intialize_Changes() {
		if (this.allChanges != null)
			this.allChanges.clear();
		this.allChanges = new HashMap<String, Integer>();
		this.allChanges.put("Auto ID Not Found", 0);
		this.allChanges.put("Manual ID Not Found", 0);
		this.allChanges.put("Href Attribute Not Found", 0);
		this.allChanges.put("Alternative Text Attribute Not Found", 0);
		this.allChanges.put("Name Attribute Not Found", 0);
		this.allChanges.put("Type Attribute Not Found", 0);
		this.allChanges.put("Value Attribute Not Found", 0);
		this.allChanges.put("Class Attribute Not Found", 0);
		this.allChanges.put("OnClick Attribute Not Found", 0);
		this.allChanges.put("Hierarchy-Based Locator Target not Found", 0);
		this.allChanges.put("Index-Based Locator Target not Found", 0);
		this.allChanges.put("Invalid Text Field Input", 0);
		this.allChanges.put("Missing Value", 0);
		this.allChanges.put("Value Absent from Dropdown List", 0);
		this.allChanges.put("Unexpected Assertion Value", 0);
		this.allChanges.put("Element Text not found", 0);

	}
	
	
	/****
	 * 
	 * percent_Changes get html tag of variant1 and variant2 and path to 
	 * store detected changes. this function detect detect all taxonomy 
	 * changes in both the variants'given lines and store into corresponding
	 * path.
	 * 
	 * ****/
	public void percent_Changes(String s1, String s2, String foldername) throws IOException {

		Document doc1 = Jsoup.parse(s1);
		Document doc2 = Jsoup.parse(s2);
		Elements elements1 = doc1.getAllElements();
		Elements elements2 = doc2.getAllElements();
		boolean flag = true;
		int size = elements1.size();
		for (int i = 0; i < size; i++) {
			if (elements1.size() > elements2.size())
				size = elements2.size();
			if (elements1.get(i).tagName() != elements2.get(i).tagName()) {
				this.allChanges.replace("Hierarchy-Based Locator Target not Found",
						this.allChanges.get("Hierarchy-Based Locator Target not Found") + 1);
				System.out.println("Tags are not same....breaking");
				FileWriter br1 = null;
				FileWriter br2 = null;
				try {
					br1 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/1_hierar_based.txt", true);
					br2 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/2_hierar_based.txt", true);
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
				br1.write(elements1.get(i).tagName() + "\n");
				br2.write(elements2.get(i).tagName() + "\n");
				br1.close();
				br2.close();
			}
			if (elements1.get(i).tagName() != "#root" && elements1.get(i).tagName() != "html"
					&& elements1.get(i).tagName() != "head" && elements1.get(i).tagName() != "body"
					&& elements2.size() == elements1.size()) {
				Attributes attrs1 = elements1.get(i).attributes();
				Attributes attrs2 = elements2.get(i).attributes();
				List<String> all_attr1_key = new ArrayList<String>();
				List<String> all_attr2_key = new ArrayList<String>();
				List<String> all_attr1_value = new ArrayList<String>();
				List<String> all_attr2_value = new ArrayList<String>();
				for (Attribute attr : attrs1) {
					all_attr1_key.add(attr.getKey());
					all_attr1_value.add(attr.getValue());
				}
				for (Attribute attr : attrs2) {
					all_attr2_key.add(attr.getKey());
					all_attr2_value.add(attr.getValue());
				}

				for (int l = 0; l < all_attr1_value.size(); l++) {
					if (all_attr2_key.contains(all_attr1_key.get(l))) {
						if (all_attr1_key.get(l).equals("href") && !all_attr1_value.get(l)
								.equals(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))))) {
							this.allChanges.replace("Href Attribute Not Found",
									this.allChanges.get("Href Attribute Not Found") + 1);
							FileWriter br1 = null;
							FileWriter br2 = null;
							try {
								br1 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/1_href.txt", true);
								br2 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/2_href.txt", true);
							} catch (IOException e) {
								System.out.println("An error occurred.");
								e.printStackTrace();
							}
							br1.write(all_attr1_value.get(l) + "\n");
							br2.write(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))) + "\n");
							br1.close();
							br2.close();
						}
						if (all_attr1_key.get(l).equals("id") && !all_attr1_value.get(l)
								.equals(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))))) {
							this.allChanges.replace("Manual ID Not Found",
									this.allChanges.get("Manual ID Not Found") + 1);
							FileWriter br1 = null;
							FileWriter br2 = null;
							try {
								br1 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/1_manual_id.txt", true);
								br2 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/2_manual_id.txt", true);
							} catch (IOException e) {
								System.out.println("An error occurred.");
								e.printStackTrace();
							}

							br1.write(all_attr1_value.get(l) + "\n");
							br2.write(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))) + "\n");
							br1.close();
							br2.close();
						}
						if (all_attr1_key.get(l).equals("alt") && !all_attr1_value.get(l)
								.equals(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))))) {
							this.allChanges.replace("Alternative Text Attribute Not Found",
									this.allChanges.get("Alternative Text Attribute Not Found") + 1);
							FileWriter br1 = null;
							FileWriter br2 = null;
							try {
								br1 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/1_alt_text.txt", true);
								br2 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/2_alt_text.txt", true);
							} catch (IOException e) {
								System.out.println("An error occurred.");
								e.printStackTrace();
							}

							br1.write(all_attr1_value.get(l) + "\n");
							br2.write(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))) + "\n");
							br1.close();
							br2.close();
						}
						if (all_attr1_key.get(l).equals("name") && !all_attr1_value.get(l)
								.equals(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))))) {
							this.allChanges.replace("Name Attribute Not Found",
									this.allChanges.get("Name Attribute Not Found") + 1);
							FileWriter br1 = null;
							FileWriter br2 = null;
							try {
								br1 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/1_Name.txt", true);
								br2 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/2_Name.txt", true);
							} catch (IOException e) {
								System.out.println("An error occurred.");
								e.printStackTrace();
							}

							br1.write(all_attr1_value.get(l) + "\n");
							br2.write(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))) + "\n");
							br1.close();
							br2.close();
						}
						if (all_attr1_key.get(l).equals("type") && !all_attr1_value.get(l)
								.equals(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))))) {
							this.allChanges.replace("Type Attribute Not Found",
									this.allChanges.get("Type Attribute Not Found") + 1);
							FileWriter br1 = null;
							FileWriter br2 = null;
							try {
								br1 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/1_type.txt", true);
								br2 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/2_type.txt", true);
							} catch (IOException e) {
								System.out.println("An error occurred.");
								e.printStackTrace();
							}

							br1.write(all_attr1_value.get(l) + "\n");
							br2.write(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))) + "\n");
							br1.close();
							br2.close();
						}
						if (all_attr1_key.get(l).equals("value") && !all_attr1_value.get(l)
								.equals(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))))) {
							this.allChanges.replace("Value Attribute Not Found",
									this.allChanges.get("Value Attribute Not Found") + 1);
							FileWriter br1 = null;
							FileWriter br2 = null;
							try {
								br1 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/1_value.txt", true);
								br2 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/2_value.txt", true);
							} catch (IOException e) {
								System.out.println("An error occurred.");
								e.printStackTrace();
							}

							br1.write(all_attr1_value.get(l) + "\n");
							br2.write(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))) + "\n");
							br1.close();
							br2.close();
						}
						if (all_attr1_key.get(l).equals("class") && !all_attr1_value.get(l)
								.equals(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))))) {
							this.allChanges.replace("Class Attribute Not Found",
									this.allChanges.get("Class Attribute Not Found") + 1);
							FileWriter br1 = null;
							FileWriter br2 = null;
							try {
								br1 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/1_Class.txt", true);
								br2 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/2_Class.txt", true);
							} catch (IOException e) {
								System.out.println("An error occurred.");
								e.printStackTrace();
							}

							br1.write(all_attr1_value.get(l) + "\n");
							br2.write(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))) + "\n");
							br1.close();
							br2.close();
						}
						if (all_attr1_key.get(l).equals("onclick") && !all_attr1_value.get(l)
								.equals(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))))) {
							this.allChanges.replace("OnClick Attribute Not Found",
									this.allChanges.get("OnClick Attribute Not Found") + 1);
							FileWriter br1 = null;
							FileWriter br2 = null;
							try {
								br1 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/1_onclick.txt", true);
								br2 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/2_onclick.txt", true);
							} catch (IOException e) {
								System.out.println("An error occurred.");
								e.printStackTrace();
							}

							br1.write(all_attr1_value.get(l) + "\n");
							br2.write(all_attr2_value.get(all_attr2_key.indexOf(all_attr1_key.get(l))) + "\n");
							br1.close();
							br2.close();
						}

					} else {
						System.out.println("<==================Not Found====================>");
					}
				}
				if (!(elements1.get(i).text().equals(elements2.get(i).text())) && flag
						&& !elements1.get(i).text().equals("") && !elements2.get(i).text().equals("")) {
					this.allChanges.replace("Element Text not found",
							this.allChanges.get("Element Text not found") + 1);
					FileWriter br1 = null;
					FileWriter br2 = null;
					try {
						br1 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/1_element_text.txt", true);
						br2 = new FileWriter("J:/7 semester/FYP/frontend/public/ChangesSidebySide/" + foldername + "/2_element_text.txt", true);
					} catch (IOException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}

					br1.write(elements1.get(i).text() + "\n");
					br2.write(elements2.get(i).text() + "\n");
					br1.close();
					br2.close();
					flag = false;
				}
				if (elements1.get(i).data() != "") {
				}
			}
		}
	}
	
	/****
	 * 
	 *editDistance function take two strings as input and return
	 *the count of index level difference character of strings
	 * 
	 * ****/
	public int editDistance(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

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
							new_value = Math.min(Math.min(new_value, last_value), arr[j]) + 1;
						arr[j - 1] = last_value;
						last_value = new_value;
					}
				}
			}
			if (i > 0)
				arr[s2.length()] = last_value;
		}
		return arr[s2.length()];
	}
	

	/****
	 * 
	 *printSimilarity function take two strings as input and print
	 *the similarity of both the strings
	 * 
	 * ****/
	public void printSimilarity(String s1, String s2) {
		double simi = similarity(s1, s2);
		if (simi >= 0.3) {
			System.out.println(String.format("%.3f similarity: \"%s\" and \"%s\"", simi, s1, s2));
		}
	}
	

	/****
	 * 
	 *Similarity function takes an array of variant1 and variant2
	 *similar lines and write then into a txt file 
	 * 
	 * ****/
	public void Similarity(String[] arr) throws IOException {
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter("similarity.txt");

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].charAt(0) == ' ') {
				myWriter.write(arr[i]);
				System.out.println(i + "         " + arr[i]);
			}
		}
		myWriter.close();
	}
	

	/****
	 * 
	 *sort_File function takes sorted array of variant1 and variant2
	 *lines and write into a file given as input
	 * 
	 * ****/
	public void sort_File(String[] arr, String filename) throws IOException {
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter(filename);

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		for (int i = 0; i < arr.length; i++) {

			myWriter.write(arr[i]);

		}
		myWriter.close();
	}
	

	/****
	 * 
	 *   diff_fun function takes two line of html of variant1 and variant2
	 *   and finds the character level difference and return variant1 html line 
	 *   attributes and Xpath in an array
	 * 
	 * ****/
	public String[] diff_fun(String v1_line, String v2_line, String foldername) throws IOException {
		List<String> list2 = new ArrayList<String>();

		v1_line = v1_line.substring(1, v1_line.length() - 1);
		v2_line = v2_line.substring(1, v2_line.length() - 1);
		v1_line = v1_line.trim();
		v2_line = v2_line.trim();
		Document doc = Jsoup.parse(v1_line);
		Elements elements1 = doc.getAllElements();
		Document doc1 = Jsoup.parse(v2_line);
		Elements elements2 = doc1.getAllElements();
		String fullLine = "";
		this.percent_Changes(v1_line, v2_line, foldername);
		fullLine = fullLine + "   Line:  " + v1_line;
		fullLine = fullLine + "         { ";
		int counter = 0, tagcount = 0;
		String Parent_Xpath1 = "", Parent_Xpath2 = "";
		boolean flag1 = true, flag2 = true;
		for (Element element : elements1) {
			if (element.tagName() != "#root" && element.tagName() != "html" && element.tagName() != "head"
					&& element.tagName() != "body") {

				tagcount++;
				fullLine = fullLine + "   tag " + tagcount + ":" + element.tagName() + "   Attributes:  ";
				Attributes attrs = element.attributes();

				for (Attribute attr : attrs) {
					if (flag1) {
						Parent_Xpath1 = "//" + element.tagName().toString() + "[@" + attr.toString() + "]";
						flag1 = false;
					}
					counter++;
					fullLine = fullLine + "   " + counter + ":  " + attr;
				}
				if (element.text() != "") {
					counter++;
					fullLine = fullLine + "   " + counter + ":  text:" + element.text();
					if (flag1) {
						Parent_Xpath1 = "//" + element.tagName().toString() + "[text()=" + element.text() + "]";

						flag1 = false;
					}
				}
				if (element.data() != "") {
					counter++;
					fullLine = fullLine + "   " + counter + ":  data:" + element.data();
				}
			}
			flag1 = true;
			counter = 0;

		}
		fullLine = fullLine + "         }";
		list2.add(fullLine);
		list2.add(Parent_Xpath1);
		fullLine = "";

		fullLine = fullLine + "   Line:  " + v2_line;
		fullLine = fullLine + "        { ";
		counter = 0;
		tagcount = 0;
		for (Element element : elements2) {
			if (element.tagName() != "#root" && element.tagName() != "html" && element.tagName() != "head"
					&& element.tagName() != "body") {
				tagcount++;
				fullLine = fullLine + "   tag " + tagcount + ":" + element.tagName() + "   Attributes:  ";
				Attributes attrs = element.attributes();

				for (Attribute attr : attrs) {
					counter++;
					fullLine = fullLine + "   " + counter + ":  " + attr;
					if (flag1) {
						Parent_Xpath2 = "//" + element.tagName().toString() + "[@" + attr.toString() + "]";
						flag1 = false;
					}
				}
				if (element.text() != "") {
					counter++;
					fullLine = fullLine + "   " + counter + ":  text:" + element.text();
					if (flag1) {
						Parent_Xpath2 = "//" + element.tagName().toString() + "[text()=" + element.text() + "]";

						flag1 = false;
					}

				}
				if (element.data() != "") {
					counter++;
					fullLine = fullLine + "   " + counter + ":  data:" + element.data();
				}
			}

			counter = 0;

		}

		fullLine = fullLine + "         }";
		list2.add(fullLine);
		list2.add(Parent_Xpath2);
		fullLine = "";
		Parent_Xpath1 = "";
		Parent_Xpath2 = "";
		String[] arr2 = list2.toArray(new String[0]);
		return arr2;
	}
	

	/****
	 * 
	 *   Diffrence_Phrase function filter html files and call diff_fun function 
	 *  and get array containing both the variants corresponding 
	 *  lines, attributes and xpaths and write in to txt files basically 
	 *  this function stores phrase wise difference of both the variants
	 *  into a json file
	 * 
	 * ****/
	public void Diffrence_Phrase(String[] arr, String filename, String txtfile, String foldername) throws IOException {

		String length = "", v1_line = "", v2_line = "";
		int diffrence_index = 100;
		FileWriter myWriter = null;

		try {
			myWriter = new FileWriter(txtfile);

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() > 5
					&& !(((arr[i].charAt(0) == '-') && (arr[i + 2].charAt(0) == '?') && (arr[i + 4].charAt(0) == '+'))
							|| ((arr[i].charAt(0) == '-') && (arr[i + 2].charAt(0) == '+')
									&& (arr[i + 4].charAt(0) == '?')))
					&& !(arr[i].charAt(0) == '+' && arr[i + 2].charAt(0) == '?') && (arr[i].charAt(0) == '+')
					&& !(arr[i].charAt(3) == '!') && !(arr[i].charAt(3) == '/')) {
				if (arr[i + 4].length() > 5 && arr[i + 2].length() > 5 && arr[i].length() > 5
						&& !((arr[i].charAt(0) == '+') && (arr[i + 2].charAt(0) == '+')) && !(arr[i].charAt(3) == '!')
						&& !(arr[i + 2].charAt(3) == '!') && !(arr[i + 4].charAt(3) == '!')) {
					// System.out.println("\n\n\n");
					if (i + 20 <= arr.length) {
						for (int k = i + 2; k < i + 20; k += 2) {
							if (arr[k].charAt(0) == '?')
								break;
							if (arr[k].charAt(0) == '?')
								break;
							if (!(arr[i].charAt(3) == '/') && !(arr[i].charAt(3) == '!')) {
								double simi = similarity(arr[k], arr[i]);
								if (simi >= 0.5) {
									String[] arr2 = this.diff_fun(arr[k], arr[i], filename);
									arr2[0] = arr2[0].replace('%', ' ');
									arr2[1] = arr2[1].replace('%', ' ');
									myWriter.write(String
											.format("v111:      " + arr2[0] + "   XPath: " + arr2[1]
													+ "      pageTitle: " + this.GetPageTitle(foldername + filename))
											+ "\n");
									arr2[2] = arr2[2].replace('%', ' ');
									arr2[3] = arr2[3].replace('%', ' ');
									myWriter.write(String
											.format("v222:      " + arr2[2] + "   XPath: " + arr2[3]
													+ "      pageTitle: " + this.GetPageTitle(foldername + filename))
											+ "\n\n\n");

								}
							}
						}

					} else {
						for (int k = i + 2; k < arr.length; k += 2) {
							if (arr[k].charAt(0) == '?')
								break;
							if (!(arr[i].charAt(3) == '/') && !(arr[i].charAt(3) == '!')) {
								double simi = similarity(arr[k], arr[i]);
								if (simi >= 0.5) {
									String[] arr2 = this.diff_fun(arr[k], arr[i], filename);
									arr2[0] = arr2[0].replace('%', ' ');
									arr2[1] = arr2[1].replace('%', ' ');
									myWriter.write(String
											.format("v11:      " + arr2[0] + "   XPath: " + arr2[1]
													+ "      pageTitle: " + this.GetPageTitle(foldername + filename))
											+ "\n");
									arr2[2] = arr2[2].replace('%', ' ');
									arr2[3] = arr2[3].replace('%', ' ');
									myWriter.write(String
											.format("v22:      " + arr2[2] + "   XPath: " + arr2[3]
													+ "      pageTitle: " + this.GetPageTitle(foldername + filename))
											+ "\n\n\n");

								}
							}
						}
					}
				}
			}

			if (((arr[i].charAt(0) == '-') && (arr[i + 2].charAt(0) == '?') && (arr[i + 4].charAt(0) == '+'))
					|| ((arr[i].charAt(0) == '-') && (arr[i + 2].charAt(0) == '+') && (arr[i + 4].charAt(0) == '?'))) {
				if ((arr[i].charAt(0) == '-') && (arr[i + 2].charAt(0) == '+') && (arr[i + 4].charAt(0) == '?')
						&& !(arr[i].charAt(3) == '!')
						&& !(arr[i + 2].charAt(3) == '!' && !(arr[i + 4].charAt(3) == '!'))) {
					v1_line = arr[i];
					v2_line = arr[i + 2];

				} else if ((arr[i].charAt(0) == '-') && (arr[i + 2].charAt(0) == '?')
						&& (arr[i + 4].charAt(0) == '+')) {
					v1_line = arr[i];
					v2_line = arr[i + 4];
				}

				String[] arr2 = this.diff_fun(v1_line, v2_line, filename);
				arr2[0] = arr2[0].replace('%', ' ');
				arr2[1] = arr2[1].replace('%', ' ');
				myWriter.write(String.format("v1:      " + arr2[0] + "   XPath: " + arr2[1] + "      pageTitle: "
						+ this.GetPageTitle(foldername + filename)) + "\n");
				arr2[2] = arr2[2].replace('%', ' ');
				arr2[3] = arr2[3].replace('%', ' ');
				myWriter.write(String.format("v2:      " + arr2[2] + "   XPath: " + arr2[3] + "      pageTitle: "
						+ this.GetPageTitle(foldername + filename)) + "\n\n\n");
			}
			diffrence_index = 100;
		}
		myWriter.close();

		FileWriter br1 = null;
		try {
			br1 = new FileWriter("J:/7 semester/FYP/frontend/src/GraphsData/ChangesSidebySide/" + filename + "/data.json");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}


		String[] Taxonomy_name={"Auto Id","Manual Id","Href Attribute","Alternative Text","Name Attribute","Type Attribute","Value Attribute","Class Attribute"
				,"On Click Attribute","Hierarchy Based Locator","Index Based Locator","Invalid Text Feild","Missing Value","Dropdown list Value",
				"Unexpected Assertion","Element Text"};
		Integer[] Taxanomy_values= {this.allChanges.get("Auto ID Not Found"),this.allChanges.get("Manual ID Not Found"),this.allChanges.get("Href Attribute Not Found")
				,this.allChanges.get("Alternative Text Attribute Not Found"),this.allChanges.get("Name Attribute Not Found"),this.allChanges.get("Type Attribute Not Found"),
				this.allChanges.get("Value Attribute Not Found"), this.allChanges.get("Class Attribute Not Found"),this.allChanges.get("OnClick Attribute Not Found")
				,this.allChanges.get("Hierarchy-Based Locator Target not Found"),this.allChanges.get("Index-Based Locator Target not Found"),this.allChanges.get("Invalid Text Field Input"),
				this.allChanges.get("Missing Value"),this.allChanges.get("Value Absent from Dropdown List"),this.allChanges.get("Unexpected Assertion Value"),
				this.allChanges.get("Element Text not found")};

		List<String> list = new ArrayList<String>();
		int i=0;
		while (i<Taxonomy_name.length) {
			JSONObject obj = new JSONObject();
			obj.put("type", Taxonomy_name[i]);
			obj.put("value", new Integer(Taxanomy_values[i]));
			Gson gson1 = new Gson(); 
			String json1 = gson1.toJson(obj); 
			list.add(json1);
			i++;
		}

		br1.write(list.toString());
		br1.close();
		AutoID += this.allChanges.get("Auto ID Not Found");
		ManualID += this.allChanges.get("Manual ID Not Found");
		Href_attri += this.allChanges.get("Href Attribute Not Found");
		AlternativeText_attri += this.allChanges.get("Alternative Text Attribute Not Found");
		Name_attri += this.allChanges.get("Name Attribute Not Found");
		Type_attri += this.allChanges.get("Type Attribute Not Found");
		Value_attri += this.allChanges.get("Value Attribute Not Found");
		Class_attri += this.allChanges.get("Class Attribute Not Found");
		OnClick_attri += this.allChanges.get("OnClick Attribute Not Found");
		Hierarchy_Based_Locator += this.allChanges.get("Hierarchy-Based Locator Target not Found");
		Index_Based_Locator += this.allChanges.get("Index-Based Locator Target not Found");
		Invalid_Text_Field += this.allChanges.get("Invalid Text Field Input");
		Missing_Value += this.allChanges.get("Missing Value");
		Value_Absent_Dropdown_List += this.allChanges.get("Value Absent from Dropdown List");
		Unexpected_Assertion_Value += this.allChanges.get("Unexpected Assertion Value");
		Element_text += this.allChanges.get("Element Text not found");

	}
	

	/****
	 * 
	 *  Write_Overall_changes function write the overall changes of a complete 
	 *  variant into a json file
	 * 
	 * ****/
	public void Write_Overall_changes() throws IOException {

		FileWriter br2 = null;
		try {
			br2 = new FileWriter("J:/7 semester/FYP/frontend/src/GraphsData/data.json");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		String[] Taxonomy_name={"Auto Id","Manual Id","Href Attribute","Alternative Text","Name Attribute","Type Attribute","Value Attribute","Class Attribute"
				,"On Click Attribute","Hierarchy Based Locator","Index Based Locator","Invalid Text Feild","Missing Value","Dropdown list Value",
				"Unexpected Assertion","Element Text"};
		Integer[] Taxanomy_values= {AutoID,ManualID,Href_attri,AlternativeText_attri,Name_attri,Type_attri,Value_attri,Class_attri,OnClick_attri,Hierarchy_Based_Locator,
				Index_Based_Locator,Invalid_Text_Field,Missing_Value,Value_Absent_Dropdown_List,Unexpected_Assertion_Value,Element_text};

		List<String> list = new ArrayList<String>();
		int i=0;
		while (i<Taxonomy_name.length) {
			JSONObject obj = new JSONObject();
			obj.put("type", Taxonomy_name[i]);
			obj.put("value", new Integer(Taxanomy_values[i]));
			Gson gson1 = new Gson(); 
			String json1 = gson1.toJson(obj); 
			list.add(json1);
			i++;
		}

		br2.write(list.toString());


		br2.close();
	}
	

	
	/****
	 * 
	 *  GetPageTitle function takes a webpage html file as
	 *  input and return the page title of the page
	 * 
	 * ****/
	public String GetPageTitle(String filename) throws IOException {
		File input1 = new File(filename);
		Document doc1 = Jsoup.parse(input1, "UTF-8", "");
		String pageTitle = "";
		Elements elements1 = doc1.getAllElements();

		for (Element element : elements1) { // unique tags

			if (element.attr("class").toString().equals("toolTitle mainTitle"))
				pageTitle = element.text();
		}
		return pageTitle;
	}


	/****
	 * 
	 *  GetAllTags function takes a webpage html file as
	 *  input and return the all all html tags parent in file
	 * 
	 * ****/
	public Set<String> GetAllTags(String filename, Set<String> tag_list) throws IOException {
		File input1 = new File(filename);
		Document doc1 = Jsoup.parse(input1, "UTF-8", "");
		Elements elements1 = doc1.getAllElements();
		for (Element element : elements1) { // unique tags
			tag_list.add(element.tagName());
			if (element.tagName() == "body" || element.tagName() == "input" || element.tagName() == "li"
					|| element.tagName() == "label") {
			} else {
			}
		}
		return tag_list;
	}


	/****
	 * 
	 *  Formatting function takes a webpage html file as
	 *  input and remove white spaces and comments for 
	 *  better understanding
	 * 
	 * ****/
	public List<String> Formatting(String filename) throws IOException {
		DOM_Diffrence_Detector obj = new DOM_Diffrence_Detector();
		Set<String> tag_list = new LinkedHashSet<String>();
		tag_list = obj.GetAllTags(filename, tag_list);
		String st1, st2, firstTag = "", lastTag = "", sortedLine = "", nextLine = "";
		List<String> list3 = new ArrayList<String>();
		List<String> sorted_List = new ArrayList<String>();
		File input1 = new File(filename);
		BufferedReader br1 = new BufferedReader(new FileReader(input1));
		int j = 0;
		String first = "", last = "", sort = "";
		int lines = 0;

		while ((st1 = br1.readLine()) != null) {
			list3.add(st1);
		}

		for (int i = 0; i < list3.size(); i++) {
			st1 = list3.get(i);
			lines++;
			st1 = st1.trim();
			if (!st1.isEmpty() && st1.charAt(0) == '<' && st1.charAt(1) != '!') {
				int index = st1.indexOf(' ');
				if (index > -1) { // Check if there is more than one word.

					first = st1.substring(0, index).trim(); // Extract first word.
					last = st1.replaceAll("^.*?(\\w+)\\W*$", "$1");
					first = first.substring(1, first.length());
					tag_list.add(first);
					if (first.equals("html") || first.equals("head") || first.equals("body") || first.equals("div")
							|| first.equals("meta") || first.equals("link")) {
						st1 = st1.replaceAll("\\s{2,}", " ");
						sorted_List.add(st1 + "\n");
					} else {
						firstTag = st1.substring(1, index).trim();

						String[] newTag = firstTag.split(">");
						firstTag = newTag[0];
						if (!sortedLine.equals("")) {
							sortedLine = sortedLine.replaceAll("\\s{2,}", " ");
							sorted_List.add(sortedLine + "\n");
							sortedLine = "";
						}
						if (st1.contains("</" + firstTag)) {
							st1 = st1.replaceAll("\\s{2,}", " ");
							sorted_List.add(st1 + "\n");
							sortedLine = "";
						} else {

							sortedLine = st1;
							for (int k = i; k < i + 10; k++) {
								st2 = list3.get(k + 1);
								st2 = st2.trim();
								if (!st2.isEmpty() && (st2.length() > 1 && st2.charAt(1) != '!')) {
									nextLine = st2.substring(0, 3).trim(); // Extract first word.
									if (nextLine.charAt(0) == '<') {
										sortedLine = sortedLine.replaceAll("\\s{2,}", " ");
										sorted_List.add(sortedLine + "\n");
										sortedLine = "";
									} else {
									}
									break;
								}

							}

							lastTag = firstTag;

						}
					}
				} else {
					last = st1.replaceAll("^.*?(\\w+)\\W*$", "$1");
					if (last.equals("html") || last.equals("head") || last.equals("body") || last.equals("div")
							|| last.equals("meta") || last.equals("link") || last.equals("title")) {
						st1 = st1.replaceAll("\\s{2,}", " ");
						sorted_List.add(st1 + "\n");

					} else {

						if (st1.contains("</" + firstTag)) {
							sortedLine = sortedLine + st1;
							sortedLine = sortedLine.replaceAll("\\s{2,}", " ");
							sorted_List.add(sortedLine + "\n");
							sortedLine = "";
						} else {
							if (st1.charAt(1) == '/') {
								sortedLine = sortedLine + st1;
								sortedLine = sortedLine.replaceAll("\\s{2,}", " ");
								sorted_List.add(sortedLine + "\n");
								sortedLine = "";
							} else {
								if (sortedLine != "") {
									sortedLine = sortedLine.replaceAll("\\s{2,}", " ");
									sorted_List.add(sortedLine + "\n");
									sortedLine = "";
								}
								if (st1.equals("<hr>") || st1.equals("<br>")) {
									st1 = st1.replaceAll("\\s{2,}", " ");
									sorted_List.add(st1 + "\n");
								} else
									sortedLine = st1;
							}
						}
					}

				}

			} else {
				last = st1.replaceAll("^.*?(\\w+)\\W*$", "$1");
				if (tag_list.contains(last)) {

					if (st1.contains("</" + firstTag)) {
						sortedLine = sortedLine + st1;
						sortedLine = sortedLine.replaceAll("\\s{2,}", " ");
						sorted_List.add(sortedLine + "\n");
						sortedLine = "";
					} else {
						sortedLine = sortedLine + st1;

					}

				} else {
					if (sortedLine != "") {
						sortedLine = sortedLine + st1;
					} else {
						st1 = st1.replaceAll("\\s{2,}", " ");
						sorted_List.add(st1 + "\n");
					}
				}
			}

			j++;
		}
		return sorted_List;
	}

}
