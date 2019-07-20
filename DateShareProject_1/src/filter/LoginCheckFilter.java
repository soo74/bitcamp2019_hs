package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("/")
public class LoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

   /**
    * @see Filter#destroy()
    */
   public void destroy() {
      // TODO Auto-generated method stub
   }

   /**
    * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
    */
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      // TODO Auto-generated method stub
      // place your code here
      
      //조건을 주고 처리하는 부분
      
      HttpServletRequest req = (HttpServletRequest)request;
      HttpServletResponse resp = (HttpServletResponse)response;
      
      //session
      //세션을 만들건지 기존에 있는 것을 사용할것인지 false는 기존에 있는것을 사용
      HttpSession session = req.getSession(false);
      
      boolean loginChk = false;
      
      //session 안에 LoginInfo 가 있다면 true 없다면 보내줌
      if(session != null && session.getAttribute("LoginInfo") != null) {
         
         loginChk = true;
      }
      
      if(loginChk) {
         chain.doFilter(request, response);
      }else {
         //RequestDispatcher dispatcher = request.getRequestDispatcher("/0626/session/member/loginForm.jsp");
         //실행
         //dispatcher.forward(request, response);
         
         resp.sendRedirect(req.getContextPath()+"/0626/session/member/loginForm.jsp");
      }
      
      // pass the request along the filter chain
      chain.doFilter(request, response);
   }

   /**
    * @see Filter#init(FilterConfig)
    */
   public void init(FilterConfig fConfig) throws ServletException {
      // TODO Auto-generated method stub
   }

}