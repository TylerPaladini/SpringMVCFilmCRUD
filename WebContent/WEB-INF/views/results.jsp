<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="icon" href="WebContent/favicon.ico">

<title>MVCFilmSite</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


<!-- Local CSS -->
<link rel="stylesheet" href="WebContent/style.css ">

</head>
<body>

<div class="container">

		<div class="py-5 text-center">
			<img class="d-block mx-auto mb-4" src="" alt="" width="72"
				height="72">
			<h2>Results</h2>
			<p>
			<form action="index.do" method="GET">
				<input type="Submit" value="Return Home" class="btn btn-primary btn-lg"/>
			</form>
			</p>
		</div>

		<c:choose>
				<c:when test="${ not empty film }">
				<div class="row">
					<div class="col-xs-6">
						<div>
						test
				
					<p>
						<h3>Film</h3>
					</p>
					<table>
					<c:forEach items="${film}" var="filmItem">
					<tr>
					<td>Film ID: </td>
					<td><c:out value="${filmItem.id }"/></td>
					<tr>
					<td>Title: </td>
					<td><c:out value="${filmItem.title }"/></td>
					</tr>
					<tr>
					<td>Description: </td>
					<td><c:out value="${filmItem.description }"/></td>
					</tr>
					<tr>
					<td>Year: </td>
					<td><c:out value="${filmItem.releaseYear }"/></td>
					</tr>
					<tr>
					<td>Language: </td>
					<td><c:out value="${filmItem.language_id }"/></td>
					</tr>
					</table>
					</td>
						</div>
					</div>
					<div class="col-xs-6">
						<div>
						test
					
					<td>
					<p>
						<h3>Update Film</h3>
					</p>
					<p>
					<table>
					<tr>
						<form action="updateFilm.do" method="GET">
						
							<input type="hidden" name="filmId" value="${filmItem.id }" /> <br>
					<td>
							<label for="title">Title</label>
					</td>
					<td>
							<input id="title" type="text" name="filmTitle" value="${filmItem.title }" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="desc">Description</label>
					</td>
					<td>
							<input id="desc" type="text" name="filmDescription" value="${filmItem.description }" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="year">Year</label>
					</td>
					<td>
							<input id="year" type="text" name="filmYear" value="${filmItem.releaseYear }" />
					</td>
					</tr>
					<tr>
					<td>
					
							<label for="lang">Language</label>
					</td>
					<td>
							<input id="lang" type="text" name="filmLanguage" value="${filmItem.language_id }" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="dura">Duration</label>
					</td>
					<td>
							<input id="dura" type="text" name="filmrentalDuration" value="${filmItem.rentalDuration }" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="rate">Rate</label>
					</td>
					<td>
							<input id="rate" type="text" name="filmRentalRate" value="${filmItem.rentalRate }" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="length">Length</label>
					</td>
					<td>
							<input id="length" type="text" name="filmLength" value="${filmItem.length}" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="replace">Replacement Cost</label>
					</td>
					<td>
							<input id="replace" type="text" name="filmReplacementCost" value="${filmItem.replacementCost}" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="rating">Rating</label>
					</td>
					<td>
							<input id="rating" type="text" name="filmRating value=" ${filmItem.rating}" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="sf">Special Features</label>
					</td>
					<td>
							<input id="sf" type="text" name="filmSF" value="${filmItem.specialFeature}" /> <br>
						
					</tr>
					</table>
								<p>
								<input type="Submit" value="Update Film" />
								</p>
						</form>
					</p>
					<p>
						<form action="deleteFilm.do" method="GET">
							<input type="hidden" name="filmId" value="${filmItem.id }" /> 
							<input type="Submit" value="Delete Film" />
						</form>
						</p>
						</div>
					</div>
				</div>
				
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h2>No film found</h2>
				</c:otherwise>
			</c:choose>

</div>
	<!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/agency.min.js"></script>

</body>
</html>