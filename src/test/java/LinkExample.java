import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }


    @Test
    public void linkTests(){
        //Take me to dashboard
        WebElement homelink = driver.findElement(By.linkText("Go To Dashboard"));
        homelink.click();
        driver.navigate().back();

        //Find My Destination
        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = wheretoGo.getAttribute("href");
        System.out.printf("This link is going to: "+ path);

        //Am I Broken Link?
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")){
            System.out.println("The link is broken");
        }else{
            System.out.println("Not Broken");
        }
        driver.navigate().back();

        //Duplicate Link
        homelink.click();


        //Count page link
        List<WebElement> countfullpageLinks =  driver.findElements(By.tagName("a"));
        int pageLinkCount = countfullpageLinks.size();
        System.out.println("Count of full oage links: " + pageLinkCount);


        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLinks = layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of layout links: " + countOfLayoutLinks.size());

    }





    //Find my destination
    //Am I Broken link?
    //Count page links
    //count layout links
}
