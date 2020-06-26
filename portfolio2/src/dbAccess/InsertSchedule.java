package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dto.ScheduleDto;

public class InsertSchedule implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		
		
		Dao dao = null;
		int n = 0;
		
		HttpSession session = request.getSession(false);
		String date = (String) session.getAttribute("date");
		
		String schedule = request.getParameter("schedule");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		System.out.println(schedule);
		System.out.println(start);
		System.out.println(end);
		System.out.println(date);
		
		ScheduleDto s = new ScheduleDto();
		s.setschedule(schedule);
		s.setStart(Integer.parseInt(start));
		s.setEnd(Integer.parseInt(end));
		s.setDate((String) session.getAttribute("date"));
		
		
		
		
		try {
			dao = new Dao();
			n = dao.insertSchedule(s);

			if(n > 0) {
				request.setAttribute("flag", true);
			}else {
				request.setAttribute("flag", false);
			}
		}finally {
			if(dao != null) dao.close();
		}
	}

}
