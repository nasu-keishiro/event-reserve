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
import dao.ReviewDao;
import domain.Event;
import domain.Review;

/**
 * Servlet implementation class review
 */
@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id")); //eventId
			
			// イベント1件分の取得
			EventDao eventDao = DaoFactory.createEventDao();
			Event event = eventDao.findById(id);
			
			// レヴューリストの取得
			ReviewDao reviewDao = DaoFactory.createReviewDao();
			List<Review> reviewList = reviewDao.findByEvent(id);
			
			// ファイルがない場合の画像をセット
			if (event.getFileName() != null) {

			} else {
				event.setFileName("noImage.jpg");
			}
			
			request.setAttribute("eventId", event.getId());
			request.setAttribute("name", event.getName());
			request.setAttribute("date", event.getDate());
			request.setAttribute("place", event.getPlace());
			request.setAttribute("contents", event.getContents());
			request.setAttribute("fileName", event.getFileName());
			request.setAttribute("reviewList", reviewList);
			
			request.getRequestDispatcher("/WEB-INF/view/review.jsp").forward(request, response);
		;
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("eventId")); //eventId
		String name = request.getParameter("name");
		Integer evaluation = Integer.parseInt(request.getParameter("evaluation"));
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");
		
		// すでに登録してあるメールアドレスの場合(eventNumとemailが合致したときリダイレクト)
		try {
			ReviewDao reviewDao2 = DaoFactory.createReviewDao();
			Review review2 = reviewDao2.findByEmail(id, email);
			if(review2 != null) {
				
			}else {
				request.setAttribute("emailError", "すでに登録してあるメールアドレスです。");
				response.sendRedirect("review");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
				
		
		
		// 名前欄が未記入の時
		if(name.isBlank()) {
			name = "名無し";
		}
		
		Review review = new Review();
		review.setName(name);
		review.setEvaluation(evaluation);
		review.setEmail(email);
		review.setComment(comment);
		review.setEventNum(id);
		
		
		// コメントの追加
		try {
			ReviewDao reviewDao = DaoFactory.createReviewDao();
			reviewDao.insert(review);
			
		// イベント1件分の取得
			EventDao eventDao = DaoFactory.createEventDao();
			Event event = eventDao.findById(id);
			request.setAttribute("eventId", event.getId());
			request.setAttribute("name", event.getName());
			request.setAttribute("date", event.getDate());
			request.setAttribute("place", event.getPlace());
			request.setAttribute("contents", event.getContents());
			request.setAttribute("fileName", event.getFileName());
			
		// レヴューリストの取得
			List<Review> reviewList = reviewDao.findByEvent(id);
			request.setAttribute("reviewList", reviewList);
			
			request.getRequestDispatcher("/WEB-INF/view/review.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
			
		}
	}

}
