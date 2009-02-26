<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form modelAttribute="hop" action="processHop" method="post">
	<span class="errors">
		<form:errors path="*" />
	</span>
	

	<c:if test="${hop.id > 0}">
		<h1>Edit Hop Information</h1>
	</c:if>
	
	<c:if test="${hop.id == 0}">
		<h1> New Hop</h1>
	</c:if>
 
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>Name: </td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Country: </td>
			<td><form:input path="country"/></td>
		</tr>
		<tr>
			<td>Application: </td>
			<td><form:textarea path="application"/></td>
		</tr>
		<tr>
			<td>Aroma / Bitter: </td>
			<td><form:textarea path="aroma_bitter"/></td>
		</tr>
		<tr>
			<td>Average Alpha: </td>
			<td><form:input path="alpha" /></td>
		</tr>
		<tr>
			<td><p>Storage: </td>
			<td><form:input path="storage" /></td>
		</tr>
		<tr>
			<td>Description: </td>
			<td><form:textarea path="description"/></td>
		</tr>
	</table>
	<input type="submit" />
	
</form:form>

