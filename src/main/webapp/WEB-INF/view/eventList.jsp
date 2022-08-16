<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>イベントリスト</title>
<%-- ファビコンの生成 --%>
<link rel="icon" href="">
<c:import url="parts/commonCss.jsp" />
</head>

<header>
<h1>イベントリスト</h1>

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
<input type="submit">
</form>
<%-- 
<form action="">
<input name="year" type="number" min="2020" max="2030" value="2022" step="1">
<input name="month" type="number" min="1" max="12" value="1" step="1">月
<input type="submit">
</form>
--%>
</header>
<body>
<h1>イベント一覧</h1>
<table border="1">
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
<td><a href="reserveMonthList?id=<c:out value="${event.id}" />"><c:out value="${event.name}"/></a></td>
<td><c:out value="${event.date}" /></td>
<td><c:out value="${event.place}" /></td>
<td><c:out value="${event.capacity}" /></td>
<td><c:out value="${event.remaining}" /></td>
<td><a href="updateEvent?id=<c:out value="${event.id}" />">更新</a></td>
<td><a href="deleteEvent?id=<c:out value="${event.id}" />">削除</a></td>

</tr>
</c:forEach>

</table>



	<ul>
		<li>ホーム</li>
		<li><a href="eventList">イベントリスト</a></li>
		<li><a href="addEvent">イベント作成</a></li>
		<li><a href="reserveList">予約者リスト</a></li>
		<li><a href="">予約者追加</a></li>
		<li><a href="logout">ログアウト</a></li>

	</ul>
	<footer>
		<p>Copyright &copy; hi-life support, Inc. All Rights Reserved.</p>
	</footer>
	<c:import url="parts/commonJs.jsp" />
</body>
</html>