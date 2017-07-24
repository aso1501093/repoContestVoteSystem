<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作品詳細</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	<br>

	<center>
		<form action="contestvote/V2Vote" method="POST">
			<h1><c:out value="${ image.title }"/></h1>
			<br>

			<img border="0" width="300" height="300" src="<c:out value="${ image.base64Image }"/>"/>
			<br>

<<<<<<< HEAD
		<img src="${ detailArt.img }" />
		<br>
s
		<form action="/repContestVote/V2Vote" method="POST">
			<input type="button" name="vote" value="投票する" />
=======
			<input type="button" value="投票する" />
>>>>>>> branch 'master' of https://github.com/aso1501093/repoContestVoteSystem
			<br>
		</form>
		<br>

		<div id="commentArea">
			<c:if test="${ commentList.size() == 0 }">
				<p align="center"><c:out value="${message}"/></p>
			</c:if>

			<c:if test="${ commentList.size() > 0 }">
				<ul>
					<c:forEach var="list" items="${commentList}">
						<li><c:out value="${ list.comment }"/></li>
					</c:forEach>
				</ul>
			</c:if>
		</div>

<<<<<<< HEAD
		<form action="/repoContestVoteSystem/V2Addcomment" method="POST">
=======
		<form action="contestvote/V2Contribution" method="POST">
>>>>>>> branch 'master' of https://github.com/aso1501093/repoContestVoteSystem
			<input type="text" name="comment" />
			<br>

			<input type="button" value="投稿" />
		</form>

	<%-- 岩永追加分 --%>
			<div id="btn">
		<a href="javascript:void(0);">投票する</a>
	</div>
	<br><br>
	<%-- end --%>
	</center>
</body>
</html>