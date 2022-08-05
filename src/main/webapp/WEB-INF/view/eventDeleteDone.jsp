<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベント削除</title>
</head>

<header>
<h1>イベント削除完了</h1>
<p>下記内容のイベントを削除しました。</p>
</header>

<body>

<h1>タイトル:<c:out value="${name}" /></h1>
<h2>内容と特記事項:</h2>
<p>日付:<c:out value="${date}" /></p>
<p>場所:<c:out value="${place}" /></p>
<p>定員:<c:out value="${capacity}" /></p>
<p>内容:<c:out value="${contents}" /></p>
<p>特記事項:<c:out value="${remarks}" /></p>
<!--  <p>残り予約数<c:out value="${remaining}" /></p>-->

	<ul>
		<li>ホーム</li>
		<li><a href="eventList">イベントリスト</a></li>
		<li><a href="">イベント作成</a></li>
		<li><a href="reserveList">予約者リスト</a></li>
		<li><a href="">予約者追加</a></li>
		<li><a href="logout">ログアウト</a></li>

	</ul>

	<footer>
		<p>Copyright &copy; hi-life support, Inc. All Rights Reserved.</p>
	</footer>


</body>
</html>