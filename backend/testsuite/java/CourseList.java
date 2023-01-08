import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Common.DriverIntializor;


public class CourseList extends DriverIntializor
{
	JavascriptExecutor jse;
//	 
//    @Test(priority = 1, groups = "regression")
//    public void logIn()          //testing LogIn  
//    {
//	    //login
//		driver.findElement(By.id("login")).sendKeys("admin");
//		driver.findElement(By.id("password")).sendKeys("admin");
//		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
//	
//    	AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*MY DESKTOP[\\s\\S]*$"));
//		 
//    	//logout
//    	driver.findElement(By.linkText("Logout")).click();	 
//    }
    
   
    
    @Test(priority = 2, groups = "regression")
    public void PlatformAdministration_CourseList_Coursetitle_AddaNewPortlet_Announcement()         //testing Platform administration --> Course list --> Course title(e.g CNET) --> Add a new portlet: Announcement
    {
        //logIn
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		 
		driver.findElement(By.linkText("Platform administration")).click();              //click on Platform administration button
		driver.findElement(By.linkText("Course list")).click();							//click on Course list button in Courses
		 
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).click();		//click on Course Title(e.g CNET)  
		driver.findElement(By.linkText("Add a new portlet: Announcement")).click();						//Add a new portlet
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Portlet created[\\s\\S]*$"));
		
		
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div/div[2]/h1/a")).click();		//click on Manage Next course events
		driver.findElement(By.linkText("Add announcement")).click();									//click on Add announcement
		
		driver.findElement(By.id("title")).sendKeys("Regarding AI Elective Registration for Batch-2019 in Fall-2022 Semester");
		driver.findElement(By.xpath("//*[@id=\"newContent_bold\"]/span[1]")).click();
		
		driver.findElement(By.cssSelector("#emailOption")).click();
		driver.findElement(By.className("doCollapse")).click();
		
		driver.findElement(By.id("enable_visible_from")).click();
		driver.findElement(By.id("enable_visible_until")).click();
		
		jse = (JavascriptExecutor)driver;
	    jse.executeScript("scroll(0,300)");
		
	    driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/input")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Announcement has been added[\\s\\S]*$"));
		
		
		driver.findElement(By.linkText("Clear up list of announcements")).click();	
		Alert alert = driver.switchTo().alert();
		alert.accept();
	    Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Announcements list has been cleared up[\\s\\S]*$"));
		
	    
		driver.findElement(By.linkText("Messages to selected users")).click();	
		driver.findElement(By.xpath("//*[@id=\"mslist1\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/form/div/table/tbody/tr/td[2]/a[1]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/form/div/div/input[1]")).sendKeys("FYP Hardware");
		
		driver.findElement(By.cssSelector("#courseRightContent > div.messagesform > form > div > div > input[type=submit]:nth-child(12)")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Message sent[\\s\\S]*$"));
			
		
    	//logout
    	driver.findElement(By.linkText("Logout")).click();	 
		 
    }
    
    
    @Test(priority = 3, groups = "regression")
    public void PlatformAdministration_CourseList_Coursetitle_AddaNewPortlet_Calendar()         //testing Platform administration --> Course list --> Course title(e.g CNET) --> Add a new portlet: Announcement
    {       
  
        //logIn
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		 
		driver.findElement(By.linkText("Platform administration")).click();              //click on Platform administration button
		driver.findElement(By.linkText("Course list")).click();			//click on Course list button in Courses
		 
	
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).click();		//click on Course Title(e.g CNET)
		
		//Delete portlet
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div/div/h1/span[2]/a[4]/img")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Portlet deleted[\\s\\S]*$"));
		
		driver.findElement(By.linkText("Add a new portlet: Calendar")).click();			//Add a new portlet
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Portlet created[\\s\\S]*$"));
		
		
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div/div[2]/h1/a")).click();		//click on Mange Next course events
		driver.findElement(By.linkText("Add an event")).click();			//click on Add announcement
		
		driver.findElement(By.id("title")).sendKeys("Batch 22 Orientation Session");
		driver.findElement(By.id("lasting")).sendKeys("2-Hours");
		driver.findElement(By.id("location")).sendKeys("Auditorium");
		driver.findElement(By.id("speakers")).sendKeys("Dr. Ahmad Ali, Dr. Sikandar Sultan");
	    driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/input")).click();
	    Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Event added to the agenda.[\\s\\S]*$"));
	    
	    
	    driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[3]/div[3]/a[2]/img")).click();
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Event deleted from the agenda.[\\s\\S]*$"));
	 
		//logout
    	driver.findElement(By.linkText("Logout")).click();	
	 
    }
    
    
    @Test(priority = 4, groups = "regression")
    public void PlatformAdministration_CourseList_Coursetitle_AddaNewPortlet_Headline()         //testing Platform administration --> Course list --> Course title(e.g CNET) --> Add a new portlet: Announcement
    {       
  
        //logIn
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		 
		driver.findElement(By.linkText("Platform administration")).click();              //click on Platform administration button
		driver.findElement(By.linkText("Course list")).click();			//click on Course list button in Courses
		 
	
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).click();		//click on Course Title(e.g CNET)  
		
		//Delete portlet
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div/div/h1/span[2]/a[4]/img")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Portlet deleted[\\s\\S]*$"));
		
		driver.findElement(By.linkText("Add a new portlet: Headlines")).click();			//Add a new portlet
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Portlet created[\\s\\S]*$"));
		
	    driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div/div[2]/h1/a")).click();	
		
		driver.findElement(By.xpath("//*[@id=\"content_formatselect_open\"]")).click();		//click on Mange Next course events
		driver.findElement(By.linkText("Paragraph")).click();			//click on Add announcement
		
	    driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/input")).click();
	    Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Introduction added[\\s\\S]*$"));
	    
	    driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[3]/div[2]/a[2]/img")).click();
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	    Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Introduction deleted[\\s\\S]*$"));
	    
	    //logout
    	driver.findElement(By.linkText("Logout")).click();	
    }
    
    
    
    @Test(priority = 5, groups = "regression")
    public void PlatformAdministration_CourseList_CourseTitle_CourseDescription()         //Platform administration --> Course list -->  Course title --> Course description
    {       
	    //logIn
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		 
		driver.findElement(By.linkText("Platform administration")).click();              //click on Platform administration button
		driver.findElement(By.linkText("Course list")).click();			//click on Course list button in Courses
		 
	
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).click();		//click on Course Title(e.g CNET)
		
		driver.findElement(By.id("CLDSC")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/fieldset/input[4]")).click();	
		driver.findElement(By.xpath("//*[@id=\"descContent_formatselect_open\"]")).click();	
		driver.findElement(By.linkText("Heading 1")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/p[1]/input")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Description added[\\s\\S]*$"));
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[3]/div[2]/a[2]/img")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Description deleted.[\\s\\S]*$"));
		
		//logout
		driver.findElement(By.linkText("Logout")).click();	
    }
    
    
    
    @Test(priority = 5, groups = "regression")
    public void PlatformAdministration_CourseList_CourseTitle_Document()         //Platform administration --> Course list --> Course title -->   Document
    {       
    //logIn
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		 
		driver.findElement(By.linkText("Platform administration")).click();              //click on Platform administration button
		driver.findElement(By.linkText("Course list")).click();			//click on Course list button in Courses
		 
	
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).click();		//click on Course Title(e.g CNET)
		
		driver.findElement(By.id("CLDOC")).click();
		
		//File Upload
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div/table/tbody/tr/td[2]/ul/li[3]/a")).click();	
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div[2]/form/input")).click();	
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*No file uploaded[\\s\\S]*$"));
		
		//Hyperlink
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"fileName\"]")).sendKeys("Slate");
		driver.findElement(By.xpath("//*[@id=\"url\"]")).sendKeys("http://slate.nu.edu.pk/portal");
		driver.findElement(By.xpath("//*[@id=\"comment\"]")).sendKeys("This is slate.");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div[2]/form/input[7]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*This is slate.[\\s\\S]*$"));
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/table/tbody/tr[1]/td[5]/a/img")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Document deleted[\\s\\S]*$"));
		
		//Directory	
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div/table/tbody/tr/td[2]/ul/li[4]/a")).click();    
		driver.findElement(By.xpath("//*[@id=\"newName\"]")).sendKeys("3D Objects");
		driver.findElement(By.xpath("//*[@id=\"comment\"]")).sendKeys("This is my new directory.");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div[2]/form/input[6]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Directory created[\\s\\S]*$")); 
		
		
		
		//Document
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[7]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/p[1]/input")).sendKeys("NewDocument");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/p[3]/input")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*File created[\\s\\S]*$"));
		
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[2]/a")).click();	
		driver.findElement(By.xpath("//*[@id=\"searchPattern\"]")).sendKeys("Hello");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div/form/input[6]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Nothing to display[\\s\\S]*$"));
		
		
		//logout
    	driver.findElement(By.linkText("Logout")).click();	
	
    }


   
    

    @Test(priority = 6, groups = "regression")
    public void PlatformAdministration_CourseList_CourseTitle_Exercises()      //testing Platform administration --> Course list --> Course title -->  Exercises
    {       
	    //logIn
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		 
		driver.findElement(By.linkText("Platform administration")).click();              //click on Platform administration button
		driver.findElement(By.linkText("Course list")).click();							//click on Course list button in Courses
		 
	
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).click();		//click on Course Title(e.g CNET)
		driver.findElement(By.id("CLQWZ")).click();               										//click on Exercises
		
		//New Exercise
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("Exercise No.1");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/div[2]/input")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Exercise added[\\s\\S]*$"));
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[1]/a")).click();
		
		
		//Import exercise
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div/form/p/input")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Import failed[\\s\\S]*$"));
		driver.findElement(By.id("CLQWZ")).click();
		
		
		
		//Question Pool
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li/a")).click();
		driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("Do you think living in New York City has become expensive?");
		driver.findElement(By.xpath("//*[@id=\"TF\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/div[2]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"trueCorrect\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/table/tbody/tr[1]/td[4]/input")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/table/tbody/tr[3]/td/input")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Do you think living in New York City has become expensive?[\\s\\S]*$"));
		driver.findElement(By.id("CLQWZ")).click();
		
		
		//Question categories
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li/a")).click();
		driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("Cat1");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/table/tbody/tr[4]/td[2]/input")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Category created[\\s\\S]*$"));
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/table/tbody/tr/td[3]/a/img")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Category deleted[\\s\\S]*$"));
		driver.findElement(By.id("CLQWZ")).click();
		
		//My results
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"leftContent\"]/div[1]/table/tbody/tr/td[2]/ul/li/a")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Month[\\s\\S]*$"));
		
		//logout
    	driver.findElement(By.linkText("Logout")).click();	
    }
    
    
    

    @Test(priority = 7, groups = "regression")
    public void PlatformAdministration_CourseList_CourseTitle_LearningPath()         //testing Platform administration --> Course list --> Course title -->  Learning Path
    {       
	    //logIn
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		 
		driver.findElement(By.linkText("Platform administration")).click();              //click on Platform administration button
		driver.findElement(By.linkText("Course list")).click();							//click on Course list button in Courses
		 
	
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).click();		//click on Course Title(e.g CNET)
		driver.findElement(By.id("CLLNP")).click();               										//click on Learning Path
		
		
	    //Create a new learning path
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div/table/tbody/tr/td[2]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"newPathName\"]")).sendKeys("HTML to React");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div/form/input[2]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HTML to React[\\s\\S]*$"));
		
		//Import a learning path
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/p/input")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*An error occurred. Learning Path import failed.[\\s\\S]*$"));
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/a")).click();
		
		
		//Pool of modules
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div/table/tbody/tr/td[2]/ul/li[3]/a")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*No module[\\s\\S]*$"));
		driver.findElement(By.id("CLLNP")).click();       
		
		//User tracking
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div/table/tbody/tr/td[2]/ul/li[4]/a")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*0%[\\s\\S]*$"));
		
		//logout
    	driver.findElement(By.linkText("Logout")).click();	
    }
    
    
    
    
    @Test(priority = 8, groups = "regression")
    public void PlatformAdministration_CourseList_CourseTitle_Assignment()         //testing Platform administration --> Course list --> Course title -->  Document
    {       
	    //logIn
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		 
		driver.findElement(By.linkText("Platform administration")).click();              //click on Platform administration button
		driver.findElement(By.linkText("Course list")).click();			//click on Course list button in Courses
		 
	
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).click();		//click on Course Title(e.g CNET)
		
		driver.findElement(By.id("CLWRK")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[2]/a")).click();
		
		//Assignment Creation and Deletion
		driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("CNET Assignment.1");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/fieldset/dl/dd[9]/input")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*New assignment created[\\s\\S]*$"));
		
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/table/tbody[2]/tr/td[6]/a/img")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Assignment deleted[\\s\\S]*$"));
		
		//Download Submissions
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div[2]/form/input[8]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*There is no submission available for download with these settings.[\\s\\S]*$"));
		
		
		//logout
    	driver.findElement(By.linkText("Logout")).click();	
    }
    

    @Test(priority = 9, groups = "regression")
    public void PlatformAdministration_CourseList_CourseTitle_Forums()         //testing Platform administration --> Course list --> Course title-->   Forums
    {       
	    //logIn
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		 
		driver.findElement(By.linkText("Platform administration")).click();              //click on Platform administration button
		driver.findElement(By.linkText("Course list")).click();							//click on Course list button in Courses
		 
	
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).click();		//click on Course Title(e.g CNET)
		driver.findElement(By.id("CLFRM")).click();               										//click on Learning Path
		
		
	    //Create Category
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div/table/tbody/tr/td[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"catName\"]")).sendKeys("Category 2");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div/form/input[5]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*The new category has been created.[\\s\\S]*$"));
		
		//Create forum
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"forumName\"]")).sendKeys("Forum 2");
		driver.findElement(By.xpath("//*[@id=\"forumDesc\"]")).sendKeys("This is my forum 2.");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div/form/input[11]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Forum created.[\\s\\S]*$"));
		
		//Search 
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div/form/input[3]")).sendKeys("Forum 2");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div/form/input[4]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Search result : Forum 2[\\s\\S]*$"));
		
		//logout
    	driver.findElement(By.linkText("Logout")).click();	
    }
    
    
    
    @Test(priority = 10, groups = "regression")
    public void PlatformAdministration_CourseList_CourseTitle_Groups()         //testing Platform administration --> Course list --> Course title-->   Groups
    {       
	    //logIn
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		 
		driver.findElement(By.linkText("Platform administration")).click();              //click on Platform administration button
		driver.findElement(By.linkText("Course list")).click();							//click on Course list button in Courses
		 
	
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).click();		//click on Course Title(e.g CNET)
		driver.findElement(By.id("CLGRP")).click();               										//click on Learning Path
		
		
	    //Create new Group(s)
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"creation\"]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*1 group\\(s\\) has \\(have\\) been added[\\s\\S]*$"));
		
		//Delete all groups
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[2]/a")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Empty[\\s\\S]*$"));
		
		
		//Main Group Settings
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/form/table/tbody/tr[15]/td/input")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Group settings have been modified[\\s\\S]*$"));
		
        
		//Fill groups (automatically)
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[4]/a")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Groups have been filled \\(or completed\\) by students present in the 'Users' list.[\\s\\S]*$"));
		
		
		//Empty all groups
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[5]/a")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*All groups are now empty[\\s\\S]*$"));
		
		//logout
    	driver.findElement(By.linkText("Logout")).click();	
    }
    
    
    @Test(priority = 11, groups = "regression")
    public void PlatformAdministration_CourseList_CourseTitle_EditToolList()         //testing Platform administration --> Course list --> Course title -->   Edit Tool List
    {       
	    //logIn
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		 
		driver.findElement(By.linkText("Platform administration")).click();              //click on Platform administration button
		driver.findElement(By.linkText("Course list")).click();							//click on Course list button in Courses
		 
	
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).click();		//click on Course Title(e.g CNET)
		driver.findElement(By.xpath("//*[@id=\"courseManageToolList\"]/li[1]/a")).click();
		
		//Manage tool access rights
		//Anonymous
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/blockquote/table/tbody/tr[1]/td[3]/a/span")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*No access[\\s\\S]*$"));
		
		//Guest
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/blockquote/table/tbody/tr[1]/td[4]/a/span")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*No access[\\s\\S]*$"));
		
		//User
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/blockquote/table/tbody/tr[1]/td[5]/a/span")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Edition allowed[\\s\\S]*$"));
		
		//Manager
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/blockquote/table/tbody/tr[1]/td[6]/a/span")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Edition allowed[\\s\\S]*$"));
		
		//Manage External Links
		driver.findElement(By.xpath("//*[@id=\"extLinks\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/blockquote/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"toolName\"]")).sendKeys("Slate");
		driver.findElement(By.xpath("//*[@id=\"toolUrl\"]")).sendKeys("http://slate.nu.edu.pk/portal");
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[3]/div/form/input[8]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*External Tool added.[\\s\\S]*$"));
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/blockquote/table/tbody/tr/td[4]/a/img")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*External tool deleted[\\s\\S]*$"));
		
		
		//Add or remove tool
		driver.findElement(By.xpath("//*[@id=\"toolList\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/blockquote[1]/table/tbody/tr[1]/td[2]/a/img")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Tool removed from course[\\s\\S]*$"));
		
		//logout
    	driver.findElement(By.linkText("Logout")).click();	
    }
    
    
    
    @Test(priority = 12, groups = "regression")
    public void PlatformAdministration_CourseList_CourseTitle_Statistics()         //testing Platform administration --> Course list --> Course title -->  Statistics
    {       
	    //logIn
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		 
		driver.findElement(By.linkText("Platform administration")).click();              //click on Platform administration button
		driver.findElement(By.linkText("Course list")).click();							//click on Course list button in Courses
		 
	
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).click();		//click on Course Title(e.g CNET)
		driver.findElement(By.xpath("//*[@id=\"courseManageToolList\"]/li[4]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li/a")).click();
		driver.findElement(By.xpath("//*[@id=\"scope_all\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div[2]/form/input[6]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Course statistics are now empty[\\s\\S]*$"));
		
		//logout
    	driver.findElement(By.linkText("Logout")).click();	
    }	
    
    

	 

}
