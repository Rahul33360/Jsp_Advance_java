package communicationUsingSession;

import java.io.IOException;
import java.io.PrintWriter;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/second")
public class second extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ServletContext sc = getServletContext();
		PrintWriter p =  resp.getWriter();
//		HttpSession sc = req.getSession();
		Cookie[] c = req.getCookies();
//		String ocap = (String) sc.getAttribute("OriginalCap");
		String ocap = c[0].getValue();
		String s = req.getParameter("cap");
//		System.out.println(s);
		
		if(s.equals(ocap)) {
			p.println("<html><body><h2>Welcome</h2></body></html>");
		}
		
		else {
			req.setAttribute("result", "failed");
			req.getRequestDispatcher("first").forward(req, resp);
			
//			req.getRequestDispatcher("first").include(req, resp);
//			p.println("<html><body><h2>IncorrectCaptcha</h2></body></html>");
		}
		
	}
}
