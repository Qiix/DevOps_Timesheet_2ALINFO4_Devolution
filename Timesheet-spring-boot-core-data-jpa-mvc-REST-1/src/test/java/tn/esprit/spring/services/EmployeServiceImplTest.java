package tn.esprit.spring.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.SimpleDateFormat;
import java.util.Date;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= tn.esprit.spring.TimesheetSpringBootCoreDataJpaMvcRest1Application.class)

public class EmployeServiceImplTest {
	private static final Logger l = LogManager.getLogger(EmployeServiceImplTest.class);
	
	@Autowired
	IEmployeService emp;

	
    @Test
	public void TestmettreAjourEmailByEmployeId()
	{
    	l.info("Start The test for the method / INFO");
    	try {
		emp.mettreAjourEmailByEmployeId("MettreAjour@gmailcom",1);
    	}
    	catch (Exception e)
    	{
    		l.error("Test failed /ERROR"+e);
    	}
	}
	
	@Test
	public void TestajouterEmploye()
	{ 
		l.info("Start The test for the method / INFO");
		try
		{
			Employe e = new Employe("Chayma","Jlassi","testemail@gmail.com",true,Role.INGENIEUR);
			emp.ajouterEmploye(e);
		}
		catch (Exception e)
		{
			 l.error("Test failed /ERROR"+e);
		}
	
	}
	

   @Test
	public void TestaffecterEmployeADepartement()
	{
	   l.info("Start The test for the method / INFO");
	   try
	   {
	   emp.affecterEmployeADepartement(1,1);
	   }
	   catch(Exception e) 
	   {
	   l.error("Test failed /ERROR"+e);
	   }
	}
	
	@Test
	public void TestdesaffecterEmployeDuDepartement()
	{
		l.info("Start The test for the method / INFO");
		try {
		emp.desaffecterEmployeDuDepartement(1,1);
		}
		catch (Exception e)
		{
	    l.error("Test failed /ERROR"+e);	
		}
	}
	
   @Test
	public void TestajouterContrat() 
	{
	   l.info("Start The test for the method / INFO");
	   try
    	{
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dDebut = dateFormat.parse("1997-12-26");
	     Contrat c = new Contrat(dDebut,"salaire",547);
	     emp.ajouterContrat(c);
    	}
	   catch (Exception e)
	   {
		   l.error("Test failed /ERROR"+e);
	   }
		
	}
	
	@Test
	public void TestaffecterContratAEmploye()
	{
		l.info("Start The test for the method / INFO");
		try
		{
		emp.affecterContratAEmploye(1,1);
		}
		catch (Exception e)
		{
	    l.error("Test failed /ERROR"+e);	
		}
	}


}