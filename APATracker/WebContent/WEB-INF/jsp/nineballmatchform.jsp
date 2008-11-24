<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Nine Ball Match</title>
<style>
    .error { color: red; }
  </style> 
</head>
<body>

	<form:form method="post" commandName="nineballmatchform">
		<table>
			<tr>
				<td><form:input path="player1Id"/><br />
					<br />
					<form:input path="player2Id"/>
					<br />
				</td>
				<td>Score <br />
					Innings <br />
					Dead Balls <br />
					Score <br />
				</td>
				
				<td>
					<form:input path="rack1player1Score"/> <br />
					<form:input path="rack1player1Innings"/> <br />
					<form:input path="rack1player1DeadBalls"/> <br />
					<form:input path="rack1player2Score"/> <br />
				</td>
				
				<td>
					<form:input path="rack2player1Score"/> <br />
					<form:input path="rack2player1Innings"/> <br />
					<form:input path="rack2player1DeadBalls"/> <br />
					<form:input path="rack2player2Score"/> <br />
				</td>
				<td>
					<form:input path="rack3player1Score"/> <br />
					<form:input path="rack3player1Innings"/> <br />
					<form:input path="rack3player1DeadBalls"/> <br />
					<form:input path="rack3player2Score"/> <br />
				</td>
				<td>
					<form:input path="rack4player1Score"/> <br />
					<form:input path="rack4player1Innings"/> <br />
					<form:input path="rack4player1DeadBalls"/> <br />
					<form:input path="rack4player2Score"/> <br />
				</td>
				
				
			</tr>
		</table>
	</form:form>

</body>
</html>