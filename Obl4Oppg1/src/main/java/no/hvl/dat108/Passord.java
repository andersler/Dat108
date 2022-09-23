package no.hvl.dat108;

import javax.persistence.Embeddable;

import utils.PassordUtil;

@Embeddable
public class Passord {


		private String pwd_hash;
		private String pwd_salt;

		public Passord(String hash, String salt) {
			pwd_hash = hash;
			pwd_salt = salt;
		}

		public Passord() {
			
		}

		@Override
		public String toString() {
			return " [pwd_hash=" + pwd_hash + ", pwd_salt=" + pwd_salt + "]";
		}

		public static Passord lagPassord(String passordKlartekst) {
			String salt = PassordUtil.genererTilfeldigSalt();
			String hash = PassordUtil.hashMedSalt(passordKlartekst, salt);
			return new Passord(hash, salt);
		}

		public String getPwd_hash() {
			return pwd_hash;
		}

		public String getPwd_salt() {
			return pwd_salt;
		}

	}
