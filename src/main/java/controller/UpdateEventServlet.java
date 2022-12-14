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
 * Servlet implementation class UpdateEventServlet
 */
@WebServlet("/updateEvent")
@MultipartConfig(location="C:/temp")
public class UpdateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEventServlet() {
        super();
        // 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// eventidを取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);
		
		
		
		try {
			//idから編集するデータを取得
			EventDao eventDao = DaoFactory.createEventDao();
			Event event = eventDao.findById(id);
			
			
			//編集ページにデータを返して表示
			request.setAttribute("name", event.getName());
			request.setAttribute("date", event.getDate());
			request.setAttribute("place", event.getPlace());
			request.setAttribute("capacity", event.getCapacity());
			request.setAttribute("contents", event.getContents());
			request.setAttribute("remarks", event.getRemarks());
			request.setAttribute("fileName", event.getFileName());
			request.getRequestDispatcher("/WEB-INF/view/eventUpdate.jsp").forward(request, response);
		
		} catch (Exception e) {
			// 
			throw new ServletException(e);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//TODOイベント更新　バリデーション
			//編集したデータの取得
			String strId = request.getParameter("id");
			Integer id = Integer.parseInt(strId);
			
			String name = request.getParameter("name");
			
			String strDate = request.getParameter("date");
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
			
						
			//ファイルの保存
			if(fileSize > 0) {
				File filePath = getUploadDirectory(request);
				part.write(filePath + "/" + fileName);
			}
			
			//DTOへ
			Event event = new Event();
			event.setId(id);
			event.setName(name);
			event.setDate(date);
			event.setPlace(place);
			event.setCapacity(capacity);
			event.setContents(contents);
			event.setRemarks(remarks);
			event.setFileName(fileName);
			
			//Daoへ
			EventDao eventDao = DaoFactory.createEventDao();
			eventDao.update(event);
			
			//完了画面表示(内容表示も)
			request.setAttribute("name", name);
			//JSPの表示用に日時の表示変更
			SimpleDateFormat sdFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			request.setAttribute("date",sdFormat2.format(date));
			request.setAttribute("place", place);
			request.setAttribute("capacity", capacity);
			request.setAttribute("contents", contents);
			request.setAttribute("remarks", remarks);
			request.getRequestDispatcher("/WEB-INF/view/eventUpdateDone.jsp").forward(request, response);
		
		} catch (Exception e) {
			
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
