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
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<br>

	<center>
		<h1><c:out value="${ detailArt.title }"/></h1>
	</center>
	<br>

	<center>

		<img src="${ detailArt.img }" />
		<br>

		<form action="contestvote/" method="POST">
			<input type="button" name="vote" value="投票する" />
			<br>
		</form>

		<c:out value="${ detailArt.comment }" />
		<br>

		<div id="commentArea">
			<c:forEach var="i" items="${detailArt}">
				<ul>
					<li><c:out value="${ i.comment }" /></li>
				</ul>
			</c:forEach>
		</div>

		<form action="contestvote/" method="POST">
			<input type="text" name="comment" />
			<br>

			<input type="button" name="contribution" value="投稿" />
		</form>
	</center>
</body>
</html>