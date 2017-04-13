<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/designs.css">
</head>
<body>

<fm:form action="productadd" commandName="product" enctype="multipart/form-data" method="post">

ProductName<input type="text" name="name">
Price<input type="text" name="price">
Category<input type="text" name="category">

Supplier<input type="text" name="supplier">
Stock<input type="text" name="stock">
Image<input type="File" name="img">

<input type="submit">
</fm:form>


</body>
</html>