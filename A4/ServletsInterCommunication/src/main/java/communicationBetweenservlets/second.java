package communicationBetweenservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(value = "/secondPage")
public class second extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		
		ServletContext rc = getServletContext();
		String s = (String) rc.getAttribute("username");
		PrintWriter pr = arg1.getWriter();
		pr.println("<Html><body><H2>"+s+" Welcome " + "</H2></body></Html>");
		
		
	}

}
