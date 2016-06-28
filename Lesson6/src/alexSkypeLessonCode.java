import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit; 

import org.junit.After; 
import org.junit.Before; 
import org.junit.Test; 
import org.junit.Assert.*;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver;

public class alexSkypeLessonCode {
		
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
	public void testFirstResult() throws InterruptedException 
	{ 						
		driver.get("http://www.vpl.ca"); 
		
		WebElement searchField = driver.findElement(By.xpath("//input[@id='globalQuery']")); 
		
		searchField.click(); 
			
		searchField.clear(); 
					
		searchField.sendKeys("java");			
					
		WebElement searchButton = driver.findElement(By.xpath("//input[@class='search_button']"));
					
		searchButton.click(); 
			
		Thread.sleep(3000);
					
		WebElement bookTitle = driver.findElement(By.xpath("//span[@class='title']/a"));
								
		assertTrue(bookTitle.getText().length() > 0);
					
		assertTrue(bookTitle.isDisplayed());
								
		assertEquals(bookTitle.isEnabled(), true);
	} 
			
	@Test	
	public void testSecondResult() throws InterruptedException 
	{ 			
				
		driver.get("http://www.vpl.ca"); 
					
		WebElement searchField = driver.findElement(By.xpath("//input[@id='globalQuery']")); 
			
		searchField.click(); 
			
		searchField.clear(); 
					
		searchField.sendKeys("java");			
					
		WebElement searchButton = driver.findElement(By.xpath("//input[@class='search_button']"));
					
		searchButton.click(); 
			
		Thread.sleep(3000);
					
		WebElement bookTitle = driver.findElement(By.xpath("//span[@class='title']/a"));
								
		assertTrue("title is empty", bookTitle.getText().length() > 0);
					
		assertTrue("bookTitle is not displayed", bookTitle.isDisplayed() == true);
								
		assertTrue("bookTitle is not enabled", bookTitle.isEnabled() == true);	
	} 
			
	@Test
	public void testThirdResult() throws InterruptedException 
	{ 			
				
		driver.get("http://www.vpl.ca"); 
					
		WebElement searchField = driver.findElement(By.xpath("//input[@id='globalQuery']")); 
			
		searchField.click(); 
			
		searchField.clear(); 
					
		searchField.sendKeys("java");			
					
		WebElement searchButton = driver.findElement(By.xpath("//input[@class='search_button']"));
					
		searchButton.click(); 
					
		Thread.sleep(3000);
					
		WebElement bookTitle = driver.findElement(By.xpath("//span[@class='title']/a"));
								
		assertTrue(bookTitle.getText().length() > 0);
					
		assertTrue(bookTitle.isDisplayed() == true);
								
		assertTrue(bookTitle.isEnabled() == true);	
	} 

}
