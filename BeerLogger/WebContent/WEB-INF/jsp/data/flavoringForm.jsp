<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form modelAttribute="flavoring" action="processFlavoring" method="post">
	<span class="errors">
		<form:errors path="*" />
	</span>
	

	<c:if test="${flavoring.id > 0}">
		<h1>Edit Flavoring Information</h1>
	</c:if>
	
	<c:if test="${flavoring.id == 0}">
		<h1> New Flavoring</h1>
	</c:if>
	
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>Name: <form:input path="name"/></td>
		</tr>
	</table>
	<input type="submit" />
	
</form:form>