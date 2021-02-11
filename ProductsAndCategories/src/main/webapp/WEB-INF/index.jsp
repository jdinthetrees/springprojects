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
	<div class="container">
		<div>
			<h1><a href="/categories/new">Add Categories</a> | <a href="/products/new">Add New Product</a></h1>
		</div>
		
		<h2>All Products</h2>
		
		<ul>
		<c:forEach items="${ products }" var="product">
			<li><a href="/products/${ product.id }">${ product.name }</a></li>		
		</c:forEach>
		</ul>
		
	</div>
	
	<div>
		
		<h2>All Categories</h2>
		
		<ul>
		<c:forEach items="${ categories }" var="category">
			<li><a href="/categories/${ category.id }">${ category.name }</a></li>		
		</c:forEach>
		</ul>
		
	</div>
</body>
</html>