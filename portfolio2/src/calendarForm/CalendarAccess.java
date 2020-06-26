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
        //  �t�H���[�h�ɂ��y�[�W�J��
        dispatcher.forward(request, response);
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
    //  ���M�p�̃f�[�^�̍쐬
    private void prepData(HttpServletRequest request){
        //  �J�����_�[�̎擾
        Calendar cal = Calendar.getInstance();
        //  �N���ݒ肳��Ă���΁A���̒l���擾�B�����łȂ���΁A���N�̔N��������
        if(request.getParameter("year")==null){
            request.setAttribute("year", cal.get(Calendar.YEAR));   //  ���݂̔N
 
        }else{
            request.setAttribute("year", request.getParameter("year")); //  ���݂̔N
        }
        if(request.getParameter("month")==null){
            request.setAttribute("month", cal.get(Calendar.MONTH)+1);   //  ���݂̌�
        }else{
            request.setAttribute("month", request.getParameter("month"));   //  �^�����ꂽ��
        }
        int year = Integer.parseInt(request.getAttribute("year").toString());
        int month = Integer.parseInt(request.getAttribute("month").toString());
        // �����߂̗j��(��-> 1)
        cal.set(year, month - 1, 1);
        // �����̓��t
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        
    }
 
}