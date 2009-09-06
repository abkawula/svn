<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>${addive.name }</h1>
	<table>
		
		<tr>
			<td>Gravity: </td>
			<td>${additive.gravity }</td>
		</tr>
		
		<tr>
			<td>Color: </td>
			<td>${additive.color }</td>
		</tr>
		
		<tr>
			<td>Comment: </td>
			<td>${additive.comment }</td>
		</tr>
		
		<tr>
			<td>Used in the following recipes:</td>
			<td>
				<c:forEach var="additiveIngredient" items="${additive.additiveIngredients}">
					<a href="<c:url value="/spring/browse/showRecipe?id=${additiveIngredient.recipe.id }"/>" >${additiveIngredient.recipe.name }</a><br />
				</c:forEach>
			</td>
		</tr>
	</table>