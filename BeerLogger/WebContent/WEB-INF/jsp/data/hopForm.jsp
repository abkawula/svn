<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1>${hop.name }</h1>
<table>
	<tr>
		<td>Average alpha:</td>
		<td>${hop.alpha}</td>	
	</tr>
	
	<tr>
		<td>Description:</td>
		<td>${hop.description }</td>	
	</tr>
	
	<tr>
		<td>Possible Substitutions:</td>
		<td>
			<c:forEach var="sub" items="${hop.substitutions}">
				<a href="hop.jsp?id=${sub.id }">${sub.name }</a><br />
			</c:forEach>
		</td>	
	</tr>
	<tr>
		<td>Use in the following recipes</td>
		<td>
			<c:forEach var="hopIngredient" items="${hop.hopIngredients}">
				<a href="../browse/showRecipe?id=${hopIngredient.recipe.id }">${hopIngredient.recipe.name }</a><br />
			</c:forEach>
		</td>
	</tr>
</table>
