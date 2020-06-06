package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLConnect {

	public static Connection conn = null;
	public static Statement st = null;

	public static void main(String[] args) throws Exception {
		
		// Connecting to database
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "Desmond@2020");
		st =conn.createStatement();

		Operations os = new Operations();

		// Operations
		String tableName = "student";
		//os.createTable(tableName);
		//os.insertData(tableName, 1, "Naruto");
		//os.insertData(tableName, 2, "Sakura");
		//os.insertData(tableName, 3, "Saske");
		//os.fetchNameByRollNo(tableName, 1);
		//os.updateNameByRollNo(tableName, 3, "Sai");
		//os.deleteDataByRollNo(tableName, 3);
		//os.fetchTable(tableName);
		//os.deleteTable(tableName);
	}
}
