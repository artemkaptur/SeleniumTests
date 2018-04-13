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

public class GoogleSearchJavaTest {

	private WebDriver driver;

	@Test
	public void googleSearchJava() {
		driver.get("https://google.by");

		WebElement searchField = driver.findElement(By.name("q"));

		searchField.sendKeys("Java");
		searchField.submit();

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='rso']/div/div/div/div/div/h3/a"));

		for (WebElement element : elements) {
			if (!(element.getText().contains("Java") || element.getText().contains("JAVA"))) {
				System.out.println("Element " + element.getText() + "doesn't contain 'Java'!!!");
			}

			System.out.println(element.getText());
		}

		System.out.println("Count of finded elements: " + elements.size());
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
