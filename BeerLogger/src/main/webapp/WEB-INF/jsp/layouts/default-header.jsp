<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 id="logo"><a href="<c:url value="/"/>"><img src="<c:url value="/resources/images/beer_logo.gif"/>" alt="Spring Travel" /></a></h1>	

	<ul id="menu">		
		<li><a href="#">My Recipes</a></li>
		<li><a href="#">Recipe</a>
			<ul id="recipes">
	            <li><a href="#">Add Recipes</a></li>
	            <li><a href="#">Most Popular</a></li>	            
	        </ul> 
		</li>
		
		<li><a href="#">Ingredient</a>
			<ul id="ingedients">
	            <li><a href="#">Add Barley</a></li>
	            <li><a href="#">Add Hops</a></li>
	            <li><a href="#">Add xxxx</a></li>
	        </ul> 
		</li>
		
		<li class="searchContainer">
	        <div>
		        <input type="text" id="searchField" />
		        <!-- <img src="magnifier.png" alt="Search" onclick="alert('You clicked on search button')" />  -->
	        </div>
	        <ul id="search">
	            <li><input id="cbxAll" type="checkbox" />All</li>
	            <li><input id="Articles" type="checkbox" />Search Reipces</li>
	            <li><input id="Tutorials" type="checkbox" />Search Ingredents</li>
	            <li><input id="Reviews" type="checkbox" />Search People</li>
	            <li><input id="Resources" type="checkbox" />Resources</li>
	        </ul>
    	</li> 
	</ul>
