<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="hop" items="${hops }">
	<a href="<c:url value="/spring/data/hop?id=${hop.id }"/> ">${hop.name }</a><br />
</c:forEach>