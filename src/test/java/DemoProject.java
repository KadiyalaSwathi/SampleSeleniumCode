import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoProject {

    public static WebDriver driver;
    public static void main(String[] args) {

        DemoProject dp = new DemoProject();
        dp.launchBrowser();
        dp.login();
        dp.addContact();
        System.out.println(dp.getTotalContacts());
        dp.closeBrowser();
    }
        public void launchBrowser() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        }
        public void login() {
            driver.get("https://thinking-tester-contact-list.herokuapp.com/");
            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("swathi@k.com");
            WebElement pwd = driver.findElement(By.id("password"));
            pwd.sendKeys("Swathi@123");
            WebElement subBtn = driver.findElement(By.id("submit"));
            subBtn.click();
        }
        public void addContact() {

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement addContactBtn = driver.findElement(By.xpath("//button[@id='add-contact']"));
        //wait.until(ExpectedConditions.visibilityOf(addContactBtn));
        addContactBtn.click();

       WebElement Fname = driver.findElement(By.id("firstName"));
       Fname.sendKeys(JavaFaker.getIndianFirstName());

       WebElement Lname = driver.findElement(By.id("lastName"));
       Lname.sendKeys(JavaFaker.getIndianLastName());

       WebElement email = driver.findElement(By.id("email"));
       email.sendKeys(JavaFaker.getEmail());

       WebElement phone = driver.findElement(By.id("phone"));
       phone.sendKeys(JavaFaker.getMobileNumber());

      WebElement subitBtn = driver.findElement(By.id("submit"));
      subitBtn.click();
    }

    public int getTotalContacts(){

        List<WebElement> Rows = driver.findElements(By.xpath("//table[@class='contactTable']//tr"));
        return Rows.size()-1;
    }

        public void closeBrowser(){

        driver.quit();
        }
    }


