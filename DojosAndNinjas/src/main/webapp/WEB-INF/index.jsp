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
	<h1>Hello World!</h1>
	
	<a href="/createDojo">create a new dojo!</a> | <a href="/createNinja">create a new Ninja!</a>
	
	<hr>
	
	<c:forEach items="${dojos}" var="dojo">
		<h3><c:out value="${dojo.name}"></c:out></h3>
		<p><c:out value="${dojo.getNinjas().size()}"/> ninjas</p>
		<c:forEach items="${dojo.ninjas}"  var="i">
			<p><c:out value="${i.firstName}"></c:out></p>
		</c:forEach>
		<hr />
	</c:forEach>

</body>
</html>