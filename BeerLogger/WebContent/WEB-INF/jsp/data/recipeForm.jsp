<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script>
	function addNewHop() {
		var index = $('#hopTable tr').length - 1;
		//var appendrow = $('#hopTemplate tr').html();
		var html = replaceAll($('#hopTemplate tbody').html(), '$index', index);
		$('#hopTable tr:last').after(html);

	}

	function replaceAll(OldString, FindString, ReplaceString) {
		  var SearchIndex = 0;
		  var NewString = ""; 
		  while (OldString.indexOf(FindString,SearchIndex) != -1)    {
		    NewString += OldString.substring(SearchIndex,OldString.indexOf(FindString,SearchIndex));
		    NewString += ReplaceString;
		    SearchIndex = (OldString.indexOf(FindString,SearchIndex) + FindString.length);         
		  }
		  NewString += OldString.substring(SearchIndex,OldString.length);
		  return NewString;
		}
</script>

<table id="hopTemplate" style="display:none">
	<tr>
		<td>	
			<select name="hops[$index].hop.id">
				<c:forEach items="${hops}" var="hop"><option value="${hop.id}">${hop.name }</option>
				</c:forEach>
			</select>
		</td>
		
		<td>
			<input type="text" name="hops[$index].quantity"/>
		</td>

		<td>
			<select name="hops[$index].pelletLeaf">
				<option value="P">Pellet</option>
				<option value="L">Leaf</option>
			</select>
		</td>
		
		<td>
			<input type="text" name="hops[$index].boilTime" />
		</td>
	</tr>	
 </table>
 
<form:form modelAttribute="recipe" action="processRecipe" method="post">
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
	<table id="hopTable">
		<tr><th>Variety</th><th>Quantity (Oz)</th><th>Pellet / Leaf</th><th>Boil Time (minutes)**</th></tr>		
 			
			<c:forEach items="${recipe.hops}" varStatus="hopIngredientRow">
			<spring:nestedPath path="hops[${hopIngredientRow.index}]">
				<tr>
					<td>
<%--
						<spring:bind path="id">
							<input type="hidden" class="hopId" name="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>" />
						</spring:bind>
--%>
						<spring:bind path="hop.id">						
 							<select name="<c:out value="${status.expression}"/>"> 
 								<c:forEach items="${hops}" var="hop">
 									<option value="${hop.id}" <c:if test="${status.value == hop.id}">selected="selectect" </c:if> >
 										${hop.name }
 									</option>
 								</c:forEach>
 							</select>
						</spring:bind>
						 	
					</td>
					
					<td>
						<spring:bind path="quantity">
							<input type="text" name="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>" />
						</spring:bind>
					</td>
					
					<td>
						<spring:bind path="pelletLeaf">
							<select name="<c:out value="${status.expression}"/>"> 
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
						<spring:bind path="boilTime">
							<input type="text" name="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>" />
						</spring:bind>
					</td>
				</tr>	
			</spring:nestedPath>
			</c:forEach>
		</tr>
	</table>
	<input id="hopButton" type="button" onclick="addNewHop();" value="Add New Hop"/>
	**Enter "M" for Mash hops or "D" for Dry Hops
	
	<h1>Grains</h1>
	<table id="barleyTable">
		<tr><th>Variety</th><th>Quantity (lbs)</th></tr>
		
		<c:forEach items="${recipe.barlies}" varStatus="barleyIngredientRow">
		<spring:nestedPath path="barlies[${barleyIngredientRow.index}]">
			<tr>
				<td>							
					<spring:bind path="id"> 
						<input type="hidden" name="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>" />
					</spring:bind>
					
					<spring:bind path="barley.id">						
							<select name="<c:out value="${status.expression}"/>"> 
								<c:forEach items="${barlies}" var="barley">
									<option value="${barley.id}"
									<c:if test="${barley.id == status.value}"> selected="selected" </c:if> > 
										${barley.variety }
									</option>
								</c:forEach>
							</select>
					</spring:bind>	
				</td>
				
				<td>
					<spring:bind path="quantity">
						<input type="text" name="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>" />
					</spring:bind>
				</td>
			</tr>
		</spring:nestedPath>
		</c:forEach>	
	</table>
	
<h1>Additives</h1>
	<table id="additiveTable">
		<tr><th>Name</th><th>Quantity (lbs)</th></tr>
			<c:forEach items="${recipe.additives}" varStatus="additiveIngredientRow">
			<spring:nestedPath path="additives[${additiveIngredientRow.index}]">
				<tr>
					<td>							
						<spring:bind path="id"> 
							<input type="hidden" name="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>" />
						</spring:bind>						
						<spring:bind path="additive.id">						
								<select name="<c:out value="${status.expression}"/>"> 
									<c:forEach items="${additives}" var="additive">
										<option value="${additive.id}"
										<c:if test="${additive.id == status.value}"> selected="selected" </c:if> > 
											${additive.name }
										</option>
									</c:forEach>
								</select>
						</spring:bind>
					</td>
					
					<td>
						<spring:bind path="quantity">
							<input type="text" name="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>" />
						</spring:bind>
					</td>
				</tr>
			</spring:nestedPath>
			</c:forEach>
	</table>

	<h1>Flavorings</h1>
	<table id="flavoringTable">
		<tr><th>Name</th><th>Quantity</th></tr>
		
		<c:forEach items="${recipe.flavorings}" varStatus="flavoringIngredientRow">
		<spring:nestedPath path="flavorings[${flavoringIngredientRow.index}]">
			<tr>
				<td>							
					<spring:bind path="id"> 
						<input type="hidden" name="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>" />
					</spring:bind>
					
					<spring:bind path="flavoring.id">						
							<select name="<c:out value="${status.expression}"/>"> 
								<c:forEach items="${flavorings}" var="flavoring">
									<option value="${flavoring.id}"
									<c:if test="${flavoring.id == status.value}"> selected="selected" </c:if> > 
										${flavoring.name }
									</option>
								</c:forEach>
							</select>
					</spring:bind>	
				</td>
				
				<td>
					<spring:bind path="quantity">
						<input type="text" name="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>" />
					</spring:bind>
				</td>
			</tr>
		</spring:nestedPath>
		</c:forEach>
	</table>

 <input type="submit" />
</form:form>

