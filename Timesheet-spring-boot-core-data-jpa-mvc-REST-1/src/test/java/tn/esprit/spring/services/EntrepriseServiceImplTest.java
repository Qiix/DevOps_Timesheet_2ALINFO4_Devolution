package tn.esprit.spring.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Entreprise;

public class EntrepriseServiceImplTest {
	
	@Autowired
	IEntrepriseService es;

	@Test
	public void testAjouterEntreprise() {
		Entreprise entreprise = new Entreprise("Devolution","DevOps");
		// test insert with id value
		// id value is sequence, auto incremented
		//assertEquals(1,es.ajouterEntreprise(entreprise));
	}

	@Test
	public void testAjouterDepartement() {
		//fail("Not yet implemented");
	}

	@Test
	public void testAffecterDepartementAEntreprise() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAllDepartementsNamesByEntreprise() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteEntrepriseById() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteDepartementById() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetEntrepriseById() {
		//fail("Not yet implemented");
	}

}
