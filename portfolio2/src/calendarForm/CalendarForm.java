package calendarForm;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalendarForm
 */
@WebServlet("/CalendarForm")
public class CalendarForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalendarForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		prepData(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("calendarForm.jsp");
		// フォワードによるページ遷移
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	// 送信用のデータの作成
	private void prepData(HttpServletRequest request) {
		// 変数初期化
		int startday;
		int lastday;
		// カレンダーの取得
		Calendar cal = Calendar.getInstance();

		HttpSession session = request.getSession(true);
		// 年が設定されていれば、その値を取得。そうでなければ、今年の年号を入れる
		if (request.getParameter("year") == null) {
			session.setAttribute("year", cal.get(Calendar.YEAR)); // 現在の年

		} else {
			session.setAttribute("year", request.getParameter("year")); // 現在の年
		}
		if (request.getParameter("month") == null) {
			session.setAttribute("month", cal.get(Calendar.MONTH) + 1); // 現在の月
		} else {
			session.setAttribute("month", request.getParameter("month")); // 与えらられた月
		}

		int year = Integer.parseInt(session.getAttribute("year").toString());
		int month = Integer.parseInt(session.getAttribute("month").toString());
		// 月初めの曜日(日-> 1)
		cal.set(year, month - 1, 1);
		startday = cal.get(Calendar.DAY_OF_WEEK);
		// 月末の日付
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		lastday = cal.get(Calendar.DATE);
		// カレンダーのデータを作成する
		int date = 1;
		int maxday = 6 * 7;
		StringBuilder sb = new StringBuilder();
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<th >Sun</th>");
		sb.append("<th>Mon</th><th>Tue</th><th>Wed</th><th>Thu</th><th>Fri</th>");
		sb.append("<th>Sta</th>");
		sb.append("</tr>");
		sb.append("<tr>");
		for (int num = 1; num <= maxday; num++) {
			if (num < startday || num > lastday + startday - 1) {
				sb.append("<td></td>");
			} else {
				sb.append("<td><form action=\"Test\" method=\"get\"><input type=\"submit\" name=\"day\" value=\""
						+ date + "\"></form></td>");
				date++;
			}
			if (num % 7 == 0) {
				sb.append("</tr>");
				if (num > startday + lastday - 1) {
					break;
				}
				if (date < lastday) {
					sb.append("<tr>");
				} else {
					// 最後だったら、ループから抜ける
					break;
				}
			}
		}
		sb.append("</table>");
		// パラメータを設定
		session.setAttribute("calender", sb);
		return;
	}

}