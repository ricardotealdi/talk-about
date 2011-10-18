<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<layout:page title="I want to talk about ${subject.name}" description="Give your opinion about ${subject.name}">
    <jsp:body>
    	<h1>What people are talking about <strong>${subject.name}</strong>?</h1>
    	<c:forEach items="${subject.comments}" var="comment">
    		<ul>
    			<li>${comment.commentersEmail} said ${comment.comment}</li>
    		</ul>
    	</c:forEach>
    	<c:if test="${fn:length(subject.comments) == 0}">
    		<h2>Be the first to let a comment about ${subject.name}</h2>
    	</c:if>
    	<form action="${linkTo[CommentsController].save}" method="POST">
    		<fieldset>
    			<legend>Let your opinion about ${subject.name}</legend>
	    		<label>What's your e-mail? <input type="text" name="comment.commentersEmail" /></label> <br />
	    		<label>What do you think about it? <textarea name="comment.comment"></textarea></label> <br />
	    		<input type="hidden" name="subject.id" value="${subject.id}" />
	    		<input type="hidden" name="subject.name" value="${subject.name}" />
	    		<input type="submit" value="send it" />
    		</fieldset>
    	</form>
    	<a href="${linkTo[IndexController].index}">You want to talk about another thing?</a>
    </jsp:body>
</layout:page>