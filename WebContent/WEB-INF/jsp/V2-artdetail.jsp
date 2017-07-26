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
		<form action="V2Vote" method="POST">
			<h1><c:out value="${ image.title }"/></h1>
			<br>

			<img border="0" width="300" height="300" src="<c:out value="${ image.base64Image }"/>"/>
			<br>


		<img src="${ detailArt.img }" />
		<br>
			<input type="button" name="vote" value="投票する" />

			<input type="button" value="投票する" />

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
		<form action="V2Addcomment" method="POST">


			<input type="text" name="comment" />
			<br>

			<input type="submit" value="投稿" />
		</form>

	</center>
</body>
</html>