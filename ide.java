package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ide {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "www.google.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testIde() throws Exception {
    driver.get("http://172.17.2.95/para/Home.aspx");
    driver.findElement(By.linkText("Candidate")).click();
    driver.findElement(By.id("ContentPlaceHolder1_idtxtbox")).clear();
    driver.findElement(By.id("ContentPlaceHolder1_idtxtbox")).sendKeys("deepak@gmail.com");
    driver.findElement(By.id("ContentPlaceHolder1_pwdtxtbox")).clear();
    driver.findElement(By.id("ContentPlaceHolder1_pwdtxtbox")).sendKeys("deepak");
    driver.findElement(By.id("ContentPlaceHolder1_btnlogin")).click();
    driver.findElement(By.linkText("ViewExam")).click();
    driver.findElement(By.linkText("Syllabus")).click();
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.linkText("Admin")).click();
    driver.findElement(By.id("ContentPlaceHolder1_idtxtbox")).clear();
    driver.findElement(By.id("ContentPlaceHolder1_idtxtbox")).sendKeys("");
    driver.findElement(By.id("ContentPlaceHolder1_pwdtxtbox")).clear();
    driver.findElement(By.id("ContentPlaceHolder1_pwdtxtbox")).sendKeys("");
    driver.findElement(By.id("ContentPlaceHolder1_idtxtbox")).clear();
    driver.findElement(By.id("ContentPlaceHolder1_idtxtbox")).sendKeys("admin@gmail.com");
    driver.findElement(By.id("ContentPlaceHolder1_pwdtxtbox")).clear();
    driver.findElement(By.id("ContentPlaceHolder1_pwdtxtbox")).sendKeys("admin");
    driver.findElement(By.id("ContentPlaceHolder1_btnlogin")).click();
    driver.findElement(By.linkText("Add Exam")).click();
    driver.findElement(By.id("ContentPlaceHolder1_txtexid")).clear();
    driver.findElement(By.id("ContentPlaceHolder1_txtexid")).sendKeys("999");
    driver.findElement(By.id("ContentPlaceHolder1_txtpost")).clear();
    driver.findElement(By.id("ContentPlaceHolder1_txtpost")).sendKeys("hdjsbdb");
    driver.findElement(By.id("ContentPlaceHolder1_txtagelimit")).clear();
    driver.findElement(By.id("ContentPlaceHolder1_txtagelimit")).sendKeys("30");
    driver.findElement(By.id("ContentPlaceHolder1_txtqual")).clear();
    driver.findElement(By.id("ContentPlaceHolder1_txtqual")).sendKeys("degree");
    driver.findElement(By.id("ContentPlaceHolder1_txtexam")).clear();
    driver.findElement(By.id("ContentPlaceHolder1_txtexam")).sendKeys("06/12/2017");
    driver.findElement(By.id("ContentPlaceHolder1_txtldate")).clear();
    driver.findElement(By.id("ContentPlaceHolder1_txtldate")).sendKeys("24/11/2017");
    driver.findElement(By.id("ContentPlaceHolder1_Proceed")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
