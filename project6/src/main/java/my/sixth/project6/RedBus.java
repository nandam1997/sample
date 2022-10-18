package my.sixth.project6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {
		WebDriver driver =null;
	@BeforeTest
	public void driver_open() {
	
	
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void Netflix_page() {
		String expected_title="Netflix India – Watch TV Shows Online, Watch Movies Online";
		driver.get("https://www.netflix.com/in/");
		verify(expected_title);
	}
	@Test
	public void aha_page() {
		String expected_title="Watch Movies Online | Watch Latest movies Online | aha";
		driver.get("https://www.aha.video/");
		verify(expected_title);
		
	}
	@Test
	public void redbus_page() {
		String expected_title="Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India";
		driver.get("https://www.redbus.in/");
		verify(expected_title);
	}
	@AfterTest
	public void close_page() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	public void verify(String expected_title)
	{
		String actual_title=(driver.getTitle());
		System.out.println(driver.getTitle());
		Assert.assertEquals(expected_title, actual_title);
	}
}
