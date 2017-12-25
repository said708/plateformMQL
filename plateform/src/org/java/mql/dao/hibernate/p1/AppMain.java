package org.java.mql.dao.hibernate.p1;



import org.java.mql.business.Module2Business;
import org.java.mql.models.p1.Ensignant;
import org.java.mql.models.p1.Etudiant;
import org.java.mql.models.p1.Team;
import org.java.mql.models.p2.Liverable;
import org.java.mql.models.p2.Matiere;
import org.java.mql.models.p2.Project;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AppMain {
	
	public static void main(String[] args) {
		new AppMain();
	}

	
		
	public  AppMain() {
					
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConext.xml");
		Module2Business service = context.getBean(Module2Business.class);
		AddTeam(service);
		context.close();
		
	}


		 //Ajout d'un groupe
		public void AddTeam(Module2Business service) {
		 Team team1=new Team(); 
		 team1.setName("F");
		 team1.setMatiere(service.selectMatiereById(1));
		  service.addTeam(team1);
		}
		
		  
	    //Liste des groupes 
		private void ListTeam(Module2Business service) {
			System.out.println(service.listTeams());
		}
		
		//Select groupe by id
		private void SelectTeamById(Module2Business service) {
			System.out.println(service.selectTeamById(3));

		}
		
		
		//Supprimer un groupe
		private void DeleteTeam(Module2Business service) {
			service.deleteTeam(2);

		}


		//Modifier un groupe
		private void UpdateTeam(Module2Business service) {
			Team team = service.selectTeamById(3);
			team.setMatiere(service.selectMatiereById(2));
			service.updateTeam(3, team);

		}

		
		
	//	Ajout d'un étudiant 
		private void AddStudent(Module2Business service) {
			Etudiant etudiant1 = new Etudiant();
			etudiant1.setNom("fk");
			etudiant1.setPrenom("hasna");
			etudiant1.setEmail("hasnaefourkane@gmail.com");
			etudiant1.setPhone("0600000");
			etudiant1.setTeam(service.selectTeamById(7));
			service.addEtudiant(etudiant1);

		}

		
		
		//ajouter etudiant dans un team
		private void AddStudentInTeam(Module2Business service) {
			Etudiant e1 = new Etudiant(101, "Fourkan", "Hasna", "hasnaefourkane@gmail.com", "06545");
		    Team team1=service.selectTeamById(6);
		    e1.setTeam(team1);
		    service.addEtudiant(e1);

		}
	   
		 
	  //Supprimer un étudiant
		private void DeleteStudent(Module2Business service) {
			service.deleteEtudiant(20);
		}

	 
	 //Liste des étudiants
     private void ListStudents(Module2Business service) {
    	 System.out.println(service.listEtudiants());
	}
	
		
	 //Select d'un étudiant by id
     private void SelectStudentByStudent(Module2Business service) {
    	 System.out.println(service.selectEtudiantById(19));

	}
	 
	
		
	//Ajout Enseignant
     private void AddEnseignant(Module2Business service) {
 		Ensignant enseignant = new Ensignant(2, "Nfaoui", "Abdelhak", "037777");
       service.addEnsignant(enseignant);

	}

		

	//Ajout matiere		
     private void AddMatiere(Module2Business service) {
 		Matiere matiere = new Matiere();
 		matiere.setName("JEE");
 		matiere.setEnsignant(service.selectEnsignantById(1));
 		service.addMatiere(matiere);

	}

		
		
		

		//Ajout projet	
     private void AddProject(Module2Business service) {
			Project projet = new Project();
			projet.setName("E-Medical");
			projet.setDescription("dossier medical");
			projet.setDatePublication("12/12/2017");
			projet.setDeadLine("10/01/2018");
			projet.setTeam(service.selectTeamById(7));
			projet.setMatiere(service.selectMatiereById(2));
			projet.setLiverable(service.selectLivrableById(1));
			service.addProject(projet);

	}

			 
		
		
		//Update project
     private void UpdateProject(Module2Business service) {
 		Project projet = service.selectProjectById(2);
 		projet.setLiverable(service.selectLivrableById(2));
 		service.updateProject(2, projet);

	}

		
		//Ajout Liverable
     
     private void AddLivrable(Module2Business service) {
 		Liverable livrable = new Liverable();
 		livrable.setName("L2");
 		livrable.setProject(service.selectProjectById(2));
 		service.addLivrable(livrable);
 		

	}
     	//Modif livrable
	private void UpdateLivrable(Module2Business service) {
		
		Liverable livrable = service.selectLivrableById(1);
		livrable.setProject(service.selectProjectById(1));
		service.updateLivrable(livrable.getId(), livrable);
	}
		
	//Liste des étudiants dans un groupe
	private void ListStudentsInTeam(Module2Business service) {
		System.out.println(service.listEtudiantsInTeam(7));
	}
		
	//Supprimer un étudiant d'un groupe
	private void removeEtudiantFromTeam(Module2Business service) {
		System.out.println(service.removeEtudiantFromTeam(17,1));

	}
		
	//Ajouter un projet dans un groupe
	private void addProjectToTeam(Module2Business service) {
		System.out.println(service.addProjectToTeam(2,6));

	}
		
	//Supprimer un projet from un groupe
	private void removeProjectFromTeam(Module2Business service) {
		System.out.println(service.removeProjectFromTeam(2, 6));

	}
	
	//Ajouter un étudiant dans un groupe
	private void addEtudiantToTeam(Module2Business service) {
		System.out.println(service.addEtudiantToTeam(18, 6));
		
	}
		 
		
	}

