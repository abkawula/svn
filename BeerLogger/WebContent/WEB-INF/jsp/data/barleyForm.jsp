<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form modelAttribute="barley" action="processBarley" method="post">
	<span class="errors">
		<form:errors path="*" />
	</span>
	

	<c:if test="${barley.id > 0}">
		<h1>Edit Barley Information</h1>
	</c:if>
	
	<c:if test="${barley.id == 0}">
		<h1> New Barley</h1>
	</c:if>
	
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>Name: </td>
			<td><form:input path="variety"/></td>
		</tr>
	</table>
	<input type="submit" />
	
</form:form>