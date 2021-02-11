<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<div>
			<h1><a href="/categories/new">Categories</a> | <a href="/products/new">Add New Product</a></h1>
		</div>
	<div>
		<h1>${ category.name }</h1>
	
	</div>
	
	<h3>Products</h3>
	 <ul>
		<c:forEach items="${ allProducts }" var="product">
			<li>${ product.name }</li>	
		</c:forEach>
		</ul>
	
	<h3>Add Product</h3>
		<form method="post" action="/categories/${category.id}">
		<select name="addProductToCategory">
		<c:forEach items="${ products }" var="product">
		        <option value="${ product.id }">${ product.name }</option>
		</c:forEach> 
		</select>
		<button>Add product</button>
		</form>
	
	<a href="/">Home</a>
</body>
</html>