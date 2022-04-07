package tn.esprit.spring.services;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EntrepriseServiceImplTest {
	
	@Autowired
	IEntrepriseService es;
	
	Integer idObj;
	Integer idEntreprise;
	Integer idDepartment;
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);

	@Test
	public void testAjouterEntreprise() {
		l.debug("methode ajouterEntreprise");
		try {
			// test insert with id value
			// id value is sequence, auto incremented
			l.debug("create entreprise instance");
			Entreprise entreprise = new Entreprise("Entreprise_Devolution", "Raison_DevOps");
			l.debug("call ajouterEntreprise() with created instance");
			idObj = es.ajouterEntreprise(entreprise);
			assertNotNull(idObj);
		} catch (Exception e) {
			l.error("erreur methode ajouterEntreprise :" + e);

		}
	}

	@Test
	public void testAjouterDepartement() {
		l.debug("methode ajouterDepartement");
		try {
			// test insert with id value
			// id value is sequence, auto incremented
			l.debug("create Department instance");
			Departement dp = new Departement("testDepartmentName");
			l.debug("call ajouterDepartement() with created instance");
			idObj = es.ajouterDepartement(dp);
			assertNotNull(idObj);
		} catch (Exception e) {
			l.error("erreur methode ajouterDepartement :" + e);

		}
	}

	@Test
	public void testAffecterDepartementAEntreprise() {
		l.debug("methode AffecterDepartementAEntreprise");
		try {
			l.debug("create Entreprise instance");
			Entreprise entreprise = new Entreprise("Entreprise_test", "Raison_test");
			l.debug("call ajouterDepartement() with created instance");
			idEntreprise = es.ajouterEntreprise(entreprise);
			
			l.debug("create Department instance");
			Departement dp = new Departement("testDpName");
			l.debug("call ajouterDepartement() with created instance");
			idDepartment = es.ajouterDepartement(dp);
			
			es.affecterDepartementAEntreprise(1, 1);
		} catch (Exception e) {
			l.error("erreur methode ajouterDepartement :" + e);

		}
	}

	@Test
	public void testGetAllDepartementsNamesByEntreprise() {
		l.debug("methode GetAllDepartementNAmesByEntreprise");
		List<String> depNames = es.getAllDepartementsNamesByEntreprise(1);
		assertNotNull(depNames);
	}


}
