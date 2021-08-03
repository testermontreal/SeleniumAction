package classAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

// Pour deplacer coursor de souris sur l element "Blogs"
public class MoveToTest {
	WebDriver driver;

	@Test
	public void move() {
		driver.get("http://omayo.blogspot.com/");
		Actions action1 = new Actions(driver);
		WebElement link = driver.findElement(By.id("blogsmenu"));
		
		action1.moveToElement(link).build().perform();
		action1.pause(3000);
		// Cliquer sur 2-eme element "SeleniumByArun"
		WebElement lien = driver.findElement(By.linkText("SeleniumByArun"));
		action1.moveToElement(lien).click(lien).build().perform();

	}

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		// driver.close();
	}

}
