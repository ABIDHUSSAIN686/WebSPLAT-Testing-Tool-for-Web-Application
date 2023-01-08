import static org.testng.Assert.fail;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import Common.DriverIntializor;

public class ManageClasses extends DriverIntializor {
	private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	@Test(priority =1 ,groups= "regression")
	public void testCreateNewClass()throws Exception
	{
		
		//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

		driver.findElement(By.id("login")).clear();      //clear the field
		driver.findElement(By.id("login")).sendKeys("admin");  //set the value
		driver.findElement(By.id("password")).clear();        //clear the field
		driver.findElement(By.id("password")).sendKeys("admin");   //set the value
		driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
		driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
		driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[6]/a")).get(0).click();   //click on Manage classes
		driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[1]/table/tbody/tr/td[2]/ul/li/a")).get(0).click();   //click  on create a new class
		driver.findElement(By.name("class_name")).sendKeys("class1");  //set the value
		driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/form/table/tbody/tr[2]/td[2]/input")).get(0).click();   //click on OK
		try {
		      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*The new class has been created[\\s\\S]*$")); //validation
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		    driver.findElement(By.linkText("Logout")).click(); //click to logout
	}
	
	@Test(priority =2 ,groups= "regression")
	public void testEmptyAllClasses()throws Exception
	{
		
		//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

		driver.findElement(By.id("login")).clear();      //clear the field
		driver.findElement(By.id("login")).sendKeys("admin");  //set the value
		driver.findElement(By.id("password")).clear();        //clear the field
		driver.findElement(By.id("password")).sendKeys("admin");   //set the value
		driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
		driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
		driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[6]/a")).get(0).click();   //click on Manage classes
		driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[1]/table/tbody/tr/td[2]/ul/li/a")).get(0).click();   //click  on create a new class
		driver.findElement(By.name("class_name")).sendKeys("class1");  //set the value
		driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/form/table/tbody/tr[2]/td[2]/input")).get(0).click();   //click on OK
		try {
		      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*The new class has been created[\\s\\S]*$")); //validation
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		    driver.findElement(By.linkText("Logout")).click(); //click to logout
	}
	
	@Test(priority =3 ,groups= "regression")
	public void testDeleteClass()throws Exception
	{
		
		//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

		driver.findElement(By.id("login")).clear();      //clear the field
		driver.findElement(By.id("login")).sendKeys("admin");  //set the value
		driver.findElement(By.id("password")).clear();        //clear the field
		driver.findElement(By.id("password")).sendKeys("admin");   //set the value
		driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
		driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
		driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[6]/a")).get(0).click();   //click on Manage classes
		driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[1]/table/tbody/tr/td[2]/ul/li[2]/a")).get(0).click();   //click on Empty all classes
		Alert alert = driver.switchTo().alert();
        alert.accept();
		
			try {
		      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*All classes emptied[\\s\\S]*$")); //validation
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		    driver.findElement(By.linkText("Logout")).click(); //click to logout
	}
	
	@Test(priority =4 ,groups= "regression")
	public void testAllDeleteClass()throws Exception
	{
		
		//js.executeScript("window.open('"+"http://localhost/parent/claroline/claroline/admin/"+"');"); 

		driver.findElement(By.id("login")).clear();      //clear the field
		driver.findElement(By.id("login")).sendKeys("admin");  //set the value
		driver.findElement(By.id("password")).clear();        //clear the field
		driver.findElement(By.id("password")).sendKeys("admin");   //set the value
		
		
		driver.findElements(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).get(0).click();  //click on Enter
		driver.findElements(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).get(0).click();   //click on Platform administration
		driver.findElements(By.xpath("//*[@id=\"claroBody\"]/ul/li[1]/ul/li[6]/a")).get(0).click();   //click on Manage classes
		driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[1]/table/tbody/tr/td[2]/ul/li/a")).get(0).click();   //click  on create a new class
		driver.findElement(By.name("class_name")).sendKeys("class2");  //set the value
		driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/form/table/tbody/tr[2]/td[2]/input")).get(0).click();   //click on OK
	
		
		driver.findElements(By.xpath("//*[@id=\"claroBody\"]/div[1]/table/tbody/tr/td[2]/ul/li[3]/a")).get(0).click();  //click on Delete all classes
		Alert alert = driver.switchTo().alert();
        alert.accept();
		
			try {
		      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*All classes deleted[\\s\\S]*$")); //validation
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		   driver.findElement(By.linkText("Logout")).click(); //click to logout
	}
//	 @AfterClass(alwaysRun = true)
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
