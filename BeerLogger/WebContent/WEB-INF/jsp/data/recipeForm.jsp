<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<form:form modelAttribute="recipeForm" action="processRecipe" method="post">
	<span class="errors">
		<form:errors path="*" />
	</span>
	
	<form:hidden path="id"/>
	<form:label path="name"> Name: </form:label> <form:input path="name"/><br>
	<form:label path="initialGravity"> Initial Gravity: </form:label><form:input path="initialGravity"/><br>
	<form:label path="finalGravity">Final Gravity: </form:label><form:input path="finalGravity"/><br>
	<form:label path="style">Style:</form:label><form:select path="style"><form:options items="${styles}" itemLabel="name"/> </form:select><br>
	<form:label path="batchSize">Batch Size (Gallons) </form:label><form:input path="batchSize"/><br>
 
 
 
 <h1> Hops </h1>
	<table>
		<tr><th>Variety</th><th>Quantity (Oz)</th><th>Pellet / Leaf</th><th>Boil Time (minutes)**</th></tr>		
 			
			<c:forEach items="${recipeForm.hops}" varStatus="hopIngredientRow">
				<tr>
					<td>
						<spring:bind path="recipeForm.hops[${hopIngredientRow.index}].id"> 
							<input type="hidden" name="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>" />
						</spring:bind>
						<spring:bind path="recipeForm.hops[${hopIngredientRow.index}].hop">						
 							<select>
 								<c:forEach items="${hops}" var="hop">
 									<option value="${hop.id}"
 									<c:if test="${hop.id == status.value.id}"> selected="selected" </c:if> > 
 										${hop.name }
 									</option>
 								</c:forEach>
 							</select>
						</spring:bind>
					</td>
					
					<td>
						<spring:bind path="recipeForm.hops[${hopIngredientRow.index}].quantity">
							<input type="text" name="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>" />
						</spring:bind>
					</td>
					
					<td>
						<spring:bind path="recipeForm.hops[${hopIngredientRow.index}].pelletLeaf">
							<select>
								<option value="P"
									<c:if test="${status.value == 'P'}">selected="selected" </c:if> >
									Pellet
								</option>
								<option value="L"
									<c:if test="${status.value == 'L'}">selected="selected" </c:if> >
									Leaf
								</option>
							</select>
						</spring:bind>
					</td>
					
					<td>
						<spring:bind path="recipeForm.hops[${hopIngredientRow.index}].boilTime">
							<input type="text" name="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>" />
						</spring:bind>
					</td>
				</tr>	
			</c:forEach>
		</tr>
	</table>
	**Enter "M" for Mash hops or "D" for Dry Hops
	
	<h1>Grains</h1>
	<table>
		<tr><th>Variety</th><th>Quantity (lbs)</th></tr>
		
		<c:forEach items="${recipeForm.barlies}" varStatus="barleyIngredientRow">
			<tr>
				<td>							
					<spring:bind path="recipeForm.barlies[${barleyIngredientRow.index}].id"> 
						<input type="hidden" name="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>" />
					</spring:bind>
					
					<spring:bind path="recipeForm.barlies[${barleyIngredientRow.index}].barley">						
							<select>
								<c:forEach items="${barlies}" var="barley">
									<option value="${barley.id}"
									<c:if test="${barley.id == status.value.id}"> selected="selected" </c:if> > 
										${barley.variety }
									</option>
								</c:forEach>
							</select>
					</spring:bind>	
				</td>
				
				<td>
					<spring:bind path="recipeForm.barlies[${barleyIngredientRow.index}].quantity">
						<input type="text" name="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>" />
					</spring:bind>
				</td>
			</tr>
		</c:forEach>	
	</table>
<%--	
	<h1>Additives</h1>
	<table>
		<tr><th>Name</th><th>Quantity (lbs)</th></tr>
		
		<tr>
			<td><form:hidden path="additive0.id"/><form:select path="additive0.additive.id"><form:option value="0" label=""> </form:option> <form:options items="${additives}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="additive0.quantity"/></td>
		</tr>
		
	</table>
	
	<h1>Flavorings</h1>
	<table>
		<tr><th>Name</th><th>Quantity</th></tr>
		
		<tr>
			<td><form:hidden path="flavoring0.id"/><form:select path="flavoring0.flavoring.id"><form:option value="0" label=""> </form:option> <form:options items="${flavorings}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="flavoring0.quantity"/></td>
		</tr>
	</table>
 --%>
 <input type="submit" />
</form:form>

