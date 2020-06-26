package top;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calendarForm.SelectAll;

/**
 * Servlet implementation class Selectdb
 */
@WebServlet("/Selectdb")
public class Selectdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectAll dbAccess;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			dbAccess = new SelectAll();
			
		
		try {
			dbAccess.execute(request);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/Selectdb.jsp");
		dis.forward(request, response);
	}
	}


	

