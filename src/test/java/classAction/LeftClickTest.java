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

public class LeftClickTest {
	WebDriver driver;

	@Test
	public void leftClickTest() {
		driver.get("http://omayo.blogspot.com/");
		Actions action1 = new Actions(driver);
		WebElement link = driver.findElement(By.id("home"));
		action1.clickAndHold(link).build().perform();
		action1.pause(3000);
		action1.release().perform();

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
