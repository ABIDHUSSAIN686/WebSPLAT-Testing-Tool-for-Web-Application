package com.example.demo;

import java.io.File;
import java.io.FileWriter; 
import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/****
 * 
 *WebPage class is used to 
 *extract web pages of a variant.
 * 
 * ****/

public class WebPage {
	protected static WebDriver driver;
	protected WebDriverWait wait;
	protected static JavascriptExecutor js;
	protected String pageName;
	protected String pageID;
	protected String pageURL;
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getPageID() {
		return pageID;
	}
	public void setPageID(String pageID) {
		this.pageID = pageID;
	}
	public String getPageURL() {
		return pageURL;
	}
	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}
	
	
	/****
	 * 
	 *generator function is used to 
	 *extract web pages of a variant.
	 *it take root link of the variant as input
	 *and store the files to the given path as 
	 *input.
	 * 
	 * ****/
	public void genrator(String rootLink,String foldername) throws IOException {
		String filepath = foldername+"/";
		File file1 = new File(filepath);
		FileUtils.cleanDirectory(file1);
		String strs=rootLink.substring(16);
		int no = 0;
		int index = 0;
		String fileName;
		int pageLinkno = 0;
		boolean duplicateFiles = false;
		String pageLink = rootLink;

		ArrayList<String> linkArray = new ArrayList<String>();// Creating arraylist
		Set<String> s;
		int flag = 1;

		Iterator itr1 = linkArray.iterator(); // getting the Iterator
		System.setProperty("webdriver.chrome.driver",
				"J:\\7 semester\\FYP\\Spring_Boot\\chromedriver.exe");
		driver = new ChromeDriver(); // for Chrome driver

		int i = 0;
		do {

			int totallinks = 0;
			System.out.println("link No. = " + i);
			System.out.println("Main Page Link = " + pageLink);

			driver.get(pageLink); // loading page url to driver

			if (i > 0) {
				boolean isloginPresent = driver.findElements(By.id("login")).size() > 0;

				if (isloginPresent) {
					driver.findElement(By.id("login")).clear(); // clear the field
					driver.findElement(By.id("login")).sendKeys("admin");
					driver.findElement(By.id("password")).clear(); // clear the field
					driver.findElement(By.id("password")).sendKeys("admin");
				}

				boolean isEnterPresent = driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button"))
						.size() > 0;
						boolean isOkPresent = driver
								.findElements(By.xpath("//*[@id=\"claroBody\"]/div[1]/form/fieldset/input[6]")).size() > 0;

								if (isEnterPresent) {
									driver.findElement(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).click();

								} else if (isOkPresent) {
									driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[1]/form/fieldset/input[6]")).click();
								}
			}

			String duplicatefileName = "";
			String title = driver.getTitle();
			System.out.println(title);

			fileName = no +"  "+title+".html"; 
			String p = driver.getPageSource(); 
			
			/*
			 * Fetching already created files from the folder and comparing their page
			 * source with page source of current page to detect duplications
			 */
			try {
				String content = "";
				File folder = new File(foldername+"/");
				File[] listOfFiles = folder.listFiles();

				for (File file : listOfFiles) {
					if (file.isFile()) {
						String fileName1 = file.getPath();
						content = new String(Files.readAllBytes(Paths.get(fileName1)));
						// comparing page source
						duplicateFiles = p.equals(content);
						if (duplicateFiles) {
							duplicatefileName = fileName1;
							break;
						}
					}
				}

				System.out.println("File Same ? " + p.equals(content) + "\nDuplicate With = " + duplicatefileName);

				// if current page is duplicated then ignore it, otherwise make file
				if (!(duplicateFiles)&&!title.equals("")) {

					System.out.println(no+"   "+fileName);
					FileWriter myWriter = new FileWriter(filepath + "\\" + fileName);
					myWriter.write(p);
					myWriter.close();

					FileWriter fw = new FileWriter(filepath + "\\Links.txt", true);
					fw.write(no + "-pageLink--->" + pageLink + "\n");
					fw.close();
				}

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

			// If current page is not duplicate, then extract href tags
			if (!(duplicateFiles)&&!title.equals("")) {

				File input1 = new File(filepath + "\\" + fileName);
				Document doc1 = Jsoup.parse(input1, "UTF-8", "");
				Elements elements1 = doc1.body().getAllElements();

				String l = "";
				System.out.println("Links of this Page are = ");
				for (Element element : elements1) {
					if (element.hasAttr("href")) // href tags
					{
						if ((element.attr("href").contains(strs)
								|| element.attr("href").contains(".php"))) {
							if (element.attr("href").contains(strs)
									&& !(element.attr("href").contains("//localhost"))) {
								totallinks++;
								linkArray.add("http://localhost" + element.attr("href"));
								System.out.println("http://localhost" + element.attr("href"));
							} else if (element.attr("href").equals("inscription.php")) {
								totallinks++;
								linkArray.add("http://localhost"+strs+"auth/inscription.php");
								System.out.println("http://localhost"+strs+"auth/inscription.php");
							} else if (element.attr("href").contains("//localhost")) {
								totallinks++;
								linkArray.add(element.attr("href"));
								System.out.println(element.attr("href"));
							}
						}
					}
				}
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------");
				// set to remove duplicate links from arraylist
				s = new LinkedHashSet<String>(linkArray);
				linkArray.clear();
				linkArray.addAll(s);
				s.clear();

				// Traversing list through Iterator
				Iterator itrr = linkArray.iterator(); // getting the Iterator
				System.out.println("Total Links in a Page = " + totallinks);
			}

			no++;
			if (linkArray.size() > pageLinkno)
			{
				pageLink = linkArray.get(pageLinkno);
				pageLinkno++;
			}
			else
			{
				break;
			}

			i++;

		} while (itr1.hasNext()); // check if iterator has the elements

		System.out.println(
				"\n\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\nList without Duplication : \n");
		System.out.println("Total links are = " + linkArray.size());

		// Traversing list through Iterator
		Iterator itrr = linkArray.iterator(); // getting the Iterator
		while (itrr.hasNext()) // check if iterator has the elements
		{
			System.out.println(itrr.next()); // printing the element and move to next
		}
		driver.close();	
	}
	public static void main(String[] args) throws Exception {

	}
}