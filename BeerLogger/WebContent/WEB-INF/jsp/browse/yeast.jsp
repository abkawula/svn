<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="yeast" items="${yeasts }">
	<a href="<c:url value="/spring/data/yeast?id=${yeast.id }"/>">${yeast.name }</a><br />
</c:forEach>