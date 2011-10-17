<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page title="I want to talk about ${subject}" description="Give your opinion about ${subject}">
    <jsp:body>
    	<h1>${subject}</h1>
    </jsp:body>
</layout:page>