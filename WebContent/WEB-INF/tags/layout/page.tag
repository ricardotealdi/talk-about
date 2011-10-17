<%@ tag description="Page layout" %>
<%@ attribute name="title"       required="true" description="Page title" %>
<%@ attribute name="description"       required="true" description="Page description" %>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="description" content="${description}" />
		<title>${title}</title>
	</head>
	<body>
		<jsp:doBody/>
	</body>
</html>