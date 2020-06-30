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
		
		// �Z�b�V�����̎擾(�Ȃ����null���Ԃ��Ă���)
		// �����ɏ������L�����Ă�������
		//HttpSession session = request.getSession(false); //session���ŏ��͂Ȃ�����null������ ���O�C�������ɂ��邩��false������Blogout�����Ƃ��ɂ�session���c���Ă���
		// �Z�b�V�����̔j��
		// �����ɏ������L�����Ă�������
		//if(session != null) session.invalidate();//���O�A�E�g�������̏����@���O�A�E�g���Ĕj���������Ƃ��Ɏ��s�����
		// ���O�C�����s���A���O�A�E�g���A�s�����쎞�ȊO�̏ꍇ
		if(request.getAttribute("message") == null) request.setAttribute("message", "Please enter your name or Pass ");//request�X�R�[�v����l�����o���Ă���
		//80�s�ڂ�����ł����Ƃ���message��null�łȂ�����if���͔�΂�		
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
			response.sendRedirect("http://localhost:8080/portfolio2/TopSelectServlet");
		}else {
			doGet(request, response);
		}
		

		
	}
}