package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DaoFactory;
import dao.EventDao;
import domain.Event;

/**
 * Servlet implementation class AddEventServlet
 */
@WebServlet("/addEvent")
//アップロードされたファイルの一時保存場所のパス
@MultipartConfig(location="C:/Users/zd2L22/temp")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEventServlet() {
        super();
        // 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/eventAdd.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// データの受け取り
		//TODO イベント追加　バリデーション
		try {
			String name = request.getParameter("name");
		
			
			String strDate = request.getParameter("date");
			//LocalDateTimeでもできるかも
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
			Date date = sdFormat.parse(strDate);
		
			
			String place = request.getParameter("place");
			
			String strCapacity = request.getParameter("capacity");
			Integer capacity = Integer.parseInt(strCapacity);
			
			String contents = request.getParameter("contents");
			String remarks = request.getParameter("remarks");
			
			// 画像情報の取得
			Part part = request.getPart("image");
			String fileName = part.getSubmittedFileName();
			long fileSize = part.getSize();
			//System.out.println(fileName);
			
			//ファイルの保存
			if(fileSize > 0) {
				File filePath = getUploadDirectory(request);
				part.write(filePath + "/" + fileName);
				}
			
			//DTO
			Event event = new Event();
			event.setName(name);
			event.setDate(date);
			event.setPlace(place);
			event.setCapacity(capacity);
			event.setContents(contents);
			event.setRemarks(remarks);
			event.setFileName(fileName);
			
			//Dao接続
			//確認画面なし
				EventDao eventDao = DaoFactory.createEventDao();

				eventDao.insert(event);
				//イベントリストへ移動(eventListServletを通して)
				response.sendRedirect("eventList");
				
				//↓下記ではリストの情報が反映されない
				//request.getRequestDispatcher("/WEB-INF/view/eventList.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			// 
			throw new ServletException(e);
			
		}
        
        
        
        
		
		
		
	}

	private File getUploadDirectory(HttpServletRequest request) {
		// ファイルが保存されているフォルダまでのパスを取得する
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/images");
		// webapp直下のimagesに接続
		return new File(path);
		
	}

}
