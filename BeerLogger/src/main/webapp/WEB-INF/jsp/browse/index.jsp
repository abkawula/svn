<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="style" items="${styles}">

<a href="showBeer?style=${style}">${style.name}</a><br/>
</c:forEach>