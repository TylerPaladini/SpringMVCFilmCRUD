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
<form action="updateFilm.do" method="GET">

					<input type="hidden" name="filmId" value="${filmItem.id }" /> 
					<input type="text" name="filmTitle" value="${filmItem.title }" /> 
					<input type="text" name="filmDescription" value="${filmItem.description }" /> 
					<input type="text" name="filmYear" value="${filmItem.releaseYear }" /> 
					<input type="text" name="filmLanguage" value="${filmItem.language_id }" /> 
					<input type="text" name="filmrentalDuration" value="${filmItem.rentalDuration }" /> 
					<input type="text" name="filmRentalRate" value="${filmItem.rentalRate }" /> 
					<input type="text" name="filmLength" value="${filmItem.length}" /> 
					<input type="text" name="filmReplacementCost" value="${filmItem.replacementCost}" /> 
					<input type="text" name="filmRating value="${filmItem.rating}" /> 
					<input type="text" name="filmSF" value="${filmItem.specialFeature}" /> 
					
					<input type="Submit" value="Update Film" />


				</form>

				<form action="deleteFilm.do" method="GET">

					<input type="hidden" name="filmId" value="${filmItem.id }" /> 
					<input type="Submit" value="Delete Film" />


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