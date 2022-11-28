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
import dao.EmployeeDAO;
import model.Anken;
import model.Employee;
import model.RegistList;


@WebServlet("/AnkenServlet")
public class AnkenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//案件一覧を取得
		AnkenDAO dao = new AnkenDAO();
		List<model.Anken> ankenList = dao.findAll();
		//待機中の社員一覧取得
		EmployeeDAO dao2 = new EmployeeDAO();
		ArrayList<Employee> stanbyList = dao2.findByStandby();
		System.out.println(stanbyList);

		HttpSession session = request.getSession();
		session.removeAttribute("formData2");
		session.removeAttribute("formData");
		session.removeAttribute("registList");

		if(ankenList != null) {

		session.setAttribute("ankenList",ankenList);
		session.setAttribute("stanbyList",stanbyList);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/main_sfa.jsp");
	    dispatcher.forward(request, response);
		} else {
			System.out.println("エラー");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションから社員番号を取得
		HttpSession session = request.getSession();
		ArrayList<RegistList> registList2 = (ArrayList<RegistList>)session.getAttribute("registList");
		System.out.println(registList2 + "51行目");


		//セッション「formData」を破棄
		session.removeAttribute("formData");
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

		String anken_startday = styear + stmonth + stday;
		String anken_endday = edyear + edmonth + edday;

		//営業担当場所をintにキャスト
		int sales_place = Integer.parseInt(place);

		Anken anken = new Anken(anken_name, anken_startday, anken_endday,client_name,sales_place,sales_name);
		AnkenDAO dao = new AnkenDAO();
		boolean rs = dao.create(anken);

		System.out.println(registList2);


		if (rs == true) {
			if(registList2 != null && !(registList2.isEmpty()) ) {
				int anken_id = dao.findID();
				Anken_dataDAO dataDao = new Anken_dataDAO();
				boolean drs = dataDao.create(anken_id, registList2);
				if(drs){
					session.removeAttribute("registList");
					response.sendRedirect("/sfa/AnkenServlet");
				}else{
					//エラー処理
				}
			} else if(registList2 == null) {
				System.out.println(registList2 + "90");
				response.sendRedirect("/sfa/AnkenServlet");
			} else {
				System.out.println(registList2 + "95");
				response.sendRedirect("/sfa/AnkenServlet");
			}

		}else {
			//エラー処理
		}

		}
}
