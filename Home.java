package AppTest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Home {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();  		//creates an instance of the ChromeDriver, which provides the WebDriver interface for interacting with the Chrome browser.
		
		driver.get("http://localhost:8072/");       //To Fetch URL for Insurance App
		driver.manage().window().maximize();        //Maximize Screen
		
		//Client Page
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click(); // To click clients button exist in the home page
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/a")).click(); // To click New Client button exist in the Clients page
		driver.findElement(By.id("name")).sendKeys("abc");   // Id locator to send data to the Name field
		driver.findElement(By.id("dob")).sendKeys("10/10/2000");   // Id locator to send data to the Date of Birth field
		driver.findElement(By.id("address")).sendKeys("Pune");    // Id locator to send data to the Address field
		driver.findElement(By.id("contact")).sendKeys("80000011");  // Id locator to send data to the Contact Information field
		driver.findElement(By.xpath("/html/body/main/form/button")).click();   // To click Create button exist in the New Client page
		driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td[6]/a")).click();  // To click Edit button exist 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/a")).click(); // To click View Client button exist in the Clients page
		
		
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click(); // To click Home button
		
		//Insurance Policy Page
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/a")).click(); // To click Insurance Policies button exist in the home page
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/a")).click(); // To click New Policy button
		driver.findElement(By.id("policyNumber")).sendKeys("100212");   // Id locator to send data to the Policy Number field
		driver.findElement(By.id("type")).sendKeys("New");   // Id locator to send data to the Type field
		driver.findElement(By.id("coverageAmount")).sendKeys("520000");    // Id locator to send data to the Coverage Amount field
		driver.findElement(By.id("premium")).sendKeys("100");  // Id locator to send data to the Premium field
		driver.findElement(By.id("startDate")).sendKeys("10/10/2021");  // Id locator to send data to the Start Date field
		driver.findElement(By.id("endDate")).sendKeys("10/10/2023");  // Id locator to send data to the End Date field
		driver.findElement(By.id("client.id")).sendKeys("1");  // Id locator to send data to the Client Id field
		driver.findElement(By.xpath("/html/body/main/form/input[9]")).click();   // To click Submit button
		
		
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click(); // To click Home button
		
		//Claim Page
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[3]/a")).click(); // To click Claims button exist in the home page
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/a")).click(); // To click New Claim button
		driver.findElement(By.id("claimNumber")).sendKeys("10021345");   // Id locator to send data to the Claim Number field
		driver.findElement(By.id("description")).sendKeys("claim");   // Id locator to send data to the Description field
		driver.findElement(By.id("claimDate")).sendKeys("10/10/2021");    // Id locator to send data to the Claim Date field
		driver.findElement(By.id("claimStatus")).sendKeys("Pending");  // Id locator to send data to the Claim Status field
		driver.findElement(By.id("insurancePolicy.id")).sendKeys("1");  // Id locator to send data to the Insurance Policy Id field
		driver.findElement(By.xpath("/html/body/main/form/button")).click();   // To click Submit button
		driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td[7]/a")).click();   // To click Edit button
		driver.findElement(By.id("claimStatus")).clear();  // Id locator to clear data from Claim Status field
		driver.findElement(By.id("claimStatus")).sendKeys("Approved");  // Id locator to send data to the Claim Status field
		driver.findElement(By.xpath("/html/body/main/form/button")).click();   // To click Submit button
		driver.findElement(By.xpath("/html/body/main/table/tbody/tr[1]/td[7]/form/button")).click();   // To click Delete button

		
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click(); // To click Home button
	}
}
