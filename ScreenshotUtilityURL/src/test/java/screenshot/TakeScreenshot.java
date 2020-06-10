package screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshot {
	
	public static void screenshot(String url, String fileType, String filePath) {
		
		try {
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		final File screenShotOutputFile = new File(filePath+"screenshot_" + System.currentTimeMillis() + "."+fileType).getAbsoluteFile();
	        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, screenShotOutputFile);
	        System.out.println("File Name: " + screenShotOutputFile +" saved successfully");
	        
	        //Quit the driver
	        driver.quit();
		}catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("Exception occured");
		}
	}

}
