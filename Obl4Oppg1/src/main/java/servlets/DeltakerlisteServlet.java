package servlets;

import java.io.IOException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import no.hvl.dat108.Deltaker;
import no.hvl.dat108.DeltakerDAO;

import utils.InnloggingUtil;

@WebServlet(name = "DeltakerlisteServlet", urlPatterns = "/deltakerliste")
public class DeltakerlisteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private DeltakerDAO deltakerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		if (!InnloggingUtil.erInnlogget(request)) {
			response.sendRedirect("logginn");
		} else {
			
		List<Deltaker> deltaker = deltakerDAO.hentAlleDeltakere();
		String mobil = (String) request.getSession().getAttribute("mobil");
		
		Collections.sort(deltaker, new Comparator<Deltaker>() {
			public int compare(Deltaker d1, Deltaker d2) {
				int res = d1.getEtternavn().compareToIgnoreCase(d2.getEtternavn());
				if (res!=0) 
				return res;
				return d1.getFornavn().compareToIgnoreCase(d2.getFornavn());
			}});
			
			
		
		request.setAttribute("deltaker", deltaker);
		request.setAttribute("currentDeltaker",mobil);
		
		request.getRequestDispatcher("WEB-INF/Deltagerliste.jsp").forward(request, response);
	}
	}

}
