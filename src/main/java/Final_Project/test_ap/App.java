package Final_Project.test_ap;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);


		driver.get("http://3.145.160.140:8081/contact.html");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement name = driver.findElement(By.name("your_name"));
		name.sendKeys("Pabesh Thapa");

		WebElement phone_number = driver.findElement(By.name("phone_number"));
		phone_number.sendKeys("234-543-4322");

		WebElement email = driver.findElement(By.name("email_address"));
		email.sendKeys("test@gmail.com");

		WebElement msg = driver.findElement(By.name("your_message"));
		msg.sendKeys("This is the test message");

		WebElement send_button = driver.findElement(By.id("my-button"));
		send_button.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement message = driver.findElement(By.id("response"));
		System.out.println(message.getText());

		try {
			File screenshotFile = driver.getScreenshotAs(OutputType.FILE);

			File destFile = new File("test-report.jpg");
			FileUtils.copyFile(screenshotFile, destFile);
			System.out.println("Screen Captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Scripted Executed and quitting.....");
		driver.quit();
    }
}
