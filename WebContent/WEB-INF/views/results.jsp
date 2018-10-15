<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="icon" href="favicon.ico">

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

		<div class="col-md-8 order-md-1">

			<c:choose>
				<c:when test="${ not empty film }">




					<c:forEach items="${film}" var="filmItem">
						<table>
							<tr>
								<td><h3>Title:</h3></td>
								<td><h3>
										<c:out value="${filmItem.title }" />
									</h3></td>
							</tr>
							<tr>
								<td>Film ID:</td>
								<td><c:out value="${filmItem.id }" /></td>
								<tr>
					<td>Description: </td>
					<td><c:out value="${filmItem.description }" /></td>
					</tr>
					<tr>
					<td>Year: </td>
					<td><c:out value="${filmItem.releaseYear }" /></td>
					</tr>
					<tr>
					<td>Language: </td>
					<td><c:out value="${filmItem.language_id }" /></td>
					</tr>
					<tr>
					<td>Duration: </td>
					<td><c:out value="${filmItem.rentalDuration }" /></td>
					</tr>
					<tr>
					<td>Rental Rate: </td>
					<td><c:out value="${filmItem.rentalRate }" /></td>
					</tr>
					<tr>
					<td>Length: </td>
					<td><c:out value="${filmItem.length }" /></td>
					</tr>
					<tr>
					<td>Replacement Cost: </td>
					<td><c:out value="${filmItem.replacementCost }" /></td>
					</tr>
					<tr>
					<td>Rating: </td>
					<td><c:out value="${filmItem.rating }" /></td>
					</tr>
					<tr>
					<td>Special Features: </td>
					<td><c:out value="${filmItem.specialFeature }" /></td>
					</tr>
					</table>
					
					<br>
					<br>
					
						<h5>Change This Film</h5>
					
					<table>
					<tr>
						<form action="updateFilm.do" method="GET">
						
							<input type="hidden" name="filmId" value="${filmItem.id }" /> <br>
					<td>
							<label for="title">Title</label>
					</td>
					<td>
							<input id="title" type="text" name="filmTitle"
										value="${filmItem.title }" class="form-control" />
					</td>
					
							</tr>
					<tr>
					<td>
							<label for="desc">Description</label>
					</td>
					<td>
							<input id="desc" type="text" name="filmDescription"
									value="${filmItem.description }" class="form-control" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="year">Year</label>
					</td>
					<td>
							<input id="year" type="text" name="filmYear"
									value="${filmItem.releaseYear }" class="form-control" />
					</td>
					</tr>
					<tr>
					<td>
					
							<label for="lang">Language</label>
					</td>
					<td>
							<input id="lang" type="text" name="filmLanguage"
									value="${filmItem.language_id }" class="form-control" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="dura">Duration</label>
					</td>
					<td>
							<input id="dura" type="text" name="filmrentalDuration"
									value="${filmItem.rentalDuration }" class="form-control" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="rate">Rental Rate</label>
					</td>
					<td>
							<input id="rate" type="text" name="filmRentalRate"
									value="${filmItem.rentalRate }" class="form-control" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="length">Length</label>
					</td>
					<td>
							<input id="length" type="text" name="filmLength"
									value="${filmItem.length}" class="form-control" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="replace">Replacement Cost</label>
					</td>
					<td>
							<input id="replace" type="text" name="filmReplacementCost"
									value="${filmItem.replacementCost}" class="form-control" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="rating">Rating</label>
					</td>
					<td>
							<input id="rating" type="text" name="filmRating"
									value="${filmItem.rating}" class="form-control" />
					</td>
					</tr>
					<tr>
					<td>
							<label for="sf">Special Features</label>
					</td>
					<td>
							<input id="sf" type="text" name="filmSF"
									value="${filmItem.specialFeature}" class="form-control" /> <br>
						
					
							</tr>
					</table>
					<br>
								<p>
								<input type="Submit" value="Update Film"
								class="btn btn-success btn-lg" />
								</p>
						</form>
					</p>
					<p>
						
						<form action="deleteFilm.do" method="GET">
							<input type="hidden" name="filmId" value="${filmItem.id }" /> 
							<input type="Submit" value="Delete Film"
								class="btn btn-danger btn-lg" />
						</form>
						</p>
						<hr>
				
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h2>No film found</h2>
				</c:otherwise>
			</c:choose>
			
</div>

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