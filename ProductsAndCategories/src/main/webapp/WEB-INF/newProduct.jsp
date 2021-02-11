<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>

		<div>
			<h1><a href="/categories/new">Categories</a> | <a href="/products/new">Add New Product</a></h1>
		</div>

	<h1>new product</h1>
	
	<form:form action="/products" method="POST" modelAttribute="product">
		<div>
			<p>Name:</p>
			<form:label path="name"></form:label>
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</div>
		<div>
			<p>Description:</p>
			<form:label path="description"></form:label>
			<form:errors path="description"></form:errors>
			<form:input path="description"></form:input>
		</div>
		<div>
			<p>Price:</p>
			<form:label path="price"></form:label>
			<form:errors path="price"></form:errors>
			<form:input path="price"></form:input>
		</div>
			
			<p>
			<input type="submit" value="Create a Product!">
			</p>
	
	</form:form>

<a href="/">Home</a>

</body>
</html>