package za_automation.KeyWordsFrameWork.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static za_automation.KeyWordsFrameWork.util.WaitUtil.*;

import java.util.List;

import static za_automation.KeyWordsFrameWork.util.KeyBoradUtil.*;


public class TestSendMailWithAttachment {
	WebDriver driver;
	String baseUrl;
	
	@Test
	public void testSendMailWithAttachment(){
		driver.get("http://mail.126.com");
		WebElement userName = driver.findElement(By.cssSelector("form>input[name='email']"));
		WebElement passWord = driver.findElement(By.cssSelector("form>input[name='password']"));
		WebElement loginButton = driver.findElement(By.id("loginBtn"));
		userName.clear();
		userName.sendKeys("lxc3712");
		passWord.clear();
		passWord.sendKeys("37125642525511");
		loginButton.click();
		waitWebElement(driver,"//a[contains(.,'退出')]");
		WebElement writeMailLink = driver.findElement(By.xpath("//*[contains(@id,'_mail_component_')]/span[contains(.,'写信')]"));
		writeMailLink.click();
		waitWebElement(driver,"//a[contains(.,'收件人')]");
		WebElement recipients = driver.findElement(By.xpath("//*[contains(@id,'_mail_emailinput_0_')]/input"));
		WebElement mailSubject = driver.findElement(By.xpath("//*[contains(@id,'_mail_input_3')]/input"));
		recipients.sendKeys("liuxingchen@zhongan.com");
		mailSubject.sendKeys("这是一封测试邮件");
		pressTabKey();
		sleep(4000);
		List<WebElement> buttons = driver.findElements(By.xpath("//*[contains(@id,'_mail_button_')]/span[contains(.,'发送')]"));
		buttons.get(1).click();
		waitWebElement(driver, "//*contains(@id,'_succInfo')]");
		Assert.assertTrue(driver.getPageSource().contains("发送成功"));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
}
