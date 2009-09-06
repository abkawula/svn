<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="additive" items="${additives }">
	<a href="<c:url value="/spring/data/additive?id=${additive.id }"/> ">${additive.name }</a><br />
</c:forEach>