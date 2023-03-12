package GFG_Maven.GFG_MAven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Demo7 {
	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		//Code for Chrome Security Issue
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//Add 'options' as argument
		driver = new ChromeDriver(options);
			
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");

		WebElement dropdownField = driver.findElement(By.id("drop"));

		Select select = new Select(dropdownField);

		select.selectByVisibleText("doc 3");

		select.selectByIndex(1);

		select.selectByValue("ghi");

		System.out.println(select.isMultiple()); //False - drop list only allows 1 selection at a time
		
		List<WebElement> choices = select.getOptions();
		
		for(WebElement option : choices) {
			System.out.println(option.getText());
			
		}
		
		WebElement multiSelectionBoxField = driver.findElement(By.id("multiselect1"));
		Select sel = new Select(multiSelectionBoxField);
		sel.selectByVisibleText("Volvo"); //Highlights
		sel.selectByIndex(3); //highlights
		sel.deselectByIndex(1); //UNhighlights
		
		
		List<WebElement> li = select.getOptions();
		for(WebElement l : li) {
			System.out.println(l.getText());
		}
		
		driver.get("letcode.in/dropdowns");
		By fruits = By.id("fruits");
		By languages = By.id("lang");
		
		Select select1 = new Select(driver.findElement(fruits));
		select1.selectByVisibleText("Orange");
		Select select2 = new Select(driver.findElement(languages));
		select2.selectByVisibleText("Java");
		//driver.quit();
				
	}
	
	public static WebElement getWebElement(By field) {
		return driver.findElement(field);
	}
	
	public static void selectOptionInDropDownField(By field, String option) {
		Select select3 = new Select(getWebElement(field));
		select3.selectByVisibleText(option);
		
		/*switch(option) {
		
		case "visibleText":
			select3.selectByVisibleText(option);
			break;
			
		case "index":
			select3.selectByVisibleText(option);
			break;*/
		WebElement logo = null; //driver.findelement...
		Actions actions = new Actions(driver);
		actions.moveToElement(logo).click().perform();
		
		}
	}





















