import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit; 

import org.junit.After; 
import org.junit.Before; 
import org.junit.Test; 

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver;

public class jUnitPractice {
	WebDriver driver; 

	@Before 
	public void setUp() { 
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.manage().window().maximize(); 
	} 
	
	@After 
	public void tearDown() { 
		driver.quit();
	} 
	
	@Test
	public void searchCheck() throws InterruptedException {
		driver.get("http://www.vpl.ca"); 
		
		WebElement searchField = driver.findElement(By.xpath("//input[@id='globalQuery']")); 
		
		searchField.click(); 
		searchField.clear(); 
		searchField.sendKeys("java");
		
		WebElement searchButton = driver.findElement(By.xpath("//input[@class='search_button']"));
		searchButton.click(); 
			
		Thread.sleep(3000);
		
		assertEquals("https://vpl.bibliocommons.com/search?q=java&t=keyword", driver.getCurrentUrl());
		
		assertEquals("Search | Vancouver Public Library | BiblioCommons", driver.getTitle());

		assertTrue(driver.findElement(By.xpath("//span[@class='items_showing_count']")).isDisplayed());
	}

	@Test
	public void checkPageTwo() throws InterruptedException {
		//Since these lines are repetitive, could I put this in the @Before section?
		driver.get("http://www.vpl.ca"); 
		
		WebElement searchField = driver.findElement(By.xpath("//input[@id='globalQuery']")); 
		
		searchField.click(); 
		searchField.clear(); 
		searchField.sendKeys("java");
		
		WebElement searchButton = driver.findElement(By.xpath("//input[@class='search_button']"));
		searchButton.click(); 
			
		Thread.sleep(3000);
		//End of repeat
		
		WebElement pageTwoLink = driver.findElement(By.xpath("//a[@testid='link_page2']"));
		pageTwoLink.click();
		
		Thread.sleep(3000);
		
		assertEquals("https://vpl.bibliocommons.com/search?display_quantity=25&page=2&q=java&t=keyword", driver.getCurrentUrl());
		
		assertTrue(driver.findElement(By.xpath("//li[@class='active']/a[@testid='link_page2']")).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath("//input[@value='java']")).isDisplayed());
		
		assertEquals("26 - 50 of 898 items", driver.findElement(By.xpath("//span[@class='items_showing_count']")).getText());
		
		assertTrue(driver.findElement(By.xpath("//span[@class='items_showing_count']")).isDisplayed());
	}

	@Test
	public void checkPageFive() throws InterruptedException {
		//Since these lines are repetitive, could I put this in the @Before section?
		driver.get("http://www.vpl.ca"); 
		
		WebElement searchField = driver.findElement(By.xpath("//input[@id='globalQuery']")); 
		
		searchField.click(); 
		searchField.clear(); 
		searchField.sendKeys("java");
		
		WebElement searchButton = driver.findElement(By.xpath("//input[@class='search_button']"));
		searchButton.click(); 
			
		Thread.sleep(3000);
		//End of repeat
		
		WebElement pageFiveLink = driver.findElement(By.xpath("//a[@testid='link_page5']"));
		pageFiveLink.click();
		
		Thread.sleep(3000);
		
		assertEquals("https://vpl.bibliocommons.com/search?display_quantity=25&page=5&q=java&t=keyword", driver.getCurrentUrl());
		
		assertTrue(driver.findElement(By.xpath("//li[@class='active']/a[@testid='link_page5']")).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath("//input[@value='java']")).isDisplayed());
		
		assertEquals("101 - 125 of 898 items", driver.findElement(By.xpath("//span[@class='items_showing_count']")).getText());
		
		assertTrue(driver.findElement(By.xpath("//span[@class='items_showing_count']")).isDisplayed());
	}
}
