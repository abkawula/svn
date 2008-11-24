<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nine Ball Matches</title>
</head>
<body>
	<h3> Nine Ball Matches </h3>
	<c:forEach items="${model.nineBallMatches}" var="match">
		<table>
			<tr>
				<td>Player 1<br />
					<br />
					Player 2
					<br />
				</td>
				<td>Score <br />
					Innings <br />
					Dead Balls <br />
					Score <br />
				</td>
				<c:forEach items="${match.nineBallRacks}" var="rack">
					<td>
						<c:out value="${rack.player1Score}" /><br />
						<c:out value="${rack.innings}" /><br />
						<c:out value="${rack.deadBalls}" /><br />
						<c:out value="${rack.player2Score}" /><br />
					</td>
				</c:forEach>
			</tr>
		</table>
	</c:forEach>

<!-- 
	<c:forEach items="${model.nineBallMatches}" var="match">
		<c:out value="${match.player1Id}" />
	</c:forEach>
 -->

</body>
</html>


<!--

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Products</h3>
    <c:forEach items="${model.products}" var="prod">
      <c:out value="${prod.description}"/> <i>$<c:out value="${prod.price}"/></i><br><br>
    </c:forEach>
    <br>
    <a href="<c:url value="priceincrease.htm"/>">Increase Prices</a>
    <br>
  </body>
</html>

 -->