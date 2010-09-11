<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="flavoring" items="${flavorings }">
	<a href="<c:url value="/spring/data/flavoring?id=${flavoring.id }"/> ">${flavoring.name }</a><br />
</c:forEach>