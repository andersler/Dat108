package servlets;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.Deltaker;
import no.hvl.dat108.DeltakerDAO;
import no.hvl.dat108.SkjemaBean;
import utils.InnloggingUtil;
import utils.PassordUtil;

@WebServlet(name = "LogginnServlet", urlPatterns = "/logginn")
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltakerDAO deltakerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String errorCode = request.getParameter("error");
		String melding = "";

		if (errorCode != null && errorCode.equals("invaliduser")) {
			melding = "Ugyldig brukernavn og/eller passord";
		}

		request.setAttribute("melding", melding);
		request.getRequestDispatcher("WEB-INF/Logginn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SkjemaBean skjema = new SkjemaBean(request);
		String mobil = skjema.getMobil();
		String passord = skjema.getPassord();

		Deltaker deltaker = deltakerDAO.hentDeltaker(mobil);
		

			if (!InnloggingUtil.validInnlogging(mobil, passord)) {

				response.sendRedirect("logginn" + "?error=invaliduser");

			} else if (deltaker == null) {
				response.sendRedirect("logginn" + "?error=invaliduser");

			} else if (deltaker != null && PassordUtil.validerMedSalt(passord, deltaker.getPassord().getPwd_salt(),
					deltaker.getPassord().getPwd_hash()) == false) {

				response.sendRedirect("logginn" + "?error=invaliduser");

			} else if (deltaker != null && PassordUtil.validerMedSalt(passord, deltaker.getPassord().getPwd_salt(),
					deltaker.getPassord().getPwd_hash()) == true) {

				InnloggingUtil.loggUt(request);
				InnloggingUtil.loggInn(request,mobil,passord);
				response.sendRedirect("deltakerliste");
				
			}
		
	}
}
