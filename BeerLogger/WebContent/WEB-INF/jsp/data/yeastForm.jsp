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
	<p>Name: <form:input path="name"/></p>
	<p>Brand: <form:input path="brand"/></p>
	
	<input type="submit" />
	
</form:form>