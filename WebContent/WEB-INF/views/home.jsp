<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVCFilmSite</title>
</head>
<body>

<form action="GetFilm.do" method="GET">
	  	<h3>Search By Film ID</h3><br>
	  	ID:
		<input type="text" name="FilmId" size="4"/> 
		<input type="submit" value="Search" />
		
		${film}
	</form>



</body>
</html>