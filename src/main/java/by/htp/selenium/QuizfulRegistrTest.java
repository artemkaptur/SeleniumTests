package by.htp.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class QuizfulRegistrTest {

	private WebDriver driver;

	@Test
	public void quizfulRegistr() throws InterruptedException {
		driver.get("http://www.quizful.net/LoginAction.registration");

		WebElement loginQuiz = driver.findElement(By.name("registrationForm.login"));
		loginQuiz.sendKeys("testUser");

		WebElement passwordQuiz = driver.findElement(By.name("registrationForm.password"));
		passwordQuiz.sendKeys("testUser");

		WebElement rePasswordQuiz = driver.findElement(By.name("registrationForm.repassword"));
		rePasswordQuiz.sendKeys("testUser");

		WebElement email = driver.findElement(By.name("registrationForm.email"));
		email.sendKeys("testprofile@mail.ru");

		WebElement corporateCheckBox = driver.findElement(By.name("registrationForm.corporate"));
		corporateCheckBox.click();

		Thread.sleep(7000);
		WebElement captcha = driver.findElement(By.name("registrationForm.captcha"));
		captcha.click();

		WebElement submitButton = driver.findElement(By.name("ok"));
		submitButton.click();

		WebElement succesProof = (new WebDriverWait(driver, 7))
				.until(ExpectedConditions.elementToBeClickable(By.className("content")));
		Assert.assertTrue(succesProof.getText().contains("Регистрация прошла успешно"));
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
