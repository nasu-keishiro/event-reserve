<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約確認</title>
<link rel="stylesheet" href="././css/style_user.css">
<link rel="stylesheet" href="././css/style_user_ref.css">

<style type="text/css">
	header {background-image: url(images/health1.jpg);}
</style>


</head>
<h1>予約確認</h1>
<%-- TODO キャンセルの実装 --%>
<header>
<br>
<div class="info">
<p> 予約番号と氏名をご入力ください。</p>
</div>
<br>
</header>


<body>
<div class="form-wrapper">
<form action="" method="post" class="form">
<p><label class="moji">予約番号</label>:<input type="text" class="text" name="confirmationNum" required placeholder="必須"></p>
<p><label class="moji">氏名</label>:<input type="text" class="text" name="name" required placeholder="必須"></p>

<p class="text-center"><input type="submit" value="送信"></p>
</form>
</div>

<a href="event">戻る</a>
</body>
</html>