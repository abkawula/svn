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
	<p>Name: <form:input path="name"/></p>
	<p>Country: <form:input path="country"/></p>
	<p>Application: <form:textarea path="application"/></p>
	<p>Aroma / Bitter: <form:textarea path="aroma_bitter"/></p>
	<p>Average Alpha: <form:input path="alpha" /></p>
	<p>Storage: <form:input path="storage" /></p>
	<p>Description: <form:textarea path="description"/></p>
	
	<input type="submit" />
	
</form:form>

