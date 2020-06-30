package dbAccess;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import dao.Dao;
import dto.ScheduleDto;

/**
 * Servlet implementation class SelectAll
 */
@WebServlet("/SelectAll")
public class SelectAll implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		
		Dao dao = null;
		
		try {
			dao = new Dao();
			ArrayList<ScheduleDto> list = dao.getItemsAll();
			if(list.size() > 0) {
				System.out.println("get data");
				request.setAttribute("list", list);
			}else {
				request.setAttribute("message", "まだデータがありません");
			}
		}finally {
			if(dao != null) dao.close();
		}
	}
}

