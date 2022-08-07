<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="parts/commonCss.jsp" />
<title>健康・栄養イベント情報</title>

</head>
<header>
	<h1>健康・栄養イベント情報</h1>
	

</header>
<body>
<h2>新着情報</h2>
	<dl>
	<%-- 管理者ページに新着情報更新Formatを追加してもよし --%>
		<dt>2022年11月のイベント追加</dt>
		<dd>○○による運動相談付の面談も実施されます。</dd>
		<dt>2022年10月のイベント情報</dt>
		<dd>ウォーキングイベントが実施されます。運動のプロからのレクチャーあり！体育の秋の一大イベントです。</dd>
		<dt>2022年9月のイベント情報</dt>
		<dd>管理栄養士による料理教室が開催されます。食事は減らすだけじゃない！食と生活の向き合い方から考えるイベントになっています。</dd>
		<dt>2022年8月のイベント終了(満席)</dt>
		<dd>多くのご予約をいただき満席のため終了とさせていただきます。</dd>
	</dl>
	<img alt="" src="">
	
	<form action="">
<input name="month" type="month" min="" max="" value="">
<input type="submit">
</form>


<%-- 初期表示として今月のイベント情報を表示する --%>
<table border="1">

<c:forEach items="${eventMonthList}" var="event">
<tr><th>イベント名</th></tr><td><a href="reserve?id=<c:out value="${event.id}" />"><c:out value="${event.name}"/></a></td>
<tr><th>日程</th></tr><td><c:out value="${event.date}" /></td>
<tr><th>場所</th></tr><td><c:out value="${event.place}" /></td>
<tr><th>定員</th></tr><td><c:out value="${event.capacity}" /></td>

<br>
</c:forEach>

</table>
	
	<h3><a href="reserveConfirmation">予約確認</a></h3>
	
	<ul>
		<li>ホーム</li>
		<li><a href="">会社概要</a></li>
		<li><a href="">スタッフ紹介</a></li>
		<li><a href="">採用情報</a></li>
		<li><a href="">お問い合わせ</a></li>

	</ul>

	<footer>
		<p>Copyright &copy; hi-life support, Inc. All Rights Reserved.</p>
	</footer>
	<c:import url="parts/commonJs.jsp" />
</body>
</html>