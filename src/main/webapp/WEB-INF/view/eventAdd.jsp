<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベント作成</title>
<link rel="stylesheet" href="././css/style_admin.css">
<link rel="stylesheet" href="././css/style_admin_form.css">
</head>

<header>
<h1>イベント作成</h1>
<div class="info">
<p>
	&nbsp;
</p>
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
<div class="lef-pading">
<br>
<div class="form-wrapper">

	<form class="form" action="" method="post">
		<div class="rigth">
		<p>タイトル：<input class="text" type="text" name="name" value=""></p>
		<p>日時：<input class="text" type="datetime-local" name="date" value="" step="300"></p>
		<p>場所：<input class="text" type="text" name="place" value=""></p>
		<p>定員：<input class="text" type="number" name="capacity" value=""></p>
		</div>
		<p>内容：
	  		<br><textarea name="contents" cols="80" rows="5"></textarea></p>
		<p>特記事項：
	  		<br><textarea name="remarks" cols="40" rows="3"></textarea></p>
		<p class="text-center"><input type="submit" value="作成"></p>
	</form>
	</div>
	
	<a class="return" href="eventList">イベントリストへ戻る</a>

</div>



	<footer>
		<p>Copyright &copy; hi-life support, Inc. All Rights Reserved.</p>
	</footer>

</body>
</html>