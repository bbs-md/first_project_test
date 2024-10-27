package org.example.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static org.example.utils.Utils.explicitWait;
import static org.example.utils.Utils.fluentWaitCond;

public class DemoqaFrom extends BasicTest{

    @Test
    public void practiceFormTest() throws AWTException, InterruptedException {
        logger.info("Start practiceFormTest");
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement firstNameEl = driver.findElement(By.cssSelector("#firstName"));
        WebElement lastNameEl = driver.findElement(By.cssSelector("#lastName"));
        WebElement userEmailEl = driver.findElement(By.xpath("//*[@id='userEmail']"));
        WebElement genderEl = driver.findElement(By.xpath("//*[@id='gender-radio-1']"));
        WebElement userNumberEl = driver.findElement(By.xpath("//*[@id='userNumber']"));
        userNumberEl.sendKeys("0671777380");
        firstNameEl.sendKeys("Anatolie");
        lastNameEl.sendKeys("Snegur");
        userEmailEl.sendKeys("bbs.md@mail.ru");
        genderEl.sendKeys(" ");
        executor.executeScript("document.getElementById('dateOfBirthInput').value='23 Apr 1077';");
        WebElement uploadPictureEl = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
        WebElement uploadPictureLabelEl = driver.findElement(By.xpath("//*[@for='uploadPicture']"));


        executor.executeScript("var elem = document.evaluate(\"//footer\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "elem.parentNode.removeChild(elem);");

        executor.executeScript("var elem = document.evaluate(\"//*[@id='fixedban']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "elem.parentNode.removeChild(elem);");



        executor.executeScript("arguments[0].scrollIntoView(true);", uploadPictureEl);
//        uploadPictureLabelEl.click();
//
//        Thread.sleep(1000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_D);
//        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_SEMICOLON);
//        robot.keyRelease(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_BACK_SLASH);
//        robot.keyPress(KeyEvent.VK_A);
//        robot.keyPress(KeyEvent.VK_N);
//        robot.keyPress(KeyEvent.VK_A);
//        robot.keyPress(KeyEvent.VK_T);
//        robot.keyPress(KeyEvent.VK_O);
//        robot.keyPress(KeyEvent.VK_L);
//        robot.keyPress(KeyEvent.VK_I);
//        robot.keyPress(KeyEvent.VK_E);
//        robot.keyPress(KeyEvent.VK_BACK_SLASH);
//        robot.keyPress(KeyEvent.VK_C);
//        robot.keyPress(KeyEvent.VK_U);
//        robot.keyPress(KeyEvent.VK_R);
//        robot.keyPress(KeyEvent.VK_L);
//        robot.keyPress(KeyEvent.VK_PERIOD);
//        robot.keyPress(KeyEvent.VK_T);
//        robot.keyPress(KeyEvent.VK_X);
//        robot.keyPress(KeyEvent.VK_T);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement stateEl = fluentWaitCond(driver, ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='state']")));
        stateEl.click();
        WebElement subStateSelEl = fluentWaitCond(driver, ExpectedConditions.visibilityOf(stateEl.findElement(By.xpath(".//*[contains(@class, 'menu')]"))));
        List<WebElement> subStateListEl = fluentWaitCond(driver, ExpectedConditions.visibilityOfAllElements(subStateSelEl.findElements(By.xpath(".//*"))));
        for (WebElement subStateEl: subStateListEl) {
            if (subStateEl.getText().equals("Rajasthan")){
                subStateEl.click();
                break;
            }
        }

        WebElement cityEl = driver.findElement(By.xpath("//*[@id='city']"));
        cityEl.click();
        WebElement subCityEl = cityEl.findElement(By.xpath(".//*[contains(@class, 'menu')]"));

        List<WebElement> subCityListEl = (subCityEl.findElements(By.xpath(".//*")));
        for (WebElement subCityItemEl: subCityListEl) {
            if (subCityItemEl.getText().equals("Jaipur")){
                subCityItemEl.click();
                break;
            }
        }

        WebElement submitEl = driver.findElement(By.xpath("//*[@id='submit']"));
        submitEl.click();

        WebElement studentNameEl = explicitWait(driver, ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Student Name']/../*[2]")), 10);
        String studentName = studentNameEl.getText();
        String expectedStudentName = STUDENT_NAME;
        Assert.assertEquals(studentName, expectedStudentName, "Names are not equals");
        Thread.sleep(4000);
        logger.info("Finish practiceFormTest");
    }

}
