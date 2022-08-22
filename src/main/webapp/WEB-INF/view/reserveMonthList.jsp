<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約者リスト</title>
<link rel="stylesheet" href="././css/style_admin.css">
</head>
<header>
<h1>タイトル:<c:out value="${name}" /></h1>
<div class="info">
<h2>内容と特記事項:</h2>
<p>日付:<c:out value="${date}" /></p>
<p>場所:<c:out value="${place}" /></p>
<p>定員:<c:out value="${capacity}" />名</p>
<p>残り:<c:out value="${remaining}" />名</p>
<p>特記事項:<br>
<c:out value="${remarks}" /></p>

</div>
<div class="center-container">
	<div class="flex-container">
<ul>
	
	<li><a href="eventList">イベントリスト</a></li>
	<li><a href="">イベント作成</a></li>
	<li><a href="reserveList">予約者リスト</a></li>
	<li><a href="">予約者追加</a></li>
	<li><a href="logout">ログアウト</a></li>

</ul>
	</div>
</div>
</header>

<body>
<br>
<h2>予約者リスト</h2>
<table>
<tr>
<th>名前</th>
<th>年齢</th>
<th>住所</th>
<th>電話番号</th>
<th>メールアドレス</th>
<th>データの操作</th>

</tr>
<c:forEach items="${reserveMonth}" var="reserve">
<tr>
<td><c:out value="${reserve.name}" /></td>
<td><c:out value="${reserve.age}" /></td>
<td><c:out value="${reserve.address}" /></td>
<td><c:out value="${reserve.tell}" /></td>
<td><c:out value="${reserve.email}" /></td>
<td><a class="kuromoji" href="deleteReserve?id=<c:out value="${reserve.id}" />">削除</a></td>

</tr>
</c:forEach>

</table>

	<footer>
		<p>Copyright &copy; hi-life support, Inc. All Rights Reserved.</p>
	</footer>
</body>
</html>