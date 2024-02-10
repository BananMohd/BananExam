package myTestCasesExam;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class  Tests extends Parameters {

	WebDriver driver = new ChromeDriver();

	
	@BeforeTest
	public void Setup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	
	@Test(priority = 1, enabled = true)
	public void SignUpTest() {

		driver.get(TheUrl);

		driver.findElement(By.linkText("Create an Account")).click();

		// find the elements
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement createAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account'] span"));

		
		// interact with the elements...and create the account
		FirstName.sendKeys(FirstNames[RandomIndex]);
		LastName.sendKeys(LastNames[RandomIndex]);
		Email.sendKeys(EmailID);
		Password.sendKeys(CommonPassword);
		confirmPassword.sendKeys(CommonPassword);
		createAccountButton.click();

		//to check the creatAccount test
		String WelcomeMsg = driver.findElement(By.className("message-success")).getText();

		assertEquals(WelcomeMsg, "Thank you for registering with Main Website Store.");

	}

	
	@Test(priority = 2, enabled = true)
	public void logoutProcess() {

		driver.get(TheLogoutUrl);
		
		assertEquals(driver.getCurrentUrl().contains("logoutSuccess"), true);
	}

	
	
	@Test(priority = 3, enabled = true)
	public void LoginProcess() throws InterruptedException {

		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(EmailID);
		driver.findElement(By.id("pass")).sendKeys(CommonPassword);

		driver.findElement(By.id("send2")).click();

		Thread.sleep(2000);
		String WelcomeMessage = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		assertEquals(WelcomeMessage.contains("Welcome"), true);
	}

	
	
	@Test(priority = 4, enabled = true)
	public void Requirment7() throws InterruptedException  {
		driver.get(TheUrl7);
		
		//a. requirement: 1. let selenium add the first item ,
		                //2.the color and the size should be randomly selected 
		
		               //a.1.find first element by link text
		WebElement FirstItem= driver.findElement(By.linkText("Proteus Fitness Jackshirt"));
		FirstItem.click();
		

                           //a.2.the color and the size should be randomly selected 
		  //select the size randomly
		WebElement sizesContainer = driver.findElement(By.cssSelector(".swatch-attribute.size"));
		int theSizes = sizesContainer.findElements(By.className("swatch-option")).size();//put all color in list, and print the size to check
		sizesContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theSizes)).click();//take one randomly
		Thread.sleep(2000);

		  //select the color randomly
		WebElement colorsContainer = driver.findElement(By.cssSelector(".swatch-attribute.color"));
		int theColors = colorsContainer.findElements(By.className("swatch-option")).size();
		colorsContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theColors)).click();
		Thread.sleep(2000);
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(3000);

		
		//b. once add please print the item name and the price of it
		System.out.println(FirstItem.getText());
		
		

		//assertEquals(ActualMsg.contains(,);

	}
	

	
	
	@Test(priority = 5, enabled = false)
	public void Draft() {
		//find first element by name or link text
				//WebElement FirstItem= driver.findElement(By.name("Proteus Fitness Jackshirt"));
				//FirstItem.click();
				
				//
				//WebElement FirstItemAddtoCartButton= driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/div/div[3]/div/div[1]/form"));
				//FirstItemAddtoCartButton.click();
				

				//find element by class name 
				//List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
				//System.out.println(AddtoCartButtons.size());
		        //for (int i = 0; i < AddtoCartButtons.size(); i++) {
					//AddtoCartButtons.get(i).click();
					//Thread.sleep(2000);
					
					
				//WebElement ItemsContainer = driver.findElement(By.cssSelector("products.list.items.product-items"));
				//int numberofitems = ItemsContainer.findElements(By.tagName("li")).size();
				//System.out.println(numberofitems);
				//List<WebElement> numberofitems = ItemsContainer.findElements(By.tagName("li"));
				//numberofitems.get(0);
				//actions-primary
		
	}
	

}
