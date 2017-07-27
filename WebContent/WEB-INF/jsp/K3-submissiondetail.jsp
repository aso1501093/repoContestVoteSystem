<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作品紹介</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
タイトル:<c:out value="${art.title }"/><br>
<p>獲得票数:<c:out value="${art.vote_num }"/>票</p><br><br>

<p class="img01 waku02 bImg shadow bWidth" ><img src="${art.base64Image }" width="900" height="630"></p>

<ul>
<c:forEach var="comments" items="${commentlist}" varStatus="loop">
<li>${comments }</li>
</c:forEach>
</ul>
<form action="/Contest/K3AddComment" method="post">
<input type="hidden" name="art_id" value="${art.art_id}">
<input type="text" name="comment">
<input type="submit" value="投稿">
</form>
</body>
</html>