package org.java.mql.business;
import java.util.List;

import org.java.mql.models.p01.Etudiant;
import org.java.mql.models.p01.Team;
import org.java.mql.models.p02.AbstractFile;
import org.java.mql.models.p02.File;
import org.java.mql.models.p02.Liverable;
import org.java.mql.models.p02.Project;



public interface Module2Business {
	
	//manage etudiant
	Etudiant deleteEtudiant(long id);//work
	List<Etudiant> listEtudiants();//work
	int addEtudiant(Etudiant etudiant);//work
	Etudiant selectEtudiantById(long id);//work
	int updateEtudiant(long idEtudiant , Etudiant etudiant );//work
	boolean isAnEtudiantExiste(long idEtudiant);
	
	//manage team
	int addTeam(Team team);//work
	Team deleteTeam(long id);//work
	List<Team> listTeams();//work
	Team selectTeamById(long id);//work
	int updateTeam(long idTeam , Team team);//work
	int addEtudiantToTeam(long etudiant , long teamId);//work
	void addListEtudiantsToTeam(long teamId , long ...etdsId);//work
	Etudiant removeEtudiantFromTeam(long studentId , long teamId);//work
	int addProjectToTeam(long projectId , long teamId);//work
	Project removeProjectFromTeam(long projectId , long teamId);//work
	List<Etudiant> listEtudiantsInTeam(long idTeam);//work
	boolean isAnTeamExiste(long idTeam);
	
	
	//manage project
	int addProject(Project project);
	Project selectProjectById(long idProject);
	Project deleteProject(long idProject);
	int updateProject(long idProject , Project project);
	List<Project> listProjects();
	boolean isAnProjectExiste(long idProject);
	
	//manage liverable
	AbstractFile deleteFileFromLiverable(long fileId , long liverableId);
	int addFileToLiverable(File file , long idLiverable);
	List<Liverable> listLiverables();
	List<AbstractFile> listFilesInLiverable(long liverableId);
	boolean isAnFileExisteInLiverable(long fileId , long liverableId);
	boolean  isAnLiverableExiste(long liverableId);
	
}
