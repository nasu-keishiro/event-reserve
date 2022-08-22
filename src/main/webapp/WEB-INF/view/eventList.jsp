<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベントリスト</title>
<%-- ファビコンの生成 --%>
<link rel="icon" href="">
<link rel="stylesheet" href="././css/style_admin.css">
<%-- <c:import url="parts/commonCss.jsp" /> --%>
</head>

<header>
<h1>イベントリスト</h1>
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
<h2>イベント一覧</h2>
<%-- 
<a href="?year=2022&month=1">2022年1月</a>
<a href="?year=2022&month=2">2022年2月</a>
<a href="?year=2022&month=3">2022年3月</a>

<c:forEach var="month" begin="${n}" end="${n} + 5" >
<a href="eventList?date=<c:out value="${n}" />">${month}月</a>
n = n + 1
</c:forEach>
--%>
<form action="">
<input name="month" type="month" min="" max="" value="">
<input type="submit" value="絞り込み">
</form>
<br>
<%-- 
<form action="">
<input name="year" type="number" min="2020" max="2030" value="2022" step="1">
<input name="month" type="number" min="1" max="12" value="1" step="1">月
<input type="submit">
</form>
--%>
<table>
<tr>
<th>イベント名</th>
<th>日程</th>
<th>場所</th>
<th>定員</th>
<th>残り予約数</th>
<th colspan="2">データの操作</th>
</tr>

<c:forEach items="${eventList}" var="event">
<tr>
<td><a class="kuromoji" href="reserveMonthList?id=<c:out value="${event.id}" />"><c:out value="${event.name}"/></a></td>
<td><c:out value="${event.date}" /></td>
<td><c:out value="${event.place}" /></td>
<td><c:out value="${event.capacity}" /></td>
<td><c:out value="${event.remaining}" /></td>
<td><a class="kuromoji" href="updateEvent?id=<c:out value="${event.id}" />">更新</a></td>
<td><a class="kuromoji" href="deleteEvent?id=<c:out value="${event.id}" />">削除</a></td>

</tr>
</c:forEach>

</table>



	<footer>
		<p>Copyright &copy; hi-life support, Inc. All Rights Reserved.</p>
	</footer>
	
	
</body>
</html>