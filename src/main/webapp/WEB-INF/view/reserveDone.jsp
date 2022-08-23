<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>予約完了</title>
<link rel="stylesheet" href="././css/style_user.css">
<link rel="stylesheet" href="././css/style_user_ref.css">

<style type="text/css">
	header {background-image: url("images/<c:out value="${fileName}" />");}
</style>
</head>

<header>
<h1>予約完了</h1>
<div class="info">

<h2>予約番号</h2>
<c:out value="${confirmationNum}"></c:out>
</div>
<br>

</header>
<body>


<p class="text-center">
予約いただき、誠にありがとうございます<br>
ご予約が完了いたしました。<br>
予約完了の確認メールを送信いたしましたので、必ずご確認ください。
</p>

<div class="conf">
<h2>入力内容</h2>
<p><c:out value="${eventName}" /></p>
<p>名前：<c:out value="${name}" /></p>
<p>年齢：<c:out value="${age}" /></p>
<p>住所：<c:out value="${address}" /></p>
<p>電話番号：<c:out value="${tell}" /></p>
<p>E-mail：<c:out value="${email}" /></p>
</div>

<a href="event">イベント一覧へ戻る</a>

</body>
</html>