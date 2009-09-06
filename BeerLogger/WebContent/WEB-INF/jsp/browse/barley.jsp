<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="barley" items="${barlies }">
	<a href="<c:url value="/spring/data/barley?id=${barley.id }"/> ">${barley.variety }</a><br />
</c:forEach>