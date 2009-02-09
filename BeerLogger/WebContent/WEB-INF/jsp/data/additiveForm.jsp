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
	<p>Name: <form:input path="name"/></p>
	
	<input type="submit" />
	
</form:form>