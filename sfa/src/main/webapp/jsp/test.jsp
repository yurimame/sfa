<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/sfa/css/test.css">
</head>
<body>






<header>
	<div class="header-top">ヘッダー上部</div>
	<div class="headre-bottom">ヘッダー下部</div>
</header>
<main>
	<div>
		<ul>
			<li class="li-oya">進行中の案件一覧　　<span></span></li>
			<li class="li-oya">終了2か月前の案件一覧</li>
			<li class="li-oya">新規・人員募集中の案件一覧</li>
			<li class="li-oya">待機中の社員一覧</li>
		</ul>
	</div>
	<div class="anken-itiran">
		<ul class="drag-list">　<!-- メイン画面全体のリスト -->
			<li class="anken-list" id="item1" draggable="true">アクセンチュア　かんでんプロジェクト</li>
			<li class="anken-list" id="item2" draggable="true">リンクレア　〇〇プロジェクト</li>
			<li class="anken-list" id="item3" draggable="true">ダイフク　〇〇プロジェクト</li>
			<li class="anken-list" id="item4" draggable="true">テスト用</li>
			<li class="anken-list" id="item5" draggable="true">テスト用</li>
			<li class="anken-list" id="item6" draggable="true">テスト用</li>
			<li style="border:0;list-style-type:none;">&nbsp;</li>
		</ul>
	</div>
	<div class="anken-itiran">
		<ul class="drag-list">　<!-- メイン画面全体のリスト -->
			<li class="anken-list" id="item7" draggable="true">アクセンチュア　かんでんプロジェクト</li>
			<li class="anken-list" id="item8" draggable="true">リンクレア　〇〇プロジェクト</li>
			<li class="anken-list" id="item9" draggable="true">ダイフク　〇〇プロジェクト</li>
			<li style="border:0;list-style-type:none;">&nbsp;</li>
		</ul>
	</div>
	<div class="anken-itiran">
		<ul class="drag-list">　<!-- メイン画面全体のリスト -->
			<li class="anken-list" id="item10" draggable="true">アクセンチュア　かんでんプロジェクト</li>
			<li style="border:0;list-style-type:none;">&nbsp;</li>
		</ul>
	</div>
	<div class="anken-itiran">
		<ul class="drag-list">　<!-- メイン画面全体のリスト -->
			<li class="anken-list" id="item11" draggable="true"><a href="#">秋田</a>　大阪事業二部事業推進課</li>
			<li class="anken-list" id="item12" draggable="true"><a href="#">原</a>　大阪事業二部事業推進課</li>
			<li style="border:0;list-style-type:none;">&nbsp;</li>
		</ul>
	</div>
</main>

<script>
document.querySelectorAll('.drag-list li').forEach (elm => {
	elm.ondragstart = function () {
		event.dataTransfer.setData('text/plain', event.target.id);
	};
	elm.ondragover = function () {
		event.preventDefault();
		let rect = this.getBoundingClientRect();
		if ((event.clientY - rect.top) < (this.clientHeight / 2)) {
			//マウスカーソルの位置が要素の半分より上
			this.style.borderTop = '2px solid #483D8B';
			this.style.borderBottom = '';
		} else {
			//マウスカーソルの位置が要素の半分より下
			this.style.borderTop = '';
			this.style.borderBottom = '2px solid #483D8B';
		}
	};
	elm.ondragleave = function () {
		this.style.borderTop = '';
		this.style.borderBottom = '';
	};
	elm.ondrop = function () {
		event.preventDefault();
		let id = event.dataTransfer.getData('text/plain');
		let elm_drag = document.getElementById(id);

		let rect = this.getBoundingClientRect();
		if ((event.clientY - rect.top) < (this.clientHeight / 2)) {
			//マウスカーソルの位置が要素の半分より上
			this.parentNode.insertBefore(elm_drag, this);
		} else {
			//マウスカーソルの位置が要素の半分より下
			this.parentNode.insertBefore(elm_drag, this.nextSibling);
		}
		this.style.borderTop = '';
		this.style.borderBottom = '';
	};
});
</script>
</body>
</html>