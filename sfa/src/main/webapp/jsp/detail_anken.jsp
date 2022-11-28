<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Anken" %>
<%@ page import="model.RegistList" %>

<%
//案件リストをセッションから取得
ArrayList<Anken> ankenList =
(ArrayList<Anken>)session.getAttribute("ankenList");

//セッションスコープからregistlistを取得
ArrayList<RegistList> registList =
(ArrayList<RegistList>)session.getAttribute("registList");

String anken_id = request.getParameter("id");
String anken_name = ankenList.get(0).getAnken_name();
String startday = ankenList.get(0).getAnken_startday();
String endday = ankenList.get(0).getAnken_endday();

String styear = startday.substring(0,4);
String stmonth = startday.substring(5,7);
String stday = startday.substring(8,10);

String edyear = endday.substring(0,4);
String edmonth = endday.substring(5,7);
String edday = endday.substring(8,10);  

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sfa</title>
</head>
<body>
<h1>案件詳細情報</h1>
<p>案件名：<%=anken_name%></p>
<p>案件開始日：<%= startday %></p>
<p>案件終了日：<%= endday%></p>
<p>クライアント名：<%= ankenList.get(0).getClient_name()%></p>
<p>営業担当場所：
	<% int sales_place = ankenList.get(0).getSales_place();%>
	<%if(sales_place == 1){ %>
	大阪
	<%} else if(sales_place == 2) { %>
	東京
	<%} %></p>
<p>営業担当者：<%= ankenList.get(0).getSales_name()%></p>

人員
<div class="textarea">
	<%if(registList != null){ %>
				<%for(RegistList i : registList){ %>
					<%=i.getName_kanji() %>
					<%} %>
				<%}else{%>
			<%} %>
</div><br>
	<form name="form2" action="/sfa/PositionChangeServlet" method="post">
		<input type="hidden" name="position_id" value="0">
		<input type="hidden" name="id" value="<%=anken_id%>">
		<button type="submit" id="mybtn" onclick="return confirmDelete()">案件を削除する</button>
	</form>
	<form action="/sfa/DetailAnkenServlet" method="post">
		<input type="hidden" name="anken_id" value="<%=anken_id%>">
		<input type="hidden" name="anken_name" value="<%=anken_name%>">
		<input type="hidden" name="styear" value="<%=styear %>">
		<input type="hidden" name="stmonth" value="<%=stmonth %>">
		<input type="hidden" name="stday" value="<%=stday %>">
		<input type="hidden" name="edyear" value="<%=edyear %>">
		<input type="hidden" name="edmonth" value="<%=edmonth %>">
		<input type="hidden" name="edday" value="<%=edday %>">
		<input type="hidden" name="client_name" value="<%= ankenList.get(0).getClient_name()%>">
		<input type="hidden" name="sales_place" value="<%= ankenList.get(0).getSales_place()%>">
		<input type="hidden" name="sales_name" value="<%= ankenList.get(0).getSales_name()%>">		
		<input type="submit" value="編集">
	</form>
	<p>表示位置変更</p>
	<form name="form1" action="/sfa/PositionChangeServlet" method="post">
		<select name="position_id">
			<option value=1>進行中の案件一覧</option>
			<option value=2>終了が近い案件</option>
			<option value=3>新規・人員募集中の案件</option>
			<option value=4>完了した案件</option>
		</select>
		<input type="hidden"  name="id" value="<%=anken_id%>">
		<input type="submit" value="変更">
	</form>
<script>
function confirmDelete(){
    flag = confirm("本当に削除しますか？");

    // 「はい」が押されたときの処理
    if ( flag == true ){
       return true; 
    }else{    // 「いいえ」が押されたときの処理
      return false;
    }
};
</script>
</body>
</html>