package simplePage;
//import java.io.*;
import java.sql.*;
public class simplePage {

	public static void main(String[] args) {
	//System.out.println("hi");
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:9011/auction_analysis","root","sandip");
			String query="select * from user";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			rs.next();
			
			String name=rs.getString("user_name");
			System.out.println(name);
			
					 
			
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}

	}

}
