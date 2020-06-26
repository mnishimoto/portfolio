package newMen;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Dto;

/**
 * Servlet implementation class NewMen
 */
@WebServlet("/NewMen")
public class NewMen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");	
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/NewMen.jsp");
		dis.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		 Dto dto = new Dto();
		 
		 dto.setName(name);
		 dto.setPass(pass);
		 
		 
		 try {
			Dao dao = new Dao();
			
			
			if(dao.insertAccount(dto)> 0) {
				ServletContext context = getServletContext();
				RequestDispatcher dis = context.getRequestDispatcher("/Top.jsp");
				dis.forward(request, response);
				
			}else {
				doGet(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("message", "そのパスワードは使用されています");
			e.printStackTrace();
			doGet(request, response);	}

	}
}