<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:forEach var="recipe" items="${recipeList}">
<a href="showRecipe?id=${recipe.id }">${recipe.name}</a><br>

</c:forEach>