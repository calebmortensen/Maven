package GFG_Maven.GFG_MAven;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo3 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='LinkList1']//a"));
		
		int noOfLinks = links.size();
		
		String path = "(//div[@id='LinkList1']//a)";
		
		for(int i=1; i<=noOfLinks; i++ ) {
			String elementPath = path+"["+i+"]";
			driver.findElement(By.xpath(elementPath)).click();
			driver.navigate().back();
		}
		
		List<WebElement> allLinks = driver.findElements(By.tagName("//a"));
			for(WebElement e : allLinks) {
			System.out.println(e.getAttribute("href")!=null);
		}
		
		driver.quit();
		
		
		Set<String> allWindows = driver.getWindowHandles();
		String parentWindow = driver.getWindowHandle();
		Iterator<String> itr = allWindows.iterator();
		
		while(itr.hasNext()) {
			String win = itr.next();
			driver.switchTo().window(win);
			
			if(driver.getTitle().equals("Basic Web Page Title")) {
			String paraText = driver.findElement(By.id("para1")).getText();
				System.out.println(paraText);
				break;
			}
		}
		
		/*//This isn't good because of StaleReference
		 * for(WebElement e: links) { e.click(); driver.navigate().back(); }
		 * driver.quit();
		 */
		
		//WebElement loginButton = driver.findElement(By.xpath("//button[@value='LogIn']"));
		
		/*
		 * List<WebElement> options =
		 * driver.findElements(By.xpath("//select[@id='multiselect1']/option"));
		 * 
		 * for(WebElement e: options) { System.out.println(e.getText()); }
		 */
		
		/*
		 * String optionText = option.getText(); System.out.println(optionText);
		 * driver.quit();
		 */
		
		//String textOnButton = loginButton.getText();
		//System.out.println(textOnButton);
	}

}
