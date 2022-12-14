package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ex.Fruit;

/**
 * Servlet implementation class FruitServlet
 */
@WebServlet("/FruitServlet")
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 入力値リクエストスコープに保存
		final String name = "いちご";
		final int price = 700;
		Fruit fruit = new Fruit(name, price);
		HttpSession session = request.getSession();
		session.setAttribute("fruit", fruit);
		
		// フォーワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/fruit.jsp");
		dispatcher.forward(request, response);
	}

}
