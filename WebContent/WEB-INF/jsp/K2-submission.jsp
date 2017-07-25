<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>応募作品一覧</title>
<link rel="stylesheet" type="text/css" href="/contestvote/css/main.css">
</head>
<body>

	<jsp:include page="/WEB-INF/jsp/header.jsp" flush="true" />

	<div class="back">
		<a>応募総数:<c:out value="${ extralist.size()}"/>点<br>投票総数:920票
		</a>
	</div>
<c:forEach var="arts" items="${extralist}" varStatus="loop">
	<div class="img-left">
		<figure> <img src="${arts.base64Image}" width="300" height="210" />
		<figcaption>
		<h3>作品タイトル</h3>
		<p><c:out value="${arts.title}"/></p>
		</figcaption> </figure>
	</div>
</c:forEach>

</body>
</html>