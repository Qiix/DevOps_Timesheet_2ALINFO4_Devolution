package tn.esprit.spring.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.controller.IControllerEmployeImpl;
import tn.esprit.spring.controller.IControllerEntrepriseImpl;
import tn.esprit.spring.controller.RestControlEmploye;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetServiceImplTest {
	@Autowired
	IControllerEntrepriseImpl entrepriseControl;
	@Autowired
	IControllerEmployeImpl employeControl;
	@Autowired
	RestControlEmploye RestemployeControl;
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	ITimesheetService iTimesheetService;
	
	private static final Logger l = LogManager.getLogger(TimesheetServiceImplTest.class);
	
	@Test
	public void testAjouterMission() {
		l.info("methode ajouter mission");
		try {
			Mission mission = new Mission();
			mission.setName("devops");
		    mission.setDescription("devops");
			int m=iTimesheetService.ajouterMission(mission);
			System.out.println(m);
			l.debug("mission ajoutée");
			assertThat(m!=0);
			assertNotSame(m,0);
		} catch (Exception e) {
			l.error("erreur methode ajouter mission");
		}
		l.info("out methode ajouter mission");
	}
	
	@Test
	public void testAffecterMissionADepartement() {
		l.info("methode affecter mission a departement");
		Mission mission0 = new Mission("devops","devops");
		Departement departement0 = new Departement("recherche");
		try {
			Mission mission = missionRepository.findById(1).orElse(mission0);
			Departement dept = deptRepoistory.findById(1).orElse(departement0);
			l.debug(dept.getId()+ "-----------------------------------------------------------------------------");
			deptRepoistory.save(dept);
			l.debug(dept.getId()+ "-----------------------------------------------------------------------------");

			List<Mission> listmission =new ArrayList<>();
			listmission.add(mission);
			dept.setMissions(listmission);
			l.debug("after save misssion in dept"+ "-----------------------------------------------------------------------------");
			mission.setDepartement(dept);
			l.debug("departement affecté");
			missionRepository.save(mission);
			assertNotNull(mission.getDepartement());
			assertThat(mission.getId() != 0);
			assertNotSame(mission.getId(),0);
		}catch(Exception e) {
			l.error("erreur affecter mission a departement");
		}
		l.info(" out methode affecter mission a departement");
	}
	
	@Test
	public void testAjouterTimesheet() {
		l.info("in methode AjouterTimesheet");
		Mission mission = new Mission();
		mission.setName("test");
	    mission.setDescription("test");
	    l.info("debut ajouter mission");
	    int m=1;
	    try {
	    	m=iTimesheetService.ajouterMission(mission);
	    } catch(Exception r) {
	    	l.error("mission not saved ");
	    }
		
		l.info("fin ajouter mission");
		
		Employe e=new Employe();
		e.setEmail("hello@eprit.tn");
		e.setNom("hello");
		e.setPrenom("helo");
		e.setRole(Role.INGENIEUR);
		Employe emp;
		try {
			emp=employeRepository.save(e);
		} catch(Exception f) {
			l.error("error");
		}
		
		Date date1=new Date();
		Date date2=new Date(2/2/2022);
		TimesheetPK timesheetPK = new TimesheetPK(m,e.getId(),date2,date1);
		Timesheet timesheet = new Timesheet();
		timesheet.setTimesheetPK(timesheetPK);
		timesheet.setValide(false);
		try {
			timesheetRepository.save(timesheet);
			assertNotNull(timesheet.getTimesheetPK());
		} catch(Exception s) {
			l.error("timesheet not saved");
		}
		
		
		l.debug("timesheet saved successfully");
		l.info("out methode AjouterTimesheet");
	}
	
	@Test
	public void testfindAllMissionByEmployeJPQL() {
		l.info("in methode findAllMissionByEmployeJPQL");
		int id=1;
		try {
			List<Mission> listMissions=timesheetRepository.findAllMissionByEmployeJPQL(id);
			l.info(listMissions.isEmpty());
			assertNotNull(listMissions);
			assertThat(!listMissions.isEmpty());
		} catch(Exception e) {
			l.error("could not find all missions");
		}
		l.info("out methode findAllMissionByEmployeJPQL");
	}
	
	@Test
	public void testgetAllEmployeByMission() {
		l.info("in methode getAllEmployeByMission");
		int id=1;
		try {
			List<Employe> listEmpl=timesheetRepository.getAllEmployeByMission(id);
			assertNotNull(listEmpl);
			assertThat(!listEmpl.isEmpty());
			l.info(listEmpl);
		} catch(Exception e) {
			l.error("could not get list employes");
		}
		
		l.info("in methode getAllEmployeByMission");
	}
}
