<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" 
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" 
%><layout:page title="I want to talk about..." description="Give your opinion about anything you want"
>
	<jsp:body>
		<div class="page-header">
			<h1>Give your opinion about anything you want</h1>
		</div>
    	<form class="center" action="${linkTo[IndexController].redirectToSubject}" method="POST">
        	<input type="text" class="span5 home" size="30" maxlength="30" name="subject" placeholder="I want to talk about ..." />
        	<input type="submit" class="btn home primary" value="start" />
        </form>
    </jsp:body>
</layout:page>