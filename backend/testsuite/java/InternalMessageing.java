import static org.testng.Assert.fail;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import Common.DriverIntializor;
public class InternalMessageing extends DriverIntializor{
	private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @Test(priority =1 ,groups= "regression")
		public void testAllMessagesFromAUser()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[6]/ul/li/a")).get(0).click();  //click on Internal Massageing
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul[1]/li[1]/a")).get(0).click();   //click on All message from a user
			driver.findElement(By.name("name")).clear();      //clear the field
			driver.findElement(By.name("name")).sendKeys("abid");  //set the value
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/form/input[2]")).get(0).click();   //click on Search
			
			
			 Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/form/table/thead/tr/th[2]")).getText(), "Subject");  //validation
			    driver.findElement(By.linkText("Logout")).click();  //click to logout
		}
	  
	  @Test(priority =2 ,groups= "regression")
		public void testAllMessagesOlderThan()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[6]/ul/li/a")).get(0).click();  //click on Internal Massageing
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul[1]/li[2]/a")).get(0).click();   //click on All messages older then
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/form/input[2]")).get(0).click();   //click on Search
			 Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/form/table/thead/tr/th[2]")).getText(), "Subject");  //validation
			    driver.findElement(By.linkText("Logout")).click();  //click to logout
		}
	  
	  @Test(priority =3 ,groups= "regression")
		public void testAllPlatformMessages()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[6]/ul/li/a")).get(0).click();  //click on Internal Massageing
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul[1]/li[4]/a")).get(0).click();   //click on All platform messages
			 Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[1]/span")).getText(), "All platform messages");  //validation
			    driver.findElement(By.linkText("Logout")).click();  //click to logout
		}
	
	  @Test(priority =4 ,groups= "regression")
		public void testAllMessagesInDateInterval()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[6]/ul/li/a")).get(0).click();  //click on Internal Massageing
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul[1]/li[3]/a")).get(0).click();   //click on All messages in date interval
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/form/input[3]")).get(0).click();   //click on Search
			 Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/form/table/thead/tr/th[2]")).getText(), "Subject");  //validation
			    driver.findElement(By.linkText("Logout")).click();  //click to logout
		}
	  
	  
	  
	  @Test(priority =5 ,groups= "regression")
		public void testDeleteAllMessagesFromAUser()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[6]/ul/li/a")).get(0).click();  //click on Internal Massageing
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul[2]/li[2]/a")).get(0).click();   //click on All messages from a user
			driver.findElement(By.name("search")).clear();      //clear the field
			driver.findElement(By.name("search")).sendKeys("abid");  //set the value
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/form/input[2]")).get(0).click();   //click on Search

			 Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table/thead/tr/th[1]")).getText(), "Id");  //validation
			    driver.findElement(By.linkText("Logout")).click();  //click to logout
		}
	  
	  @Test(priority =6 ,groups= "regression")
		public void testDeleteAllMessagesOlderThan()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[6]/ul/li/a")).get(0).click();  //click on Internal Massageing
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul[2]/li[3]/a")).get(0).click();   //click on All messages older than
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/form/input[2]")).get(0).click();   //click on Delete
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[3]/a[1]")).get(0).click();   //click on yes
			 Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/a")).getText(), "Back");  //validation
			    driver.findElement(By.linkText("Logout")).click();  //click to logout
		}
	  @Test(priority =7 ,groups= "regression")
		public void testDeleteAllMessages()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[6]/ul/li/a")).get(0).click();  //click on Internal Massageing
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul[2]/li[1]/a")).get(0).click();   //click on All messages
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[3]/a[1]")).get(0).click();   //click on yes
			 Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/a")).getText(), "Back");  //validation
			    driver.findElement(By.linkText("Logout")).click();  //click to logout
		}
	  
	  @Test(priority =8 ,groups= "regression")
		public void testDeleteAllPlatformMssages() throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[6]/ul/li/a")).get(0).click();  //click on Internal Massageing
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul[2]/li[4]/a")).get(0).click();   //click on All platform messages
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[3]/a[1]")).get(0).click();   //click on yes
			 Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/a")).getText(), "Back");  //validation
			    driver.findElement(By.linkText("Logout")).click();  //click to logout
		}
	  
	  
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
