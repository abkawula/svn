<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1>${spiceHerb.name }</h1>
<table>
	<tr>
		<td>Description:</td>
		<td>${spiceHerb.description }</td>	
	</tr>
	
	<tr>
		<td>Use in the following recipes</td>
		<td>
			<c:forEach var="spiceHerbIngredient" items="${spiceHerb.spiceHerbIngredients}">
				<a href="<c:url value="/spring/browse/showRecipe?id=${spiceHerbIngredient.recipe.id }"/>">${spiceHerbIngredient.recipe.name }</a><br />
			</c:forEach>
		</td>
	</tr>
</table>
