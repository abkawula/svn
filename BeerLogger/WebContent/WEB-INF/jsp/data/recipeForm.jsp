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
 <h1> test ${fn:length(recipeForm.hop)}</h1>
 	<table>
 		<tr><th>Variety</th><th>Quantity (Oz)</th><th>Pellet / Leaf</th><th>Boil Time (minutes)**</th></tr>
 		
 		<c:forEach items="${recipeForm.hop}" var="h">
 			<tr>
 			
			<td><form:hidden path="${h.id}"/><form:select path="${h.hop.id}">
			<form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="${h.quantity}"/></td>
			<td><form:select path="${h.pelletLeaf}"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="${h.boilTime}"/></td>
			
			</tr>
 		</c:forEach>
 		
 	</table>
 <h1> Hops </h1>
	<table>
		<tr><th>Variety</th><th>Quantity (Oz)</th><th>Pellet / Leaf</th><th>Boil Time (minutes)**</th></tr>
		
		<tr>
			<td><form:hidden path="hop0.id"/><form:select path="hop0.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop0.quantity"/></td>
			<td><form:select path="hop0.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop0.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop1.id"/><form:select path="hop1.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop1.quantity"/></td>
			<td><form:select path="hop1.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop1.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop2.id"/><form:select path="hop2.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop2.quantity"/></td>
			<td><form:select path="hop2.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop2.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop3.id"/><form:select path="hop3.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop3.quantity"/></td>
			<td><form:select path="hop3.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop3.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop4.id"/><form:select path="hop4.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop4.quantity"/></td>
			<td><form:select path="hop4.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop4.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop5.id"/><form:select path="hop5.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop5.quantity"/></td>
			<td><form:select path="hop5.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop5.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop6.id"/><form:select path="hop6.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop6.quantity"/></td>
			<td><form:select path="hop6.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop6.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop7.id"/><form:select path="hop7.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop7.quantity"/></td>
			<td><form:select path="hop7.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop7.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop8.id"/><form:select path="hop8.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop8.quantity"/></td>
			<td><form:select path="hop8.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop8.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop9.id"/><form:select path="hop9.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop9.quantity"/></td>
			<td><form:select path="hop9.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop9.boilTime"/></td>
		</tr>

		<tr>
			<td><form:hidden path="hop10.id"/><form:select path="hop10.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop10.quantity"/></td>
			<td><form:select path="hop10.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop10.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop11.id"/><form:select path="hop11.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop11.quantity"/></td>
			<td><form:select path="hop11.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop11.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop12.id"/><form:select path="hop12.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop12.quantity"/></td>
			<td><form:select path="hop12.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop12.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop13.id"/><form:select path="hop13.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop13.quantity"/></td>
			<td><form:select path="hop13.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop13.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop14.id"/><form:select path="hop14.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop14.quantity"/></td>
			<td><form:select path="hop14.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop14.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop15.id"/><form:select path="hop15.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop15.quantity"/></td>
			<td><form:select path="hop15.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop15.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop16.id"/><form:select path="hop16.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop16.quantity"/></td>
			<td><form:select path="hop16.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop16.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop17.id"/><form:select path="hop17.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop17.quantity"/></td>
			<td><form:select path="hop17.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop17.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop18.id"/><form:select path="hop18.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop18.quantity"/></td>
			<td><form:select path="hop18.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop18.boilTime"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="hop19.id"/><form:select path="hop19.hop.id"><form:option value="0" label=""> </form:option> <form:options items="${hops}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="hop19.quantity"/></td>
			<td><form:select path="hop19.pelletLeaf"><form:option value="L">Leaf</form:option><form:option value="P">Pellet</form:option></form:select></td>
			<td><form:input path="hop19.boilTime"/></td>
		</tr>
	</table>
	**Enter "M" for Mash hops or "D" for Dry Hops
	
	<h1>Grains</h1>
	<table>
		<tr><th>Variety</th><th>Quantity (lbs)</th></tr>
		
		<tr>
			<td><form:hidden path="barley0.id"/><form:select path="barley0.barley.id"><form:option value="0" label=""> </form:option> <form:options items="${barlies}" itemValue="id" itemLabel="variety" /></form:select></td>
			<td><form:input path="barley0.quantity" /></td>
		</tr>
		
		<tr>
			<td><form:hidden path="barley1.id"/><form:select path="barley1.barley.id"><form:option value="0" label=""> </form:option> <form:options items="${barlies}" itemValue="id" itemLabel="variety" /></form:select></td>
			<td><form:input path="barley1.quantity" /></td>
		</tr>
		
		<tr>
			<td><form:hidden path="barley2.id"/><form:select path="barley2.barley.id"><form:option value="0" label=""> </form:option> <form:options items="${barlies}" itemValue="id" itemLabel="variety" /></form:select></td>
			<td><form:input path="barley2.quantity" /></td>
		</tr>
		
		<tr>
			<td><form:hidden path="barley3.id"/><form:select path="barley3.barley.id"><form:option value="0" label=""> </form:option> <form:options items="${barlies}" itemValue="id" itemLabel="variety" /></form:select></td>
			<td><form:input path="barley3.quantity" /></td>
		</tr>
		
		<tr>
			<td><form:hidden path="barley4.id"/><form:select path="barley4.barley.id"><form:option value="0" label=""> </form:option> <form:options items="${barlies}" itemValue="id" itemLabel="variety" /></form:select></td>
			<td><form:input path="barley4.quantity" /></td>
		</tr>
		
	</table>
	
	<h1>Additives</h1>
	<table>
		<tr><th>Name</th><th>Quantity (lbs)</th></tr>
		
		<tr>
			<td><form:hidden path="additive0.id"/><form:select path="additive0.additive.id"><form:option value="0" label=""> </form:option> <form:options items="${additives}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="additive0.quantity"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="additive1.id"/><form:select path="additive1.additive.id"><form:option value="0" label=""> </form:option> <form:options items="${additives}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="additive1.quantity"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="additive2.id"/><form:select path="additive2.additive.id"><form:option value="0" label=""> </form:option> <form:options items="${additives}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="additive2.quantity"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="additive3.id"/><form:select path="additive3.additive.id"><form:option value="0" label=""> </form:option> <form:options items="${additives}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="additive3.quantity"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="additive4.id"/><form:select path="additive4.additive.id"><form:option value="0" label=""> </form:option> <form:options items="${additives}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="additive4.quantity"/></td>
		</tr>
	</table>
	
	<h1>Flavorings</h1>
	<table>
		<tr><th>Name</th><th>Quantity</th></tr>
		
		<tr>
			<td><form:hidden path="flavoring0.id"/><form:select path="flavoring0.flavoring.id"><form:option value="0" label=""> </form:option> <form:options items="${flavorings}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="flavoring0.quantity"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="flavoring1.id"/><form:select path="flavoring1.flavoring.id"><form:option value="0" label=""> </form:option> <form:options items="${flavorings}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="flavoring1.quantity"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="flavoring2.id"/><form:select path="flavoring2.flavoring.id"><form:option value="0" label=""> </form:option> <form:options items="${flavorings}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="flavoring2.quantity"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="flavoring3.id"/><form:select path="flavoring3.flavoring.id"><form:option value="0" label=""> </form:option> <form:options items="${flavorings}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="flavoring3.quantity"/></td>
		</tr>
		
		<tr>
			<td><form:hidden path="flavoring4.id"/><form:select path="flavoring4.flavoring.id"><form:option value="0" label=""> </form:option> <form:options items="${flavorings}" itemValue="id" itemLabel="name" /></form:select></td>
			<td><form:input path="flavoring4.quantity"/></td>
		</tr>
	</table>
</form:form>

