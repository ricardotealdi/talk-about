<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page title="I want to talk about..." description="Give your opinion about anything you want">
    <jsp:body>
    	<form action="" method="POST">
        	<span>I want to talk about </span>
        	<input type="text" name="subject" />
        	<input type="submit" value="let's talk" />
        </form>
    </jsp:body>
</layout:page>