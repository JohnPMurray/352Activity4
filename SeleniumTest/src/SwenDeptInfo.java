import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
	
public class SwenDeptInfo {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
	    driver = new ChromeDriver(new ChromeOptions());
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void test1()throws Exception {
		  driver.get("http://www.rit.edu/");
		  driver.findElement(By.xpath("//div[@id='navbarCollapse']/ul/li[2]")).click();
		  driver.findElement(By.xpath("//div[@id='navbarCollapse']/ul/li[2]/ul/li/div/div/div[2]/ul/li[3]/a")).click();
		  driver.findElement(By.xpath("//div[@id='block-menu-block-1']/div/div/ul/li[3]/a/span")).click();
		  driver.findElement(By.xpath("//div[@id='block-system-main']/div/div[4]/div[4]/div/a")).click();
		  Thread.sleep(2000);
		  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		  driver.switchTo().window(tabs.get(1));
		  driver.findElement(By.xpath("//div[@id='block-menu-block-1']/div/div/ul/li[11]/a/span")).click();
		  if(isElementPresent(By.xpath("//div[@id='node-60']/div/div/div/div/p[2]")) && isElementPresent(By.xpath("//div[@id='node-60']/div/div/div/div/p[3]"))) {
		  System.out.println(driver.findElement(By.xpath("//div[@id='node-60']/div/div/div/div/p[2]")).getText());
		  System.out.println(driver.findElement(By.xpath("//div[@id='node-60']/div/div/div/div/p[3]")).getText());
		  }
		  else {
			  System.out.println("Contact Information not avaliable");
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
}
