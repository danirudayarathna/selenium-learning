import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdown {
    WebDriver driver;

    @BeforeMethod
    public void openDropdownPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");
    }

    @Test
    public void testDropdown(){
        // ways of select values in basic dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        select.selectByVisibleText("Playwright");

        //Get the number of options
        List<WebElement> listofOptions = select.getOptions();
        int size = listofOptions.size();
        System.out.println("Number of elements: " + size);

        for (WebElement element:listofOptions){
            System.out.println(element.getText());
        }

        //Using Sendkeys select dropdown values
        dropdown.sendKeys("Puppeteer");

        //Selecting value in a Bootstrap dropdown
        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> dropdown2values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element: dropdown2values){
            String dropdownvalue=element.getText();
            if (dropdownvalue.equals("USA")){
                element.click();
                break;
            }
        }

        //Google Search - pick a value from suggestions

    }
    @Test
    public void googleSearchDropdown() throws InterruptedException{
        driver.get("https://www.google.com");
        By.name("q").findElements(driver).sendKeys("palitha");
        List<WebElement> googleSearchList = driver.findElements(By.xpath("//ul[@role = 'listbox']/li//div[@class='eIPGRd']"));
        for (WebElement element : googleSearchList){
            String dropDown2 = element.getText();

            if (dropDown2.equals("Palitha Thewarapperuma")){
                element.click();
                break;
            }
        }



    }
}
