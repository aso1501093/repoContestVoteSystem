<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作品紹介</title>
</head>
<body>
画像<img src="${art.base64Image }"><br>
タイトル${art.title }<br>
アートID${art.art_id }<br>
コンテストID${art.contest_id }<br><br>
<p>獲得票数:50票</p><br><br>

<c:forEach var="comments" items="${commentlist}" varStatus="loop">
${comments }<br>

</c:forEach>

<form action="/Contest/K3AddComment" method="post">
<input type="hidden" name="art_id" value="${art.art_id}">
<input type="text" name="comment">
<input type="submit" value="投稿">
</form>
</body>
</html>