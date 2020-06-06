package jsontotext;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Serilization {
	
	public static void serilize(String fileName) throws Exception {
		
		FileReader reader =null;
		File file = new File(fileName);
		
		JSONParser parser = new JSONParser();
		
		try {
			
			reader = new FileReader(file.getAbsolutePath());
			Object obj = parser.parse(reader);
			JSONObject jobj = (JSONObject) obj;
			JSONObject jsonobj = (JSONObject) jobj.get("info");
			System.out.println("Info : "+jsonobj);
			
			String out = jsonobj.toString();
			
			FileWriter write = new FileWriter(new File("outputText.txt"));
			write.write(out);
			write.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			reader.close();
		}
		
	}

	
}
