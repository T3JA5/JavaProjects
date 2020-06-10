package runner;

import org.testng.annotations.Test;

import screenshot.TakeScreenshot;

public class POMTest {
	
	@Test
	public void pomTest() {
		
		String url = "https://www.google.com/";
		String filePath = "E:\\Automation\\Screenshots\\";
		String fileType = ".png";
		
		// Calling utility
		TakeScreenshot.screenshot(url, fileType, filePath);
		
		System.out.println("Screenshot took for " + url + "and saved successfully to " + filePath);	
	}

}
