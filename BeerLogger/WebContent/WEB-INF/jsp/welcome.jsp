<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Beer Logger</title>
</head>
<body>
<h1> Welcome to the Beer Logger</h1>
<h3> What would you like to do</h3>
<ul>
	<li><a href="browse/showCategories">Browse by category</a></li>
	<%--<li><a href="#">Browse by popularity</a> </li> --%>
	<%--<li><a href="#">Search for recipe by ingredients</a></li> --%>
	<br/>
	<br/>
	<li><a href="browse/hop">Browse hops</a> </li>
	<li><a href="browse/barley">Browse barlies</a> </li>
	<li><a href="browse/yeast">Browse yeasts</a> </li>
	<li><a href="browse/additive">Browse additives</a> </li>
	<li><a href="browse/flavoring">Browse flavorings</a> </li>
	<br/>
	<br/>
	<li><a href="data/recipe">Add a new recipe</a> </li>
</ul>
</body>
</html>