<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=request.getParameter("uname");
int age=Integer.parseInt(request.getParameter("age"));

if(age>=62){
	out.println("<h1>Name : "+name+"</h1><br>");
	out.println("<h1>The age is : "+age+"</h1><br>");
	out.println("<h1>The movie ticket price is Rs. 50</h1>");
}else{
	if(age<=10){
		out.println("<h1>Name : "+name+"</h1><br>");
		out.println("<h1>The age is : "+age+"</h1><br>");
		out.println("<h1>The movie ticket price is Rs. 30</h1>");
	}
	else{
		out.println("<h1>Name : "+name+"</h1><br>");
		out.println("<h1>The age is : "+age+"</h1><br>");
		out.println("<h1>The movie ticket price is Rs. 80</h1>");
	}
}

%>
</body>
</html>