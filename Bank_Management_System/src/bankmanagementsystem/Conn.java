package bankmanagementsystem;

import java.sql.*;

public class Conn {
	
	Connection c;
	Statement s;

	public Conn() {
		try {
//			Class.forName(con.mysql.cj.jdbc.Driver);
			c=DriverManager.getConnection("jdbc:mysql:///BankManagementSystem","root","siddhesH@8446");
			s=c.createStatement();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
