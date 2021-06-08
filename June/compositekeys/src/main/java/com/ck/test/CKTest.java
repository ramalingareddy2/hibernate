package com.ck.test;

import com.ck.dao.GuarageDao;
import com.ck.entities.Guarage;

public class CKTest {
	public static void main(String[] args) {
		Guarage guarage = null;

		/*
		 * guarage = new Guarage(); guarage.setGuarageClubRegNo("CG-039333");
		 * guarage.setGuarageName("Rolls and Smith Guarage");
		 * guarage.setLocation("Hyderabad"); guarage.setProprietorName("Roll Smith");
		 * guarage.setContactNo("9389887383");
		 * guarage.setEmailAddress("roll.smith@gmail.com");
		 */

		GuarageDao dao = new GuarageDao();
		// dao.saveGuarage(guarage);
		guarage = dao.getGuarage("CG-039333", "Rolls and Smith Guarage");
		System.out.println(guarage);

	}
}
