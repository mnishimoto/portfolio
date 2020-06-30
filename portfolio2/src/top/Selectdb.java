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

import dbAccess.DBAccess;
import dbAccess.SelectAll;
import dbAccess.SelectDate;
import dbAccess.SelectSchedule;




/**
 * Servlet implementation class Selectdb
 */
@WebServlet("/Selectdb")
public class Selectdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DBAccess dbAccess;
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectWay = request.getParameter("selectWay");
		
		switch (selectWay){
		case "name":
			dbAccess = new SelectDate();
			break;
		case "all":
			dbAccess = new SelectAll();
			break;
		case "schedule":
			dbAccess = new SelectSchedule();
			break;
		}
		
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



	

