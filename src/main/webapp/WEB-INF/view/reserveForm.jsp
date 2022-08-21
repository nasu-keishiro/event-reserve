<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベント予約フォーム</title>
<link rel="stylesheet" href="././css/style_user.css">
<link rel="stylesheet" href="././css/style_user_ref.css">
<style type="text/css"> /*DBに登録してある画像を表示させる*/
	header {background-image: url('https://cdn.pixabay.com/photo/2013/03/19/23/07/easter-bunny-95096_960_720.jpg');}
</style>
</head>
<body>
	<header>
		<h1>イベント予約フォーム</h1>
		<div class="info">
		<h2>イベント詳細</h2>
		<p>イベント名:<c:out value="${name}" /></p>
			<p>日程:<c:out value="${date}" /></p>
			<p>場所:<c:out value="${plece}" /></p>
			<p>内容:<c:out value="${contents}" /></p>
			<p>定員:<c:out value="${capacity}" />名</p>
			<p>残り:<c:out value="${remaining}" />名</p>
		
		</div>
		<br>
		
		
	</header>

	<div class="form-wrapper">
	<form action="" method="post" class="form">
	<p>名前：<input class="text" type="text" name="name" ></p>
	<p>年齢：<input class="text" type="number" name="age" ></p>
	<p>住所：<input class="text" type="text" name="address" ></p>
	<p>電話番号：<input class="text" type="number" name="tell" ></p>
	<p>E-mail：<input class="text" type="text" name="email" ></p>
	<p>予約イベント：<input type="checkbox" name="eventId" value="<c:out value="${eventId}" />"  checked ><c:out value="${name}" /></p>
	 <label for="privacyCheck"><a href="" target="_blank" >個人情報取り扱い同意</a></label>
	<input type="checkbox" id="privacyCheck" >
	<br>
	
	<p class="text-center"><input type="submit" id="js-submit" value="予約する" disabled></p>
	</form>
	</div>
	
	<script>
	<%-- 残り予約数が0の時の処理 --%>
	let	remainig = 3; <%-- JSPでの記述<c:out value="${remaining}" />; --%>
	<%-- let element = document.getElementById('privacyCheck'); --%>
    if( remainig <= 0){
	const button = document.querySelector("#js-submit");
	<%-- またはconst button = document.getElementById("ボタンのID"); --%>
	button.disabled = true
    }else{
	<%-- 同意するのチェックボックス --%>
	const consent_chk = document.querySelector(`#privacyCheck`);
	<%-- 送信ボタン --%>
	const submit_btn = document.querySelector(`input[type=submit]`);

	<%-- チェックボックスの入力イベント --%>
	consent_chk.addEventListener('change', () => {
	
	<%-- チェックボックスがあれば無効化をオフ、なければオン --%>
	if (consent_chk.checked === true) {
		submit_btn.disabled = false;
	} else {
		submit_btn.disabled = true;
	}
});
	}

	</script>
	
	<a href="event">イベント一覧へ戻る</a>
	
	<ul>
		<li>ホーム</li>
		<li><a href="">会社概要</a></li>
		<li><a href="">スタッフ紹介</a></li>
		<li><a href="">採用情報</a></li>
		<li><a href="">お問い合わせ</a></li>

	</ul>
	
	<%-- 残り予約数が０の場合は、予約ボタンを押せないようにブランクにする --%>
		<script>
		<%--残り予約数が0の時の処理 --%>
	let	remainig = <c:out value="${remaining}" />; 
	
    if( remainig <= 0){
	const button = document.querySelector("#js-submit");
	<%-- またはconst button = document.getElementById("ボタンのID"); --%>
	button.disabled = true
    }else{
	<%-- 同意するのチェックボックス --%>
	const consent_chk = document.querySelector(`#privacyCheck`);
	<%-- 送信ボタン --%>
	const submit_btn = document.querySelector(`input[type=submit]`);

	<%-- チェックボックスの入力イベント --%>
	consent_chk.addEventListener('change', () => {
	
	<%-- チェックボックスがあれば無効化をオフ、なければオン --%>
	if (consent_chk.checked === true) {
		submit_btn.disabled = false;
	} else {
		submit_btn.disabled = true;
	}
});
	}

	</script>
	<footer>
		<p>Copyright &copy; hi-life support, Inc. All Rights Reserved.</p>
	</footer>
</body>
</html>