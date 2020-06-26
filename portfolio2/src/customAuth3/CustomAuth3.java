package customAuth3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomAuth3
 */
@SuppressWarnings("serial")
@WebServlet("/CustomAuth3")
public class CustomAuth3 extends HttpServlet {
	  @SuppressWarnings("unused")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException{

	    response.setContentType("text/html; charset=utf-8");
	    PrintWriter out = response.getWriter();

	    String target = request.getRequestURI();

	    HttpSession session = request.getSession(false);

	    if (session == null){
	      /* Ç‹ÇæîFèÿÇ≥ÇÍÇƒÇ¢Ç»Ç¢ */
	      session = request.getSession(true);
	      session.setAttribute("target", target);

	      response.sendRedirect("http://localhost:8080/portfolio2/LoginServlet");
	    }else{
	      Object loginCheck = session.getAttribute("login");
	      if (loginCheck == null){
	        /* Ç‹ÇæîFèÿÇ≥ÇÍÇƒÇ¢Ç»Ç¢ */
	        session.setAttribute("target", target);
	        response.sendRedirect("http://localhost:8080/portfolio2/LoginServlet");
	      }
	    }

	  }
	}