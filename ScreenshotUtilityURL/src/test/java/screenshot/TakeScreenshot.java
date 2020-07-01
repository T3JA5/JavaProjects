package screenshot;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class TakeScreenshot {

	public void screenshot(String url, String fileType, String filePath) {

		try {
			WebDriver driver = new ChromeDriver();
			driver.get(url);

			if(fileType == ".pdf") {

				byte[] input = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				Document document = new Document();
				String output = filePath + "Image" + fileType;
				FileOutputStream fos = new FileOutputStream(output);

				// Instantiate the PDF writer
				PdfWriter writer = PdfWriter.getInstance(document, fos);

				// open the pdf for writing
				writer.open();
				document.open();

				// process content into image
				Image im = Image.getInstance(input);

				//set the size of the image
				im.scaleToFit(PageSize.A4.getWidth()/2, PageSize.A4.getHeight()/2);

				// add the captured image to PDF
				document.add(im);
				document.add(new Paragraph(" "));

				//close the files and write to local system
				document.close();
				writer.close();
				
			}

			else {

				final File screenShotOutputFile = new File(filePath+"screenshot_" + System.currentTimeMillis() + "."+fileType).getAbsoluteFile();
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, screenShotOutputFile);
				System.out.println("File Name: " + screenShotOutputFile +" saved successfully");
			}
			
			//Quit the driver
			driver.quit();
			
		}catch(Exception e) {

			e.printStackTrace();
			System.out.println("Exception occured");
		}
	}

}
