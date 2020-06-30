package dbAccess;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import dao.Dao;
import dto.ScheduleDto;

/**
 * Servlet implementation class SelectDate
 */
@WebServlet("/SelectDate")
public class SelectDate implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {

		Dao dao = null;
		String date = null;
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		if(month.length() == 1) {
			month  = "0" + month;
		}
		
		String day = request.getParameter("day");
		
		if(!day.equals("0")) {
			date = year + "-" + month + "-" + day;
		}else {
			date = year + "-" + month;
		}
		
		
		System.out.println("date" + date);
		
		
		
		try {
			if(date != null && !date.isEmpty() ) {
				dao = new Dao();
				ArrayList<ScheduleDto> list = null;
				if(!day.equals("0")) {
					 list = dao.getItemsFromDate(date);
				}else {
					list = dao.getItemsFromMonth(date);
				}
				if(list.size() > 0) {
					request.setAttribute("list", list);
				}else {
					request.setAttribute("message", "該当するデータがありません");
				}
			}else {
				request.setAttribute("message", "入力が不正です");
			}
		}finally {
			if(dao != null) dao.close();
		}

	}

}
