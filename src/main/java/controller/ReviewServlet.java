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
			int id = Integer.parseInt(request.getParameter("eventId"));
			
			// イベント1件分の取得
			EventDao eventDao = DaoFactory.createEventDao();
			Event event = eventDao.findById(id);
			
			// レヴューリストの取得
			ReviewDao reviewDao = DaoFactory.createReviewDao();
			List<Review> reviewList = reviewDao.findByEvent(id);
			
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
		
		String name = request.getParameter("name");
		Integer evaluation = Integer.parseInt(request.getParameter("evaluation"));
		String comment = request.getParameter("comment");
		
		Review review = new Review();
		review.setName(name);
		review.setEvaluation(evaluation);
		review.setContents(comment);
		
		
		// コメントの追加
		try {
			ReviewDao reviewDao = DaoFactory.createReviewDao();
			reviewDao.insert(review);
			request.getRequestDispatcher("/WEB-INF/view/review.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
			
		}
	}

}
