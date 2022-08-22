<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベント削除</title>
<link rel="stylesheet" href="././css/style_admin.css">
</head>

<header>
<h1>イベント削除</h1>
<div class="info">
<p>下記内容のイベント内容を確認ください。</p>
</div>
<div class="center-container">
	<div class="flex-container">
		<ul>
			<li><a href="eventList">イベントリスト</a></li>
			<li><a href="addEvent">イベント作成</a></li>
			<li><a href="reserveList">予約者リスト</a></li>
			<li><a href="">予約者追加</a></li>
			<li><a href="logout">ログアウト</a></li>
		</ul>
	</div>
	</div>
</header>


<body>

<h1>タイトル:<c:out value="${name}" /></h1>

<form action="" method="post">

<div class="e-contents">
<h2>内容と特記事項:</h2>
<p>日付:<c:out value="${date}" /></p>
<p>場所:<c:out value="${place}" /></p>
<p>定員:<c:out value="${capacity}" /></p>
<p>内容:
<br><c:out value="${contents}" /></p>
<p>特記事項:
<br><c:out value="${remarks}" /></p>
<!--  <p>残り予約数<c:out value="${remaining}" /></p>-->
</div>

<input type="submit" value="削除">
</form>

<br>
<h2>予約者</h2>
<table>
<tr>
<th>名前</th>
<th>年齢</th>
<th>住所</th>
<th>電話番号</th>
<th>メールアドレス</th>


</tr>
<c:forEach items="${reserveList}" var="reserve">
<tr>
<td><c:out value="${reserve.name}" /></td>
<td><c:out value="${reserve.age}" /></td>
<td><c:out value="${reserve.address}" /></td>
<td><c:out value="${reserve.tell}" /></td>
<td><c:out value="${reserve.email}" /></td>

</tr>
</c:forEach>
</table>

<br>
<a class="return" href="eventList">イベントリストへ戻る</a>

	<footer>
		<p>Copyright &copy; hi-life support, Inc. All Rights Reserved.</p>
	</footer>


</body>
</html>