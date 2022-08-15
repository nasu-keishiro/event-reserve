package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AuthFilter() {
        super();
        // 
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// 
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//セーブレットリクエストでHTTPサーブレットのリクエスト情報をすべて取得
		HttpServletResponse res = (HttpServletResponse) response;
		//リクエストを送信（レスポンスしてあげる）
		HttpSession session = req.getSession();
		//HTTPの全てを保持
		
		String uri = req.getRequestURI();
		if(!uri.endsWith("/login")) {
          //String.EndsWith:文字列インスタンスの末尾が、
			//指定した文字列と一致するかどうかを判断
			if(session.getAttribute("loginId") == null) {
				res.sendRedirect("login");
				return;
			}
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		//この記述でフィルターを実行している
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 
	}

}
