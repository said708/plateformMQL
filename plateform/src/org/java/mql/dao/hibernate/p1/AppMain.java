package org.java.mql.dao.hibernate.p1;



import org.java.mql.business.DefaultModule2Business;
import org.java.mql.business.Module2Business;
import org.java.mql.models.p1.Enseignant;
import org.java.mql.models.p1.Etudiant;
import org.java.mql.models.p1.Team;
import org.java.mql.models.p2.AbstractFile;
import org.java.mql.models.p2.File;
import org.java.mql.models.p2.Liverable;
import org.java.mql.models.p2.Matiere;
import org.java.mql.models.p2.Project;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AppMain {


	public  AppMain() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConext.xml");
		Module2Business service = context.getBean(DefaultModule2Business.class);
		//testAddFileToLiverable(service);
		context.close();

	}

	//Ajout d'un groupe
	public void AddTeam(Module2Business service) {
		Team team1=new Team(); 
		team1.setName("D");
		//		 team1.setMatiere(service.selectMatierById(1));
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
		Team team = service.selectTeamById(2);
		//			team.setMatiere(service.selectMatiereById(3));
		service.updateTeam(2, team);

	}

	//	Ajout d'un �tudiant 
	private void AddStudent(Module2Business service) {
		Etudiant etudiant1 = new Etudiant();
		etudiant1.setNom("fk");
		etudiant1.setPrenom("hasna");
		etudiant1.setEmail("hasnaefourkane@gmail.com");
		etudiant1.setPhone("063333");
		etudiant1.setTeam(service.selectTeamById(1));
		service.addEtudiant(etudiant1);

	}

	//ajouter etudiant dans un team
	private void AddStudentInTeam(Module2Business service) {
		Etudiant e1 = new Etudiant(101, "Fourkane", "Hasnae", "hasnaefourkane@gmail.com", "06545");
		Team team1=service.selectTeamById(1);
		e1.setTeam(team1);
		service.addEtudiant(e1);

	}

	//Supprimer un �tudiant
	private void DeleteStudent(Module2Business service) {
		service.deleteEtudiant(2);
	}

	//Liste des �tudiants
	private void ListStudents(Module2Business service) {
		System.out.println(service.listEtudiants());
	}

	//Select d'un �tudiant by id
	private void SelectStudentByStudent(Module2Business service) {
		System.out.println(service.selectEtudiantById(1));

	}

	//Ajout Enseignant
	private void AddEnseignant(Module2Business service) {
		Enseignant enseignant = new Enseignant(1, "Chenffour", "Noureddine", "037777");
		//       service.addEnseignant(enseignant);

	}

	//Ajout matiere		
	private void AddMatiere(Module2Business service) {
		Matiere matiere = new Matiere();
		matiere.setName("web service");
		// 		matiere.setEnsignant(service.selectEnsignantById(1));
		// 		service.addMatiere(matiere);

	}

	//Ajout projet	
	private void AddProject(Module2Business service) {
		Project projet = new Project();
		projet.setName("E-Medical");
		projet.setDescription("dossier medical");
		projet.setDatePublication("12/12/2017");
		projet.setDeadLine("10/01/2018");
		projet.setTeam(service.selectTeamById(1));
		//			projet.setMatiere(service.selectMatiereById(1));
		//			projet.setLiverable(service.selectLivrableById(1));
		service.addProject(projet);

	}

	//Update project
	private void UpdatePr(Module2Business service) {
		Project projet = service.selectProjectById(1);
		// 		projet.setLiverable(service.selectLivrableById(7));
		service.updateProject(1, projet);

	}

	//Ajout Liverable
	private void AddLiverable(Module2Business service) {
		Liverable livrable = new Liverable();
		livrable.setName("L1");
		livrable.setProject(service.selectProjectById(1));
		service.addLiverable(livrable);

	}

	//Modif livrable
	private void UpdateLivrable(Module2Business service) {

		//		Liverable livrable = service.selectLivrableById(1);
		//		livrable.setProject(service.selectProjectById(1));
		//		service.updateLiverable(1, livrable);
	}

	//Liste des etudiants dans un groupe
	private void ListStudentsInTeam(Module2Business service) {
		System.out.println(service.listEtudiantsInTeam(2));
	}

	//Supprimer un etudiant d'un groupe
	private void removeEtudiantFromTeam(Module2Business service) {
		System.out.println(service.removeEtudiantFromTeam(18,5));

	}

	//Ajouter un projet dans un groupe
	private void addProjectToTeam(Module2Business service) {
		System.out.println(service.addProjectToTeam(1, 4));

	}

	//Supprimer un projet from un groupe
	private void removeProjectFromTeam(Module2Business service) {
		System.out.println(service.removeProjectFromTeam(1, 3));

	}

	//Ajouter un etudiant dans un groupe
	private void addEtudiantToTeam(Module2Business service) {
		System.out.println(service.addEtudiantToTeam(18, 5));

	}

	/*---------------- Test of Liverable management methods----------------*/

	// Add file to liverable : YcDev
	public void testAddFileToLiverable(Module2Business service) {
		AbstractFile file = new File(101, "Platform resume", "/home/yassine/Desktop");
		Liverable liverable = service.listLiverables().get(0);
		file.setLiverable(liverable);
		service.addFileToLiverable(file, liverable.getId());
	}
	
	public static void main(String[] args) {
		new AppMain();
	}

}

