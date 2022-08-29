<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="parts/commonCss.jsp" />
<title>健康・栄養イベント情報</title>
<link rel="stylesheet" href="././css/style_user.css">
<link rel="stylesheet" href="././css/style_user_eve.css">

<style type="text/css">
	header {background-image: url(images/health2.jpg);}
</style>

</head>
	<header>
	<h1>健康・栄養イベント情報</h1>
	<div class="info">
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
	</div>	
	<br>

</header>

<body>
	
<br>
<div class="container">
<form action="">
<input name="month" type="month" min="" max="" value="2022-08">
<input type="submit">
</form>
<h3><a href="reserveConfirmation" class="itemB">予約確認</a></h3>
</div>

<%-- 初期表示として今月のイベント情報を表示する --%>
<c:forEach items="${eventMonthList}" var="event">
<div class="event">

<img class="img" src="images/<c:out value="${event.fileName}" />">
<div class="detail" class="eventDate" data-event-date="<fmt:formatDate value="${event.date}" pattern="yyyy-MM-dd" />">
<p>イベント名:<a class="name" href="reserve?id=<c:out value="${event.id}" />"><c:out value="${event.name}"/></a></p>
<p>日程:<fmt:formatDate value="${event.date}" pattern="yyyy年MM月dd日 h:mm" /></p>
<p>場所:<c:out value="${event.place}" /></p>
<p>定員:<c:out value="${event.capacity}" /></p>
<p class="nokori">残り枠数:<c:out value="${event.remaining}" /></p>
</div>
</div>
<br>
<br>
</c:forEach>


	

	
	<ul>
		<li><a href="event">ホーム</a></li>
		<li><a href="">会社概要</a></li>
		<li><a href="">スタッフ紹介</a></li>
		<li><a href="">採用情報</a></li>
		<li><a href="">お問い合わせ</a></li>

	</ul>
	
	<footer>
		<p>Copyright &copy; hi-life support, Inc. All Rights Reserved.</p>
	</footer>
	
	
	 
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	let date1 = Date.now();
	
	$('.detail').each(function(){
		// イベントの日付の情報を取得
		let date2 = Date.parse( $(this).attr('data-event-date'));
		// 比較
		if(date1 - date2 > 0){
			
		// 過ぎていたら、この子要素の.nokoriを色変え
		$(this).children('.nokori').css('color', 'red');
		$(this).children('.nokori').text('イベントは終了しました。');
		
		let changeL = $(this).children('p:first-child').children('.name').attr('href').replace('reserve', 'review');
		$(this).children('p:first-child').children('.name').attr('href', changeL);
		
	}	//if
	}); // each
	
}); // document
</script>
	

	
	
</body>
</html>