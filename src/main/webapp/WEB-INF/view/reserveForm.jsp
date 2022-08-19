<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベント予約フォーム</title>
</head>
<body>
	<header>
		<h1>イベント予約フォーム</h1>
		<h2>イベント詳細</h2>
		<p>
			イベント名
			<c:out value="${name}" />
			日程
			<c:out value="${date}" />
			場所
			<c:out value="${plece}" />
			内容
			<c:out value="${contents}" />
			定員
			残り<c:out value="${remaining}" />
		</p>
		
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12971.095496832771!2d139.5677784!3d35.6333007!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x10fea757d9c7e680!2z44GC44GE44Go44G044GC44K744Oz44K_44O8!5e0!3m2!1sja!2sjp!4v1658470812151!5m2!1sja!2sjp"
			width="600" height="450" style="border: 0;" allowfullscreen=""
			loading="lazy" referrerpolicy="no-referrer-when-downgrade">
			このページはiframe表示に対応したブラウザでご覧ください </iframe>
	</header>


	<form action="" method="post">
	名前：<input type="text" name="name" >
	年齢：<input type="number" name="age" >
	住所：<input type="text" name="address" >
	電話番号：<input type="number" name="tell" >
	E-mail：<input type="text" name="email" >
	予約イベント：<input type="checkbox" name="eventId" value="<c:out value="${eventId}" />"  checked ><c:out value="${name}" />
	 <label for="privacyCheck"><a href="" target="_blank" >個人情報取り扱い同意</a></label>
	<input type="checkbox" id="privacyCheck" >
	
	<input type="submit" id="js-submit" value="予約する" disabled>
	</form>
	
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