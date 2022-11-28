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


@WebServlet("/EditRegistListServlet")
public class EditRegistListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//セッションの値を取得
		ArrayList<RegistList> registList2 =
				(ArrayList<RegistList>)session.getAttribute("registList");
		//パラメータ取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");

		if(registList2 == null) {
			//1回目(セッションが空の場合)
			//beansにセット
			RegistList registList1 = new RegistList(id,name);
			//ArrayListに保存
			ArrayList<RegistList> registList = new ArrayList<RegistList>();
			registList.add(registList1);
		//セッションに保存し、リダイレクト
			session.setAttribute("registList",registList );
			response.sendRedirect("/sfa/RegistPersonnelServlet");
		}else{
			//2回目以降(セッションが空でない場合)
			//パラメータで受けとった値をArrayListにセット
			ArrayList<RegistList> registList = new ArrayList<RegistList>();
			RegistList registList1 = new RegistList(id,name);
			registList.add(registList1);
			//現在のセッションの値を全て取り出す
			for(RegistList i : registList2){
				int anken_id = i.getAnken_id();
				String id2 = i.getEmp_no();
				String name2 = i.getName_kanji();
				if(!(id2.equals(id))) {
					RegistList registList3 = new RegistList(anken_id,id2,name2);
					registList.add(registList3);
				}
			}
			//リストをセッションに保存し、フォワード
			session.setAttribute("registList",registList );
			response.sendRedirect("/sfa/EditPersonnelServlet");
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
