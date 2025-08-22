package lti;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkValidator {

	public static void main(String[] args) throws IOException {

		WebDriver wd = new ChromeDriver();
		wd.get("C:\\Users\\vinee\\OneDrive\\Desktop\\SDET with Jatin\\Java Module\\TestAssignment\\src\\main\\java\\lti\\brokenlink.html");

		List<WebElement> alist = wd.findElements(By.tagName("a"));
		System.out.println(alist.size());

		for (WebElement aElement : alist) {
//			System.out.println(aElement.getAttribute("href"));
			String url = aElement.getDomAttribute("href");
			checkBrokenLink(url);
		}

	}

	private static void checkBrokenLink(String url) throws IOException {
		// check if the URL is broken or not
		// API request from JAVA

		try {
			URL urlLink = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) urlLink.openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect(); //

			int statusCode = connection.getResponseCode();

			if (statusCode >= 400) {
				System.out.println("Broken Link: " + url);
			} else if (statusCode >= 200 && statusCode < 400) {
				System.out.println("Valid Link :" + url);

			}
		} catch (Exception e) {
			System.err.println("Caught the Exception " + e.getMessage());
		}
	}

}
