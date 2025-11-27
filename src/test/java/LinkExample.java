import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkExample {

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void openLinkTestPage(){

        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }


    @Test
    public void LinkTests(){
        //Take me to dashboard
        WebElement homelink = driver.findElement(By.linkText("Go To Dashboard"));
        homelink.click();

    }





    //Find my destination
    //Am I Broken link?
    //Count page links
    //count layout links
}
