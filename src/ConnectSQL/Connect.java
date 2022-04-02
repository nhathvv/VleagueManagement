package ConnectSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class Connect {
	
	public Connection getConnection() {
		Connection conn = null;
		try{
			   String userName = "root";
			   String password = "";
			   String url = "jdbc:mysql://localhost/vleague";
			   Class.forName ("com.mysql.cj.jdbc.Driver");
			   conn = DriverManager.getConnection(url, userName, password);
		} catch(Exception e){
			   System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void main(String[] args) {
		Connection conn = null;
		try{
			   String userName = "root";
			   String password = "";
			   String url = "jdbc:mysql://localhost/vleague";
			   Class.forName ("com.mysql.cj.jdbc.Driver");
			   conn = DriverManager.getConnection(url, userName, password);
			   System.out.println("Connection thanh cong");
			   
			   String sql = "SELECT * FROM footballteam";
			   PreparedStatement stm= conn.prepareStatement(sql);
			   stm = conn.prepareStatement(sql);
			   ResultSet rs = stm.executeQuery();
			 //  while(rs.next()) {
				//   System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getDate(4));
			 //  }
			   
		} catch(Exception e){
			  // System.out.println(e.getMessage());
		}
	}

}
