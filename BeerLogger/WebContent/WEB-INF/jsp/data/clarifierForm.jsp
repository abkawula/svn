<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1>${clarifier.name }</h1>
<table>
	
	<tr>
		<td>Description:</td>
		<td>${clarifier.description }</td>	
	</tr>
	
	<tr>
		<td>Use in the following recipes</td>
		<td>
			<c:forEach var="clarifierIngredient" items="${clarifier.clarifierIngredients}">
				<a href="<c:url value="/spring/browse/showRecipe?id=${clarifierIngredient.recipe.id }"/>">${clarifierIngredient.recipe.name }</a><br />
			</c:forEach>
		</td>
	</tr>
</table>
