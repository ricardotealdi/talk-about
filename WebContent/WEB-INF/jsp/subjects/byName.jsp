<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" 
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" 
%><%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" 
%><layout:page title="I want to talk about ${subject.name}" description="Give your opinion about ${subject.name}"
>
	<jsp:body>
		<div class="page-header">
	    	<h1>What people are talking about <strong>${subject.name}</strong>?</h1>
	    </div>
	    	<c:forEach items="${subject.comments}" var="comment">
	    		<ul>
	    			<li><strong>${fn:escapeXml(comment.commentersEmail)}</strong> said "${fn:escapeXml(comment.comment)}"</li>
	    		</ul>
	    	</c:forEach>
	    	<c:if test="${fn:length(subject.comments) == 0}">
	    		<p>Be the first person to leave a comment about <strong>${subject.name}</strong></p>
	    	</c:if>
	    	<hr />
	    	<form action="${linkTo[CommentsController].save}" method="POST">
	    		<fieldset>
	    			<legend>Leave your opinion about ${subject.name}</legend>
	    			<div class="clearfix">
			    		<label for="comment.commentersEmail">What's your e-mail</label>
			    		<div class="input">
			    			<input class="xlarge" id="comment.commentersEmail" type="text" name="comment.commentersEmail" size="30" />
			    		</div>
		    		</div>
		    		<div class="clearfix">
			    		<label for="comment.comment">What do you think about it?</label>
			    		<div class="input">
			    			<textarea class="xxlarge" id="comment.comment" name="comment.comment"></textarea>
			    		</div>
			    	</div>
		    		<input type="hidden" name="subject.id" value="${subject.id}" />
		    		<input type="hidden" name="subject.name" value="${subject.name}" />
		    		<input type="submit" class="btn primary" value="send" />
	    		</fieldset>
	    	</form>
	    	<a href="${linkTo[IndexController].index}">You want to talk about another thing?</a>
  	</jsp:body>
</layout:page>