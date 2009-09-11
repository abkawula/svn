<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1>${hop.name }</h1>
<table>
	<tr>
		<td>Description:</td>
		<td>${spiceHop.description }</td>	
	</tr>
	
	<tr>
		<td>Use in the following recipes</td>
		<td>
			<c:forEach var="spiceHopIngredient" items="${spiceHop.spiceHopIngredients}">
				<a href="<c:url value="/spring/browse/showRecipe?id=${spiceHopIngredient.recipe.id }"/>">${spiceHopIngredient.recipe.name }</a><br />
			</c:forEach>
		</td>
	</tr>
</table>
