<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter</title>
</head>
<body>

<h3>You have visited the home page <c:out value="${count}"/> times </h3>

<a href="/">Test another visit?</a>
<a href="/clear">Clear the count</a>

</body>
</html>