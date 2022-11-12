

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Police_Station")
public class Police_Station extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		System.out.println("Entet Which Area Police Staion Details You Want.");
		Scanner sc= new Scanner(System.in);
		String area=sc.next();
		
		Statement pstmt;
		try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/1MS21CS406","root","");
		System.out.println("Connection Established");
		pstmt = conn.createStatement();
		ResultSet rs=pstmt.executeQuery("SELECT * FROM Police_Station where Area='"+area+"'");
		while(rs.next()) 
        {
            String f1 = rs.getString(1);
			String f2 = rs.getString(2);
			String f3 = rs.getString(3);
			String f4 = rs.getString(4);
			String f5 = rs.getString(5);
			System.out.println(f1+"  "+f2);
			
        }
		conn.close();
		} catch (Exception e) {
		System.out.println("ERROR"+e);
		out.close();
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
