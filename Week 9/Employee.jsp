<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  


<%@ page import="java.sql.*" %>
<%

int eid=Integer.parseInt(request.getParameter("emp_id"));
String fname=request.getParameter("fname");
String lname=request.getParameter("lname");
int salary=Integer.parseInt(request.getParameter("salary"));

String prj=request.getParameter("prj");

String url = "jdbc:mysql://localhost:3306/"; 
String dbName = "mydb"; 
String driver = "com.mysql.jdbc.Driver"; 
String user = "root";  
String password = ""; 
try {
	Class.forName(driver).newInstance(); 
	Connection con = DriverManager.getConnection(url+dbName, user, password); 
	Statement st= con.createStatement(); 
	PreparedStatement ps=con.prepareStatement("insert into employee_jsp value(?,?,?,?,?)");
	ps.setInt(1,eid);
	ps.setString(2,fname);
	ps.setString(3,lname);
	ps.setString(4,fname);
	ps.setInt(5,salary);
	
	ps.executeUpdate();
	System.out.println("Values are inserted..... \nDo you want another Record(y/n)");
	
			
	ResultSet rs; 
	rs=st.executeQuery("select * from stud"); 
	String f1,f2;      

	out.println("<TABLE CELLSPACING=\"0\" CELLPADDING=\"3\" BORDER=\"1\">");
	out.println("<TR><TH>ID</TH><TH>Name</TH></TR>");

	//Loop through results of query.
	while(rs.next())
	{
  	out.println("<TR>");
  	out.println("  <TD>" + rs.getString("usn") + "</TD>");
  	out.println("  <TD>" + rs.getString("name") + "</TD>");
  	out.println("</TR>");
	}
out.println("</TABLE>");
  }
  catch(SQLException e) {
  out.println("SQLException: " + e.getMessage() + "<BR>");
  while((e = e.getNextException()) != null)
     out.println(e.getMessage() + "<BR>");
  }
catch(ClassNotFoundException e) {
  out.println("ClassNotFoundException: " + e.getMessage() + "<BR>");
  }
 %>


</body>
</html>