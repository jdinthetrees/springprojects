<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page isErrorPage="true" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




<a href="/songs/new">add a new song</a>

<a href="/dashboard">Dashboard</a>


<form action="/searchArtist">

<input name="search" type="text" />
<input type="submit" value="search" />

</form>

<%-- <h1>songs by <c:out value="${search}"/> </h1> --%>
<h1>These are the Top Ten Songs</h1>
<table>
    <thead>
        <tr>
            <th>Song</th>
            <th>Artist</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            
            <td><a href="/songs/${ song.id }">${ song.title }</a></td>
            <td><c:out value="${song.artist}"/></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/songs/delete/${song.id}">Delete</a></td>
			
        </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>