package calendarForm;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalendarAccess
 */
@WebServlet("/CalendarAccess")
public class CalendarAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarAccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        prepData(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        //  フォワードによるページ遷移
        dispatcher.forward(request, response);
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
    //  送信用のデータの作成
    private void prepData(HttpServletRequest request){
        //  カレンダーの取得
        Calendar cal = Calendar.getInstance();
        //  年が設定されていれば、その値を取得。そうでなければ、今年の年号を入れる
        if(request.getParameter("year")==null){
            request.setAttribute("year", cal.get(Calendar.YEAR));   //  現在の年
 
        }else{
            request.setAttribute("year", request.getParameter("year")); //  現在の年
        }
        if(request.getParameter("month")==null){
            request.setAttribute("month", cal.get(Calendar.MONTH)+1);   //  現在の月
        }else{
            request.setAttribute("month", request.getParameter("month"));   //  与えらられた月
        }
        int year = Integer.parseInt(request.getAttribute("year").toString());
        int month = Integer.parseInt(request.getAttribute("month").toString());
        // 月初めの曜日(日-> 1)
        cal.set(year, month - 1, 1);
        // 月末の日付
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        
    }
 
}