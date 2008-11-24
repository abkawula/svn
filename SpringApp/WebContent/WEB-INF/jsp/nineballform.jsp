<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>New nine ball rack</title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1>New nine ball rack</h1>
<form:form method="post" commandName="nineBallForm">
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">Player 1 score</td>
      <td width="20%"><form:input path="player1Score"/></td>
     </tr><tr>
      <tr>
      <td align="right" width="20%">Innings</td>
      <td width="20%"><form:input path="innings"/></td>
     </tr><tr>
     <tr>
      <td align="right" width="20%">Dead Balls</td>
      <td width="20%"><form:input path="deadBalls"/></td>
     </tr><tr>
     <tr>
      <td align="right" width="20%">Player 2 score</td>
      <td width="20%"><form:input path="player2Score"/></td>
     </tr>
  </table>
  <br>
  <input type="submit" align="center" value="Execute">
</form:form>
<a href="<c:url value="hello.htm"/>">Home</a>
</body>
</html>