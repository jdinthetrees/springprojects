<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
</head>
<body>

		<div>
			<h1><a href="/categories/new">Categories</a> | <a href="/products/new">Add New Product</a></h1>
		</div>
	<div>
		<h1>${ product.name }</h1>
	
	</div>
	
	<h3>Categories</h3>
	 <ul>
		<c:forEach items="${ allCategories }" var="category">
			<li>${ category.name }</li>	
		</c:forEach>
		</ul>
	
	<h3>Add Category</h3>
		<form method="post" action="/products/${product.id}">
		<select name="addCatToProd">
		<c:forEach items="${ categories }" var="category">
		        <option value="${ category.id }">${ category.name }</option>
		</c:forEach> 
		</select>
		<button>Add Category</button>
		</form>
	
	<a href="/">Home</a>
</body>
</html>