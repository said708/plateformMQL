package org.java.mql.dao.hibernate.p1;



import org.java.mql.business.DefaultModule2Business;
import org.java.mql.models.p01.Etudiant;
import org.java.mql.models.p01.Team;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AppMain {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConext.xml");

		DefaultModule2Business service = (DefaultModule2Business) context.getBean("defaultModule2Business");

		
		Etudiant etudiant1 = new Etudiant();
		etudiant1.setNom("fourkane");
		etudiant1.setPrenom("hasnae");
		etudiant1.setEmail("hasnaefourkane@gmail.com");
		etudiant1.setPhone("067777");

		
		
	   //Ajout d'un team
	   Team team1=new Team();  
	   team1.setNom("B"); 
	   service.addTeam(team1);
	   service.addEtudiant(etudiant1);
	 
		
		
		//ajouter etudiant dans un team
//	    Team team1=service.selectTeamById(1);
//	    etudiant1.setTeam(team1);
//	    service.addEtudiant(etudiant1);
	  
	  
	 
		
		//Suppression
		//service.deleteTeam(11);
		
		
		
		//selectAll Etudiants
//		List<Etudiant> etudiants = service.listEtudiants();
//		for (Etudiant etud : etudiants) {
//			System.out.println(etud);
//		}
//		
	
	    
	    
	    
	  //selectAll Teams
//		List<Team> groupes = service.listTeams();
//		for (Team team : groupes) {
//			System.out.println(team);
//		}
		
	    
	    
		//selectById
	    //service.selectTeamById(10);
	    
	

		
		
		//Modification
//		Team team = service.selectTeamById(10);
//		team.setNom(new String ("B"));
//		service.updateTeam(team);
//		
		context.close();
	}
}
