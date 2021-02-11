<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>results page</title>
   
    <link rel="stylesheet" href="css/style.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Abel&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="wrapper2">
      <h1>results page</h1>
      <p>My name is <c:out value="${name}"/>.</p>
      <p>My location is <c:out value="${location}"/>.</p>
      <p>My favorite language is <c:out value="${language}"/></p>
      <p class="comment"><c:out value="${message}"/></p>
      <form action="/" class="goback">
        <input type="submit" value="Go back" />
      </form>
    </div>
    <a href="/">Go Back</a>
  </body>
</html>