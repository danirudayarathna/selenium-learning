import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml;jsessionid=node01jd5y5v2x7qqn9x0pwknaz7vh10321307.node0");

    }

    @Test
    public void buttonTest(){
        //Click the button
        WebElement button1 = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        button1.click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.navigate().back();

        // Find the position of the submit button
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt94']"));
        Point xyPoint = submitButton.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X position: " + x + "\nY position: " + y);

        //Find the Save button
        WebElement saveButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt96']"));
        String color = saveButton.getCssValue("background-color");
        System.out.println("Color: " + color);

        //Find the height and width of this button
        WebElement button2 = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']"));
        int height = button2.getSize().getHeight();
        int width = button2.getSize().getWidth();

        System.out.println("Height: " + height + "\nWidth: " + width);

        //Mouse over and confirm the color changed
        WebElement colorButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']"));
        String color1 = colorButton.getCssValue("background-color");
        System.out.println("Before Hoover Color: " + color1);

        Actions actions = new Actions(driver);
        actions.moveToElement(colorButton).perform();

        String color2 = colorButton.getCssValue("background-color");
        System.out.println("After Hoover Color: " + color2);

    }

}
