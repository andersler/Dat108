package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.InnloggingUtil;


@WebServlet("/loggut")
public class LoggUtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			if (InnloggingUtil.erInnlogget(request)) {
			InnloggingUtil.loggUt(request);
			request.getRequestDispatcher("WEB-INF/Ferdig.jsp").forward(request, response);
			}
	}

}
