package connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operations {
	
	// Create the table with TableName arg
	public void createTable(String tableName) {

		String query = "create table "+tableName+" (rollNo int(3), name varchar(10));";
		try {
			MySQLConnect.st.executeUpdate(query);
			System.out.println("Table Created");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error occured");
		}
	}
	
	// Insert the data into table
	public void insertData(String tableName, int rollNo, String name) {

		String query = "insert into "+tableName+" values (?,?)";
		try {
			PreparedStatement ps = MySQLConnect.conn.prepareStatement(query);
			ps.setInt(1, rollNo);
			ps.setString(2, name);
			ps.executeUpdate();
			System.out.println("Data inserted successfully as "+rollNo+" : "+name);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error Occured");
		}
	}
	
	// Fetching the data from the table
	public void fetchNameByRollNo(String tableName, int rollNo) {

		String query = "select name from "+tableName+" where rollNo="+rollNo;
		try {

			ResultSet rs = MySQLConnect.st.executeQuery(query);
			rs.next();
			System.out.println("Name for Roll Number "+rollNo+" is: "+rs.getString(1));
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error occured");
		}
	}
	
	// Update the record into table
	public void updateNameByRollNo(String tableName, int rollNo, String name) {

		String query = "update "+tableName+" set name=? where rollNo=?";
		try {
			PreparedStatement ps = MySQLConnect.conn.prepareStatement(query);
			ps.setInt(2, rollNo);
			ps.setString(1, name);
			ps.executeUpdate();
			System.out.println("Data updated successfully as "+rollNo+" : "+name);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error Occured");
		}
	}
	
	// Fetech all records from the table
	public void fetchTable(String tableName) {

		String query = "Select * from "+tableName;
		try {

			ResultSet rs = MySQLConnect.st.executeQuery(query);
			System.out.println(tableName.toUpperCase() +" table contains below user data: ");
			while(rs.next()) {

				int rollNo = rs.getInt(1);
				String name = rs.getString(2);
				System.out.println(rollNo+" : "+name);
			}

		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error Occured");
		}
	}
	
	// Delete the record in the table
	public void deleteDataByRollNo(String tableName, int rollNo) {

		String query = "delete from "+tableName+" where rollNo="+rollNo;
		try {
			MySQLConnect.st.executeUpdate(query);
			System.out.println("Record deleted for Roll Number : "+rollNo);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error Occured");
		}
	}
	
	// delete the table
	public void deleteTable(String tableName) {

		String query = "drop table "+tableName;
		try {
			MySQLConnect.st.executeUpdate(query);
			System.out.println(tableName.toUpperCase()+" table deleted sucessfully");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error Occured");
		}
	}

}
