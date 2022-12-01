<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>

<%
String usn=request.getParameter("usn");
//out.println(usn);
%>
<%

try {
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); 
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java","root","gowda@406");
	Statement st= con.createStatement(); 
	 ResultSet rs=st.executeQuery("SELECT * FROM student_jsp where usn='"+usn+"'");
     if(rs.next()) {
     	
     		 String f1 = rs.getString(1);
 			String f2 = rs.getString(2);
 			out.println("Name : "+f1+"<br>");
 			out.println("USN : "+f2);
     	
     	
     }else
     {
     	out.println("Invlaid USN ");
     }
      con.close();
	
	
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