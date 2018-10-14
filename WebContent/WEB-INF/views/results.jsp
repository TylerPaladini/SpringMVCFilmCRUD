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
<link rel="stylesheet" href="WebContent/WEB-INF/views/style.css ">

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
<div class="row">
  <div class="column">
  Column One
  </div>
  <div class="column">
  Column Two
  </div>
</div>

		<c:choose>
				<c:when test="${ not empty film }">
					<c:forEach items="${film}" var="filmItem">
					<p>
						${filmItem}
					</p>
					<p>
						<form action="updateFilm.do" method="GET">
						<p>
							<input type="hidden" name="filmId" value="${filmItem.id }" /> <br>
							<input type="text" name="filmTitle" value="${filmItem.title }" />
							<br> <input type="text" name="filmDescription"
								value="${filmItem.description }" /> <br> <input
								type="text" name="filmYear" value="${filmItem.releaseYear }" />
							<br> <input type="text" name="filmLanguage"
								value="${filmItem.language_id }" /> <br> <input
								type="text" name="filmrentalDuration"
								value="${filmItem.rentalDuration }" /> <br> <input
								type="text" name="filmRentalRate"
								value="${filmItem.rentalRate }" /> <br> <input type="text"
								name="filmLength" value="${filmItem.length}" /> <br> <input
								type="text" name="filmReplacementCost"
								value="${filmItem.replacementCost}" /> <br> <input
								type="text" name="filmRating value=" ${filmItem.rating}" /> <br>
							<input type="text" name="filmSF"
								value="${filmItem.specialFeature}" /> <br> 
						</p>
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