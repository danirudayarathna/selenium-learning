import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");// URL is wrong correct it.
        Thread.sleep(3000);
    }

    @Test
    public void textBoxTests(){
        //Step 1
        WebElement name = driver.findElement(By.id(""));
        name.sendKeys("daniru");

        //Step 2
        WebElement appendText = driver.findElement(By.id(""));
        appendText.sendKeys("Sri Lanka");

        //Step 3
        boolean enabled = driver.findElement(By.id("")).isEnabled();
        System.out.println("Is Text Box Enabled: " + enabled);

        //Step 4
        //Xpath can be copied in by right-clicking the element
        WebElement clearText = driver.findElement(By.xpath(""));
        clearText.clear();

        //Step 5
        WebElement textElement = driver.findElement(By.id(""));
        String value = textElement.getAttribute("");
        System.out.println(value);

        //Step 6
        driver.findElement(By.id("")).sendKeys("" + Keys.TAB);


    }
}
