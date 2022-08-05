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
			request.setAttribute("event", event);
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
		
		try {
			Event event = new Event();
			event.setId(id);
			
			EventDao eventDao = DaoFactory.createEventDao();
			eventDao.delete(event);
			
			//完了画面の表示（内容も）
			request.setAttribute("", response);
			request.getRequestDispatcher("/WEB-INF/view/eventDeleteDone.jsp").forward(request, response);
		
		} catch (Exception e) {
			// 
			throw new ServletException(e);
			
		}
	}

}
