package main;

import jsontotext.Serilization;
import texttojson.Deserilization;

public class Main {
	
	public static void main(String[] args) {
		
		String textFileName = "text.txt";
		String jsonFileName = "Sample.json";
		try {
			Serilization.serilize(jsonFileName);
			Deserilization.desrilize(textFileName);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
