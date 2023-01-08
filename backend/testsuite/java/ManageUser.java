import static org.testng.Assert.fail;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import Common.DriverIntializor;
	public class ManageUser extends DriverIntializor {
		
		//static WebDriver  driver;
		//WebDriverWait wait;
		//static JavascriptExecutor js;
		private boolean acceptNextAlert = true;
		  private StringBuffer verificationErrors = new StringBuffer();
		@Test(priority =1 ,groups= "regression")
		public void Authentication ()throws Exception
		{
			driver.manage().window().setSize(new Dimension(1382, 744));
			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");  //set the value		    driver.findElement(By.cssSelector("button:nth-child(11)")).click();
		    driver.findElement(By.cssSelector("tbody:nth-child(1) td:nth-child(1)")).click();
		    driver.findElement(By.cssSelector(".toolTitle")).click();
			/*
			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");  //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click(); //click on Enter
			 try {
				Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My desktop[\\s\\S]*$")); //validation
				driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click(); //click on logout
			} catch (Exception e) {
				e.printStackTrace();
			}
			*/
		}
		
		@Test(priority =2 ,groups= "regression")
		public void testLogout()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click();  //click on logout
			 try {
				Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Authentication[\\s\\S]*$")); //validation
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		@Test(priority =3 ,groups= "regression")
		public void testCreateUser ()throws Exception
		{
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 
			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[4]/a")).get(0).click();   //click on create user
		    driver.findElement(By.id("firstname")).clear();        //clear the field
		    driver.findElement(By.id("firstname")).sendKeys("Abid"); //set the value
		    driver.findElement(By.id("lastname")).clear();        //clear the field
		    driver.findElement(By.id("lastname")).sendKeys("Hussain"); //set the value
		    driver.findElement(By.id("officialCode")).clear();        //clear the field
		    driver.findElement(By.id("officialCode")).sendKeys("1234"); //set the value
		    driver.findElement(By.id("username")).clear();        //clear the field
		    driver.findElement(By.id("username")).sendKeys("nam"); //set the value
		    driver.findElement(By.id("username")).clear();        //clear the field
		    driver.findElement(By.id("username")).sendKeys("abid"); //set the value
		    driver.findElement(By.id("password")).clear();        //clear the field
		    driver.findElement(By.id("password")).sendKeys("123456"); //set the value
		    driver.findElement(By.id("password_conf")).clear();        //clear the field
		    driver.findElement(By.id("password_conf")).sendKeys("123456"); //set the value
		    driver.findElement(By.id("student")).click();  //click on Folloe Courses(Student) button
//		    driver.findElement(By.id("student")).click();
//		    driver.findElement(By.id("student")).click();
		    // Warning: verifyTextPresent may require manual changes
		    try {
		      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\\(student\\)[\\s\\S]*$"));  //validation
		    } catch (Error e) {
		    	System.out.println (e);
		    }
		    driver.findElement(By.id("applyChange")).click(); //click on OK
		  Assert.assertEquals("Create a new user - Claroline", driver.getTitle());
		    driver.findElement(By.linkText("Logout")).click();
		  
		}
		
		@Test(priority =4 ,groups= "regression")
		public void testCancelCreateUser()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 
			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[4]/a")).get(0).click();   //click on create user
			  driver.findElement(By.linkText("Logout")).click(); //click on logout button
			 try {
				Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Authentication[\\s\\S]*$")); //validation
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		@Test(priority =5 ,groups= "regression")
		public void testRegisterThisUserToACourse()throws Exception
		{
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 
			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[4]/a")).get(0).click();   //click on create user
		    driver.findElement(By.id("firstname")).clear();        //clear the field
		    driver.findElement(By.id("firstname")).sendKeys("Ahsan"); //set the value
		    driver.findElement(By.id("lastname")).clear();        //clear the field
		    driver.findElement(By.id("lastname")).sendKeys("Khan"); //set the value
		    driver.findElement(By.id("officialCode")).clear();        //clear the field
		    driver.findElement(By.id("officialCode")).sendKeys("12335"); //set the value
		    driver.findElement(By.id("username")).clear();        //clear the field
		    driver.findElement(By.id("username")).sendKeys("nam"); //set the value
		    driver.findElement(By.id("username")).clear();        //clear the field
		    driver.findElement(By.id("username")).sendKeys("Ahsan"); //set the value
		    driver.findElement(By.id("password")).clear();        //clear the field
		    driver.findElement(By.id("password")).sendKeys("123456"); //set the value
		    driver.findElement(By.id("password_conf")).clear();        //clear the field
		    driver.findElement(By.id("password_conf")).sendKeys("123456"); //set the value
		    driver.findElement(By.id("student")).click();  //click on Folloe Courses(Student) button
	
		    try {
		      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\\(student\\)[\\s\\S]*$"));  //validation
		    } catch (Error e) {
		    	System.out.println (e);
		    }
		    driver.findElement(By.id("applyChange")).click(); //click on OK
		    driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/a")).get(0).click();   //click on Register this user to a course tab
		    Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/h3[1]")).getText(),"Root category");//validation of alert
		   
		    driver.findElement(By.linkText("Logout")).click();  //click to logout
		  
		}
		
		@Test(priority =6 ,groups= "regression")
		public void testUserSetting()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 
			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[4]/a")).get(0).click();   //click on create user
		    driver.findElement(By.id("firstname")).clear();        //clear the field
		    driver.findElement(By.id("firstname")).sendKeys("Aqi"); //set the value
		    driver.findElement(By.id("lastname")).clear();        //clear the field
		    driver.findElement(By.id("lastname")).sendKeys("Khan"); //set the value
		    driver.findElement(By.id("officialCode")).clear();        //clear the field
		    driver.findElement(By.id("officialCode")).sendKeys("123478"); //set the value
		    driver.findElement(By.id("username")).clear();        //clear the field
		    driver.findElement(By.id("username")).sendKeys("nam1"); //set the value
		    driver.findElement(By.id("username")).clear();        //clear the field
		    driver.findElement(By.id("username")).sendKeys("Aqi"); //set the value
		    driver.findElement(By.id("password")).clear();        //clear the field
		    driver.findElement(By.id("password")).sendKeys("123456"); //set the value
		    driver.findElement(By.id("password_conf")).clear();        //clear the field
		    driver.findElement(By.id("password_conf")).sendKeys("123456"); //set the value
		    driver.findElement(By.id("student")).click();  //click on Folloe Courses(Student) button
	
		    try {
		      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\\(student\\)[\\s\\S]*$"));  //validation
		    } catch (Error e) {
		    	System.out.println (e);
		    }
		    driver.findElement(By.id("applyChange")).click(); //click on OK
		    driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[2]/a")).get(0).click();   //click on create user
		    Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[1]/table/tbody/tr/td[1]/h1")).getText(),"USER SETTINGS");//validation of alert
		   
		    driver.findElement(By.linkText("Logout")).click();  //click to logout
			
		}

		@Test(priority =7 ,groups= "regression")
		public void testCreateSameUserTwice ()throws Exception
		{
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 
			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[4]/a")).get(0).click();   //click on create user
		    driver.findElement(By.id("firstname")).clear();        //clear the field
		    driver.findElement(By.id("firstname")).sendKeys("Abid"); //set the value
		    driver.findElement(By.id("lastname")).clear();        //clear the field
		    driver.findElement(By.id("lastname")).sendKeys("Hussain"); //set the value
		    driver.findElement(By.id("officialCode")).clear();        //clear the field
		    driver.findElement(By.id("officialCode")).sendKeys("1234"); //set the value
		    driver.findElement(By.id("username")).clear();        //clear the field
		    driver.findElement(By.id("username")).sendKeys("nam"); //set the value
		    driver.findElement(By.id("username")).clear();        //clear the field
		    driver.findElement(By.id("username")).sendKeys("abid"); //set the value
		    driver.findElement(By.id("password")).clear();        //clear the field
		    driver.findElement(By.id("password")).sendKeys("123456"); //set the value
		    driver.findElement(By.id("password_conf")).clear();        //clear the field
		    driver.findElement(By.id("password_conf")).sendKeys("123456"); //set the value
		    driver.findElement(By.id("student")).click();  //click on Folloe Courses(Student) button
	
		    try {
		      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\\(student\\)[\\s\\S]*$"));  //validation
		    } catch (Error e) {
		    	System.out.println (e);
		    }
		    driver.findElement(By.id("applyChange")).click(); //click on OK
		    Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[2]")).getText(),"This username is already taken");//validation of alert
		   
		    driver.findElement(By.linkText("Logout")).click();  //click to logout
		  
		}

		@Test(priority =8 ,groups= "regression")
		public void testUserList()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[2]/a")).get(0).click();   //click on USer List tab
			 try {
				Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*USER LIST[\\s\\S]*$")); //validation
			} catch (Exception e) {
				e.printStackTrace();
			}
			 driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click();  //click on logout
			
		}
		@Test(priority =9 ,groups= "regression")
		public void testSendAMessageToAllUsers()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[3]/a")).get(0).click();   //click on Send a message to all users
			driver.findElement(By.id("message_subject")).clear(); //clearing subject field
		    driver.findElement(By.id("message_subject")).sendKeys("Hello");  //setting subject to hello
		    driver.findElement(By.id("message_fontselect_open")).click();// click on Font Family
		    driver.findElement(By.cssSelector("#mce_18_aria > span.mceText")).click();//selecting font curier new
		    driver.findElement(By.cssSelector("span.mceIcon.mce_bold")).click();//click to Bold the text
		    driver.findElement(By.cssSelector("span.mceIcon.mce_italic")).click();//click to italic the text
			//driver.findElement(By.cssSelector("#tinymce")).sendKeys("Please_be_on_time_tomorrow");  //set the value
		    // Warning: verifyTextPresent may require manual changes
		    try {
		      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Administrator[\\s\\S]*$"));//validation
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		    driver.findElement(By.name("send")).click();//click to send message
		    driver.findElement(By.linkText("Logout")).click();  //click to logout
		}
		

		
		@Test(priority =10 ,groups= "regression")
		public void testAddAUserList()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[5]/a")).get(0).click();   //click on add user list
			driver.findElements(By.xpath("//*[@id=\"firstLineFormat_NO\"]")).get(0).click();   //click  to select default file format
			driver.findElements(By.xpath("//*[@id=\"sendEmailToUserCreated\"]")).get(0).click();   //click to to select to send email to all users
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/form/input[7]")).get(0).click();   //click to add users
			try {
			      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*You must select a file[\\s\\S]*$")); //validation
			    } catch (Exception e) {
			    	e.printStackTrace();
			    }
			    driver.findElement(By.linkText("Logout")).click(); //click to logout
		}
		
		@Test(priority =11 ,groups= "regression")
		public void testWrongPassward ()throws Exception
		{
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 
			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[4]/a")).get(0).click();   //click on create user
		    driver.findElement(By.id("firstname")).clear();        //clear the field
		    driver.findElement(By.id("firstname")).sendKeys("Abid"); //set the value
		    driver.findElement(By.id("lastname")).clear();        //clear the field
		    driver.findElement(By.id("lastname")).sendKeys("Hussain"); //set the value
		    driver.findElement(By.id("officialCode")).clear();        //clear the field
		    driver.findElement(By.id("officialCode")).sendKeys("1234"); //set the value
		    driver.findElement(By.id("username")).clear();        //clear the field
		    driver.findElement(By.id("username")).sendKeys("nam"); //set the value
		    driver.findElement(By.id("username")).clear();        //clear the field
		    driver.findElement(By.id("username")).sendKeys("abid"); //set the value
		    driver.findElement(By.id("password")).clear();        //clear the field
		    driver.findElement(By.id("password")).sendKeys("123456"); //set the value
		    driver.findElement(By.id("password_conf")).clear();        //clear the field
		    driver.findElement(By.id("password_conf")).sendKeys("1234567"); //set the value
		    driver.findElement(By.id("student")).click();  //click on Folloe Courses(Student) button
	
		    try {
		      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\\(student\\)[\\s\\S]*$"));  //validation
		    } catch (Error e) {
		    	System.out.println (e);
		    }
		    driver.findElement(By.id("applyChange")).click(); //click on OK
		    Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[1]")).getText(),"You typed two different passwords");//validation of alert
		   
		    driver.findElement(By.linkText("Logout")).click();  //click to logout
		  
		}
		
		
		@Test(priority =12 ,groups= "regression")
		public void testWrongOfficialCode ()throws Exception
		{
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 
			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[4]/a")).get(0).click();   //click on create user
		    driver.findElement(By.id("firstname")).clear();        //clear the field
		    driver.findElement(By.id("firstname")).sendKeys("Abid"); //set the value
		    driver.findElement(By.id("lastname")).clear();        //clear the field
		    driver.findElement(By.id("lastname")).sendKeys("Hussain"); //set the value
		    driver.findElement(By.id("officialCode")).clear();        //clear the field
		    driver.findElement(By.id("officialCode")).sendKeys("12345"); //set the value
		    driver.findElement(By.id("username")).clear();        //clear the field
		    driver.findElement(By.id("username")).sendKeys("nam"); //set the value
		    driver.findElement(By.id("username")).clear();        //clear the field
		    driver.findElement(By.id("username")).sendKeys("abid"); //set the value
		    driver.findElement(By.id("password")).clear();        //clear the field
		    driver.findElement(By.id("password")).sendKeys("123456"); //set the value
		    driver.findElement(By.id("password_conf")).clear();        //clear the field
		    driver.findElement(By.id("password_conf")).sendKeys("123456"); //set the value
		    driver.findElement(By.id("student")).click();  //click on Folloe Courses(Student) button
	
		    try {
		      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\\(student\\)[\\s\\S]*$"));  //validation
		    } catch (Error e) {
		    	System.out.println (e);
		    }
		    driver.findElement(By.id("applyChange")).click(); //click on OK
		    Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[1]")).getText(),"This official code is already used by another user.");//validation of alert
		   
		    driver.findElement(By.linkText("Logout")).click();  //click to logout
		  
		}
		
		@Test(priority =13 ,groups= "regression")
		public void testDeleteUser ()throws Exception
		{
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 
			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[2]/a")).get(0).click();   //click on User list
			driver.findElement(By.id("search")).clear();      //clear the field
			driver.findElement(By.id("search")).sendKeys("12335");  //set the value
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table[1]/tbody/tr[1]/td/form/input[2]")).get(0).click();   //click on OK
		    driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[7]/a/img")).click();//click on user setting
		    driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[1]/table/tbody/tr/td[2]/ul/li[4]/a")).click();  //click on delete this user
		    driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/a[1]")).click();  //click on yes
		    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div")).getText(), "Deletion of the user was done sucessfully");
		    driver.findElement(By.linkText("Logout")).click();  //click to logout
		  
		}
		
		@Test(priority =14 ,groups= "regression")
		public void testResetPasswardOfAllUsers()throws Exception
		{
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 
			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[2]/a")).get(0).click();   //click on User list
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[1]/table/tbody/tr/td[2]/ul/li[2]/a")).get(0).click();   //click on Reset all users passward
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[2]/form/input[3]")).get(0).click();   //click on yes
		    Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[1]")).getText(), "Password changed successfully for all concerned users");
		    driver.findElement(By.linkText("Logout")).click();  //click to logout
		  
		}
		
		@Test(priority =15 ,groups= "regression")
		public void testMergeTwoUserAccounts()throws Exception
		{
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 
			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[2]/a")).get(0).click();   //click on User list
			String str1=driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr[2]/td[1]")).getText();  //getting 1st user ID
			String str2=driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr[3]/td[1]")).getText();  //getting 2nd User ID
			System.out.println(str1+str2);
			driver.findElements(By.xpath("//*[@id=\"breadcrumbLine\"]/div[1]/ul/li[2]/a")).get(0).click();  //click on Administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[9]/a")).get(0).click();  //click on Merge user accounts
			driver.findElement(By.id("uidToRemove")).sendKeys(str1);  //setting the 1st ID value
			driver.findElement(By.id("uidToKeep")).sendKeys(str2);  //setting the 2nd ID value
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[2]/form/input[2]")).get(0).click();  //click on merge
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/form/input[3]")).get(0).click();  //click on yes
		    Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[1]")).getText(), "User accounts merged");
		    driver.findElement(By.linkText("Logout")).click();  //click to logout
		  
		}

//
//		@AfterClass(alwaysRun = true)
//		  public void tearDown() throws Exception {
//		    driver.quit();
//		    String verificationErrorString = verificationErrors.toString();
//		    if (!"".equals(verificationErrorString)) {
//		      fail(verificationErrorString);
//		    }
//		  }
//
//		  @SuppressWarnings("unused")
//		private boolean isElementPresent(By by) {
//		    try {
//		      driver.findElement(by);
//		      return true;
//		    } catch (NoSuchElementException e) {
//		      return false;
//		    }
//		  }
//
//		  @SuppressWarnings("unused")
//		private boolean isAlertPresent() {
//		    try {
//		      driver.switchTo().alert();
//		      return true;
//		    } catch (NoAlertPresentException e) {
//		      return false;
//		    }
//		  }
//
//		  @SuppressWarnings("unused")
//		private String closeAlertAndGetItsText() {
//		    try {
//		      Alert alert = driver.switchTo().alert();
//		      String alertText = alert.getText();
//		      if (acceptNextAlert) {
//		        alert.accept();
//		      } else {
//		        alert.dismiss();
//		      }
//		      return alertText;
//		    } finally {
//		      acceptNextAlert = true;
//		    }
//		  }
		
//		public static void main(String[] arges) {
//			CreateUser myObj =new CreateUser();
//			myObj.invokeBrowser();
//		}
}
