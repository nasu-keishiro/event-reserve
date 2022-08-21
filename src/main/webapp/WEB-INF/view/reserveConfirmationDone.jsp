<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約情報</title>
<link rel="stylesheet" href="././css/style_user.css">
<link rel="stylesheet" href="././css/style_user_ref.css">
<style type="text/css">
	header {background-image: url('https://cdn.pixabay.com/photo/2013/03/19/23/07/easter-bunny-95096_960_720.jpg');}
</style>
</head>


<header>
<h1>予約イベント</h1>
<div class="info">
<p><c:out value="${eventName}"></c:out></p>
<p>日程：<c:out value="${date}"></c:out></p>
<p>場所：<c:out value="${place}"></c:out></p>
<p>定員：<c:out value="${capacity}"></c:out></p>
<p>内容：<c:out value="${contents}"></c:out></p>
</div>
<br>
</header>


<body>
 <div class="conf">
<h2>予約者情報</h2>
<h2>予約番号:<c:out value="${confirmationNum}"></c:out></h2>
<p>氏名：<c:out value="${name}"></c:out></p>
<p>年齢：<c:out value="${age}"></c:out></p>
<p>住所：<c:out value="${address}"></c:out></p>
<p>電話番号:<c:out value="${tell}"></c:out></p>
<p>E-mail:<c:out value="${email}"></c:out></p>
</div>

<a href="event">戻る</a>

</body>
</html>