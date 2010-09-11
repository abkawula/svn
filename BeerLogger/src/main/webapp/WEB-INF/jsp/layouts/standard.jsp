<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <!--Meta--> 
	<meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="copyright" content="Todd Ballard and Adam Kawula" />
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta name="revisit-after" content="1 day" />
    <meta name="DC.title" content="Beericpe.com" />
    <meta name="robots" content="all" />
    
	<title><tiles:getAsString name="title"/></title>
	
	<!--Style--> 
	<style type="text/css" media="projection, screen">
        @import url("<c:url value="/resources/styles/beer.css" />");
        @import url("<c:url value="/resources/styles/jquery.tabs.css" />");
    
		<!--[if lte IE 7]>
		 @import url("<c:url value="/resources/styles/jquery.tabs-ie.css" />");
		<![endif]--> 
	</style> 	    
	<!-- <link rel="Shortcut Icon" type="image/ico" href="favicon.ico" /> -->
	
	<!-- Sourcery-->
	
	<%-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script> --%>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.2.6.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.tabs.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/dojo/dojo.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"></script>
	 


    <script type="text/javascript">
		$(document).ready(function() {
	   	 
		  $("#beer_results").tabs();
		 
		});
	</script>
    

</head>

<body>
<div id="wrapper">
<div id="header">
	<tiles:insertAttribute name="header" />
</div>

<div id="content_wrapper">
<tiles:insertAttribute name="body" />
		
</div>

</body>
</html>
