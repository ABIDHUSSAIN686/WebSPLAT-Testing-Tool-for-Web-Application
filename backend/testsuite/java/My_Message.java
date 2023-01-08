import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import Common.DriverIntializor;

public class My_Message extends DriverIntializor{

	@Test(priority =2 ,groups= "regression")
	public void Platform_Configuration_Menu_CouseList_Inbox()throws Exception
	{
		driver.findElement(By.id("login")).clear(); 
		driver.findElement(By.name("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear(); 
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).click();

		// ***********************************My Messages()*****************************
		//*************************************Inbox*************************
		driver.findElement(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[2]/span/a")).click();
		driver.findElement(By.className("inputSearch")).sendKeys("Programming Fundamentals");
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[3]/div/form/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[4]/a/img")).click();
		Alert alert = driver.switchTo().alert();
        alert.accept();
		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*The message in now in your trashbox[\\s\\S]*$"));
		driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click();  //click on logout
	}

//	@Test(priority =3 ,groups= "regression")
//	public void Platform_Configuration_Menu_CouseList_TrashBox()throws Exception
//	{
//		driver.findElement(By.id("login")).clear(); 
//		driver.findElement(By.name("login")).sendKeys("admin");
//		driver.findElement(By.id("password")).clear(); 
//		driver.findElement(By.name("password")).sendKeys("admin");
//		driver.findElement(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).click();
//
//		// ***********************************My Messages()*****************************
//		//*************************************TrashBox*************************
//
//		driver.findElement(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[2]/span/a")).click();
//		driver.findElement(By.xpath("//*[@id=\"trashbox\"]")).click();
//		driver.findElement(By.className("inputSearch")).sendKeys("Programming Fundamentals");
//		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[3]/div/form/input[2]")).click();
//		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[1]/td[4]/a")).click();	
//		Alert alert = driver.switchTo().alert();
//        alert.accept();
//		driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click();  //click on logout
//
//	}

	@Test(priority =4 ,groups= "regression")
	public void Platform_Configuration_Menu_CouseList_EmptyTrashBox()throws Exception
	{
		driver.findElement(By.id("login")).clear(); 
		driver.findElement(By.name("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear(); 
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).click();

		// ***********************************My Messages()*****************************
		//*************************************TrashBox*************************

		driver.findElement(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[2]/span/a")).click();
		driver.findElement(By.xpath("//*[@id=\"trashbox\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/span/a")).click();
			
		Alert alert = driver.switchTo().alert();
        alert.accept();
    
			AssertJUnit.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr/td")).getText(),"No message");
	
		driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click();  //click on logout

	}
}
