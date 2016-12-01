package za_automation.KeyWordsFrameWork.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	//线程休眠
	public static void sleep(long millisecond){
		try {
			Thread.sleep(millisecond);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	//显示等待页面元素出现
	public static void waitWebElement(WebDriver driver,String xpathExpression){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
	}
}
