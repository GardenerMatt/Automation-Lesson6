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
	String searchFieldXpath = "//input[@id='globalQuery']";
	String searchButtonXpath = "//input[@class='search_button']";
	String searchTerm = "java";	
	String searchTermXpath = "//input[@value='" + searchTerm + "']";
	String itemsShowingXpath = "//span[@class='items_showing_count']";

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
		
		WebElement searchField = driver.findElement(By.xpath(searchFieldXpath));
		searchField.click(); 
		searchField.clear(); 
		searchField.sendKeys("java");
		
		WebElement searchButton = driver.findElement(By.xpath(searchButtonXpath));
		searchButton.click(); 
			
		Thread.sleep(3000);
		
		String pageUrl = "https://vpl.bibliocommons.com/search?q=" + searchTerm + "&t=keyword";
		assertEquals(pageUrl, driver.getCurrentUrl());
		
		String pageTitle = "Search | Vancouver Public Library | BiblioCommons";
		assertEquals(pageTitle, driver.getTitle());

		assertTrue(driver.findElement(By.xpath(itemsShowingXpath)).isDisplayed());
	}

	@Test
	public void checkPageTwo() throws InterruptedException {
		
		driver.get("http://www.vpl.ca"); 
				
		WebElement searchField = driver.findElement(By.xpath(searchFieldXpath));
		searchField.click(); 
		searchField.clear(); 
		searchField.sendKeys("java");
		
		WebElement searchButton = driver.findElement(By.xpath(searchButtonXpath));
		searchButton.click();
		
		WebElement pageTwoLink = driver.findElement(By.xpath("//a[@testid='link_page2']"));
		pageTwoLink.click();
		
		Thread.sleep(3000);
		
		String pageUrl = "https://vpl.bibliocommons.com/search?display_quantity=25&page=2&q=" + searchTerm + "&t=keyword";
		assertEquals(pageUrl, driver.getCurrentUrl());
		
		String pageLinkXpath = "//a[@testid='link_page2']";
		assertTrue(driver.findElement(By.xpath(pageLinkXpath)).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath(searchTermXpath)).isDisplayed());
		
		assertEquals("26 - 50 of 898 items", driver.findElement(By.xpath(itemsShowingXpath)).getText());
		
		assertTrue(driver.findElement(By.xpath(itemsShowingXpath)).isDisplayed());
	}

	@Test
	public void checkPageFive() throws InterruptedException {
		
		driver.get("http://www.vpl.ca"); 
		
		WebElement searchField = driver.findElement(By.xpath(searchFieldXpath));
		searchField.click(); 
		searchField.clear(); 
		searchField.sendKeys("java");
		
		WebElement searchButton = driver.findElement(By.xpath(searchButtonXpath));
		searchButton.click();
		
		Thread.sleep(3000);
		
		String pageFiveLinkXpath = "//a[@testid='link_page5']";
		WebElement pageFiveLink = driver.findElement(By.xpath(pageFiveLinkXpath));
		pageFiveLink.click();
		
		Thread.sleep(3000);
		
		String pageUrl = "https://vpl.bibliocommons.com/search?display_quantity=25&page=5&q=" + searchTerm + "&t=keyword";
		assertEquals(pageUrl, driver.getCurrentUrl());
		
		assertTrue(driver.findElement(By.xpath(pageFiveLinkXpath)).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath(searchTermXpath)).isDisplayed());
		
		assertEquals("101 - 125 of 898 items", driver.findElement(By.xpath(itemsShowingXpath)).getText());
		
		assertTrue(driver.findElement(By.xpath(itemsShowingXpath)).isDisplayed());
	}
}
