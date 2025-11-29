import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.xpath.XPath;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }


    @Test
    public void LinkTests(){
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



    }





    //Find my destination
    //Am I Broken link?
    //Count page links
    //count layout links
}
