<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<h1>${flavoring.name }</h1>
	<table>
		<tr>
			<td>Used in the following recipes:</td>
			<td>
				<c:forEach var="flavoringIngredient" items="${flavoring.flavoringIngredients}">
					<a href="<c:url value="/spring/browse/showRecipe?id=${flavoringIngredient.recipe.id }"/>" >${flavoringIngredient.recipe.name }</a><br />
				</c:forEach>
			</td>
		</tr>	
	</table>
	