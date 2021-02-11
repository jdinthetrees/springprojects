<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driver's License</title>
</head>
<body>
	<h1>Information</h1>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>License #</th>
				<th>State</th>
				<th>Expiration Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${persons}" var = "person">
				<tr>
					<td><c:out value = "${person.getFirstName()}"/></td>
					<td><c:out value = "${person.getLastName()}"/></td>
					<td><c:out value = "${person.getLicense().getNumber()}"/></td>
					<td><c:out value = "${person.getLicense().getState()}"/></td>
					<td><c:out value = "${person.getLicense().getExpirationDate()}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>