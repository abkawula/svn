<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Racks</h3>
    <c:forEach items="${model.nineBallRacks}" var="prod">
    	<table>
    		<tr><td><c:out value="${prod.player1Score}"/></td></tr>
      		<tr><td><c:out value="${prod.innings}"/></td></tr>
      		<tr><td><c:out value="${prod.deadBalls}"/></td></tr>
      		<tr><td><c:out value="${prod.player2Score}"/></td></tr>
      	</table>
    </c:forEach>
    <br>
    <a href="<c:url value="priceincrease.htm"/>">Increase Prices</a>
    <br>
  </body>
</html>