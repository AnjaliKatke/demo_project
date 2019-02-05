

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String username=request.getParameter("uname");
        String pass=request.getParameter("psw");
     	
      
        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:9011/sandip","root","sandip");
				if(con==null)
				{
					out.println("Connection not exists");
				}
				else {
				//	Statement st=con.createStatement();"
					String query="insert into user(user_id,user_name,password,mobile_no,phone_no,status)"+"values(?,?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1,2);
					ps.setString(2,username);
					ps.setString(3,pass);
					ps.setInt(4,88887);
					ps.setInt(5,227630);
					ps.setInt(6,0);
					ps.execute();
				}	
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
	}

}
