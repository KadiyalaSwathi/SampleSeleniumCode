import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class IkeaAssignment {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        IkeaAssignment ia = new IkeaAssignment();
        ia.launchBrowser();
        ia.findItems();
    }

    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }
    public void findItems() throws InterruptedException {
        driver.get("https://www.ikea.com/in/en/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='ikea-search-input']"));
        searchBox.sendKeys("Stainless work table");

        WebElement searchIcon = driver.findElement(By.xpath("//button[@type='submit']"));
        searchIcon.click();

        Thread.sleep(5000);

        List<WebElement> returnedItems = driver.findElements(By.xpath("//span[@class='plp-price-module__description']"));
        System.out.println(returnedItems.size());

        List<WebElement> cartIcons = driver.findElements(By.xpath("//button[@class='plp-btn plp-btn--small plp-btn--icon-emphasised']"));
        for (int i = 0; i < returnedItems.size(); i++) {
            //System.out.println(returnedItems.get(i).getText());
            if (returnedItems.get(i).getText().contains("Desk")) {

                System.out.println(returnedItems.get(i).getText());
                }

            }
        }

    }

