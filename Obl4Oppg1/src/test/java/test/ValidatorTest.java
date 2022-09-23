package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import no.hvl.dat108.Validator;

public class ValidatorTest {

	private Validator validator;

	private String fornavn = "Per";
	private String etternavn = "Pattle";
	private String mobil = "99882244";
	private String passord = "pwd123";

	@BeforeEach
	public void setup() {
		validator = new Validator();
	}

	@Test
	public void isValidNavn() {
		try {

			assertTrue("Validering av fornavn " , validator.validForNavn(this.fornavn));
			assertTrue("Validering av etternavn" , validator.validEtterNavn(this.etternavn));

		
	} catch (Exception e) {
			fail("Noe gikk galt " + e.getMessage());
		}
	}

	@Test
	public void isValidMobil() {
		try {

		assertTrue("Validering av mobil ", validator.validMobil(this.mobil));
		} catch (Exception e) {
			fail("Noe gikk galt " + e.getMessage());
		}

	}

	@Test
	public void isValidPassord() {
		try {
			assertTrue("Validering av passord ",validator.validPassord(this.passord));
		} catch (Exception e) {
			fail("Noe gikk galt " + e.getMessage());
		}
	}

}
