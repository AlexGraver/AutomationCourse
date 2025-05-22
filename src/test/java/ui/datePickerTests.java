package ui;

import pages.webFormPage.datePicker.DatePickerLevel_1;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class datePickerTests {

    private static final By DATE_PICKER = By.xpath("//input[@name='my-date']");
    private static final By SUBMIT = By.xpath("//button[@type=\"submit\"]");


    private WebDriver driver;
    private DatePickerLevel_1 datePickerLevel1;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    void enterTodayDateTest(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        DatePickerLevel_1 datePickerLevel1 = openDatePicker();
        String day = String.valueOf(LocalDate.now().getDayOfMonth());
        String expectedValue = getFormattedDate(LocalDate.now());
        datePickerLevel1.selectDay(day);
        String newValue = getDatePickerValue();

        Assertions.assertTrue(newValue.equalsIgnoreCase(expectedValue), "Date not as expected");
    }

    @Step
    private DatePickerLevel_1 openDatePicker(){
        driver.findElement(DATE_PICKER).click();
        return new DatePickerLevel_1(driver);
    }

    @Step
    void submitFormAndReturn(){
        driver.findElement(SUBMIT).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().back();
    }

    @Step
    private String getDatePickerValue(){
        submitFormAndReturn();
        return driver.findElement(DATE_PICKER).getDomProperty("value");
    }

    @Step
    private String getFormattedDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return date.format(formatter);
    }
}
