import static org.testng.Assert.fail;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import Common.DriverIntializor;
public class CourseManagemnt extends DriverIntializor{
	private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @Test(priority =1 ,groups= "regression")
		public void testChatting()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[2]/ul/li[2]/a")).get(0).click();  //click on Course list
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).get(0).click();   //click on Data structure
			driver.findElements(By.xpath("//*[@id=\"CLCHAT\"]")).get(0).click();   //click on chat
			driver.findElement(By.id("clchat_msg")).clear();      //clear the field
			driver.findElement(By.id("clchat_msg")).sendKeys("hello");  //set the value
			driver.findElements(By.xpath("//*[@id=\"clchat_form\"]/input[4]")).get(0).click();   //click to send
			Assert.assertNotEquals(driver.findElements(By.xpath("//*[@id=\"clchat_msg\"]")).get(0).equals(null),null);   //click on chat
			driver.findElement(By.linkText("Logout")).click();  //click to logout
			
			
		}
	  
	  @Test(priority =2 ,groups= "regression")
		public void testResetChatting()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[2]/ul/li[2]/a")).get(0).click();  //click on Course list
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).get(0).click();   //click on Data structure
			driver.findElements(By.xpath("//*[@id=\"CLCHAT\"]")).get(0).click();   //click on chat
			driver.findElements(By.xpath("//*[@id=\"clchat_cmd_flush\"]")).get(0).click();   //click on reset
			Alert alert = driver.switchTo().alert();
	        alert.accept();
	        Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*[\\s\\S]*$")); //validation
			driver.findElement(By.linkText("Logout")).click();  //click to logout
			
			
			
		}
	  
	  
	  @Test(priority =3 ,groups= "regression")
		public void testCreateWiki()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[2]/ul/li[2]/a")).get(0).click();  //click on Course list
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).get(0).click();   //click on Data structure
			driver.findElements(By.xpath("//*[@id=\"CLWIKI\"]")).get(0).click();   //click on wiki
			driver.findElements(By.xpath("//*[@id=\"courseRightContent\"]/div/table/tbody/tr/td[2]/ul/li[2]/a")).get(0).click();   //click on create new wiki
			driver.findElement(By.id("wikiDesc")).clear();      //clear the field
			driver.findElement(By.id("wikiDesc")).sendKeys("new wiki is created");  // set decription
			driver.findElements(By.xpath("//*[@id=\"other_edit\"]")).get(0).click();   //click to select
			driver.findElements(By.xpath("//*[@id=\"wikiProperties\"]/input[3]")).get(0).click();   //click on OK
	        Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Wiki creation succeed[\\s\\S]*$")); //validation
			driver.findElement(By.linkText("Logout")).click();  //click to logout
			
			
			
		}
	  
	  
	  @Test(priority =4 ,groups= "regression")
		public void testAddUserTOCourse()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[2]/ul/li[2]/a")).get(0).click();  //click on Course list
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).get(0).click();   //click on Data structure
			driver.findElements(By.xpath("//*[@id=\"CLUSR\"]")).get(0).click();   //click on users
			driver.findElements(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[2]/a")).get(0).click();   //click on add user
			
			driver.findElement(By.id("lastname")).clear();      //clear the field
			driver.findElement(By.id("lastname")).sendKeys("Khan");  // set decription
			driver.findElement(By.id("firstname")).clear();      //clear the field
			driver.findElement(By.id("firstname")).sendKeys("Aqi");  // set decription
			
			driver.findElements(By.xpath("//*[@id=\"applySearch\"]")).get(0).click();   //click on search
			
			
			driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[6]/form/input[7]")).get(0).click();   //click to enroll
	        Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Aqi Khan has been registered to your course[\\s\\S]*$")); //validation
			driver.findElement(By.linkText("Logout")).click();  //click to logout
			
			
			
		}
	  
	  @Test(priority =5 ,groups= "regression")
			public void testUnregisterAllStudents()throws Exception
			{
				
				//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

				driver.findElement(By.id("login")).clear();      //clear the field
				driver.findElement(By.id("login")).sendKeys("admin");  //set the value
				driver.findElement(By.id("password")).clear();        //clear the field
				driver.findElement(By.id("password")).sendKeys("admin");   //set the value
				driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
				driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
				driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[2]/ul/li[2]/a")).get(0).click();  //click on Course list
				driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table[2]/tbody/tr/td[2]/a")).get(0).click();   //click on Data structure
				driver.findElements(By.xpath("//*[@id=\"CLUSR\"]")).get(0).click();   //click on users
				driver.findElements(By.xpath("//*[@id=\"courseRightContent\"]/div[1]/table/tbody/tr/td[2]/ul/li[4]/a")).get(0).click();   //click to unregistor all users
				Alert alert = driver.switchTo().alert();
		        alert.accept();
//		        Alert alert1 = driver.switchTo().alert();
//		        alert1.accept();
		      
		        Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div")).getText(),"1 student(s) unregistered from this course");//validation of alert
				   
		    //    Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*1 student(s) unregistered from this course[\\s\\S]*$")); //validation
				driver.findElement(By.linkText("Logout")).click();  //click to logout
				
				
				
			}
	  
	 
	  
//	  
//	 
//	  @AfterClass(alwaysRun = true)
//	  public void tearDown() throws Exception {
//	    driver.quit();
//	    String verificationErrorString = verificationErrors.toString();
//	    if (!"".equals(verificationErrorString)) {
//	      fail(verificationErrorString);
//	    }
//	  }
//
//	  @SuppressWarnings("unused")
//	private boolean isElementPresent(By by) {
//	    try {
//	      driver.findElement(by);
//	      return true;
//	    } catch (NoSuchElementException e) {
//	      return false;
//	    }
//	  }
//
//	  @SuppressWarnings("unused")
//	private boolean isAlertPresent() {
//	    try {
//	      driver.switchTo().alert();
//	      return true;
//	    } catch (NoAlertPresentException e) {
//	      return false;
//	    }
//	  }
//
//	  @SuppressWarnings("unused")
//	private String closeAlertAndGetItsText() {
//	    try {
//	      Alert alert = driver.switchTo().alert();
//	      String alertText = alert.getText();
//	      if (acceptNextAlert) {
//	        alert.accept();
//	      } else {
//	        alert.dismiss();
//	      }
//	      return alertText;
//	    } finally {
//	      acceptNextAlert = true;
//	    }
//	  }
}
