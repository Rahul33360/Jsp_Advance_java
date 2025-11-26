package communicationUsingSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/first")
public class first extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter p =  resp.getWriter();
		Random r = new Random();
//		ServletContext sc = getServletContext();
		HttpSession sc = req.getSession();
		String cap = r.nextInt(9)+"" + r.nextInt(9)+"" +r.nextInt(9)+""+r.nextInt(9);
		sc.setAttribute("OriginalCap", cap);
		
		p.println("<html><body><h1>"+cap+"</h1>"
				+ "<form action='second' method='post'>"
				+ "		<label>Enter the Captcha : </label><input type='text' name ='cap'>"
				+ "		<input type='submit'>"
				+ "	</form>"
				+"</body></html>");		
	}
}
