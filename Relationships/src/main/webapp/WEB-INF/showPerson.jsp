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
		<h1>${ person.firstName } ${ person.lastName }</h1>
		<p><strong>License Number</strong> ${ person.license.number }</p>
		<p><strong>Expiration Date</strong> ${ person.license.getExpirationDate() }</p>
	</div>
</body>
</html>