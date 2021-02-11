<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
<link rel="stylesheet" href="css/styles.css" />
</head>


<body>
<div>

<form action="/process" method="POST">

	<p><c:out value="${ error }"/></p>
	<label for="code">What is the code?</label><br>
	<input type="text" name="code" id="code" placeholder="leave your code here"><br>
	<button type="submit">Try Code</button>

</form>

</div>

</body>
</html>