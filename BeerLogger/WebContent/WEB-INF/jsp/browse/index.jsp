<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="style" items="${styles}">

${style.name}<br/>
</c:forEach>