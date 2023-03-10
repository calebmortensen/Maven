package GFG_Maven.GFG_MAven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo4 {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		//Code for Chrome Security Issue
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//Add 'options' as argument
		WebDriver driver = new ChromeDriver(options);
			
		driver.manage().window().maximize();
		
		driver.get("https://omayo.blogspot.com/");
		driver.findElement(By.id("ta1")).sendKeys("Arun Motoori");
		
		driver.switchTo().newWindow(WindowType.WINDOW); //.TAB
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.name("search")).sendKeys("HP");
	}

}
