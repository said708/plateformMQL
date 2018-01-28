package org.java.mql.business;
import java.util.List;

import org.java.mql.models.Enseignant;
import org.java.mql.models.Etudiant;
import org.java.mql.models.File;
import org.java.mql.models.Liverable;
import org.java.mql.models.Matiere;
import org.java.mql.models.Project;
import org.java.mql.models.Team;



public interface Module2Business {

	//manage etudiant
	Etudiant deleteEtudiant(Etudiant etudiant);//work
	List<Etudiant> listEtudiants();//work
	int addEtudiant(Etudiant etudiant);//work
	void addListEtudiants(List<Etudiant> etudiants);//work
	Etudiant selectEtudiantById(long id);//work
	Etudiant searchEtudiant(String keyword);//work
	int updateEtudiant(Etudiant etudiant );//work
	boolean isAnEtudiantExiste(Etudiant etudiant);//work
	List<Etudiant> listEtudiantsPasEncoreAffecter();

	//manage team
	int addTeam(Team team);//work
	Team deleteTeam(Team team);//work
	List<Team> listTeams();//work
	Team selectTeamById(long id);//work
	int updateTeam(Team team);//work
	int addEtudiantToTeam(Etudiant etudiant , Team team);//work
	void addListEtudiantsToTeam(Team team , Etudiant ...etds);//work
	int removeEtudiantFromTeam(Etudiant student , Team team);//work
	int addProjectToTeam(Project project , Team team);//work
	int removeProjectFromTeam(Project project , Team team);//work
	List<Etudiant> listEtudiantsInTeam(Team team);//work
	boolean isAnTeamExiste(Team team);//work
	Etudiant selectTeamLeaderOfTeam(Team team);
	int changeTeamLeaderStatus(Etudiant e);


	//manage project
	int addProject(Project project);//work
	Project selectProjectById(long idProject);//work
	Project deleteProject(Project project);//work
	int updateProject(Project project);//work
	List<Project> listProjects();//work
	boolean isAnProjectExiste(Project project);//work

	//manage liverable
	int addLiverable(Liverable liverable); // Added by YcDev
	int updateLiverable(Liverable liverable); // Added by YcDev
	int deleteFileFromLiverable(File file , Liverable liverable);//work
	int addFileToLiverable(File file , Liverable liverable);//work     // Modified by YcDev, previous signature : int addFileToLiverable(File file , long idLiverable);
	List<Liverable> listLiverables();//work
	List<File> listFilesInLiverable(Liverable liverable);//work
	boolean isAnFileExisteInLiverable(File file , Liverable liverable);//work
	boolean  isAnLiverableExiste(Liverable liverable);//work
	Liverable selectLivrableById(long id) ;
	int addLivrable(Liverable livrable);



	Matiere selectMatiereById(long id);
	List<Matiere> listeMatieres();
	int addMatiere(Matiere matiere);
	boolean  isAnMatiereExiste(Matiere matiere);
	Matiere deleteMatiere(Matiere matiere);//work
	int updateMatiere(Matiere matiere);



	Enseignant selectEnseignantById(long idEnseigant) ;
	boolean  isAnEnseignantExiste(Enseignant enseignant);
	List<Enseignant> listeEnseignants();
	int addEnseignant(Enseignant Enseignant);
	Enseignant deleteEnseignant(Enseignant enseignant);//work
	int updateEnseignant(Enseignant enseignant);
}