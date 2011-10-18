<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page title="I want to talk about ${subject.name}" description="Give your opinion about ${subject.name}">
    <jsp:body>
    	<h1>What people are talking about <strong>${subject.name}</strong>?</h1>
    	<c:forEach items="${subject.comments}" var="comment">
    		<h2>${comment.commentersName} said ${comment.comment}</h2>
    	</c:forEach>
    	<form action="${linkTo[CommentsController].save}" action="POST">
    		<label>What's your e-mail? <input type="text" name="comment.commentersEmail" /></label> <br />
    		<label>What do you think about it? <textarea name="comment.comment"></textarea></label> <br />
    		<input type="submit" value="send it" />
    	</form>
    	<a href="${linkTo[IndexController].index}">You want to talk about another thing?</a>
    </jsp:body>
</layout:page>