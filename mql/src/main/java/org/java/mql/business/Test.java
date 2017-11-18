package org.java.mql.business;

import java.util.List;
import java.util.Vector;

import org.java.mql.models.p01.Etudiant;
import org.java.mql.models.p01.Team;
import org.java.mql.models.p02.Project;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public Test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConext.xml");
		DefaultModule2Business b = context.getBean(DefaultModule2Business.class);
		teamTest(b);
		context.close();
	}
	
	public void teamTest(Module2Business business) {
		System.out.println("+++++++gerer l'equipe comprenamt  tous les service  necessaires ajouter supprimer   et mise a jour ++++++++");
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
		Team update = new Team(67, "GroupeTModified", listEtudiants, listProjects);
		//updateTeam work as expected
		business.updateTeam(9, update);
		for (Team t : business.listTeams()) {
			System.out.println(t.getNom());	
		}
		
		
		System.out.println("+++++++addEtudiantToTeam++++++++");
		Etudiant etd  =new Etudiant(190, "bata", "redouane", "red@gmail.fr", "0989786545");
		//addEtudiantToTeam work as expected
		business.addEtudiantToTeam(etd, 9);
		for (Etudiant t : update.getEtudiants()) {
			System.out.println(t.getPrenom());	
		}
		
		System.out.println("+++++++addListEtudiantsToTeam++++++++");
		Etudiant etd1  =new Etudiant(167, "saidi", "kamal", "kamal@gmail.fr", "09667656434");
		Etudiant etd2  =new Etudiant(189, "isala", "mohamed", "isala@gmail.fr", "0989786545");
		Vector<Etudiant> list = new Vector<>();
		list.add(etd1);
		list.add(etd2);
		//addListEtudiantsToTeam work as expected
		business.addListEtudiantsToTeam(list, 9);
		for (Etudiant t : update.getEtudiants()) {
			System.out.println(t.getPrenom());	
		}
		
		
		System.out.println("+++++++removeEtudiantFromTeam++++++++");
		//removeEtudiantFromTeam work as expected
		business.removeEtudiantFromTeam(167, 9);
		for (Etudiant t : update.getEtudiants()) {
			System.out.println(t.getPrenom());	
		}
		
		
		System.out.println("+++++++removeEtudiantFromTeam++++++++");
		//addProjectToTeam work as expected
		Project p = new Project(9077, "Plateform Mql", "platefom   pour le master mql sert a gestionner le proccessur  de l'entrer a sort", "12/01/1990", "12/01/2000");
		
		business.removeEtudiantFromTeam(167, 9);
		for (Etudiant t : update.getEtudiants()) {
			System.out.println(t.getPrenom());	
		}
		
	}
	
	
	public void etudiantTest(Module2Business business) {
		
		//list all etudiants work as expected
		System.out.println(business.listEtudiantsInTeam(4));
		
		//remove service work as expected
		business.removeEtudiantFromTeam(23, 4);
		System.out.println(business.listEtudiantsInTeam(4));
		
		//add service work as expected
		business.addEtudiantToTeam(new Etudiant(87, "tajir", "bouchta", "bouchta.2330@gmail.fr", "0989787634"), 4);
		System.out.println(business.listEtudiantsInTeam(4));
		
	}
	
	
	public static void main(String[] args) {
		new Test();
	}

}
