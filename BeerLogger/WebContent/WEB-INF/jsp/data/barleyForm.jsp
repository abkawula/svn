<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>${barly.variety }</h1>
	<table>
		
		<tr>
			<td>Country: </td>
			<td>${barley.country }</td>
		</tr>
		
		<tr>
			<td>Gravity: (pound per gallon)</td>
			<td>${barley.gravity }</td>
		</tr>
		
		<tr>
			<td>Color (degrees Lovibond): </td>
			<td>${barley.color }</td>
		</tr>
		
		<tr>
			<td>Comment</td>
			<td>${barley.comment }</td>
		</tr>
		
		<tr>
			<td>Used in the following recipes:</td>
			<td>
				<c:forEach var="barleyIngredient" items="${barley.barleyIngredients}">
					<a href="<c:url value="/spring/browse/showRecipe?id=${barleyIngredient.recipe.id }"/>" >${barleyIngredient.recipe.name }</a><br />
				</c:forEach>
			</td>
		</tr>
	</table>