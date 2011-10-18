<!DOCTYPE html><%@ tag description="Page layout" 
%><%@ attribute name="title"       required="true" description="Page title" 
%><%@ attribute name="description"       required="true" description="Page description" 
%><%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" 
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" 
%>
<html>
	<head>
		<title>${title}</title>
		<meta name="description" content="${description}" />
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<c:url value="/public/style/bootstrap.min.css" />" />
		<link rel="stylesheet" href="<c:url value="/public/style/style.css" />" />
	</head>
	<body>
		<div class="topbar">
		  <div class="fill">
			<div class="container">
			  <a class="brand" href="${linkTo[IndexController].index}">talk-about</a>
			</div>
		  </div>
		</div>
		<div class="container">
			<div class="content"><jsp:doBody/></div>
		</div>
	</body>
</html>