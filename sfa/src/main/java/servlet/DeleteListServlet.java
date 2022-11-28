package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegistList;


@WebServlet("/DeleteListServlet")
public class DeleteListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//パラメータ取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		//セッションの値を取得
		ArrayList<RegistList> registList2 =
				(ArrayList<RegistList>)session.getAttribute("registList");
		ArrayList<RegistList> registList = new ArrayList<RegistList>();
		for(RegistList i : registList2) {
			String id2 = i.getEmp_no();
			String name2 = i.getName_kanji();
			if(!(name2.equals(name))) {
				System.out.println(name2+"←スコープ　パラメータ→"+name);
				RegistList registList1 = new RegistList(id2,name2);
				registList.add(registList1);
			}
		}
		//リストをセッションに保存し、リダイレクト
		session.setAttribute("registList",registList );
		response.sendRedirect("/sfa/RegistPersonnelServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
