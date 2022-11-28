package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnkenDAO;
import dao.Anken_dataDAO;
import model.FormData;
import model.RegistList;

@WebServlet("/DetailAnkenServlet")
public class DetailAnkenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int receiveId = Integer.parseInt(id);
		//案件情報を取得
		AnkenDAO dao = new AnkenDAO();
		List<model.Anken> ankenList = dao.findRecord(receiveId);
		//人員名を取得
		Anken_dataDAO dao2 = new Anken_dataDAO();
		ArrayList<RegistList> empList = dao2.findByEmpList(receiveId);



		if (ankenList != null && empList != null ) {
			HttpSession session = request.getSession();
			session.setAttribute("ankenList", ankenList);
			session.setAttribute("registList", empList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/detail_anken.jsp");
		    dispatcher.forward(request, response);
		} else {
			//エラー処理
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		FormData formData2 = (FormData) session.getAttribute("formData2");
		//パラメータ取得
		request.setCharacterEncoding("UTF-8");
		String anken_id2 = request.getParameter("anken_id");
		String anken_name = request.getParameter("anken_name");
		String styear = request.getParameter("styear");
		String stmonth = request.getParameter("stmonth");
		String stday = request.getParameter("stday");
		String edyear = request.getParameter("edyear");
		String edmonth = request.getParameter("edmonth");
		String edday = request.getParameter("edday");

		String client_name = request.getParameter("client_name");
		String place = request.getParameter("sales_place");
		String sales_name = request.getParameter("sales_name");



		String anken_startday = styear + stmonth + stday;
		String anken_endday = edyear + edmonth + edday;

		//キャスト
		int anken_id = Integer.parseInt(anken_id2);

		//営業担当場所をintにキャスト
		int sales_place = Integer.parseInt(place);
		//セッションに保存
		if(formData2 == null) {
			//詳細情報閲覧画面から、編集画面へ
			FormData formData = new FormData(anken_id,anken_name,styear,stmonth,stday,edyear, edmonth,edday,client_name,sales_place,sales_name);
			session.setAttribute("formData2", formData);
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/edit_anken.jsp");
		    dispatcher.forward(request, response);
		}else {
			//編集内容(案件テーブル)をupdateする
			AnkenDAO dao = new AnkenDAO();
			boolean result = dao.updateAnken(anken_id,anken_name,anken_startday,anken_endday,client_name,sales_place,sales_name);
			//編集内容(データテーブル)をupdateする
			//セッションからregistListを取得
			ArrayList<RegistList> registList = (ArrayList<RegistList>)session.getAttribute("registList");
			//案件idのデータを削除
			Anken_dataDAO dao2 = new Anken_dataDAO();
			dao2.deleteRecord(anken_id);
			//registListの社員番号をデータテーブルに登録
			boolean result2 = dao2.create(anken_id, registList);

			if(result==true && result2 == true) {
				//リダイレクト
				response.sendRedirect("/sfa/AnkenServlet");
			}else {
				//エラー処理

			}
		}
	}

}