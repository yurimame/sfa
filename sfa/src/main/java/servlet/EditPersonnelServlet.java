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

import dao.EmployeeDAO;
import model.FormData;
import model.RegistList;


@WebServlet("/EditPersonnelServlet")
public class EditPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int sales_place = 0;
		int anken_id = 0;
		//パラメータを取得
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
		String place = request.getParameter("sales_place"); System.out.println(place+"編集画面から");
		String sales_name = request.getParameter("sales_name");


		//営業担当場所をintにキャスト
		if(place != null) {
			sales_place = Integer.parseInt(place); System.out.println(sales_place +"キャスト");
		}
		//キャスト
		if(anken_id2 != null) {
			 anken_id = Integer.parseInt(anken_id2);
		}
		//パラメータをセッションスコープに保存
		if(anken_name != null) {
			FormData formData2 = new FormData(anken_id,anken_name,styear,stmonth,stday,edyear, edmonth,edday,client_name, sales_place,sales_name);
			session.setAttribute("formData2", formData2);
		}
		//社員テーブルから全社員を取得
		EmployeeDAO dao = new EmployeeDAO();
		List<model.Employee> employeeList = dao.findByName();
		if(employeeList != null){
			session.setAttribute("employeeList", employeeList);
		} else {
			//エラー処理
		}

		ArrayList<RegistList> registList = (ArrayList<RegistList>) session.getAttribute("registList");

		//データテーブルの社員を取得
		//Anken_dataDAO dao2 = new Anken_dataDAO();
		//ArrayList<RegistList> registList = dao2.findByRegistList(anken_id);


		if(registList != null && anken_id2 != null ) {

			System.out.println("初回のみのはず");

			session.setAttribute("registList", registList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/edit_personnel.jsp");
		    dispatcher.forward(request, response);
		}else if(anken_id2 == null) {

			System.out.println("2回目以降のはず");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/edit_personnel.jsp");
		    dispatcher.forward(request, response);
		}else {
			//エラー処理
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
