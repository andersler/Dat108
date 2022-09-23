package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeltakerDAO {

	@PersistenceContext(name = "oblig4DB")
	private EntityManager em;

	public List<Deltaker> hentAlleDeltakere() {
		return em.createQuery("SELECT d FROM Deltaker d", Deltaker.class).getResultList();
	}
	
	public Deltaker hentDeltaker(String mobil) {
		return em.find(Deltaker.class, mobil);
	}

	public void lagreNyDeltaker(Deltaker nyDeltaker) {
		em.persist(nyDeltaker);
	}
}
