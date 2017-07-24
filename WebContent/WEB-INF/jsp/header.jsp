<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<div id="headerArea">
	<div style="width: 400px; float: left;">
		<h1 style="font-size: 2em; color: #ffffff; vertical-align: middle;">
			<a class="header">コンテスト投票システム</a>
		</h1>
	</div>
	<div
		style="text-align: right; font-size: 20px; width: 330px; padding: 4px; float: right;">

		ようこそ&nbsp;
		<c:out value="${CommonLoginMember.memberName}" />
		&nbsp; 様 &nbsp; <br>

		<%-- ログイン時 --%>

			<a class="header2" href="/lecturesystem/Logout">ログアウト</a>

	</div>
	<br style="clear: both;">
</div>