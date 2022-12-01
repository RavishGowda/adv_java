<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scientific Calculator</title>
</head>
<body>
<h1> Scientific Calculator</h1>
<form action="scientific_CAL.jsp" method="get">
<label>Enter Number</label>
<input type="text" name="num"><br>
<input type="radio" name="ans" value="sin" />Sin<br>
<input type="radio" name="ans" value="cos" />Cos<br>
<input type="radio" name="ans" value="tan" />Tan<br>
<input type="radio" name="ans" value="log" />Log<br>
<input type="radio" name="ans" value="root" />Root<br>
<input type="submit" value="Submit" /><br>
</form>

</body>
</html>