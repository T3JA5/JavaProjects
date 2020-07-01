package runner;

import org.testng.annotations.Test;

import screenshot.TakeScreenshot;

public class POMTest extends TakeScreenshot {
	
	@Test
	public void pomTest() {
		
		String url = "https://www.google.com/";
		String filePath = "E:\\Automation\\Screenshots\\";
		String fileType = ".pdf";
		
		// Calling utility
		screenshot(url, fileType, filePath);
		
		System.out.println("Screenshot took for " + url + "and saved successfully to " + filePath);	
	}

}
