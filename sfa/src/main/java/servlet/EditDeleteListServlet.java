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


@WebServlet("/EditDeleteListServlet")
public class EditDeleteListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("deleteしたい");
		
		HttpSession session = request.getSession();
		//パラメータ取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println(name+"をdeleteしたい");
		//セッションの値を取得
		ArrayList<RegistList> registList2 =
				(ArrayList<RegistList>)session.getAttribute("registList");
		ArrayList<RegistList> registList = new ArrayList<RegistList>();
		for(RegistList i : registList2) {
			int anken_id = i.getAnken_id(); 
			String id2 = i.getEmp_no();	
			String name2 = i.getName_kanji();System.out.println(anken_id+id2+name2);
			if(!(id2.equals(id))) {
				System.out.println(id2+"←スコープ　パラメータ→"+id);
				RegistList registList1 = new RegistList(anken_id,id2,name2);
				registList.add(registList1);
			}
		}
		//リストをセッションに保存し、リダイレクト
		//テスト用でリストを出力
		for(RegistList h : registList) {
			System.out.println(h.getAnken_id());
			System.out.println(h.getEmp_no());
			System.out.println(h.getName_kanji());
		}
		session.setAttribute("registList",registList );
		response.sendRedirect("/sfa/EditPersonnelServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
