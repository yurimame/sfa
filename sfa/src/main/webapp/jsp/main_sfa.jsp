<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Anken" %>
<%@ page import="model.Employee" %>
<%
//案件リストをセッションから取得
ArrayList<Anken> ankenList =
(ArrayList<Anken>)session.getAttribute("ankenList");
//待機中社員一覧をセッションから取得
ArrayList<Employee> stanbyList =
(ArrayList<Employee>)session.getAttribute("stanbyList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sfa</title>
<link rel="stylesheet" href="/sfa/css/main_sfa.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.2.0/css/all.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<header>
	<%-- 検索 --%>
	<form action = ""  method="get">
		<input type="search" name="search"  placeholder = "検索">
		<input class = "submit" type="submit" value="検索">
	</form>
	 <!-- ハンバーガーメニュー部分 -->
      <div>
        <!-- ハンバーガーメニューの表示・非表示を切り替えるチェックボックス -->
        <input id="drawer_input" class="drawer_hidden" type="checkbox">
        <!-- ハンバーガーアイコン -->
        <label for="drawer_input" class="drawer_open"><span></span></label>
        <!-- メニュー -->
        <nav class="nav_content">
          <ul>
            <li class="nav_item"><a href="">メニュー1</a></li>
            <li class="nav_item"><a href="">メニュー2</a></li>
            <li class="nav_item"><a href="">メニュー3</a></li>
          </ul>
        </nav>
      </div>
	<%-- メニューバー --%>
	<nav>
  		<ul class="menu">
    		<li><a class="menu_ber" href="#">案件一覧</a></li>
    		<li><a class="menu_ber"href="#">東京</a></li>
    		<li><a class="menu_ber"href="#">大阪</a></li>
    		<li><a class="menu_ber"href="#">カレンダー</a></li>
  		</ul>
	</nav>
</header>

<main>
	<div>
		<ul>
			<li class="li-oya">進行中の案件一覧　　<button class="button" onclick="location.href='/sfa/PositionChangeServlet'">
			<i class="fa-solid fa-plus fa-lg"></i></button></li>
			<li class="li-oya">終了が近い案件一覧</li>
			<li class="li-oya">新規・人員募集中の案件一覧</li>
			<!-- <li class="li-oya">完了した案件</li> -->
			<li class="li-oya taiki">待機中の社員一覧</li>
		</ul>
	</div>
	<div class="anken-itiran">
		<ul class="drag-list">　
			<%for(int i = 0; i<ankenList.size(); i++){%>
				<%if(ankenList.get(i).getDisplay_position() == 1){ %>
				<li class="anken-list" id="<%="item" + i %>" draggable="true">
				<a href="/sfa/DetailAnkenServlet?id=<%=ankenList.get(i).getAnken_id()%>"><%=ankenList.get(i).getAnken_name()%>
				</a><div id="triangle-btn">...</div></li>
				<div class="henkou-box" id="menubox">
					<ul class="henkou-ul">
						<li class="henkou-li li-li" onclick="location.href='#'">位置変更</li>
						<li class="li-li" onclick="location.href='#'">詳細</li>
					</ul>
				</div>
				<%} %>
			<%}%>
		</ul>
	</div>
	<div class="anken-itiran">
		<ul class="drag-list">　
			<%for(Anken j : ankenList){%>
				<%if(j.getDisplay_position() == 2){ %>
				<li class="anken-list" id="<%="item" + j %>" draggable="true">
				<a href="/sfa/DetailAnkenServlet?id=<%=j.getAnken_id()%>"><%=j.getAnken_name()%></a></li>
				<%} %>
			<%}%>
		</ul>
	</div>
	<div class="anken-itiran">
		<ul class="drag-list">
			<%for(Anken k : ankenList){%>
				<%if(k.getDisplay_position() == 3){ %>
				<li class="anken-list" id="<%="item" + k %>" draggable="true">
				<a href="/sfa/DetailAnkenServlet?id=<%=k.getAnken_id()%>"><%=k.getAnken_name()%></a></li>
				<%} %>
			<%}%>
		</ul>
	</div>
	<!--<div class="anken-itiran">
		<ul class="drag-list">
			<%for(Anken h : ankenList){%>
				<%if(h.getDisplay_position() == 4){ %>
				<li class="anken-list" id="<%="item" + h %>" draggable="true">
				<a href="/sfa/DetailAnkenServlet?id=<%=h.getAnken_id()%>"><%=h.getAnken_name()%></a></li>
				<%} %>
			<%}%>
		</ul>
	</div>  -->
	<div class="anken-itiran">
		<ul class="drag-list">
			<%for(Employee l : stanbyList){%>
			<li class="anken-list" id="item11" draggable="true">
			<a href="/sfa/jsp/detail_employee.jsp?name=<%=l.getName_kannji() %>"><%=l.getName_kannji() %></a></li>
			<%} %>
		</ul>
	</div>
</main>
<script>
$(document).on('click', function(e) {
	if(!$(e.target).closest('#menubox').length && !$(e.target).closest('#triangle-btn').length){
		$('#menubox').fadeOut(100);
	}else if($(e.target).closest('#triangle-btn').length){
		if($('#menubox').is(':hidden')){
			$('#menubox').fadeIn(100);
		}else{
			$('#menubox').fadeOut(100);
		}
	}
});
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