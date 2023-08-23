package Command;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDbHelper {
	public static SingletonDbHelper singletonDbHelper = null;
	
	private String userName ="root";
	private String password = "12345";
	private String dbUrl = "jdbc:mysql://localhost:3306/mydb";
	public Connection con;
	
	private SingletonDbHelper() {
		// getting connection
	    try {
			con = DriverManager.getConnection(dbUrl,userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static SingletonDbHelper getInstance() { //tek obje çekme 
		if (singletonDbHelper == null) {
			singletonDbHelper = new SingletonDbHelper();
		}
		return singletonDbHelper;
	}
}
