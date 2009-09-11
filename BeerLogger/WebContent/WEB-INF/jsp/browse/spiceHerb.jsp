<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="spiceHerb" items="${spiceHerbs }">
	<a href="<c:url value="/spring/data/spiceHerb?id=${spiceHerb.id }"/> ">${spiceHerb.name }</a><br />
</c:forEach>