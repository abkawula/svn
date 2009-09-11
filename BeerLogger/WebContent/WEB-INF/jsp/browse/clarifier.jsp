<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="clarifier" items="${clarifiers }">
	<a href="<c:url value="/spring/data/clarifier?id=${clarifier.id }"/> ">${clarifier.name }</a><br />
</c:forEach>