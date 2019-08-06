package amazon.utils.browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

/*启动谷歌浏览器
* */
public class StartChrome {
  @Test
public  void main(){
   System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
   ChromeOptions options = new ChromeOptions();
   options.addArguments("disable-infobars");
   WebDriver driver = new ChromeDriver(options);
   //WebDriver driver = new ChromeDriver();
    driver.navigate().to("http://www.baidu.com");
    WebElement element = driver.findElement(By.name("wd"));
    element.sendKeys("借款时间");
    element.submit();
 try {
  Thread.sleep(1000);
 } catch (InterruptedException e) {
  e.printStackTrace();
 }
 driver.quit();

}
}
