package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.LoginDao;
import domain.Admin;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String loginId = request.getParameter("loginId");
			String loginPass = request.getParameter("loginPass");
			LoginDao loginDao = DaoFactory.createLoginDao();
			Admin admin = loginDao.findByLoginIdAndLoginPass(loginId, loginPass);
			
			if(admin != null) {
				//データ保持
				request.getSession().setAttribute("loginId",admin.getLoginId());
				//リダイレクト
				response.sendRedirect("eventList");
				
			}else {
				request.setAttribute("error",true);
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
