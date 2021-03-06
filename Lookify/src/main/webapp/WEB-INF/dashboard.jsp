<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page isErrorPage="true" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard all songs</title>
</head>
<body>




<a href="/songs/new">add a new song</a>

<a href="/topTen">Top Ten Songs</a>


<form action="/searchArtist">

<input name="search" type="text" />
<input type="submit" value="search" />

</form>

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
        <c:forEach items="${allSongs}" var="song">
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