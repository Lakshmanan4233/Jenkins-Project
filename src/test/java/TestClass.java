import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestClass {

   WebDriver driver;

   @BeforeTest
   public void beforeTest(){
      System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\Jenkins Maven\\src\\main\\resources\\Browser\\chromedriver.exe");

      driver = new ChromeDriver();

      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);

   }

   @Test
   public void lanuch(){

      driver.get("https://adactinhotelapp.com/index.php");

      driver.findElement(By.id("username")).sendKeys("test@gmail.com");

      Assert.assertEquals("test@gmail.com",driver.findElement(By.id("username")).getAttribute("value"));

   }


   @AfterTest
   public void afterTest(){

      driver.close();

      driver = null;

      System.out.println("Driver is null");

   }


}
