package SauceDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SauceDemoLogin {

	public static void main(String[] args) throws InterruptedException {
        
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/"); 
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement submit = driver.findElement(By.id("login-button"));
		submit.click();
		Thread.sleep(2000);
		
		//Add item to the cart
		WebElement item1 = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
		item1.click();
		Thread.sleep(3000);
		WebElement item2 = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button"));
		item2.click();
		Thread.sleep(3000);
		WebElement item3 = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button"));
		item3.click();
		Thread.sleep(3000);
		
		//locating element for scrolling the page
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]"));
		cart.click();
		Thread.sleep(3000);
		//Scrolling the page until element get visible
		WebElement checkout = driver.findElement(By.linkText("CHECKOUT"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", checkout);
		checkout.click();  //Click on checkout button
		Thread.sleep(3000);
		
		//Enter checkout details
		WebElement fname = driver.findElement(By.id("first-name"));
		fname.sendKeys("abc");
		Thread.sleep(3000);
		WebElement lname = driver.findElement(By.id("last-name"));
		lname.sendKeys("jhg");
		Thread.sleep(3000);
		WebElement code = driver.findElement(By.id("postal-code"));
		code.sendKeys("65");
		Thread.sleep(3000);
		WebElement cbutton = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input"));
		cbutton.click();
		Thread.sleep(3000);
		
		//Scrolling the page until element get visible
		WebElement finish = driver.findElement(By.linkText("FINISH"));
		js.executeScript("arguments[0].scrollIntoView();", finish);
		finish.click(); //Click on finish button
		
		//Click on menu
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button"));
		menu.click();
		
		//Click on about page
		WebElement about = driver.findElement(By.id("about_sidebar_link"));
		about.click();
		driver.navigate().back();
		
		//Logout
		WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
		logout.click();
		
		//Close browser
		driver.quit();
	}

}
