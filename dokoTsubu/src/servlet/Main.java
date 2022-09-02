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
import model.PostMutterLogic;
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		final String text = request.getParameter("text");
		
		// 入力値チェック
		if(text != null && text.length() != 0) {
			// アプリケーションスコープに保存されたつぶやきリストを取得
			ServletContext application = this.getServletContext();
			final List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
			
			// セッションスコープに保存されたユーザーを取得
			HttpSession session = request.getSession();
			final User loginUser = (User) session.getAttribute("loginUser");
			
			// つぶやきをつぶやきリストに追加
			Mutter mutter = new Mutter(loginUser.getName(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.addText(mutter, mutterList);
			
			// アプリケーションスコープにつぶやきリストを保存
			application.setAttribute("mutterList", mutterList);
		} else {
			// 入力されたテキストが空だった場合エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
		// メイン画面にフォーワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
