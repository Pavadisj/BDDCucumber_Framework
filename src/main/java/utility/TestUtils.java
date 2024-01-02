package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

public class TestUtils{
	
	public static String takeScreenshotAtEndOfTest(WebDriver driver,String screenshotName) throws IOException {
		String timeStamp =new SimpleDateFormat("dd-MMM-yyyy HH.mm.ss").format(new Date());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = "./test-output/ScreenShots/" +screenshotName+ timeStamp +".png";
		Files.copy(source, new File(destination));
		return destination;
	}
	
	public static void scrollToElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", ele);
	}

}


