package loginServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbAccess.DBAccess;
import dbAccess.SelectForLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DBAccess dbAccess;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// セッションの取得(なければnullが返ってくる)
		// ここに処理を記入してください
		HttpSession session = request.getSession(false); //sessionが最初はないからnullが入る ログインをしにくるからfalseが入る。logoutしたときにはsessionが残っている
		// セッションの破棄
		// ここに処理を記入してください
		if(session != null) session.invalidate();//ログアウトした時の処理　ログアウトして破棄したいときに実行される
		// ログイン失敗時、ログアウト時、不正操作時以外の場合
		if(request.getAttribute("message") == null) request.setAttribute("message", "Please enter your name or Pass ");//requestスコープから値を取り出している
		//80行目から飛んできたときはmessageがnullでないからif文は飛ばす		
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/Login.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		dbAccess = new SelectForLogin();
		
		try {
			dbAccess.execute(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		boolean flag = (boolean) request.getAttribute("flag");
		
		if(flag) {
			response.sendRedirect("http://localhost:8080/portfolio2/CalendarAccess");
		}else {
			doGet(request, response);
		}
		

		
	}
}