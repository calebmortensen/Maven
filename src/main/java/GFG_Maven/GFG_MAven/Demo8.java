package GFG_Maven.GFG_MAven;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo8 {

	public static void main(String[] args) throws IOException, AWTException {
		
         WebDriverManager.chromedriver().setup();
		
		//Code for Chrome Security Issue
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver();
		//Add 'options' as argument
		driver = new ChromeDriver(options);
			
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		WebElement blogsMenuElement = driver.findElement(By.id("blogsmenu"));
		
		Actions actions = new Actions(driver);
		//no perfom necessary
		actions.moveToElement(blogsMenuElement);
		
		WebElement option2 = driver.findElement(By.xpath("//span[text()='SeleniumByArun']"));
		//if more that one action, need to use 'build and perform'
		actions.moveToElement(option2).click().build().perform();
		
		//For a Drag & Drop slider bar
		
		//actions.dragAndDropBy(minLabelElement, -50, 0).perform();
		
		//Take ScreenShot
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./Screenshots/omayo.png");
		//FileUtils.copyFile(srcFile, destinationFile);  Does same thing, but using FileHandler
		FileHandler.copy(srcFile, destinationFile);
		
		//Screenshot using Robot Class can take pic of URL & ALERTS
		Robot robot = new Robot();
		java.awt.Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(d);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		String destinationPath = System.getProperty("user.dir")+"//Screenshots//robotone.png";
		ImageIO.write(bufferedImage, "png", new File(destinationPath));
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.close();
		//Ashot - Takes complete screenshot of Chrome page
	}

}
