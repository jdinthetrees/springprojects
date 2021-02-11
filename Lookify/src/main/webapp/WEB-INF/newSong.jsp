<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page isErrorPage="true" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify Dashboard</title>
</head>
<body>

		<div>
			<h1><a href="/dashboard">Dashboard</a></h1>
		</div>

	<h1>new song</h1>
	
	
	
	<form:form action="/createSong" method="POST" modelAttribute="song">
		<div>
			<p>Title:</p>
			<form:label path="title"></form:label>
			<form:errors path="title"></form:errors>
			<form:input path="title"></form:input>
		</div>
		<div>
			<p>Artist:</p>
			<form:label path="artist"></form:label>
			<form:errors path="artist"></form:errors>
			<form:input path="artist"></form:input>
		</div>
		<div>
			<p>rating:</p>
			<form:label path="rating"></form:label>
			<form:errors path="rating"></form:errors>
			<form:input type="number" path="rating" min="1" max="10"></form:input>
		</div>
			
			<p>
			<input type="submit" value="Add Song">
			</p>
	
	</form:form>

<a href="/">Home</a>

</body>
</html>