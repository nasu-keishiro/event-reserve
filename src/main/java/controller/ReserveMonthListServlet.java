package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calculation.Capacity;
import dao.DaoFactory;
import dao.EventDao;
import dao.ReserveDao;
import domain.Event;
import domain.Reserve;

/**
 * Servlet implementation class ReserveListServlet
 */
@WebServlet("/reserveMonthList")
public class ReserveMonthListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveMonthListServlet() {
        super();
        // 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//eventListからクリックしたeventIdを取得
		String strEventId = request.getParameter("id");
		
		//受け取ったString型をInt型に変換
		int eventId = Integer.parseInt(strEventId);
	
		//残り予約の取得
		Capacity capa = new Capacity();
		int remaining = capa.getRemaining(eventId);
		
		try {
			//eventIdからfindByIdから1つのイベント情報を取得する
			EventDao eventDao = DaoFactory.createEventDao();
			Event event = eventDao.findById(eventId);
			
			
			
			ReserveDao reserveDao = DaoFactory.createReserveDao();
			List<Reserve> reserveMonth = reserveDao.findByReserveNum(eventId);
			
			//１件分のイベント情報
			request.setAttribute("name", event.getName());
			request.setAttribute("date", event.getDate());
			request.setAttribute("place", event.getPlace());
			request.setAttribute("capacity", event.getCapacity());
			request.setAttribute("remarks", event.getRemarks());
			//request.setAttribute("event_name", event.());
			request.setAttribute("remaining", remaining);
			
			//予約者リスト
			request.setAttribute("reserveMonth", reserveMonth);
			
			request.getRequestDispatcher("/WEB-INF/view/reserveMonthList.jsp").forward(request, response);
		
		} catch (Exception e) {
			
		throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		doGet(request, response);
	}

}
