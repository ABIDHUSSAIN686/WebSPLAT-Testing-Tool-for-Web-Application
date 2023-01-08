import static org.testng.Assert.fail;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import Common.DriverIntializor;
public class ManageDesktop extends DriverIntializor{
	private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @Test(priority =1 ,groups= "regression")
		public void testVisibility()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[8]/a")).get(0).click();   //click on Manage Desktop
		    String str2=driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[2]/a/img")).get(0).getAttribute("alt");
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[2]/a/img")).get(0).click();   //click  on create a new class
			String str1=driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[2]/a/img")).get(0).getAttribute("alt");
				Assert.assertNotEquals(str1,str2);  //comparision
		
		    driver.findElement(By.linkText("Logout")).click(); //click to logout
		}
	  
	  
	  @Test(priority =2,groups= "regression")
		public void testOrder()throws Exception
		{
			
			//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

			driver.findElement(By.id("login")).clear();      //clear the field
			driver.findElement(By.id("login")).sendKeys("admin");  //set the value
			driver.findElement(By.id("password")).clear();        //clear the field
			driver.findElement(By.id("password")).sendKeys("admin");   //set the value
			driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
			driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[8]/a")).get(0).click();   //click on Manage Desktop
			String str1=driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[1]")).getText();  //get test of field
			driver.findElements(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[4]/a/img")).get(0).click();   //click  on create a new class
			String str2=driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[1]")).getText();  //get test of field
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
