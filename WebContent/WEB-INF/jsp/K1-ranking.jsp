<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>コンテスト結果発表</title>
<link rel="stylesheet" type="text/css" href="/contestvote/css/main.css">
<script type="text/javascript">
function formData(contestid){
	// フォームタグを生成
	var form = document.createElement('form');

	// フォームのmethodタイプ
	form.method = 'POST';

	// POST先
	form.action = '/Contest/K3ArtDetail';

	// POSTパラメーターようにinputタグを生成
	var reqElmId = document.createElement('input');

	// nameとvalueにそれぞれPOSTしたいパラメーターを追加
	reqElmId.type = 'hidden';
	reqElmId.name = 'art_id';
	reqElmId.value = contestid;


	// フォームタグにinputタグを追加
	form.appendChild(reqElmId);

	// bodyにフォームタグを追加
	document.body.appendChild(form);

	// 生成したフォームをSUBMIT
	form.submit();
}
</script>
</head>



<%--
<body>

	<table border="1">
		<c:forEach var="arts" items="${artlist}" varStatus="loop">
			<c:if test="${loop.first}">
				<tr>
			</c:if>
			<td id="${ arts.art_id}"  onclick="formData(${ arts.art_id});"><img src="${arts.base64Image}" /></td>



			<c:if test="${(loop.count%4)==0 && !loop.last }">
			</tr><tr>
			</c:if>



			<c:if test="${ loop.last && (loop.count%4)==1}">
			<td></td><td></td><td></td></tr>
			</c:if>


			<c:if test="${ loop.last && (loop.count%4)==2}">
			<td></td><td></td></tr>
			</c:if>


			<c:if test="${ loop.last && (loop.count%4)==3}">
			<td></td></tr>
			</c:if>


			<c:if test="${ loop.last && (loop.count%4)==0}">
			</tr>
			</c:if>




		</c:forEach>
	</table>


</body>
 --%>



 <body>
<jsp:include page="/WEB-INF/jsp/header.jsp" flush="true" />

<center>
<br><br>
<h1>浴衣コンテスト　結果発表</h1>
<table class="ranking-table">

<c:forEach var="arts" items="${toplist}" varStatus="loop">

<c:if test="${!loop.first }">
<tr class="ranking-tr" onclick="formData(${ arts.art_id});"><th class="ranking-th" >優秀賞</th><td><img src="${arts.base64Image}" width="360" height="250"></td><td class="ranking-td">タイトル:<c:out value="${arts.title}"/><br><c:out value="${ arts.vote_num}"/>票</td></tr>
</c:if>

<c:if test="${loop.first }">
<tr class="ranking-tr" onclick="formData(${ arts.art_id});"><th class="ranking-th">グランプリ</th><td><img src="${arts.base64Image}" width="360" height="250"></td><td class="ranking-td">タイトル:<c:out value="${arts.title}"/><br><c:out value="${ arts.vote_num}"/>票</td></tr>
</c:if>
</c:forEach>
</table>

<br>
<a href="/Contest/K2ArtList" class="k1button">応募作品の一覧</a>
<br><br>
</center>

</body>
</html>