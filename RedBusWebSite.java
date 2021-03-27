package week3.day1.part2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusWebSite {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.redbus.in/");
		WebElement src = driver.findElement(By.id("src"));
		src.sendKeys("C");
		
		Thread.sleep(5000);
		src.sendKeys(Keys.ARROW_DOWN, Keys.TAB);
		
		WebElement dest = driver.findElement(By.id("dest"));
		dest.sendKeys("B");
		Thread.sleep(5000);
		dest.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//tr[@class='rb-monthHeader']/td[@class='next']")).click();
		driver.findElement(By.xpath("//table[@class='rb-monthTable first last']//tr[3]/td[text()='1']")).click();
		driver.findElement(By.id("search_btn")).click();
		
		Thread.sleep(5000);
		
		String searchDate = driver.findElement(By.xpath("//input[@id='searchDat']")).getAttribute("value");
		String totBus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		
		System.out.println(driver.getTitle());
		
		System.out.println("Total Buses on "+searchDate+": "+totBus);
		
		driver.findElement(By.xpath("//div[@class='close']/i")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();
		
		Thread.sleep(5000);
		String sleepBus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Number of Sleeper Buses Available: "+sleepBus);
		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//input[@id='bt_AC']")).click();
		driver.findElement(By.xpath("//div[@id='filter-block']//ul[3]/li[3]/label[1]")).click();
		Thread.sleep(5000);
		String acBus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Number of AC Buses Available: "+acBus);
	}

}
