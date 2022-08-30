<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>参加者の感想</title>
<link rel="stylesheet" href="././css/style_user_eve.css">
<link rel="stylesheet" href="././css/style_user.css">
</head>

<style > 
	header {background-image: url("images/<c:out value="${fileName}" />");}
</style>

		<h1>参加者の感想</h1>
<header>
		<br>
		<div class="info">
		<h2><c:out value="${name}" /></h2>
			<p>日程:<fmt:formatDate value="${date}" pattern="yyyy年MM月dd日 h:mm" /></p>
			<p>場所:<c:out value="${place}" /></p>
			<p>内容:<br><c:out value="${contents}" /></p>
		
		</div>
		<br>
		
		
	</header>

<body>
<br>
<br>
<c:forEach items="${reviewList}" var="review">
<div class="event">
<div class="detail" class="eventDate" >

<p>ニックネーム:<c:out value="${review.name}" /></p>
<p>評価: <span class="star5_rating" data-rate="<c:out value="${review.evaluation}" />" ></span></p>
<p>コメント:<c:out value="${review.comment}" /></p>
<!-- 

 -->
</div>
</div>
<br>
<br>
</c:forEach>

<form action="" method="post">
		<p>ニックネーム：<input type="text" name="name"></p>
		<p>評価：星<input type="number" name="evaluation" min="1" max="5" required  placeholder="必須">個</p>
	<c:if test="${not empty emailError }">
		<p><span class="emailerror">すでに登録してあるメールアドレスです。</span></p>
	</c:if>
		<p>E-mail:<input type="email" name="email" required placeholder="必須" ></p>
		<p>コメント：<textarea name="comment" cols="40" rows="3" required placeholder="必須" ></textarea></p>
			<!-- 隠し属性でイベントIdを送る -->
		<input type="hidden" name="eventId" value="<c:out value="${eventId }" />">
		<input type="submit" value="書き込む"  >
</form>

	
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
<style>


</style>
</html>