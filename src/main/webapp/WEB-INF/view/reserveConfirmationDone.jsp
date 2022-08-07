<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約情報</title>
</head>
<header>
<h1>予約イベント</h1>
<p><c:out value="eventName"></c:out></p>
<p>日程：<c:out value="date"></c:out></p>
<p>場所：<c:out value="place"></c:out></p>
<p>定員：<c:out value="capacity"></c:out></p>
<p>内容：<c:out value="contents"></c:out></p>

</header>
<body>
<h2>予約者情報</h2>
<p>氏名：<c:out value="name"></c:out></p>
<p>年齢：<c:out value="age"></c:out></p>
<p>住所：<c:out value="address"></c:out></p>
<p>電話番号<c:out value="tell"></c:out></p>
<p>E-mail<c:out value="email"></c:out></p>

<a href="event">戻る</a>

</body>
</html>