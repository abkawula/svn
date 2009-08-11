<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form modelAttribute="yeast" action="processYeast" method="post">
	<span class="errors">
		<form:errors path="*" />
	</span>
	

	<c:if test="${yeast.id > 0}">
		<h1>Edit Yeast Information</h1>
	</c:if>
	
	<c:if test="${yeast.id == 0}">
		<h1> New Yeast</h1>
	</c:if>
	
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>Name: </td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Brand: </td>
			<td><form:input path="brand"/></td>
		</tr>
	</table>
	
	<input type="submit" />
	
</form:form>