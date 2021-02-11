<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%-- <c:out value="${2+2}"/>
<c:out value="${dojoName}"/> --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="js/time.js"></script>
     <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>time landing page</title>
</head>
<body>

   <p class="green"> <c:out value="${time}"/></p>
    
</body>
</html>