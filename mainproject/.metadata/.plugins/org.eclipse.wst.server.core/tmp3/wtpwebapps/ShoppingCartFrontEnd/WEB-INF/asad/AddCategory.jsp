<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
     <%@page isELIgnored="false" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Insert title here</title>
</head>
<body>
<fm:form action="${pageContext.request.contextPath}/categoryadd" commandName="category">
<c:if test="${not empty category.categoryName}">
CategoryID<fm:input type="text" path="categoryId" disabled="true" readonly="true" />
<fm:hidden path="categoryId"/>
</c:if>
CategoryName<fm:input type="text" path="categoryName"/>
Description<fm:input type="text" path="categoryDescription"/>
<input type="submit">
</fm:form>

<c:if test="${not empty categoryList}">

<div class="col-xs-2"></div>

<br>
<div class="row"><div class="col-xs-10"><center><h3 style="color:blue">Product List</h3></center></div></div>
<div class="row">
<div class="col-xs-1"></div>

<div class="col-xs-10">

<c:if test="${!empty categoryList}">
    <div class="table-responsive">
    <table class="table table-striped table-bordered w3-blue">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
         <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categoryList}" var="cat">
        <tr>
            <td>${cat.categoryId}</td>
            <td>${cat.categoryName}</td>
            <td>${cat.categoryDescription}</td>
            <td><a href="<c:url value='/editCategory/${cat.categoryId}'/>" >Edit</a></td>
            <td><a href="<c:url value='/deleteCategory/${cat.categoryId}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    <tbody>
    </table>
 </div>
</c:if></div>
<div class="col-xs-1"></div>
</div>
</c:if>
</body>
</html>