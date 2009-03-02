<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form modelAttribute="additive" action="processAdditive" method="post">
	<span class="errors">
		<form:errors path="*" />
	</span>
	

	<c:if test="${additive.id > 0}">
		<h1>Edit Additive Information</h1>
	</c:if>
	
	<c:if test="${additive.id == 0}">
		<h1> New Additive</h1>
	</c:if>
	
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>Name: </td>
			<td><form:input path="name"/></td>
		</tr>
		
		<tr>
			<td>Gravity: </td>
			<td><form:input path="gravity"/></td>
		</tr>
	</table>
	<input type="submit" />
	
</form:form>