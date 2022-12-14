package controller;

import java.io.IOException;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
		//
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ページの読み込み直しで月ごとに表示させる
		EventDao eventDao = DaoFactory.createEventDao();
		List<Event> eventList;

		// Jspから月データを取得
		String month = request.getParameter("month");
		// GETパラメータあり→findByMonth()
		// GETパラメータなし→今月のデータ取得→findByMonth()

		try {
			// イベントDaoに”月”情報を渡して、データを取得する
			if (month != null) {
				eventList = eventDao.findByMonth(month);

			} else {
				// 今月のイベント情報を表示する
				YearMonth today = YearMonth.now();
				// 今月の”月”情報を取得する
				month = String.valueOf(today);
				// System.out.println(today2); //2022-08が入る
				// String sample = Integer.toString(today); int型からだと変換できるが…
				eventList = eventDao.findByMonth(month);
			}

//		System.out.println("-----------------");
//		eventList.forEach(e -> System.out.println(e.getFileName()));

			int i = 0;
			while (eventList.size() > i) {
				// リスト型からIdを取得
				Event event = eventList.get(i);
				int eventId = event.getId();
				// 残り予約数を取得
				Capacity capa = new Capacity();
				Integer remaining = capa.getRemaining(eventId);
				// リスト型にremainingを上書き
				event.setRemaining(remaining);

				if (event.getFileName() != null) {

				} else {
					event.setFileName("noImage.jpg");
				}

				i++;

			}
			
			//System.out.println(eventList.get(0).getDate()); //リスト型の一部だけを取り出す
			
			// 日付で並び替え
			eventList = eventList.stream()
	    			.sorted(Comparator.comparing(Event::getDate))
	    			.collect(Collectors.toList());
			
			// 使わず
			// JSPにeventListの受け渡し(jackson)
			//ObjectMapper mapper = new ObjectMapper();
			//String result = mapper.writeValueAsString(eventList);
			//request.setAttribute("scrEventList", result);
			
			

			request.setAttribute("eventMonthList", eventList);
			request.getRequestDispatcher("/WEB-INF/view/event.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		doGet(request, response);
	}

}
