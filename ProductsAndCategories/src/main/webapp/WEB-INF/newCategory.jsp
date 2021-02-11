<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
</head>
<body>

		<div>
			<h1><a href="/categories/new">Categories</a> | <a href="/products/new">Add New Product</a></h1>
		</div>

	<h1>new category</h1>
	
	<form:form action="/categories" method="POST" modelAttribute="category">
		<div>
			<p>category:</p>
			<form:label path="name"></form:label>
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</div>
		
			
			
			<p>
			<input type="submit" value="Create a Category!">
			</p>
	
	</form:form>
	
	<a href="/">Home</a>


</body>
</html>