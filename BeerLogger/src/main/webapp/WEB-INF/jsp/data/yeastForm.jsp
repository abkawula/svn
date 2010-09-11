<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>${yeast.name }</h1>
	<table>
		<tr>
			<td>Style:</td>
			<td>${yeast.style }</td>	
		</tr>
		<tr>
			<td>Lab:</td>
			<td>${yeast.lab }</td>
		</tr>
		<tr>
			<td>Floculation:</td>
			<td>${yeast.floculation }</td>
		</tr>
		<tr>
			<td>Attenuation:</td>
			<td>${yeast.attenuation }</td>
		</tr>
		<tr>
			<td>Fermentation temperature:</td>
			<td>${yeast.temp }</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>${yeast.description }</td>
		</tr>
		<tr>
			<td>Used in the following recipes:</td>
			<td>
				<c:forEach var="yeastIngredient" items="${yeast.yeastIngredients}">
					<a href="<c:url value="/spring/browse/showRecipe?id=${yeastIngredient.recipe.id }"/>">${yeastIngredient.recipe.name }</a><br />
				</c:forEach>
			</td>
		</tr>
	</table>