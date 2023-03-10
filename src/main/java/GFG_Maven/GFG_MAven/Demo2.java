package GFG_Maven.GFG_MAven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo2 {

	public static void main(String[] args) {
        String browserName ="firefox";
		
		WebDriver driver = null;
		
		if(browserName.equals("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
			}else if(browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); driver = new ChromeDriver();
			
			}else if(browserName.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();	
			driver = new FirefoxDriver();
			
		} /*
			 * else if(browserName.equals("opera")) {
			 * System.setProperty("webdriver.opera.driver", "./drivers/operadriver.exe");
			 * driver = new OperaDriver();
			 */
			
			driver.manage().window().maximize();
			driver.get("http://tutorialsninja.com/demo");
			driver.findElement(By.name("search")).sendKeys("HP");
			driver.findElement(By.className("input-group-btn")).click();
		
	}

}
