<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:forEach var="hop" items="${hops }">
	<a href="../data/hop.jsp?id=${hop.id }">${hop.name }</a><br />
</c:forEach>