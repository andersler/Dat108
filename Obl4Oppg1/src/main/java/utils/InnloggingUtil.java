package utils;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.Deltaker;
import no.hvl.dat108.DeltakerDAO;

import no.hvl.dat108.Validator;

public class InnloggingUtil {
	
	
	
	public static boolean erInnlogget(HttpServletRequest request ) {
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute("mobil")!=null 
				&& session.getAttribute("passord") != null;
	}
	
	public static void loggInn(HttpServletRequest request, String mobil,String passord) {

		loggUt(request);
		
		HttpSession sesjon = request.getSession();
		sesjon.setAttribute("mobil", mobil);
		sesjon.setAttribute("passord", passord);
		sesjon.setMaxInactiveInterval(45);
		
	}
	
	public static void loggUt(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		
		}
	
	public static boolean validInnlogging(String mobil,String passord) {
		Validator validator = new Validator();
		
		return validator.validMobil(mobil) && validator.validPassord(passord);
			
		
		}
		
		
	}

		
