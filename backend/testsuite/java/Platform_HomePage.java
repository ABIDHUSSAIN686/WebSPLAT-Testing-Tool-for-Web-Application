import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import Common.DriverIntializor;
import org.testng.AssertJUnit;

import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
public class Platform_HomePage extends DriverIntializor {
	private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	@Test(priority =2 ,groups= "regression")
	public void Platform_Configuration_Menu_CouseList()throws Exception
	{
		driver.findElement(By.id("login")).clear(); 
		driver.findElement(By.name("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear(); 
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).click();

		driver.findElement(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).click();

		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/ul/li[3]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/ul[1]/li[1]/a")).click();

		// ***********************************Configuration_HomePage()*****************************
		// ***********************************Course List *****************************************
		driver.findElement(By.xpath("//*[@id=\"navlist\"]/li[1]/a")).click();
		driver.findElement(By.cssSelector("tr:nth-child(2) label:nth-child(6)")).click();
		driver.findElement(By.id("label_categories_order_by")).click();
		{
			WebElement dropdown = driver.findElement(By.id("label_categories_order_by"));
			dropdown.findElement(By.xpath("//option[. = 'Alphabetical ascending']")).click();
		}
		driver.findElement(By.cssSelector("tr:nth-child(4) label:nth-child(2)")).click();
		driver.findElement(By.cssSelector("tr:nth-child(5) label:nth-child(2)")).click();
		driver.findElement(By.cssSelector("tr:nth-child(6) input[type=submit]")).click(); // or we can write it as tr:nth-child(6) > td > input
		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Properties for Home page, \\(CLHOME\\) are now effective on server[\\s\\S]*$"));	
		driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click();  //click on logout
	}


	@Test(priority =3 ,groups= "regression")
	public void Platform_Configuration_Menu_Display() throws Exception {
		driver.findElement(By.id("login")).clear(); 
		driver.findElement(By.name("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear(); 
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).click();
		driver.findElement(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/ul/li[3]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/ul[1]/li[1]/a")).click();

		// ***********************************Configuration_HomePage()*****************************
		// *********************************** Display *****************************************
		driver.findElement(By.xpath("//*[@id=\"navlist\"]/li[2]/a")).click();
		driver.findElement(By.id("label_display_former_homepage_TRUE")).click();
		driver.findElement(By.id("label_userDesktopMessageCollapsedByDefault_FALSE")).click();
		driver.findElement(By.cssSelector("tr:nth-child(4) input[type=submit]")).click(); // or we can write it as tr:nth-child(6) > td > input

		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Properties for Home page, \\(CLHOME\\) are now effective on server[\\s\\S]*$"));
		driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click();  //click on logout
	}
//	@AfterClass(alwaysRun = true)
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
