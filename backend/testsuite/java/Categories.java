import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import Common.DriverIntializor;

public class Categories  extends DriverIntializor{

	@Test(priority =1 ,groups= "regression")
	public void Create_Categories()throws Exception
	{
		driver.findElement(By.id("login")).clear(); 
		driver.findElement(By.name("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear(); 
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).click();

		// **********************************Categories*****************************

		driver.findElement(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/ul/li[2]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[1]/table/tbody/tr/td[2]/ul/li/a")).click();

		driver.findElement(By.name("category_name")).sendKeys("Non-Social Sciences");
		driver.findElement(By.name("category_code")).sendKeys("NSC2003");
		driver.findElement(By.name("category_parent")).click();
		driver.findElement(By.xpath("//*[@id=\"category_parent\"]/option[4]")).click();
		driver.findElement(By.id("visible")).click(); 
		driver.findElement(By.id("can_have_courses")).click(); 
		driver.findElement(By.xpath("//*[@id=\"categorySettings\"]/input[3]")).click(); 
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div")).getText(),"Category created");
		driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click();  //click on logout

	}
	@Test(priority =2 ,groups= "regression")
	public void Edit_Categories()throws Exception
	{
		driver.findElement(By.id("login")).clear(); 
		driver.findElement(By.name("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear(); 
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).click();

		// **********************************Categories*****************************

		driver.findElement(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/ul/li[2]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[4]/td[5]/a/img")).click();
		driver.findElement(By.name("category_name")).clear();
		driver.findElement(By.name("category_name")).sendKeys("Marketing");
		driver.findElement(By.name("category_code")).clear();
		driver.findElement(By.name("category_code")).sendKeys("MG205");
		driver.findElement(By.name("category_parent")).click();
		driver.findElement(By.xpath("//*[@id=\"category_parent\"]/option[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"visible\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"can_have_courses\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"categorySettings\"]/input[3]")).click(); 
		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Category modified[\\s\\S]*$"));
		driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click();  //click on logout		
	}

	@Test(priority =3 ,groups= "regression")
	public void Visibility_of_Categories()throws Exception
	{
		driver.findElement(By.id("login")).clear(); 
		driver.findElement(By.name("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear(); 
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).click();

		// **********************************Categories*****************************

		driver.findElement(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/ul/li[2]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[4]/td[4]/a/img")).click();

		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Category's visibility modified[\\s\\S]*$"));
		driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click();  //click on logout		
	}
	@Test(priority =4 ,groups= "regression")
	public void Delete_Categories()throws Exception
	{
		driver.findElement(By.id("login")).clear(); 
		driver.findElement(By.name("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear(); 
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginBox\"]/form/fieldset/button")).click();

		// **********************************Categories*****************************

		driver.findElement(By.xpath("//*[@id=\"userBannerLeft\"]/ul/li[3]/span/a")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/ul/li[2]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[4]/td[6]/a/img")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Category deleted. Courses linked to this category have been linked to the root category.[\\s\\S]*$"));
		driver.findElements(By.xpath("//*[@id=\"userBannerRight\"]/ul/li[3]/span/a")).get(0).click();  //click on logout		
	}

}
