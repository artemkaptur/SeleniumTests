package by.htp.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class LoginMailRuTest {

	private WebDriver driver;

	@Test
	public void loginMailRu() {
		driver.get("https://mail.ru/");

		WebElement login = driver.findElement(By.id("mailbox:login"));
		login.sendKeys("TATHTP");

		WebElement password = driver.findElement(By.id("mailbox:password"));
		password.sendKeys("Klopik123");

		WebElement submitButton = driver.findElement(By.id("mailbox:submit"));
		submitButton.click();

		WebElement succesProof = (new WebDriverWait(driver, 7))
				.until(ExpectedConditions.elementToBeClickable(By.id("PH_user-email")));
		Assert.assertTrue(succesProof.getText().contains("tathtp@mail.ru"));

	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\MYPROGRAMS\\\\DRIVERS\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
