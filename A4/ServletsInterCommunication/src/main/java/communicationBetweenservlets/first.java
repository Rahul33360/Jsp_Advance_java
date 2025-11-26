package communicationBetweenservlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(value = "/firstPage")	// this one we are adding when index form we hit enter it will come in this location(action link) 
public class first extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String name = arg0.getParameter("us");
		ServletContext rc = getServletContext();
		rc.setAttribute("username", name);
		arg0.getRequestDispatcher("secondPage").forward(arg0, arg1);// here it will redirect to second servlet page and those code will run and fetch the values from the context.
		
	}

}
