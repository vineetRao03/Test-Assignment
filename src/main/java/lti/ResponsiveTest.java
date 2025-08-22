package lti;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResponsiveTest {

	private WebDriver wd;

	private static final Map<String, Dimension> deviceMap = Map.of(
			"Pixel", new Dimension(412, 915), 
			"Tablet", new Dimension(1024, 1366), 
			"Desktop", new Dimension(1920, 1080)
			);

//  Double Brace Initialization using HashMap
//  private HashMap<String, Dimension> deviceMap = new HashMap<String, Dimension>()  {{
//			put("Pixel", new Dimension(412, 915));
//			put("Tablet", new Dimension(1024, 1366));
//			put("Desktop", new Dimension(4825, 1531));
//		}};
	
	private WebDriverWait wait;

	@BeforeMethod(description = "Launching the Browser")
	public void setUp() {

		wd = new ChromeDriver();
		wd.get("C:\\Users\\vinee\\OneDrive\\Desktop\\SDET with Jatin\\Java Module\\TestAssignment\\src\\main\\java\\lti\\responsive.html");
		// if I want to pass a specific Dimensions to the wd
		wait = new WebDriverWait(wd, Duration.ofSeconds(30L));

	}

	@Test(description = "Check if the Webpage is Responsive or Not")
	public void responsiveTest() {

		for (Map.Entry<String, Dimension> device : deviceMap.entrySet()) {
			System.out.println(device.getKey() + " " + device.getValue());

			if (device.getKey().equalsIgnoreCase("Pixel")) {
				wd.manage().window().setSize(device.getValue());
				System.out.println("Running Test for Pixel");
				WebElement hamburgerIconElement = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile-menu-button")));

				Assert.assertEquals(hamburgerIconElement.isDisplayed(), true);

				hamburgerIconElement.click();

				WebElement menuItemsElements = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile-menu")));
				Assert.assertTrue(menuItemsElements.isDisplayed());

			} else if (device.getKey().equalsIgnoreCase("Tablet")) {
				wd.manage().window().setSize(device.getValue());
				System.out.println("Running Test for Tablet");
				WebElement navItemElement = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1/../div")));

				Assert.assertTrue(navItemElement.isDisplayed());

			} else if (device.getKey().equalsIgnoreCase("Desktop")) {
				wd.manage().window().setSize(device.getValue());
				System.out.println("Running Test for Desktop");
				WebElement navItemElement = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1/../div")));

				Assert.assertTrue(navItemElement.isDisplayed());

			}

		}
	}
}