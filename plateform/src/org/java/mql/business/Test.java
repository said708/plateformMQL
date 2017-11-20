package org.java.mql.business;

import java.util.List;
import java.util.Vector;

import org.java.mql.models.p01.Etudiant;
import org.java.mql.models.p01.Team;
import org.java.mql.models.p02.Project;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	//service test by hasnae
	public Test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConext.xml");
		Module2Business b = context.getBean(DefaultModule2Business.class);
		etudiantTest(b);
		context.close();
	}
	
	public void teamTest(Module2Business business) {
		System.out.println("+++++++listTeams++++++++");
		for (Team t : business.listTeams()) {
			System.out.println(t.getNom());	
		}
		System.out.println("+++++++addTeam++++++++");
		//listEtudiants work as expected
		List<Etudiant> listEtudiants = business.listEtudiants();
		
		
		//listProjects work as expected
		List<Project> listProjects = business.listProjects();
		Team team = new Team(9, "GroupeT", listEtudiants, listProjects);
		
		//addTeam work as expected
		business.addTeam(team);
		for (Team t : business.listTeams()) {
			System.out.println(t.getNom());	
		}
		
		
		System.out.println("+++++++deleteTeam++++++++");
		//addTeam work as expected
		business.deleteTeam(4);
		for (Team t : business.listTeams()) {
			System.out.println(t.getNom());	
		}
		
		
		System.out.println("+++++++selectTeamById++++++++");
		//selectTeamById work as expected
		System.out.println(business.selectTeamById(9));
		
		
		System.out.println("+++++++updateTeam++++++++");
		Team update = new Team(67, "GroupeTModified", listEtudiants, new Vector<Project>());
		//updateTeam work as expected
		business.updateTeam(9, update);
		for (Team t : business.listTeams()) {
			System.out.println(t.getNom());	
		}
		
		
		System.out.println("+++++++addProjectToTeam++++++++");
		//addProjectToTeam work as expected
		business.addProjectToTeam(1,9);
		
		for (Project t : update.getProjects()) {
			System.out.println(t.getDesc());	
		}
		
		System.out.println("+++++++removeProjectFromTeam++++++++");
		//removeProjectToTeam work as expected
		business.removeProjectFromTeam(1 , 9);
		System.out.println("Project removed with success");
		for (Project t : update.getProjects()) {
			System.out.println(t.getDesc());	
		}
		
	}
	
	
	public void etudiantTest(Module2Business business) {
		
		
		System.out.println("+++++++listEtudiantsInTeam++++++++");
		//list all etudiants work as expected
		System.out.println(business.listEtudiantsInTeam(4));
		
		
		System.out.println("+++++++removeEtudiantFromTeam++++++++");
		//remove service work as expected
		business.removeEtudiantFromTeam(23, 4);
		System.out.println(business.listEtudiantsInTeam(4));
		
		
		System.out.println("+++++++addEtudiantToTeam++++++++");
		//add service work as expected
		business.addEtudiantToTeam(3, 4);
		System.out.println(business.listEtudiantsInTeam(4));
		
		
		System.out.println("+++++++addListEtudiantsToTeam++++++++");
		Etudiant etd1  =new Etudiant(167, "saidi", "kamal", "kamal@gmail.fr", "09667656434");
		Etudiant etd2  =new Etudiant(189, "isala", "mohamed", "isala@gmail.fr", "0989786545");
		Vector<Etudiant> list = new Vector<Etudiant>();
		list.add(etd1);
		list.add(etd2);
		//addListEtudiantsToTeam work as expected
		business.addListEtudiantsToTeam(4, 1,2,3);
		for (Etudiant t : business.listEtudiantsInTeam(4)) {
			System.out.println(t.getPrenom());	
		}
	}
	
	
	public static void main(String[] args) {
		new Test();
	}

}
