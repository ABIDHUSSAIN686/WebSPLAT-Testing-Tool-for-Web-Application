import static org.testng.Assert.fail;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import Common.DriverIntializor;
public class ProfileManagement extends DriverIntializor{
	private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @Test(priority =1 ,groups= "regression")
		public void testAddNewProfile()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[7]/a")).get(0).click();   //click on Right Profile list
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[1]/table/tbody/tr/td[2]/ul/li/a")).get(0).click();   //click to add new profile
			
			 driver.findElement(By.id("name")).clear();        //clear the field
			 driver.findElement(By.id("name")).sendKeys("Admistrator"); //set the value
			 driver.findElement(By.id("description")).clear();        //clear the field
			 driver.findElement(By.id("description")).sendKeys("System Administrator"); //set the value
			 
			 driver.findElement(By.id("isLocked")).click(); //click to luck the profile
			 driver.findElement(By.name("submitProfile")).click(); //click to submit the profile
			 
			 Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[5]/td[1]")).getText(),"Admistrator");//validation of alert
		
		    driver.findElement(By.linkText("Logout")).click(); //click to logout
		}
	  
	  
	  @Test(priority =2 ,groups= "regression")
			public void testDeleteProfile()throws Exception
			{
				
				//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

				driver.findElement(By.id("login")).clear();      //clear the field
				driver.findElement(By.id("login")).sendKeys("admin");  //set the value
				driver.findElement(By.id("password")).clear();        //clear the field
				driver.findElement(By.id("password")).sendKeys("admin");   //set the value
				driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
				driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
				driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[7]/a")).get(0).click();   //click on Right Profile list
				driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[5]/td[5]/a/img")).get(0).click();   //click to delete the profile
				
				 Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[4]/td[1]")).getText(),"Manager");//validation of alert
			
			    driver.findElement(By.linkText("Logout")).click(); //click to logout
			}
	  
	  @Test(priority =3 ,groups= "regression")
		public void testLuckProfile()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[7]/a")).get(0).click();   //click on Right Profile list
			String str2=driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[6]/a/img")).get(0).getAttribute("alt");// get text
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[6]/a/img")).get(0).click();   //click  on create a new class
			String str1=driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[6]/a/img")).get(0).getAttribute("alt");  // get text
			Assert.assertNotEquals(str1,str2);  //comparision
		
		    driver.findElement(By.linkText("Logout")).click(); //click to logout
		}
	  
	  @Test(priority =4 ,groups= "regression")
		public void testEditProfile()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[7]/a")).get(0).click();   //click on Right Profile list
			String str1=driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[6]/a/img")).get(0).getAttribute("alt");  // get text
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[3]/a/img")).get(0).click();   //click to Edit profile
			 driver.findElement(By.id("isLocked")).click(); //click to luck or unluck the profile
			 driver.findElement(By.name("submitProfile")).click(); //click to submit the profile
			String str2=driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[6]/a/img")).get(0).getAttribute("alt");// get text
			Assert.assertNotEquals(str1,str2);  //comparision

		    driver.findElement(By.linkText("Logout")).click(); //click to logout
		}
	  
	  
	  @Test(priority =5 ,groups= "regression")
		public void testManageRights()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[7]/a")).get(0).click();   //click on Right Profile list
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[4]/a/img")).get(0).click();   //click to alter rights
			String str1=driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[2]/a/span")).get(0).getText();  // get text
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[2]/a/span")).get(0).click();   //click to change rights
			String str2=driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[2]/a/span")).get(0).getAttribute("alt");// get text
			Assert.assertNotEquals(str1,str2);  //comparision

		    driver.findElement(By.linkText("Logout")).click(); //click to logout
		}
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
