<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVCFilmSite</title>
</head>
<body>




<c:forEach items="${film}" var="filmItem">

${filmItem} <br>
</c:forEach>


		
		<form action="deleteFilm.do" method="POST">
		
		
		
		<input type="Submit" value="Delete Film"/>
		
		
		</form>

	

</body>
</html>