package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonSqlQuery {
	public static void main(String[]args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders","root","root");
		Statement stat=conn.createStatement();
		String query="insert into student(first_name,last_name,address)values('raja','BN','INdia')";
		int result=stat.executeUpdate(query);
		if(result==1)
		{
			System.out.println("user is created");
		}
		else
		{
			System.out.println("user is not created");
		}
		conn.close();
	}

}
