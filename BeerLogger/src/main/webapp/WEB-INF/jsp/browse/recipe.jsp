<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<h1> ${recipe.name }</h1><a href="../data/recipe?id=${recipe.id }">Edit</a>
<h2>Shopping List</h2>
<table>
	<tr>
		<td valign="top">
			<table>
			<tr>
				<th align="center">Barley</th>
			</tr>
				<c:forEach var="barley" items="${barleyMap}">
					<tr><td>${barley.value } Lbs.</td>
					<td>${barley.key }</td></tr>
				</c:forEach>
			</table>
		</td>
		
		<td />
		
		<td valign="top">
			<table>
			<tr>
				<th align="center">Hops</th>
			</tr>
				<c:forEach var="hop" items="${hopMap}">
					<tr><td>${hop.value } Oz</td>
					<td>${hop.key }</td></tr>
				</c:forEach>
			</table>
		</td>
		
		<td />
		
		<td valign="top">
			<table>
			<tr>
				<th align="center">Yeast</th>
			</tr>
				<c:forEach var="yeast" items="${yeastMap}">
					<tr><td>${yeast.value }</td>
					<td>${yeast.key }</td></tr>
				</c:forEach>
			</table>
		</td>
		
		<td />
		
		<td valign="top">
			<table>
			<c:if test="${fn:length(recipe.additives) > 0}">
				<tr>
					<th align="center">Additive</th>
				</tr>
					<c:forEach var="additive" items="${recipe.additives}">
						<tr><td>${additive.quantity } Lbs.</td>
						<td>${additive.additive.name }</td></tr>
					</c:forEach>
			</c:if>
			
			<c:if test="${fn:length(recipe.flavorings) > 0}">
				<tr>
					<th align="center">Flavoring</th>
				</tr>
					<c:forEach var="flavoring" items="${recipe.flavorings}">
						<tr><td>${flavoring.quantity }</td>
						<td>${flavoring.flavoring.name }</td></tr>
					</c:forEach>
			</c:if>
			
			<c:if test="${fn:length(recipe.clarifiers) > 0}">
				<tr>
					<th align="center">Clarifier</th>
				</tr>
					<c:forEach var="clarifier" items="${recipe.clarifiers}">
						<tr><td>${clarifier.quantity }</td>
						<td>${clarifier.clarifier.name }</td></tr>
					</c:forEach>
			</c:if>
			
			<c:if test="${fn:length(recipe.spiceHerbs) > 0}">
				<tr>
					<th align="center">Spice and Herbs</th>
				</tr>
					<c:forEach var="spiceHerb" items="${recipe.spiceHerbs}">
						<tr><td>${spiceHerb.quantity } Oz</td>
						<td>${spiceHerb.spiceHerb.name }</td></tr>
					</c:forEach>
			</c:if>
		</table>
		</td>
	</tr>
</table>

<h2>Grains and Additives</h2>
<table>
	<tr><th></th><th>Qty</th><th>Gravity</th><th>Ingredient</th><th>@CLR</th><th>CU</th></tr>
	<c:set var="start" value="true" />
	<c:forEach var="barley" items="${recipe.barlies }">
		<tr>
			<c:choose>
				<c:when test="${start}">
					<td><h3>Barlies</h3></td>
					<c:set var="start" value="false" />
				</c:when>
				<c:otherwise>
					<td></td>
				</c:otherwise>
			</c:choose>
			<td>${barley.quantity }</td>
			<td>${((barley.barley.gravity - 1) * barley.quantity / recipe.batchSize) + 1 }</td>
			<td>${barley.barley.variety }</td>
			<td>${barley.barley.color }</td>
			<td>${barley.barley.color * barley.quantity}</td>
		</tr>
	</c:forEach>
	
	<c:set var="start" value="true" />
	<c:if test="${fn:length(recipe.additives) > 0}">
		<c:forEach var="additive" items="${recipe.additives }">
			<tr>
				<c:choose>
					<c:when test="${start}">
						<td><h3>Additives</h3></td>
						<c:set var="start" value="false" />
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
				<td>${additive.quantity }</td>
				<td>${((additive.additive.gravity - 1) * additive.quantity / recipe.batchSize) + 1 }</td>
				<td>${additive.additive.name }</td>
				<td>${additive.additive.color }</td>
				<td>${additive.additive.color * additive.quantity}</td>
			</tr>
		</c:forEach>
	</c:if>
	<tr>
		<td><h3>Totals:</h3></td>
		<td></td>
		<td>${recipe.potentialGravity }</td>
		<td></td>
		<td></td>
		<td>${recipe.homebrewColorUnits }</td>
	</tr>
</table>

<h2>Hops</h2>

<table>
	<tr><th>Qty</th><th>Hop Variety</th><th>Alpha</th><th>P / L</th><th>Boil Time</th><th> Utilization Rate</th><th>IBU</th></tr>
	<c:forEach var="hop" items="${recipe.hops }">
		<tr>
			<td>${hop.quantity }</td>
			<td><a href="<c:url value="/spring/data/hop?id=${hop.hop.id }"/>">${hop.hop.name}</a></td>
			<td>${hop.hop.alpha }</td>
			<td>${hop.pelletLeaf }</td>
			<td>${hop.boilTime }</td>
			<td><fmt:formatNumber type="percent" value="${hop.utilization }" maxFractionDigits="2"/></td>
			<td><fmt:formatNumber value="${hop.IBU }" maxFractionDigits="2"/></td>
		</tr>
	</c:forEach>
	<tr><td colspan="6"><b>Total:</b></td><td><fmt:formatNumber value="${recipe.IBU }" maxFractionDigits="2"/></td></tr>
</table>

<h2>Yeast(s)</h2>
<table>
	<tr><th>Quantity</th><th>Name</th></tr>
	<c:forEach var="yeast" items="${recipe.yeasts }"> 
		<tr>
			<td>${yeast.quantity }</td>
			<td>${yeast.yeast.name }</td>
		</tr>
	</c:forEach>
</table>