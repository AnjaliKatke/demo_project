
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String username=request.getParameter("uname");
        String pass=request.getParameter("psw");
     	out.println("your id"+username);
     	out.println("your pass"+pass);
      
        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:9011/sandip","root","sandip");
				String query="select * from user";
				out.println("hi");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				while(rs.next())
				{
					out.println("Data"+rs.next());
					response.sendRedirect("demo.html");
				}
					out.println("error");
				
				/*if(con==null)
				{
					out.println("Connection not exists");
				}
				else {
				//	Statement st=con.createStatement();"
					PreparedStatement ps = con.prepareStatement("select user_name,password from user where user_name=? and password=?");
					ps.setString(2,username);
					ps.setString(3,pass);
					
					ResultSet rs=ps.executeQuery();
					
					while(rs.next())
					{
						out.println("Data"+rs.next());
						response.sendRedirect("demo.html");
					}
					out.println("error");
				}	*/
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
	}

}
