<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<h1> Shopping List</h1>
<table>
	<tr>
		<th>Barley</th><th>Hops</th><th>Yeast</th><th>Other</th>
	</tr>
	<tr>
		<td><table>
			<tr>
				<th>Lbs.</th><th>Type</th>
			</tr>
				<c:forEach var="barley" items="${recipe.barlies}">
					<tr><td>${barley.quantity }</td>
					<td>${barley.barley.variety }</td></tr>
				</c:forEach>
		</table></td>
		
		<td><table>
			<tr>
				<th>Oz</th><th>Type</th>
			</tr>
				<c:forEach var="hop" items="${recipe.hops}">
					<tr><td>${hop.quantity }</td>
					<td>${hop.hop.name }</td></tr>
				</c:forEach>
		</table></td>
		
		<td><table>
			<tr>
				<th>Qty.</th><th>Type</th>
			</tr>
				<c:forEach var="yeast" items="${recipe.yeasts}">
					<tr><td>${yeast.quantity }</td>
					<td>${yeast.yeast.name }</td></tr>
				</c:forEach>
		</table></td>
		
		<td>
		<table>
			<c:if test="${fn:length(recipe.additives) > 0}">
				<tr><th>Additives</th></tr>
				<tr>
					<th>Lbs.</th><th>Type</th>
				</tr>
					<c:forEach var="additive" items="${recipe.additives}">
						<tr><td>${additive.quantity }</td>
						<td>${additive.additive.name }</td></tr>
					</c:forEach>
			</c:if>
			
			<c:if test="${fn:length(recipe.flavorings) > 0}">
				<tr><th>Flavorings</th></tr>
				<tr>
					<th>Qty.</th><th>Type</th>
				</tr>
					<c:forEach var="flavoring" items="${recipe.flavorings}">
						<tr><td>${flavoring.quantity }</td>
						<td>${flavoring.flavoring.name }</td></tr>
					</c:forEach>
			</c:if>
		</table>
		</td>
	</tr>
</table>