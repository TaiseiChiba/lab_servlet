package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Integer count; //訪問回数

	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		super.init(config);
//		
////		// 訪問回数を表すIntegerインスタンスを新規作成しアプリケーションスコープに保存
////		Integer count = 0;
////		ServletContext application = config.getServletContext();
////		application.setAttribute("count", count);
//		
////		System.out.println("init()が実装されました");
//		
//		count = 0;
//	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy()が実行されました");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		// アプリケーションスコープに保存された訪問回数を増加　
//		ServletContext application = this.getServletContext();
//		Integer count = (Integer) application.getAttribute("count");
//		count++;
//		application.setAttribute("count", count);
		
		count += 1;
		
		// HTML出力
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<head>");
		out.println("<title>訪問回数を表示</title>");
		out.println("<p>訪問回数:" + count + "</p>");
		out.println("<a href=\"/example/CounterServlet\">更新</a>");
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
