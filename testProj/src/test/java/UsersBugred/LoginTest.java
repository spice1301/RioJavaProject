package UsersBugred;

import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


public class LoginTest extends Properties {

    @Test
    public void testLandingPaheRio() {

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://auto.ria.com/");
        driver.findElement(By.xpath("//*[@class='nav']//*[text()='Новые авто']")).click();
        Select drpAuto = new Select(driver.findElement(By.id("categories")));
        drpAuto.selectByVisibleText("Сельхозтехника");


        WebElement carBrendfield = driver.findElement(By.xpath("//div[@id='brandTooltipBrandAutocomplete-brand']"));
        carBrendfield.click();
        WebElement inputBrand = driver.findElement(By.xpath("//div[@id='brandTooltipBrandAutocomplete-brand']//input[@id='brandTooltipBrandAutocompleteInput-brand']"));
        inputBrand.sendKeys("John De");

        WebElement carBrendSelection = driver.findElement(By.xpath("//div[@class='m-rows']//ul[@class='unstyle scrollbar autocomplete-select']"));
        carBrendSelection.click();
        assertThat(inputBrand.getAttribute("aria-label")).contains("John Deere");




        driver.quit();
    }



}
