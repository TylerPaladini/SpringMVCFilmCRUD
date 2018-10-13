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


	<c:choose>
		<c:when test="${ not empty film }">

			<c:forEach items="${film}" var="filmItem">

${filmItem} <br>

				<form action="deleteFilm.do" method="GET">

					<input type="hidden" name="filmId" value="${filmItem.id }" /> <input
						type="Submit" value="Delete Film" />


				</form>

			</c:forEach>

		</c:when>
		<c:otherwise>
			<h2>No film found</h2>
			<h3><a href="index.do">Return Home</a></h3>
			
		</c:otherwise>


	</c:choose>

</body>
</html>