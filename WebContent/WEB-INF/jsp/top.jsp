
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>トップページ</title>
	<link rel="stylesheet" href="css/tab.css">
	<!--  <script type="text/javascript" src="js/changeTab.js"></script> -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
	<script type="text/javascript">
	$(function() {
	    //クリックしたときのファンクションを指定
	    $('.tab li').click(function() {

	        //クリックされたタブの番号がindex変数に代入
	        var index = $('.tab li').index(this);

	        //コンテンツを一度すべて非表示
	        $('.content li').css('display','none');

	        //クリックされたタブと同じindex番号のコンテンツを表示
	        $('.content li').eq(index).css('display','block');

	        //一度タブについているクラスselectを消し
	        $('.tab li').removeClass('select');

	        //クリックされたタブのみにクラスselectをつけ
	        $(this).addClass('select')
	    });
	});

	$(function() {
		var vote = '';
		vote = '<div class="vote">'
			+ '<table>'
	    		+ '<c:forEach var="vote" items="${voteContest}">'
					+ '<tr>'
						+ '<td><a href="V1ArtList?contest_id=${vote.contest_id}"><c:out value="${vote.name}" /></a></td>'
						+ '<td><c:out value="${vote.start_date}" />~<c:out value="${vote.end_date}" /></td>'
					+ '</tr>'
				+ '</c:forEach>'
			+ '</table>'
		+ '</div>';
		$('#vote').html(vote);

		var past = '';
		past = '<div class="past">'
			+ '<table>'
	    		+ '<c:forEach var="past" items="${pastContest}">'
					+ '<tr>'
						+ '<td><a href="K1ArtList?contest_id=${vote.contest_id}"><c:out value="${past.name}" /></a></td>'
						+ '<td><c:out value="${past.start_date}" />~<c:out value="${past.end_date}" /></td>'
					+ '</tr>'
				+ '</c:forEach>'
			+ '</table>'
		+ '</div>'
		$('#past').html(past);

		});
	
	</script>
	<link rel="stylesheet" type="text/css" href="/contestvote/css/main.css">
	</head>
	<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" flush="true" />
		<ul class="tab">
			<li class="select" >
				募集中のコンテスト
			</li>
			<li>
				過去のコンテスト
			</li>
		</ul>
		<ul class="content">
	    	<li class = "" id = "vote">
	    	<li class = "hide" id = "past" >
		</ul>
	</body>
</html>