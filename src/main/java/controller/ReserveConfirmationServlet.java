package controller;

import java.io.IOException;

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
 * Servlet implementation class ReserveConfirmationServlet
 */
@WebServlet("/reserveConfirmation")
public class ReserveConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveConfirmationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/view/reserveConfirmation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String name = request.getParameter("name");
		String reserveNum = request.getParameter("reserveNum");
		
		ReserveDao reserveDao = DaoFactory.createReserveDao();
		//引数がStringのfindByNumで1件分のデータを取得
		Reserve reserve = reserveDao.findByReserveNumAndReserveName(reserveNum, name);
		
		if(reserve != null) {
			
			//1件分の予約者情報の取得
			
			request.setAttribute("name",reserve.getName() );
			request.setAttribute("age",reserve.getAge() );
			request.setAttribute("address", reserve.getAddress());
			request.setAttribute("tell", reserve.getTell());
			request.setAttribute("email", reserve.getEmail());
			
			//reserveNumから1件分のイベント情報の取得
			EventDao eventDao = DaoFactory.createEventDao();
			Event event = eventDao.findById(reserve.getId());
			
			request.setAttribute("eventName", event.getName());
			request.setAttribute("date", event.getDate());
			request.setAttribute("place", event.getPlace());
			request.setAttribute("capacity", event.getCapacity());
			request.setAttribute("contents", event.getContents());
			
			request.getRequestDispatcher("WEB-INF/view/reserveConfirmationDone.jsp").forward(request, response);
			
		}else {
			request.setAttribute("error", true);
			request.getRequestDispatcher("/WEB-INF/view/reserveConfirmation.jsp").forward(request, response);
		}
		
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}

}
