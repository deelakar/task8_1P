package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;

/**
 * HTTP end-point to handle login service.
 */
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {	
		System.out.println("[LoginServlet] GET");
		
		doPost(req, resp);
	}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String dob = req.getParameter("dob");

        boolean loginSuccessful = LoginService.login(username, password, dob);
        String loginStatus = loginSuccessful ? "Success" : "Fail";

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Login " + loginStatus + "</title>");  // Title reflects the login status
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Login " + loginStatus + "</h1>");  // Body also indicates status for visual confirmation
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }


	
}
