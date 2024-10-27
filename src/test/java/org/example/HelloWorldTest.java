package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldTest {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "D:\\anatolie\\webdriver\\130.0.6723.58\\chromedriver-win64\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        WebElement searchEl =  driver.findElement(By.xpath("//*[@name='q']"));
        searchEl.sendKeys("My first test");
        searchEl.sendKeys(Keys.ENTER);
        driver.quit();
    }
}
