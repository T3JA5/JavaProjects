package com.file.operations;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String file = "Read.txt";
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
