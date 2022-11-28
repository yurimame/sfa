package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnkenDAO;
import model.RegistList;


@WebServlet("/PositionChangeServlet")
public class PositionChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<RegistList> registList2 = null;
		HttpSession session = request.getSession();
		session.setAttribute("registList",registList2);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/regist_anken.jsp");
	    dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメータ取得
		request.setCharacterEncoding("UTF-8");
		String id1 = request.getParameter("id");
		String position_id = request.getParameter("position_id");
		//int型に変換
		int id = Integer.parseInt(id1);
		System.out.println(position_id);
		
		//DAOインスタンス化、案件IDをもとに表示位置をupdate
		AnkenDAO dao = new AnkenDAO();
		boolean result = dao.changePosition(id,position_id);
		//update成功ならAnkenServletのdogetへ
		if(result) {
			response.sendRedirect("/sfa/AnkenServlet");
		}else{
				//エラー処理
		}
	}
}
