<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="././css/style_admin_log.css">
</head>

<header>
   <h1>管理者ログイン</h1>
 	<c:if test="${not empty error }">
   		<p>ログインIDかパスワードが正しくありません。</p>
	</c:if>
</header>

<body>

<form action="" method="post">
<p>
<input type="text" name="loginId" placeholder="ログインID" required>
</p>
<p>
<input type="password" name="loginPass" placeholder="パスワード" required>
</p>
<p>
<input type="submit" value="ログイン">
</p>
</form>

</body>
</html>