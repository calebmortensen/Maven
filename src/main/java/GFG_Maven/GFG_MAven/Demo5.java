package GFG_Maven.GFG_MAven;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo5 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		// Code for Chrome Security Issue
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		// Add 'options' as argument
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofSeconds(30L)) .pollingEvery(Duration.ofSeconds(5L))
		 * .ignoring(NoSuchElementException.class);
		 * 
		 * WebElement foo = wait.until(new Function<WebDriver, WebElement>() { public
		 * WebElement apply(WebDriver driver) { return driver.findElement(By.id("foo"));
		 * } });
		 */
		 
		//Global Explicit Wait (WebDriverWait & FluentWait)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement gmailOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Gmail")));
		gmailOption.click();
		
		//Global Implicit Wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://omayo.blogspot.com/");

		driver.findElement(By.className("dropbtn")).click();

		//Thread.sleep(1000); // 1 Second
		
		driver.findElement(By.linkText("Gmail")).click();

	}

}
