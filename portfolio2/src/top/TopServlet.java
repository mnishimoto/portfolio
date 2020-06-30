package top;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TopServlet
 */
@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = request.getParameter("btn");
		String next = null;
		
		if(btn != null) {
			switch (btn) {
			case "select":
				next = "Selectdb";
				break;
			default:
				next = "Selectdb.jsp";
				break;
			}
		}else {
			next = "Selectdb.jsp";
		}
		Calendar cal = Calendar.getInstance();
		request.setAttribute("year", cal.get(Calendar.YEAR));
		request.setAttribute("month", cal.get(Calendar.MONTH)+1);
		request.setAttribute("day", cal.get(Calendar.DATE));
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/" + next);
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
