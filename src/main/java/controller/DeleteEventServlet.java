package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.EventDao;
import dao.ReserveDao;
import domain.Event;
import domain.Reserve;

/**
 * Servlet implementation class DeleteEventServlet
 */
@WebServlet("/deleteEvent")
public class DeleteEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//イベントIdの取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);
		
		try {
			EventDao eventDao = DaoFactory.createEventDao();
			Event event = eventDao.findById(id);
			
			ReserveDao reserveDao = DaoFactory.createReserveDao();
			List<Reserve> reserveList = reserveDao.findByReserveNum(id);
			
			
			//イベント情報、予約者リストも表示させる
			request.setAttribute("id",event.getId());
			request.setAttribute("name",event.getName());
			request.setAttribute("date",event.getDate());
			request.setAttribute("place",event.getPlace());
			request.setAttribute("capacity",event.getCapacity());
			request.setAttribute("contents",event.getContents() );
			request.setAttribute("remarks",event.getRemarks());
			request.setAttribute("reserveList", reserveList);
			request.getRequestDispatcher("WEB-INF/view/eventDelete.jsp").forward(request, response);
		
		} catch (Exception e) {
			// 
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//イベントIdの取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);
		
		EventDao eventDao = DaoFactory.createEventDao();
		Event event = new Event();
				
		
		try {
			//削除の前に、完了画面表示用に、Idからデータを持ってきて先にセット
			Event event1 = eventDao.findById(id);
			request.setAttribute("name",event1.getName());
			request.setAttribute("date",event1.getDate());
			request.setAttribute("place",event1.getPlace());
			request.setAttribute("capacity",event1.getCapacity());
			request.setAttribute("contents",event1.getContents() );
			request.setAttribute("remarks",event1.getRemarks());
		} catch (Exception e1) {
			
			throw new ServletException(e1);
		}
		
		
		
		try {
			//Idからイベント削除
			event.setId(id);
			eventDao.delete(event);
			
			request.getRequestDispatcher("/WEB-INF/view/eventDeleteDone.jsp").forward(request, response);
		
		} catch (Exception e) {
			// 
			throw new ServletException(e);
			
		}
	}

}
