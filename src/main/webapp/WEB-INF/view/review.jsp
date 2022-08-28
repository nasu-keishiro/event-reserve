<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>参加者の感想</title>
<link rel="stylesheet" href="././css/style_user.css">
<link rel="stylesheet" href="././css/style_user_eve.css">
</head>

<style > 
	header {background-image: url("images/<c:out value="${fileName}" />");}
</style>

<header>
		<h1>参加者の感想</h1>
		<div class="info">
		<h2><c:out value="${name}" /></h2>
			<p>日程:<c:out value="${date}" /></p>
			<p>場所:<c:out value="${plece}" /></p>
			<p>内容:<c:out value="${contents}" /></p>
		
		</div>
		<br>
		
		
	</header>

<body>

<c:forEach items="${reviwList}" var="review">
<div class="event">
<div class="detail" class="eventDate" data-event-date="<fmt:formatDate value="${event.date}" pattern="yyyy-MM-dd" />">

<p>ニックネーム:<c:out value="${event.name}" /></p>
<p>評価:<c:out value="${review.evaluation}" /></p>
<p>コメント:<c:out value="${review.comment}" /></p>

</div>
</div>
<br>
<br>
</c:forEach>

<form action="">
<p>ニックネーム：<input type="text" name="name"></p>
<p>評価：<input type="number" name="evaluation" min="1" max="5"></p>
<p>コメント：<textarea name="comment" cols="40" rows="3" ></textarea></p>

<input type="submit" value="書き込む" >
</form>

	

	
	<ul>
		<li>ホーム</li>
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