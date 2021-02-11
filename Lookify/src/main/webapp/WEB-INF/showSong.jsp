<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page isErrorPage="true" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Song Detail Page</title>
</head>
<body>

		
			<a href="/dashboard">Dashboard</a> 
			
	<div>
		<h1>Title : ${ song.title }</h1>
	
	</div>
	
	<div>
		<h3> Artist : ${ song.artist }</h3>
	</div>
	
	<div>
		<h3> Rating(1-10) : ${ song.rating }</h3>
	</div>
	
	<a href="/songs/delete/${song.id}">Delete</a>
	
	
	
	
</body>
</html>