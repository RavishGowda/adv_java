<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%
Scanner sc=new Scanner(System.in);
	System.out.println("Enter the 5 Subject Marks");
System.out.println("Enter the  OS Marks");
 int os=sc.nextInt();
System.out.println("Enter the DBS Marks");
int dbs=sc.nextInt();
System.out.println("Enter the Java Marks");
int java=sc.nextInt();
System.out.println("Enter the AA Marks");
int aa=sc.nextInt();
System.out.println("Enter the AI Marks");
int ai=sc.nextInt();

out.println("<h1>Student Total Grade </h1>");

%><br>


<% float obtain;

if(os>=50&&dbs>=50&&java>=50&&aa>=50&&ai>=50){
	 obtain=os+dbs+java+aa+ai;
	 float avg=obtain/5;
	 out.println("<h1> Your Average :"+avg+"</h1>");
	 
	 	if(avg>=50 && avg<=59)
	 	{
	 		out.println("<h1>Grade : D</h1>");
	 	}else{
	 		if(avg>=60 && avg<=69)
	 		{
	 			out.println("<h1>Grade : C</h1>");
	 		}
	 	else{
	 		if(avg>=70 && avg<=79)
	 		{
	 			out.println("<h1>Grade : B</h1>");
	 		}else{
	 			if(avg>=80 && avg<=89)
	 			{
	 				out.println("<h1>Grade : A</h1>");
	 			}
	 		else{
	 			if(avg>=90 && avg<=100)
	 			{
	 				out.println("<h1>Grade : S</h1>");
	 			}
	 		}
	 	}}}
	 	
	 		 	if(java>=50 && java<=59)
	 	{
	 		out.println("<h1>JAVA Grade : D</h1>");
	 	}else{
	 		if(java>=60 && java<=69)
	 		{
	 			out.println("<h1>JAVA Grade : C</h1>");
	 		}
	 	else{
	 		if(java>=70 && java<=79)
	 		{
	 			out.println("<h1>JAVA Grade : B</h1>");
	 		}else{
	 			if(java>=80 && java<=89)
	 			{
	 				out.println("<h1>JAVA Grade : A</h1>");
	 			}
	 		else{
	 			if(java>=90 && java<=100)
	 			{
	 				out.println("<h1>JAVA Grade : S</h1>");
	 			}
	 			else{
	 				out.println("<h1>Fail </h1>");
	 			}
	 		}
	 	}}}
	 	


}
		
	 	


else{
	
	 out.println("Your any One or More Subject Average is less than 50 </h1>");
	out.println("<h1>Fail</h1>");
}
%>


</body>
</html>