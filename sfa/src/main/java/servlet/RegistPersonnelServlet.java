package servlet;

import java.io.IOException;
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

@WebServlet("/RegistPersonnelServlet")
public class RegistPersonnelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		FormData formData =
				(FormData)session.getAttribute("formData");
		int sales_place = 0;
		//パラメータを取得
		request.setCharacterEncoding("UTF-8");
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
		System.out.println(anken_name);
		System.out.println("開始日は"+styear+"年"+stmonth+"月"+stday+"日");
		System.out.println("終了日は"+edyear+"年"+edmonth+"月"+edday+"日");
		System.out.println(place);

		//営業担当場所をint型にする
		if (place != null) {
			sales_place = Integer.parseInt(place);
		}

		//パラメータをセッションスコープに保存
		if(anken_name != null) {
			FormData formData2 = new FormData(anken_name,styear,stmonth,stday,edyear, edmonth,edday,client_name,sales_place,sales_name);
			session.setAttribute("formData", formData2);
		}
		//社員テーブルから全社員を取得
		EmployeeDAO dao = new EmployeeDAO();
		List<model.Employee> employeeList = dao.findByName();
		if(employeeList != null){
			session.setAttribute("employeeList", employeeList);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/regist_personnel.jsp");
		    dispatcher.forward(request, response);
		} else {
			//エラー処理
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
