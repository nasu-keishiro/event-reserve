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
import domain.Event;

/**
 * Servlet implementation class EventListServlet
 */
@WebServlet("/eventList")
public class EventListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventListServlet() {
        super();
        // 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			//ページの読み込み直しで月ごとに表示させる
			EventDao eventDao = DaoFactory.createEventDao();
			List<Event> eventList;

			
			// GETパラメータとして月を取得
			String month = request.getParameter("month");
			//System.out.println(month);  2022-08が返される
			
			// GETパラメータあり→findByMonth()
			// Getパラメータなし→findAll
			if(month != null) {
			    eventList = eventDao.findByMonth(month);
			    
			    int i = 0;
			    while(eventList.size() > i) {
			  //リスト型からIdを取得
			  Event event = eventList.get(i);
			  //event型の一つのまとまり(id name address...)がi番目の配列のまとまりとして取り出し
			  //その中のIdを取得している↓
			  int eventId =event.getId();
			    
			  //残り予約数を取得
			  Capacity capa = new Capacity();
			  Integer remaining = capa.getRemaining(eventId);
		      //リスト型にremainingを上書き
		      event.setRemaining(remaining);
		      
		      i++;
		      }
			  
			}else {
				// TODO 絞り込んで直近の7件のイベントを表示
				// streamAPIで並び替えて絞る
			    eventList = eventDao.findAll();	
			    
			}
			
			// jsp用にセット
			request.setAttribute("eventList",eventList );
			request.getRequestDispatcher("/WEB-INF/view/eventList.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
