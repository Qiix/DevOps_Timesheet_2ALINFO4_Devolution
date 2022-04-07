package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	
	private static final Logger l = Logger.getLogger(EntrepriseServiceImpl.class);
	
	public Integer ajouterEntreprise(Entreprise entreprise) {
		l.debug("methode ajouterEntreprise");
		try {
		entrepriseRepoistory.save(entreprise);
		l.info("entreprise ajoutée avec id = "+entreprise.getId());
		return entreprise.getId();
		} catch (Exception e) {
		       l.error("erreur methode ajouterEntreprise :" +e);	
		       return null;       
				}
	}

	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		Entreprise entreprise = entrepriseRepoistory.findById(entrepriseId).orElse(null);
		Departement dep = deptRepoistory.findById(depId).orElse(null);
		if (dep!=null){
			dep.setEntreprise(entreprise);
			deptRepoistory.save(dep);
		}
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		l.debug("methode getAllDepartementsNamesByEntreprise ");
		List<String> depNames = new ArrayList<String>();
		try {
			Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(null);
			
			if(entrepriseManagedEntity!=null && entrepriseManagedEntity.getDepartements()!=null){
			for(Departement dep : entrepriseManagedEntity.getDepartements()){
				depNames.add(dep.getName());
			}
			l.debug("getAllDepartementsNamesByEntreprise fini avec succes ");
			return depNames;
			}
			else {
				l.error("erreur methode getAllDepartementsNamesByEntreprise : " );
				return depNames;
			}
		} catch (Exception e) {
			l.error("erreur methode getAllDepartementsNamesByEntreprise : " +e);
			return depNames;
		}
	}

	@Transactional
	public int deleteEntrepriseById(int entrepriseId) {
		l.debug("methode deleteEntrepriseById ");
		try {
			Optional<Entreprise> Optentrp = entrepriseRepoistory.findById(entrepriseId);
			if(Optentrp.isPresent()){
			Entreprise entrp = Optentrp.get();
			entrepriseRepoistory.delete(entrp);
			l.debug("deleteEntrepriseById fini avec succes ");
			return 0;}
			else {
				l.error("erreur methode deleteEntrepriseById : " );
				return -1;
			}
		} catch (Exception e) {
			l.error("erreur methode deleteEntrepriseById : " +e);
			return -1;
		}
	}

	@Transactional
	public int deleteDepartementById(int depId) {
		l.debug("methode deleteDepartementById ");
		try {
			Optional<Departement> Optdep = deptRepoistory.findById(depId);
			if(Optdep.isPresent()){
				Departement dp = Optdep.get();
				deptRepoistory.delete(dp);
			l.debug("deleteDepartementById fini avec succes ");
			return 0;}
			else {
				l.error("erreur methode deleteDepartementById : " );
				return -1;
			}
		} catch (Exception e) {
			l.error("erreur methode deleteDepartementById : " +e);
			return -1;
		}
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		l.debug("methode getEntrepriseById ");
		try {
			Entreprise et= entrepriseRepoistory.findById(entrepriseId).orElse(null);
			l.debug("getEntrepriseById fini avec succes ");
			return et;
		} catch (Exception e) {
			l.error("erreur methode getEntrepriseById : " +e);
			return null;
		}
	}

}
