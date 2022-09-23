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
import no.hvl.dat108.Passord;
import no.hvl.dat108.SkjemaBean;
import utils.InnloggingUtil;
import utils.PassordUtil;

@WebServlet(name = "PaameldingsServlet", urlPatterns = "/skjema")
public class SkjemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltakerDAO deltakerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String deltakerSjekk = request.getParameter("nyDeltaker");
		String melding = "";
		
		if (deltakerSjekk!=null && deltakerSjekk.equals("eksisterer")) {
			melding = "Hver deltaker må ha ett unikt mobilnummer!";
		} 
		
		request.setAttribute("melding", melding);
		request.getRequestDispatcher("WEB-INF/Paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SkjemaBean skjemaBean = new SkjemaBean(request);
		
		String fornavn = skjemaBean.getFornavn();
		String etternavn = skjemaBean.getEtternavn();
		String mobil = skjemaBean.getMobil();
		String passord = skjemaBean.getPassord();
		String kjonn = skjemaBean.getKjonn();

		String salt = PassordUtil.genererTilfeldigSalt();
		String hashMedSalt = PassordUtil.hashMedSalt(passord, salt);
		Deltaker deltaker = deltakerDAO.hentDeltaker(mobil);

		if (skjemaBean.isAllInputGyldig()) {

			if (deltaker != null) {
				response.sendRedirect("skjema" + "?nyDeltaker=eksisterer");
			} else if (deltaker == null) {
				if (PassordUtil.validerMedSalt(passord, salt, hashMedSalt) == true) {	
				Passord nyttPassord = new Passord(hashMedSalt, salt);
				Deltaker nyDeltaker = new Deltaker(fornavn, etternavn, mobil, nyttPassord, kjonn);
				
				deltakerDAO.lagreNyDeltaker(nyDeltaker);
				request.getSession().removeAttribute("skjema");
				
				InnloggingUtil.loggUt(request);
				InnloggingUtil.loggInn(request, mobil, passord);
				
				request.getSession().setAttribute("deltaker",skjemaBean);
				response.sendRedirect("bekreftelse");
				}
			}
		} else {

			
			skjemaBean.settOppFeilmeldinger();

			request.getSession().setAttribute("bean", skjemaBean);
			response.sendRedirect("skjema");
		}
	}
}
