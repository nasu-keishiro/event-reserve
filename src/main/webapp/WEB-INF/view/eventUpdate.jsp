<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベント内容変更</title>
</head>

<header>
<h1>イベント変更</h1>
<img alt="" src="">
</header>

<body>


<form action="" method="post">
	タイトル：<input type="text" name="name" value="<c:out value="${name}" />">
	日時：<input type="datetime-local" name="date" value="<c:out value="${date}" />" step="300">
	場所：<input type="text" name="place" value="<c:out value="${place}" />">
	定員：<input type="number" name="capacity" value="<c:out value="${capacity}" />">
	内容：<textarea name="contents" cols="80" rows="5"><c:out value="${contents}" /></textarea>
	特記事項：<textarea name="remarks" cols="40" rows="3"><c:out value="${remarks}" /></textarea>
	<input type="submit" value="更新">
	</form>
	
	<a href="eventList">イベントリストへ戻る</a>




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