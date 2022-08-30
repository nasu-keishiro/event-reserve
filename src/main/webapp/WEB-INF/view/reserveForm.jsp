<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベント予約フォーム</title>
<link rel="stylesheet" href="././css/style_user.css">
<link rel="stylesheet" href="././css/style_user_ref.css">

<style > 
	header {background-image: url("images/<c:out value="${fileName}" />");}
</style>
</head>
<body>
		<h1>イベント予約フォーム</h1>
		
	<header>
	<br>
		<div class="info">
		<h2>イベント詳細</h2>
		<p>イベント名:<c:out value="${name}" /></p>
			<p>日程:<fmt:formatDate value="${date}" pattern="yyyy年MM月dd日 h:mm" /></p>
			<p>場所:<c:out value="${place}" /></p>
			<p>内容:<c:out value="${contents}" /></p>
			<p>定員:<c:out value="${capacity}" />名</p>
			<p id="red">残り:<c:out value="${remaining}" />名</p>
		
		</div>
		<br>
		
		
	</header>

	<div class="form-wrapper">
	<form action="" method="post" class="form">
	<p>名前：<input class="text" type="text" name="name" required placeholder="必須" ></p>
	<p>年齢：<input class="text" type="number" name="age" required placeholder="必須"></p>
	<%-- 住所自動入力の実装 --%>
	<%-- WebAPIを使って --%>
	<p>郵便番号：<input type="text" id="zip" max="7">
	<button id="btn">検索</button></p>
	<p>住所：<input id="address" class="text" type="text" name="address" value="" required placeholder="必須" ></p>
	<p>電話番号：<input class="text" type="number" name="tell" required placeholder="必須" ></p>
	<p>E-mail：<input class="text" type="text" name="email" ></p>
	<p>予約イベント：<input type="checkbox" name="eventId" value="<c:out value="${eventId}" />"  checked ><c:out value="${name}" /></p>
	 <label for="privacyCheck"><a href="" target="_blank" >個人情報取り扱い同意</a></label>
	<input type="checkbox" id="privacyCheck" >
	<br>
	
	<p class="text-center"><input type="submit" id="js-submit" value="予約する"  disabled></p>
	</form>
	</div>
	
    <script src="js/jquery-3.6.0.min.js"></script>
	<script>
	// 残り予約数が0の時の処理 --%>
	let	remainig = <c:out value="${remaining}" />; 
	// let element = document.getElementById('privacyCheck'); --%>
    if( remainig <= 0){
    	document.getElementById('red').style.color = 'red'; // 残り予約数を赤文字にする --%>
	const button = document.querySelector("#js-submit");
	// またはconst button = document.getElementById("ボタンのID"); --%>
	button.disabled = true
    }else{
	// 同意するのチェックボックス --%>
	const consent_chk = document.querySelector(`#privacyCheck`);
	// 送信ボタン --%>
	const submit_btn = document.querySelector(`input[type=submit]`);

	// チェックボックスの入力イベント --%>
	consent_chk.addEventListener('change', () => {
	
	// チェックボックスがあれば無効化をオフ、なければオン --%>
	if (consent_chk.checked === true) {
		submit_btn.disabled = false;
	} else {
		submit_btn.disabled = true;
	}
});
	}

	</script>
	
	<script>

	
	$(document).ready(function(){
		$('#btn').click(function(){
			// 入力値の取得
			const zip = $('#zip').val();
			
			// リクエストの送信先URL　＋　入力された郵便番号
			const endpoint = "https://zipcloud.ibsnet.co.jp/api/search?zipcode=" + zip;
			
			// AJAX通信
			$.ajax({
			  // 引数にscriptのオブジェクトをとる
			  url:endpoint,
			  type:'GET',
			  dataType:'JSONP' // 郵便番号は少し特殊でJSONPとなる、だいたいはJSONが多い
			  })	
			 .done(function(res){
				        
				   if(res.status != 200) {
				        alert(res.message);
				    }
				    else {
				    
				        const r = res.results[0];
				        const address = r.address1 + r.address2 + r.address3;
				        console.log(address)
				        $('#address').val(address);
				      }
				    })
			 .fail(function(){
				 alert('通信失敗')
			  });
			
				       return false // form内にボタンが２つあると同時に二つとも機能してしまうため、機能を消す
		}); //click
	}); //ready
	
	</script>
	
	<a href="event">イベント一覧へ戻る</a>
	
	<ul>
		<li><a href="event">ホーム</a></li>
		<li><a href="">会社概要</a></li>
		<li><a href="">スタッフ紹介</a></li>
		<li><a href="">採用情報</a></li>
		<li><a href="">お問い合わせ</a></li>

	</ul>
	

	<footer>
		<p>Copyright &copy; hi-life support, Inc. All Rights Reserved.</p>
	</footer>
</body>
</html>