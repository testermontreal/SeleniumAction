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

// DragAndDrop - 2 methodes
public class DragDropTest {
	WebDriver driver;

	@Test
	public void dragDrop() throws InterruptedException {
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		// DragAndDrop Oslo to Norway
		Actions action1 = new Actions(driver);
		WebElement boxDepart = driver.findElement(By.id("box1"));
		WebElement boxFinal = driver.findElement(By.id("box101"));
		action1.dragAndDrop(boxDepart, boxFinal).build().perform();
	}
	
	@Test
	public void dragDrop2() throws InterruptedException {
		driver.get("http://omayo.blogspot.com/p/page3.html");
		// DragAndDrop Range Slider
		Actions action1 = new Actions(driver);
		WebElement boxDepart = driver.findElement(By.xpath("//a[@aria-labelledby='price-min-label']"));
		
		action1.pause(4000); // equvalent methode Thread.sleep(4000);
		action1.dragAndDropBy(boxDepart, 200, 0).build().perform();
		//Thread.sleep(4000);
		action1.pause(4000);
		action1.dragAndDropBy(boxDepart, -200, 0).build().perform();

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
