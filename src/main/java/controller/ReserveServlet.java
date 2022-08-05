package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReserveServlet
 */
@WebServlet("/reserve")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		response.getWriter().append("Served at: ").append(request.getContextPath());
	request.getRequestDispatcher("/WEB-INF/view/reserve.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("name");
		request.getParameter("age");
		request.getParameter("address");
		request.getParameter("tell");
		request.getParameter("email");
		request.getParameter(""); //イベントIdをここに入れる
		
		/**
		 * domain型に入れてDaoに入れ込み
		 * Member member = new Member();
		 * member.setName(name);
		 * member.setAge(age);
		 * member.setAddress(address);
		 * member.setTell(tell);
		 * member.setEmail(email);
		 * member.setEventId(eventId);
		 * 
		 * 
		 * EventDao eventDao = DaoFactory.createReserveDao();
		 */
		
		request.getRequestDispatcher("/WEB-INF/view/reserveDone.jsp").forward(request, response);
	}

}
