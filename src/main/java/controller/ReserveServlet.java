package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calculation.RamdomChar;
import dao.DaoFactory;
import dao.EventDao;
import dao.ReserveDao;
import domain.Event;
import domain.Reserve;

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
	//event,jspからクリックしたeventIdを取得
			String strEventId = request.getParameter("id");
			
			//受け取ったString型をInt型に変換
			int eventId = Integer.parseInt(strEventId);
		
			
			try {
				//eventIdからfindByIdから1つのイベント情報を取得する
				EventDao eventDao = DaoFactory.createEventDao();
				Event event = eventDao.findById(eventId);
				
				
				//１件分のイベント情報
				request.setAttribute("eventId", event.getId());
				request.setAttribute("name", event.getName());
				request.setAttribute("date", event.getDate());
				request.setAttribute("place", event.getPlace());
				request.setAttribute("contents", event.getContents());
	
	
				request.getRequestDispatcher("/WEB-INF/view/reserveForm.jsp").forward(request, response);
			} catch (Exception e) {
		
				throw new ServletException(e);
			}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 // キャッシュを無効にする
			response.setHeader("Pragma","no-cache");
			response.setHeader("Cache-Control","no-cache");
			response.setDateHeader("Expires",0);
			
			response.setContentType("text/html; charset=Shift_JIS");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>CacheServlet</title></head>");
			out.println("<body>");
			out.println("このページはキャッシュされません。");
			out.println("</body></html>");
			out.close();
		
		
		
		
		//JSPから受け取り
		try {
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		Integer age = Integer.parseInt(strAge);
		String address = request.getParameter("address");
		String strTell = request.getParameter("tell");
		Integer tell = Integer.parseInt(strTell);
		String email = request.getParameter("email");
		String id = request.getParameter("eventId"); 
		Integer reserveNum = Integer.parseInt(id);
		
		//ランダムな10文字の確認番号を生成
		RamdomChar strNum = new RamdomChar();
		String confirmationNum = strNum.getRandomString(10);
		
		//DTO
		Reserve reserve = new Reserve();
		reserve.setName(name);
		reserve.setAge(age);
		reserve.setAddress(address);
		reserve.setTell(tell);
		reserve.setEmail(email);
		reserve.setReserveNum(reserveNum);
		reserve.setConfirmationNum(confirmationNum);
		
		//Dao
		//System.out.println(reserveNum); //1が返ってきている
		ReserveDao reserveDao = DaoFactory.createReserveDao();
		reserveDao.insert(reserve);
		
		//予約完了リストに入力情報を表示
		EventDao eventDao = DaoFactory.createEventDao();
		Event event = eventDao.findById(reserveNum);
		request.setAttribute("name",name);
		request.setAttribute("age",age);
		request.setAttribute("address",address);
		request.setAttribute("tell",tell);
		request.setAttribute("email",email);
		request.setAttribute("eventName",event.getName());
		request.setAttribute("confirmationNum", confirmationNum);
		
		request.getRequestDispatcher("/WEB-INF/view/reserveDone.jsp").forward(request, response);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}

}
