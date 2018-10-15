<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>MVCFilmSite</title>
<link rel="styleSheet" href="styleSheet.css" type="text/css">
</head>
<body>
<h1>Welcome to Crud Search</h1>

	<form action="GetFilm.do" method="GET">
	  	<h4>Search By Film ID</h4>
	  <p>	ID number: 
		<input type="text" name="FilmId" size="4"/> 
		<input type="submit" value="Search" />
		</p>
	</form>
		
	<form action="GetKeyword.do" method="GET">
		<h4>Search Film by Keyword</h4>
		<p>Keyword:
		<input type="text" name="Keyword" />
		<input type="submit" value="Search" /> 
		</p>
	</form>
	
<!-- 	<form action="AddFilm" method="POST">
		<h4>Add a Film to the List</h4>
		Film Details:
		<input type="text" name="AddFilm">
		<input type="submit" value="Add Film">
	</form> -->
	
	<form  action="newFilm.do" method="GET">
    
        <h4>Add Your Film</h4>
        <p>
            <label for="addingFilm">Film Title </label>
            <input type="text" name="Title" size="35"><br>
            
            <label for="addDescription">Film Description</label>
            <input type="text" name="Description" size="28.5" /><br>   
            
            <label for="releaseYear"> Film Year</label> 
            <input type="text" name="ReleaseYear" size="35"/><br>    
                    
            
            <label for="filmLength">Length of Film</label> 
            <input type="text" name="FilmLength" size="30"/><br>      
            
                <input type="submit">
                
                
                </p>
                </form>
            
    		
       
</body>
</html>
	
    
	
		
	 
	
		
		
		
		
		
		
	


