package by.htp.selenium;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class SendLetterTest {

	private WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		driver.get("https://mail.ru/");

		WebElement login = driver.findElement(By.id("mailbox:login"));
		login.sendKeys("TATHTP");

		WebElement password = driver.findElement(By.id("mailbox:password"));
		password.sendKeys("Klopik123");

		WebElement submitButton = driver.findElement(By.id("mailbox:submit"));
		submitButton.click();

		WebElement writeLetter = driver.findElement(By.xpath("//*[@id='b-toolbar__left\']//span"));
		writeLetter.click();

		WebElement recipient = driver.findElement(By.xpath("//textarea[@data-original-name='To']"));
		recipient.sendKeys("artemkaptur@mail.ru");

		WebElement topic = driver.findElement(By.xpath("//input[@name='Subject']"));
		topic.sendKeys("TryToStudySelenium");

		WebElement changeFrame = driver.findElement(By.xpath("//iframe[@allowtransparency='true']"));
		driver.switchTo().frame(changeFrame);

		WebElement message = driver.findElement(By.xpath("//*[@id='tinymce']"));
		message.sendKeys("Hello, buddy, how is it going?");

		driver.switchTo().defaultContent();

		WebElement sendLetter = driver
				.findElement(By.xpath("//*[@id='b-toolbar__right']/div[3]/div/div[2]/div[1]/div"));
		sendLetter.click();

		WebElement sentLetters = driver.findElement(By.xpath("//*[@id='b-nav_folders']/div/div[2]/a/span"));
		sentLetters.click();

		Thread.sleep(3000);

		String currentTime = new Date().getHours() + ":" + new Date().getMinutes();
		if (new Date().getMinutes() < 10) {
			currentTime = new Date().getHours() + ":0" + new Date().getMinutes();
		}

		WebElement letterSendTime = driver
				.findElement(By.xpath("//*[@id=\"b-letters\"]/div/div[5]/div/div[2]/div[1]/div/a/div[4]/div[1]/span"));

		Assert.assertEquals(letterSendTime.getText(), currentTime);
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
