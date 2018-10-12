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

	<form action="GetFilm.do" method="GET">
	  	<h4>Search By Film ID</h4><br>
	  	ID number:
		<input type="text" name="FilmId" size="4"/> 
		<input type="submit" value="Search" />
		
		<h4>Search Film by Keyword</h4>
		Keyword:
		<input>type="text" name="keyword"/>
		<input>type="submit" value="Search/>
		
	 ${film}
		
	</form>
		
		
		
	



</body>
</html>