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
	Etudiant deleteEtudiant(Etudiant etudiant);
	List<Etudiant> listEtudiants();
	int addEtudiant(Etudiant etudiant);
	void addListEtudiants(List<Etudiant> etudiants);
	Etudiant selectEtudiantById(long id);
	Etudiant searchEtudiant(String keyword);
	int updateEtudiant(Etudiant etudiant );
	boolean isAnEtudiantExiste(Etudiant etudiant);
	int addTeamToMatiere(Team team  , Matiere matiere);
	List<Etudiant> listEtudiantNotAffectedToAnyTeam();

	//manage team
	int addTeam(Team team);
	Team deleteTeam(Team team);
	List<Team> listTeams();
	Team selectTeamById(long id);
	int updateTeam(Team team);
	void addListEtudiantsToTeam(Team team , Etudiant ...etds);
	int removeEtudiantFromTeam(Etudiant student , Team team);
	int addProjectToTeam(Project project , Team team);
	int removeProjectFromTeam(Project project , Team team);
	List<Etudiant> listEtudiantsInTeam(Team team);
	boolean isAnTeamExiste(Team team);
	Etudiant selectTeamLeaderOfTeam(Team team);
	int removeTeamFromMatiere(Team team , Matiere matiere);

	
	//manage project
	int addProject(Project project);
	Project selectProjectById(long idProject);
	List<Project> selectAllProjectByMatiere(String matiereName); // YcDev
	Project deleteProject(Project project);
	int updateProject(Project project);
	List<Project> listProjects();
	boolean isAnProjectExiste(Project project);
	List<Project> listProjectsOfTeam(Team team);
	List<Project> listProjectsByKeyword(Matiere matiere , String keyword);
	

	//manage liverable
	int addLiverable(Liverable liverable); 
	int updateLiverable(Liverable liverable); 
	int deleteFileFromLiverable(File file , Liverable liverable);
	int addFileToLiverable(File file , Liverable liverable);
	List<Liverable> listLiverables();
	List<File> listFilesInLiverable(Liverable liverable);
	boolean isAnFileExisteInLiverable(File file , Liverable liverable);
	boolean  isAnLiverableExiste(Liverable liverable);
	Liverable selectLivrableById(long id) ;
	int addLivrable(Liverable livrable);

	//manage matiere
	Matiere selectMatiereById(long id);
	List<Matiere> listeMatieres();
	int addMatiere(Matiere matiere);
	boolean  isAnMatiereExiste(Matiere matiere);
	Matiere deleteMatiere(Matiere matiere);
	int updateMatiere(Matiere matiere);
	List<Team> listTeamsInMatiere(Matiere matiere);
	List<Project> listProjectsInMatiere(Matiere matiere);


	//manage enseignant
	Enseignant selectEnseignantById(long idEnseigant) ;
	boolean  isAnEnseignantExiste(Enseignant enseignant);
	List<Enseignant> listeEnseignants();
	int addEnseignant(Enseignant Enseignant);
	Enseignant deleteEnseignant(Enseignant enseignant);
	int updateEnseignant(Enseignant enseignant);
}