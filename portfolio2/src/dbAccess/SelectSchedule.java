package dbAccess;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;
import dto.ScheduleDto;

public class SelectSchedule implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		Dao dao = null;
		String schedule = request.getParameter("schedule");
		System.out.println(schedule);
		
		try {
			if(schedule != null && !schedule.isEmpty() ) {
				dao = new Dao();
				ArrayList<ScheduleDto> list = dao.getItemsFromSchedule(schedule);
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
