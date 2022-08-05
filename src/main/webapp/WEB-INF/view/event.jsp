<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="parts/commonCss.jsp" />
<title>イベント一覧</title>

</head>
<header>
	<h1>イベント一覧</h1>
	<h2>新着情報</h2>
	<dl>
		<dt>2022年11月のイベント追加</dt>
		<dd>○○による運動相談付の面談も実施されます。</dd>
		<dt>2022年10月のイベント情報</dt>
		<dd>ウォーキングイベントが実施されます。運動のプロからのレクチャーあり！体育の秋の一大イベントです。</dd>
		<dt>2022年9月のイベント情報</dt>
		<dd>管理栄養士による料理教室が開催されます。食事は減らすだけじゃない！食と生活の向き合い方から考えるイベントになっています。</dd>
		<dt>2022年8月のイベント終了(満席)</dt>
		<dd>多くのご予約をいただき満席のため終了とさせていただきます。</dd>
	</dl>
	<img alt="" src="">

</header>
<body>

	<div class="tabs">
		<input type="radio" name="tab_name" id="tab1" checked> <label
			class="tab_class" for="tab1">８月</label>
		<div class="content_class">
			<p>
				<c:forEach items="${memberList}" var="member">
					<table border="1">
						<tr>
							<th>タイトル</th>
							<td><c:out value="${member.id}" /></td>
							<th>日付</th>
							<td><c:out value="${member.name}" /></td>
							<th>場所</th>
							<td><c:out value="${member.age}" /></td>
							<th>内容</th>
							<td><c:out value="${member.address}" /></td>
							<th>残り予約数</th>
							<td><c:out value="${member.typeName}" /></td>
							
						</tr>
					</table>
				<input type="submit" value="参加する">
				</c:forEach>
			</p>
		</div>
		<input type="radio" name="tab_name" id="tab2"> <label
			class="tab_class" for="tab2">９月</label>
		<div class="content_class">
			<p>
			<c:forEach items="${memberList}" var="member">
					<table border="1">
						<tr>
							<th>ID</th>
							<td><c:out value="${member.id}" /></td>
							<th>名前</th>
							<td><c:out value="${member.name}" /></td>
							<th>年齢</th>
							<td><c:out value="${member.age}" /></td>
							<th>住所</th>
							<td><c:out value="${member.address}" /></td>
							<th>会員種別</th>
							<td><c:out value="${member.typeName}" /></td>
							<th>登録日</th>
							<td><c:out value="${member.created}" /></td>
						</tr>
					</table>
					<input type="submit" value="参加する">
				</c:forEach>
			</p>
		</div>
		<input type="radio" name="tab_name" id="tab3"> <label
			class="tab_class" for="tab3">１０月</label>
		<div class="content_class">
			<p>
			<c:forEach items="${memberList}" var="member">
					<table border="1">
						<tr>
							<th>ID</th>
							<td><c:out value="${member.id}" /></td>
							<th>名前</th>
							<td><c:out value="${member.name}" /></td>
							<th>年齢</th>
							<td><c:out value="${member.age}" /></td>
							<th>住所</th>
							<td><c:out value="${member.address}" /></td>
							<th>会員種別</th>
							<td><c:out value="${member.typeName}" /></td>
							<th>登録日</th>
							<td><c:out value="${member.created}" /></td>
						</tr>
					</table>
					<input type="submit" value="参加する">
				</c:forEach>
			</p>
		</div>
		<input type="radio" name="tab_name" id="tab4"> <label
			class="tab_class" for="tab4">１１月</label>
		<div class="content_class">
			<p>
			<c:forEach items="${memberList}" var="member">
					<table border="1">
						<tr>
							<th>ID</th>
							<td><c:out value="${member.id}" /></td>
							<th>名前</th>
							<td><c:out value="${member.name}" /></td>
							<th>年齢</th>
							<td><c:out value="${member.age}" /></td>
							<th>住所</th>
							<td><c:out value="${member.address}" /></td>
							<th>会員種別</th>
							<td><c:out value="${member.typeName}" /></td>
							<th>登録日</th>
							<td><c:out value="${member.created}" /></td>
						</tr>
					</table>
					<input type="submit" value="参加する">
				</c:forEach>
			</p>
		</div>
		<input type="radio" name="tab_name" id="tab5"> <label
			class="tab_class" for="tab5">１２月</label>
		<div class="content_class">
			<p>
			<c:forEach items="${memberList}" var="member">
					<table border="1">
						<tr>
							<th>ID</th>
							<td><c:out value="${member.id}" /></td>
							<th>名前</th>
							<td><c:out value="${member.name}" /></td>
							<th>年齢</th>
							<td><c:out value="${member.age}" /></td>
							<th>住所</th>
							<td><c:out value="${member.address}" /></td>
							<th>会員種別</th>
							<td><c:out value="${member.typeName}" /></td>
							<th>登録日</th>
							<td><c:out value="${member.created}" /></td>
						</tr>
					</table>
					<input type="submit" value="参加する">
				</c:forEach>
			</p>
		</div>
	</div>

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
	<c:import url="parts/commonJs.jsp" />
</body>
</html>