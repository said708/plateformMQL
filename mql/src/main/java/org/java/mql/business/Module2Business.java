package org.java.mql.business;
import java.util.List;

import org.java.mql.models.p01.Etudiant;
import org.java.mql.models.p01.Team;
import org.java.mql.models.p02.AbstractFile;
import org.java.mql.models.p02.File;
import org.java.mql.models.p02.Liverable;
import org.java.mql.models.p02.Project;



public interface Module2Business {
	
	//gerer  les etudiants          
	Etudiant deleteEtudiant(long id);//work
	List<Etudiant> listEtudiants();//work
	int addEtudiant(Etudiant etudiant);//work
	Etudiant selectEtudiantById(long id);//work
	int updateEtudiant(long idEtudiant , Etudiant etudiant );//work
	
	//gerer  l'equipe
	int addTeam(Team team);//work
	Team deleteTeam(long id);//work
	List<Team> listTeams();//work
	Team selectTeamById(long id);//work
	int updateTeam(long idTeam , Team team);//work
	int addEtudiantToTeam(Etudiant etudiant , long teamId);//work
	void addListEtudiantsToTeam(List<Etudiant> etudiant , long teamId);//work
	Etudiant removeEtudiantFromTeam(long studentId , long teamId);//work
	int addProjectToTeam(Project project , long teamId);//work
	Project removeProjectFromTeam(long projectId , long teamId);//work
	List<Etudiant> listEtudiantsInTeam(long idTeam);//work
	
	
	
	//pas  encore implementer
	//manage project
	int addProject(Project project);
	Project removeProject(Project projet);
	List<Project> listProjects();
	
	//manage liverable
	Team deleteFileFromLiverable(long fileId , long teamId);
	int addFileToLiverable(File file , long idLiverable);
	List<Liverable> listLiverables();
	List<AbstractFile> listFilesInLiverable(long liverableId);
	
}
