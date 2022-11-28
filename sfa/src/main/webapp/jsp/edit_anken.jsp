<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Employee" %>
<%@ page import="model.RegistList" %>
<%@ page import="model.FormData" %>
<%
//セッションスコープからregistlistを取得
ArrayList<RegistList> registList =
(ArrayList<RegistList>)session.getAttribute("registList");
//セッションスコープからFormDataを取得
FormData formData =
(FormData)session.getAttribute("formData2");
//案件に登録されている社員名をセッションから取得
//ArrayList<EmpList> empList =
//(ArrayList<EmpList>)session.getAttribute("empList");

String anken_name = "";
String styear = "";
String stmonth = "";
String stday = "";
String edyear = "";
String edmonth = "";
String edday = "";
String client_name = "";
int sales_place = 0;
String sales_name = "";

if(formData != null){
	anken_name = formData.getAnken_name();
	styear = formData.getStyear();
	stmonth = formData.getStmonth();
	stday = formData.getStday();
	edyear = formData.getEdyear();
	edmonth = formData.getEdmonth();
	edday = formData.getEdday();
	client_name = formData.getClient_name();
	sales_place = formData.getSales_place();
	sales_name = formData.getSales_name();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sfa</title>
<link rel="stylesheet" href="/sfa/css/regist_anken.css">
</head>
<body>
<h1>編集画面</h1>
<h2>編集項目</h2>
	<form name="regist" id="testform" action="/sfa/DetailAnkenServlet" method="post">
		<label for="name">案件名</label>
        <input type="text" id="anken_name" name="anken_name" value="${formData2.anken_name}"><br>
		<label for="name">案件開始日</label>
		<select name="styear" id="styear">
			<option value="2020" <c:if test="${formData2.styear == 2020}">selected</c:if>>2020</option>
			<option value="2021" <c:if test="${formData2.styear == 2021}">selected</c:if>>2021</option>
			<option value="2022" <c:if test="${formData2.styear == 2022}">selected</c:if>>2022</option>
			<option value="2023" <c:if test="${formData2.styear == 2023}">selected</c:if>>2023</option>
			<option value="2024" <c:if test="${formData2.styear == 2024}">selected</c:if>>2024</option>
		</select>年
		<select name="stmonth" id="stmonth">
			<option value="01" <c:if test="${formData2.stmonth == 01}">selected</c:if>>1</option>
			<option value="02" <c:if test="${formData2.stmonth == 02}">selected</c:if>>2</option>
			<option value="03" <c:if test="${formData2.stmonth == 03}">selected</c:if>>3</option>
			<option value="04" <c:if test="${formData2.stmonth == 04}">selected</c:if>>4</option>
			<option value="05" <c:if test="${formData2.stmonth == 05}">selected</c:if>>5</option>
			<option value="06" <c:if test="${formData2.stmonth == 06}">selected</c:if>>6</option>
			<option value="07" <c:if test="${formData2.stmonth == 07}">selected</c:if>>7</option>
			<option value="08" <c:if test="${formData2.stmonth == 08}">selected</c:if>>8</option>
			<option value="09" <c:if test="${formData2.stmonth == 09}">selected</c:if>>9</option>
			<option value="10" <c:if test="${formData2.stmonth == 10}">selected</c:if>>10</option>
			<option value="11" <c:if test="${formData2.stmonth == 11}">selected</c:if>>11</option>
			<option value="12" <c:if test="${formData2.stmonth == 12}">selected</c:if>>12</option>
		</select>月
		<select name="stday" id="stday" >
			<option value="01" <c:if test="${formData2.stday == 01}">selected</c:if>>1</option>
			<option value="02" <c:if test="${formData2.stday == 02}">selected</c:if>>2</option>
			<option value="03" <c:if test="${formData2.stday == 03}">selected</c:if>>3</option>
			<option value="04" <c:if test="${formData2.stday == 04}">selected</c:if>>4</option>
			<option value="05" <c:if test="${formData2.stday == 05}">selected</c:if>>5</option>
			<option value="06" <c:if test="${formData2.stday == 06}">selected</c:if>>6</option>
			<option value="07" <c:if test="${formData2.stday == 07}">selected</c:if>>7</option>
			<option value="08" <c:if test="${formData2.stday == 08}">selected</c:if>>8</option>
			<option value="09" <c:if test="${formData2.stday == 09}">selected</c:if>>9</option>
			<option value="10" <c:if test="${formData2.stday == 10}">selected</c:if>>10</option>
			<option value="11" <c:if test="${formData2.stday == 11}">selected</c:if>>11</option>
			<option value="12" <c:if test="${formData2.stday == 12}">selected</c:if>>12</option>
			<option value="13" <c:if test="${formData2.stday == 13}">selected</c:if>>13</option>
			<option value="14" <c:if test="${formData2.stday == 14}">selected</c:if>>14</option>
			<option value="15" <c:if test="${formData2.stday == 15}">selected</c:if>>15</option>
			<option value="16" <c:if test="${formData2.stday == 16}">selected</c:if>>16</option>
			<option value="17" <c:if test="${formData2.stday == 17}">selected</c:if>>17</option>
			<option value="18" <c:if test="${formData2.stday == 18}">selected</c:if>>18</option>
			<option value="19" <c:if test="${formData2.stday == 19}">selected</c:if>>19</option>
			<option value="20" <c:if test="${formData2.stday == 20}">selected</c:if>>20</option>
			<option value="21" <c:if test="${formData2.stday == 21}">selected</c:if>>21</option>
			<option value="22" <c:if test="${formData2.stday == 22}">selected</c:if>>22</option>
			<option value="23" <c:if test="${formData2.stday == 23}">selected</c:if>>23</option>
			<option value="24" <c:if test="${formData2.stday == 24}">selected</c:if>>24</option>
			<option value="25" <c:if test="${formData2.stday == 25}">selected</c:if>>25</option>
			<option value="26" <c:if test="${formData2.stday == 26}">selected</c:if>>26</option>
			<option value="27" <c:if test="${formData2.stday == 27}">selected</c:if>>27</option>
			<option value="28" <c:if test="${formData2.stday == 28}">selected</c:if>>28</option>
			<option value="29" <c:if test="${formData2.stday == 29}">selected</c:if>>29</option>
			<option value="30" <c:if test="${formData2.stday == 30}">selected</c:if>>30</option>
			<option value="31" <c:if test="${formData2.stday == 31}">selected</c:if>>31</option>
		</select>日<br>

		<label for="name">案件終了日</label>
		<select name="edyear" id="edyear">
			<option value="2020" <c:if test="${formData2.edyear == 2020}">selected</c:if>>2020</option>
			<option value="2021" <c:if test="${formData2.edyear == 2021}">selected</c:if>>2021</option>
			<option value="2022" <c:if test="${formData2.edyear == 2022}">selected</c:if>>2022</option>
			<option value="2023" <c:if test="${formData2.edyear == 2023}">selected</c:if>>2023</option>
			<option value="2024" <c:if test="${formData2.edyear == 2024}">selected</c:if>>2024</option>
		</select>年
		<select name="edmonth" id="edmonth">
			<option value="01" <c:if test="${formData2.edmonth == 01}">selected</c:if>>1</option>
			<option value="02" <c:if test="${formData2.edmonth == 02}">selected</c:if>>2</option>
			<option value="03" <c:if test="${formData2.edmonth == 03}">selected</c:if>>3</option>
			<option value="04" <c:if test="${formData2.edmonth == 04}">selected</c:if>>4</option>
			<option value="05" <c:if test="${formData2.edmonth == 05}">selected</c:if>>5</option>
			<option value="06" <c:if test="${formData2.edmonth == 06}">selected</c:if>>6</option>
			<option value="07" <c:if test="${formData2.edmonth == 07}">selected</c:if>>7</option>
			<option value="08" <c:if test="${formData2.edmonth == 08}">selected</c:if>>8</option>
			<option value="09" <c:if test="${formData2.edmonth == 09}">selected</c:if>>9</option>
			<option value="10" <c:if test="${formData2.edmonth == 10}">selected</c:if>>10</option>
			<option value="11" <c:if test="${formData2.edmonth == 11}">selected</c:if>>11</option>
			<option value="12" <c:if test="${formData2.edmonth == 12}">selected</c:if>>12</option>
		</select>月
		<select name="edday" id="edday" >
			<option value="01" <c:if test="${formData2.edday == 01}">selected</c:if>>1</option>
			<option value="02" <c:if test="${formData2.edday == 02}">selected</c:if>>2</option>
			<option value="03" <c:if test="${formData2.edday == 03}">selected</c:if>>3</option>
			<option value="04" <c:if test="${formData2.edday == 04}">selected</c:if>>4</option>
			<option value="05" <c:if test="${formData2.edday == 05}">selected</c:if>>5</option>
			<option value="06" <c:if test="${formData2.edday == 06}">selected</c:if>>6</option>
			<option value="07" <c:if test="${formData2.edday == 07}">selected</c:if>>7</option>
			<option value="08" <c:if test="${formData2.edday == 08}">selected</c:if>>8</option>
			<option value="09" <c:if test="${formData2.edday == 09}">selected</c:if>>9</option>
			<option value="10" <c:if test="${formData2.edday == 10}">selected</c:if>>10</option>
			<option value="11" <c:if test="${formData2.edday == 11}">selected</c:if>>11</option>
			<option value="12" <c:if test="${formData2.edday == 12}">selected</c:if>>12</option>
			<option value="13" <c:if test="${formData2.edday == 13}">selected</c:if>>13</option>
			<option value="14" <c:if test="${formData2.edday == 14}">selected</c:if>>14</option>
			<option value="15" <c:if test="${formData2.edday == 15}">selected</c:if>>15</option>
			<option value="16" <c:if test="${formData2.edday == 16}">selected</c:if>>16</option>
			<option value="17" <c:if test="${formData2.edday == 17}">selected</c:if>>17</option>
			<option value="18" <c:if test="${formData2.edday == 18}">selected</c:if>>18</option>
			<option value="19" <c:if test="${formData2.edday == 19}">selected</c:if>>19</option>
			<option value="20" <c:if test="${formData2.edday == 20}">selected</c:if>>20</option>
			<option value="21" <c:if test="${formData2.edday == 21}">selected</c:if>>21</option>
			<option value="22" <c:if test="${formData2.edday == 22}">selected</c:if>>22</option>
			<option value="23" <c:if test="${formData2.edday == 23}">selected</c:if>>23</option>
			<option value="24" <c:if test="${formData2.edday == 24}">selected</c:if>>24</option>
			<option value="25" <c:if test="${formData2.edday == 25}">selected</c:if>>25</option>
			<option value="26" <c:if test="${formData2.edday == 26}">selected</c:if>>26</option>
			<option value="27" <c:if test="${formData2.edday == 27}">selected</c:if>>27</option>
			<option value="28" <c:if test="${formData2.edday == 28}">selected</c:if>>28</option>
			<option value="29" <c:if test="${formData2.edday == 29}">selected</c:if>>29</option>
			<option value="30" <c:if test="${formData2.edday == 30}">selected</c:if>>30</option>
			<option value="31" <c:if test="${formData2.edday == 31}">selected</c:if>>31</option>
		</select>日<br>

		<label for="name">クライアント名</label>
		<input type="text" id="client_name" name="client_name" value="<%=client_name%>"><br>

		<label for="name">営業担当場所</label>
		<select name="sales_place" id="sales_place">
			<option value="0"></option>
			<option value="1" <c:if test="${formData2.sales_place == 1}">selected</c:if>> 大阪</option>
			<option value="2" <c:if test="${formData2.sales_place == 2}">selected</c:if>> 東京</option>
		</select><br>

		<label for="name">営業担当者</label>
		<input type="text" id="sales_name" name="sales_name" value="<%=sales_name%>"><br>
		<input type="hidden" name="anken_id" value="${formData2.anken_id}">
		<input type="submit" class="submit_btn" value="登録" >
	</form>
	</form>
	<div class="textarea">
	<form name="regist2" action="/sfa/EditPersonnelServlet" method="get">

		<button type="submit" class="btn"  onclick="return getData();">人員登録</button>
		<%if(registList != null){ %>
			<%for(RegistList i : registList){ %>
				<%=i.getName_kanji() %>
				<%} %>
			<%}else{%>
		<%} %>
		<input type="hidden" name="anken_id" value="${formData2.anken_id}">
	</form>
	</div>
<script>
//入力値データ取得
function getData(){
	//案件名を取得
	const textbox = document.getElementById("anken_name");
	const anken_name = textbox.value;
	//ドキュメント上の最初のフォームを取得
	const form = document.forms[1];
	//input要素を生成
	const input = document.createElement('input');
	//input要素にtype属性とvalue属性を設定
	input.setAttribute('type', 'hidden');
	input.setAttribute('name', 'anken_name');
	input.setAttribute('value', anken_name);
	//form要素の末尾に挿入
	form.appendChild(input);


	//開始年を取得
	const textbox2 = document.getElementById("styear");
	const styear = textbox2.value;
	const form2 = document.forms[1];
	const input2 = document.createElement('input');
	input2.setAttribute('type', 'hidden');
	input2.setAttribute('name', 'styear');
	input2.setAttribute('value', styear);
	form2.appendChild(input2);

	//開始月を取得
	const textbox3 = document.getElementById("stmonth");
	const stmonth = textbox3.value;
	const form3 = document.forms[1];
	const input3 = document.createElement('input');
	input3.setAttribute('type', 'hidden');
	input3.setAttribute('name', 'stmonth');
	input3.setAttribute('value', stmonth);
	form3.appendChild(input3);

	//開始日を取得
	const textbox4 = document.getElementById("stday");
	const stday = textbox4.value;
	const form4 = document.forms[1];
	const input4 = document.createElement('input');
	input4.setAttribute('type', 'hidden');
	input4.setAttribute('name', 'stday');
	input4.setAttribute('value', stday);
	form4.appendChild(input4);

	//終了年を取得
	const textbox5 = document.getElementById("edyear");
	const edyear = textbox5.value;
	const form5 = document.forms[1];
	const input5 = document.createElement('input');
	input5.setAttribute('type', 'hidden');
	input5.setAttribute('name', 'edyear');
	input5.setAttribute('value', edyear);
	form5.appendChild(input5);

	//終了月を取得
	const textbox6 = document.getElementById("edmonth");
	const edmonth = textbox6.value;
	const form6 = document.forms[1];
	const input6 = document.createElement('input');
	input6.setAttribute('type', 'hidden');
	input6.setAttribute('name', 'edmonth');
	input6.setAttribute('value', edmonth);
	form6.appendChild(input6);

	//終了日を取得
	const textbox7 = document.getElementById("edday");
	const edday = textbox7.value;
	const form7 = document.forms[1];
	const input7 = document.createElement('input');
	input7.setAttribute('type', 'hidden');
	input7.setAttribute('name', 'edday');
	input7.setAttribute('value', edday);
	form7.appendChild(input7);

	//クライアント名を取得
	const textbox8 = document.getElementById("client_name");
	const client_name = textbox8.value;
	const form8 = document.forms[1];
	const input8 = document.createElement('input');
	input8.setAttribute('type', 'hidden');
	input8.setAttribute('name', 'client_name');
	input8.setAttribute('value', client_name);
	form8.appendChild(input8);

	//営業担当場所を取得
	const textbox9 = document.getElementById("sales_place");
	const sales_place = textbox9.value;
	const form9 = document.forms[1];
	const input9 = document.createElement('input');
	input9.setAttribute('type', 'hidden');
	input9.setAttribute('name', 'sales_place');
	input9.setAttribute('value', sales_place);
	form9.appendChild(input9);

	//営業担当者を取得
	const textbox10 = document.getElementById("sales_name");
	const sales_name = textbox10.value;
	const form10 = document.forms[1];
	const input10 = document.createElement('input');
	input10.setAttribute('type', 'hidden');
	input10.setAttribute('name', 'sales_name');
	input10.setAttribute('value', sales_name);
	form10.appendChild(input10);

	return true;
}
//入力値チェック
function checkForm(){
    if(document.regist.anken_name.value == ""){
        alert("案件名を入力して下さい。");
		return false;
    }
    if(document.regist.styear.value == ""){
        alert("案件開始日 「年」 を選択してください");
		return false;
    }
    if(document.regist.stmonth.value == ""){
        alert("案件開始日 「月」 を選択してください");
		return false;
    }
    if(document.regist.stday.value == ""){
        alert("案件開始日 「日」 を選択してください");
		return false;
    }
    if(document.regist.edyear.value == ""){
        alert("案件終了日 「年」 を選択してください");
		return false;
    }
    if(document.regist.edmonth.value == ""){
        alert("案件終了日 「月」 を選択してください");
		return false;
    }
    if(document.regist.edday.value == ""){
        alert("案件終了日 「日」 を選択してください");
		return false;
    }else{
		return true;
    }
}
</script>
</body>
</html>