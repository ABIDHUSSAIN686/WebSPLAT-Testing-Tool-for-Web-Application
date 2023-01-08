import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Common.DriverIntializor;

public class create_course extends DriverIntializor{
	private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	JavascriptExecutor jse;

	//@Test(priority =1 ,groups= "regression")
	//public void Aunthentication()throws Exception {
	//		driver.findElement(By.name("login")).sendKeys("admin");
	//		driver.findElement(By.name("password")).sendKeys("admin");
	//		driver.findElement(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).click();
	//		
	//		try {
	//			AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Claroline[\\s\\S]*$"));
	//		} catch (Exception e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click();  //click on logout
	//}

	@Test(priority =1 ,groups= "regression")
	public void Platform_Configuration_Menu_CouseList()throws Exception
	{
		driver.findElement(By.id("login")).clear(); 
		driver.findElement(By.name("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear(); 
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).click();

		driver.findElement(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/ul/li[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"courseSettings\"]/p/a[1]")).click();
		// ***********************************Create Course()*****************************
		// *********************************** Basic Setting******************************
		driver.findElement(By.id("course_title")).clear(); 
		driver.findElement(By.id("course_title")).sendKeys("Programming Fundamentals");
		driver.findElement(By.id("course_officialCode")).clear(); 
		driver.findElement(By.id("course_officialCode")).sendKeys("CS-2002");
		driver.findElement(By.xpath("//*[@id=\"mslist2\"]/option[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"mandatories\"]/div/dl/dd[3]/table/tbody/tr/td[2]/a[2]/img")).click();
		driver.findElement(By.id("course_titular")).clear();
		driver.findElement(By.id("course_titular")).sendKeys("Muhammad Aqel Afzal");
		driver.findElement(By.id("course_email")).clear();
		driver.findElement(By.id("course_email")).sendKeys("muhammadaqelafzal@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"mandatories\"]/div/dl/dd[7]/label[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"mandatories\"]/div/dl/dd[8]/label[1]")).click();
		//driver.findElement(By.xpath("//*[@id=\"mandatories\"]/legend/a")).click();


		// ***********************************Create Course()*****************************
		// ***********************************Optional Course ****************************
	//	driver.findElement(By.xpath("//*[@id=\"options\"]/legend/a")).click();
		driver.findElement(By.id("course_departmentName")).clear();
		driver.findElement(By.id("course_departmentName")).sendKeys("Computer Science");
		driver.findElement(By.id("course_extLinkUrl")).clear();
		driver.findElement(By.id("course_extLinkUrl")).sendKeys("https://www.nu.edu.pk");

		// ***********************************Create Course()*****************************
		// ***********************************Advanced Option*****************************

	//	driver.findElement(By.xpath("//*[@id=\"advancedInformation\"]/legend/a")).click();
		driver.findElement(By.xpath("//*[@id=\"visibility_hidden\"]")).click();
		driver.findElement(By.name("course_userLimit")).clear();
		driver.findElement(By.name("course_userLimit")).sendKeys("200");
		driver.findElement(By.xpath("//*[@id=\"course_status_enable\"]")).click();


		
		//*[@id="visibility_show"]
		driver.findElement(By.xpath("//*[@id=\"courseSettings\"]/dl/dt/input")).click(); // or we can write it as tr:nth-child(6) > td > input
		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*You have just created the course website : [\\s\\S]*$"));

		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/p/a")).click(); // or we can write it as tr:nth-child(6) > td > input
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
