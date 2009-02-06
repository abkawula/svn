<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<table>
<tr><th>Name</th><th>ABV</th></tr>
<c:forEach var="recipe" items="${recipeList}">
<tr><td><a href="showRecipe?id=${recipe.id }">${recipe.name}</a></td><td><fmt:formatNumber type="number" value="${recipe.ABV }" /></td></tr>

</c:forEach>
</table>