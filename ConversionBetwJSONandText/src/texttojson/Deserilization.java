package texttojson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class Deserilization {

	public static void desrilize(String fileName) throws Exception {

		BufferedReader reader = null;

		try {
			HashMap<String, String> map = new HashMap<String, String>();

			String line;
			reader = new BufferedReader(new FileReader(fileName));
			
			// Split by : symbol
			while ((line = reader.readLine()) != null)
			{
				String[] parts = line.split(":", 2);
				if (parts.length >= 2)
				{
					String key = parts[0];
					String value = parts[1];
					map.put(key, value);
				} else {
					System.out.println("ignoring line: " + line);
				}
			}

			// Text file inputs are
			System.out.println("Text File input are: ");
			for (String key : map.keySet())
			{
				System.out.println(key + ":" + map.get(key));
			}

			// Convert to json file
			JSONObject obj = new JSONObject(map);
			String jsonStr = obj.toJSONString();
			System.out.println("JSON ouput is:");
			System.out.println(jsonStr);
			
			// Write the json output to file
			FileWriter write = new FileWriter(new File("outputJSON.json"));
			write.write(jsonStr);
			write.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			reader.close(); 
		}
	}

}
