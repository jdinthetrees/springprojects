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

	<h1>create a dojo!</h1>
	
	<form:form action="createDojo" method="POST" modelAttribute="dojo">
		<div>
			<p>Name:</p>
			<form:label path="name"></form:label>
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
			</div>
			
			<p>
			<input type="submit" value="Create a dojo!">
			</p>
	
	</form:form>


</body>
</html>