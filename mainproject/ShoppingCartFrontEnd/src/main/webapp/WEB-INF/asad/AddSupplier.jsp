<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fm:form action="supplieradd" commandName="supplier">
SuplierID<input type="text" name="suplierId">
CategoryName<input type="text" name="suplierName">
SuplierDescription<input type="text" name="suplierDescription">
<input type="submit">
</fm:form>
</body>
</html>