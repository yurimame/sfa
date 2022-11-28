<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Employee" %>
<%@ page import="model.RegistList" %>
<%
//案件リストをセッションから取得
ArrayList<Employee> employeeList =
(ArrayList<Employee>)session.getAttribute("employeeList");
//セッションスコープからregistlistを取得
ArrayList<RegistList> registList =
(ArrayList<RegistList>)session.getAttribute("registList");
//待機中社員一覧をセッションから取得
ArrayList<Employee> stanbyList =
(ArrayList<Employee>)session.getAttribute("stanbyList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sfa</title>
<link rel="stylesheet" href="/sfa/css/regist_personnel.css">
</head>
<body>
<form action = ""  method="get">
	<input class="serch-box" type="search" name="search"  placeholder = "検索">
	<input class = "submit" type="submit" value="検索">
</form><br><br>
<div class="person_itiran">
	<b>社員一覧</b>
	<ul class="ul">
		<%for(Employee i : employeeList){ %>
		<li><a href="/sfa/EditRegistListServlet?id=<%=i.getEmp_no()%>&name=<%=i.getName_kannji()%>"><%=i.getName_kannji()%></a></li><br>
		<%}%>
	</ul>
</div>
 <div class="taiki-itiran">
	<b>待機中</b>
	<ul class="drag-list">
		<%for(Employee h : stanbyList){%>
		<li class="anken-list" id="item11" draggable="true">
		<a href="/sfa/EditRegistListServlet?id=<%=h.getEmp_no()%>&name=<%=h.getName_kannji()%>"><%=h.getName_kannji() %></a></li><br>
		<%} %>
	</ul>
</div> 
<form action="/sfa/AnkenServlet" method="post">
	<div class="person_list">
		<div class="list_box">
			<ul>
				<%if(registList != null){ %>
					<%for(RegistList i : registList){ %>
					<li><a href="/sfa/EditDeleteListServlet?id=<%=i.getEmp_no()%>&name=<%=i.getName_kanji()%>">
					<%=i.getName_kanji() %></a></li><br>
					<%} %>
				<%} else{%>
				<%} %>
			</ul>
		</div>
		<button type="button" onclick="location.href='/sfa/jsp/edit_anken.jsp'" class="btn">確定</button>
	</div>
</form>
</body>
</html>