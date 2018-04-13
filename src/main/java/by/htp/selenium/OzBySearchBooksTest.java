package by.htp.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class OzBySearchBooksTest {

	private WebDriver driver;

	@Test
	public void ozBySearchBooks() {
		driver.get("https://oz.by");

		WebElement searchField = driver.findElement(By.name("q"));

		searchField.sendKeys("Java");
		searchField.submit();

		List<WebElement> elements = driver.findElements(By.className("item-type-card__title"));

		for (WebElement element : elements) {
			System.out.println(element.getText());
		}

		System.out.println("Count of finded elements is " + elements.size());
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\MYPROGRAMS\\DRIVERS\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {

		driver.close();
	}

}
