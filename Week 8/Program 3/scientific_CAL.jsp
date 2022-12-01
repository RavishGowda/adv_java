<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.lang.Math" %>
<%
double number=Double.parseDouble(request.getParameter("num"));


String ans=request.getParameter("ans");
if(ans.equals("sin"))
{	double num = Math.toRadians(number);
	out.println("Sin : "+(int)number+"<br>");
	out.println(Math.sin(num));
}else if(ans.equals("cos"))
{double num = Math.toRadians(number);
	out.println("Cos : "+(int)number+"<br>");
	out.println(Math.cos(num));	
}else if(ans.equals("tan"))
{
	double num = Math.toRadians(number);
	out.println("Tan : "+(int)number+"<br>");
	out.println(Math.tan(num));
}else if(ans.equals("log"))
{out.println("Log : "+(int)number+"<br>");
	out.println(Math.log10(number));
}else if(ans.equals("root"))
{out.println("Root : "+(int)number+"<br>");
	out.println(Math.sqrt(number));
}




	
	

%>
</body>
</html>