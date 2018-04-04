package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
    driver = new ChromeDriver(DesiredCapabilities/chrome());
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://tigercenter.rit.edu/tigerCenterHome/#/landing");
    driver.findElement(By.xpath("//button[@type='button']")).click();
    driver.findElement(By.linkText("Advanced Search")).click();
    driver.findElement(By.name("campus")).click();
    new Select(driver.findElement(By.name("campus"))).selectByVisibleText("RIT Main");
    driver.findElement(By.id("college")).click();
    new Select(driver.findElement(By.id("college"))).selectByVisibleText("Golisano Col Comp&Info Science");
    driver.findElement(By.id("majors")).click();
    new Select(driver.findElement(By.id("majors"))).selectByVisibleText("SWEN - Software Engineering");
    driver.findElement(By.id("instructorBox")).click();
    driver.findElement(By.id("instructorBox")).clear();
    driver.findElement(By.id("instructorBox")).sendKeys("McKeown");
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    driver.findElement(By.xpath("//tbody[@id='resultBody']/tr/td")).click();
    System.out.println(driver.findElement(By.xpath("//h4[@id='classDetailsHeader']")).getText());
    java.util.List<WebElement> table = driver.findElements(By.xpath("//table[@id='classDetailsInfo']/tbody/tr"));
    String innerHtml;
    for (WebElement element : table) {
    		innerHtml = element.findElement(By.tagName("td")).getText();
    		if (innerHtml.equals("Days:")) {
    			System.out.println(element.findElements(By.tagName("td")).get(1).getText());
    		}
    		if (innerHtml.equals("Days:")) {
    			System.out.println(element.findElements(By.tagName("td")).get(1).getText());
    		}
    		if (innerHtml.equals("Days:")) {
    			System.out.println(element.findElements(By.tagName("td")).get(1).getText());
    		}
    		
    }
    
  }

  @After
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
