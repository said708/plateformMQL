package org.java.mql.business;
import java.util.List;

import org.java.mql.models.p1.Ensignant;
import org.java.mql.models.p1.Etudiant;
import org.java.mql.models.p1.Team;
import org.java.mql.models.p2.AbstractFile;
import org.java.mql.models.p2.File;
import org.java.mql.models.p2.Liverable;
import org.java.mql.models.p2.Matiere;
import org.java.mql.models.p2.Project;



public interface Module2Business {
	
	//manage etudiant
	Etudiant deleteEtudiant(long id);//work
	List<Etudiant> listEtudiants();//work
	int addEtudiant(Etudiant etudiant);//work
	void addListEtudiants(List<Etudiant> etudiants);//work
	Etudiant selectEtudiantById(long id);//work
	int updateEtudiant(long idEtudiant , Etudiant etudiant );//work
	boolean isAnEtudiantExiste(long idEtudiant);//work
	
	//manage team
	int addTeam(Team team);//work
	Team deleteTeam(long id);//work
	List<Team> listTeams();//work
	Team selectTeamById(long id);//work
	int updateTeam(long idTeam , Team team);//work
	int addEtudiantToTeam(long etudiant , long teamId);//work
	void addListEtudiantsToTeam(long teamId , long ...etdsId);//work
	int removeEtudiantFromTeam(long studentId , long teamId);//work
	int addProjectToTeam(long projectId , long teamId);//work
	int removeProjectFromTeam(long projectId , long teamId);//work
	List<Etudiant> listEtudiantsInTeam(long idTeam);//work
	boolean isAnTeamExiste(long idTeam);//work
	
	
	//manage project
	int addProject(Project project);//work
	Project selectProjectById(long idProject);//work
	Project deleteProject(long idProject);//work
	int updateProject(long idProject , Project project);//work
	List<Project> listProjects();//work
	boolean isAnProjectExiste(long idProject);//work
	
	//manage liverable
	int addLiverable(Liverable liverable); // Added by YcDev
	int updateLiverable(long liverableId, Liverable liverable); // Added by YcDev
	AbstractFile deleteFileFromLiverable(long fileId , long liverableId);//work
	int addFileToLiverable(AbstractFile file , long idLiverable);//work     // Modified by YcDev, previous signature : int addFileToLiverable(File file , long idLiverable);
	List<Liverable> listLiverables();//work
	List<AbstractFile> listFilesInLiverable(long liverableId);//work
	boolean isAnFileExisteInLiverable(long fileId , long liverableId);//work
	boolean  isAnLiverableExiste(long liverableId);//work
	public Liverable selectLivrableById(long id) ;
	public int addLivrable(Liverable livrable);
	public int updateLivrable(long idLivrable, Liverable livrable);
	
	
	
	public Matiere selectMatiereById(long id);
	public List<Matiere> listeMatieres();
	public int addMatiere(Matiere matiere);
	boolean  isAnMatiereExiste(long matiereId);
	
	
	
	public Ensignant selectEnsignantById(long idEnseigant) ;
	boolean  isAnEnseignantExiste(long enseignantId);
	public List<Ensignant> listeEnseignats();
	public int addEnsignant(Ensignant ensignant);
}