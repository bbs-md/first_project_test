package org.example.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.example.utils.SeleniumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicTest {

    static Logger logger = Logger.getLogger(BasicTest.class);

    public static String FIRST_NAME = "Anatolie";
    public static String LAST_NAME = "Snegur";
    public static String STUDENT_NAME = FIRST_NAME + " " + LAST_NAME;

    public static WebDriver driver;
    public static JavascriptExecutor executor;

    @BeforeClass
    public void beforeClass(){
        driver = SeleniumDriver.getRemoteDriver();
//        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        executor = (JavascriptExecutor)driver;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
