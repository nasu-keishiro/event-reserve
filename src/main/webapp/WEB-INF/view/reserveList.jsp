<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約者リスト</title>
</head>
<header>
<h1>予約者リスト</h1>
</header>

<body>
<table border="1">
<tr>
<th>名前</th>
<th>年齢</th>
<th>住所</th>
<th>電話番号</th>
<th>メールアドレス</th>
<th>データの操作</th>

</tr>
<c:forEach items="${reserveList}" var="reserve">
<tr>
<td><c:out value="${reserve.name}" /></td>
<td><c:out value="${reserve.age}" /></td>
<td><c:out value="${reserve.address}" /></td>
<td><c:out value="${reserve.tell}" /></td>
<td><c:out value="${reserve.email}" /></td>
<td><a href="deleteMember?id=<c:out value="${reserve.id}" />">削除</a></td>

</tr>
</c:forEach>
</table>


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