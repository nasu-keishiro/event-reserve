package controller;

import java.io.IOException;
import java.time.YearMonth;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.EventDao;
import domain.Event;

/**
 * Servlet implementation class EventServlet
 */
@WebServlet("/event")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//今月のイベント情報を表示する
		
		//今月の”月”情報を取得する
		YearMonth today = YearMonth.now();
		//System.out.println(today2); //2022-08が入る
		String month = String.valueOf(today);
		//String sample = Integer.toString(today); int型からだと変換できるが…
	
		//イベントDaoに”月”情報を渡して、データを取得する
		try {
		EventDao eventDao = DaoFactory.createEventDao();
		List<Event> eventList;
		eventList = eventDao.findByMonth(month);
		request.setAttribute("eventMonthList", eventList);
		request.getRequestDispatcher("/WEB-INF/view/event.jsp").forward(request,response);
		
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	    
	    
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
