package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// アプリケーションスコープからつぶやきリストを取得
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
		
		// 取得できなかった場合は、つぶやきリストを新規作成してアプリケーションスコープに保存
		if(mutterList == null) {
			mutterList = new ArrayList<>();
			application.setAttribute("mutterList", mutterList);
		}
		
		// ログインしているか確認するためセッションスコープからユーザー取得
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		
		// ログインしていない場合はホームへリダイレクト
		if(user == null) {
			response.sendRedirect("/dokoTsubu/");
		} else { // ログインしている場合フォーワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

}
