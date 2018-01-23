package org.java.mql.dao.mediator;

import java.util.List;

import org.java.mql.dao.EnseignantDao;
import org.java.mql.dao.EtudiantDao;
import org.java.mql.dao.FileDao;
import org.java.mql.dao.LiverableDao;
import org.java.mql.dao.MatiereDao;
import org.java.mql.dao.ProjectDao;
import org.java.mql.dao.TeamDao;
import org.java.mql.models.Enseignant;
import org.java.mql.models.Etudiant;
import org.java.mql.models.File;
import org.java.mql.models.Liverable;
import org.java.mql.models.Matiere;
import org.java.mql.models.Project;
import org.java.mql.models.Team;

// This class gathers all DAOs to access them easily
public class DaoMediator {
	
	private EnseignantDao EnseignantDao;
	private EtudiantDao etudiantDao;
	private TeamDao teamDao;
	private FileDao fileDao;
	private LiverableDao liverableDao;
	private MatiereDao matiereDao;
	private ProjectDao projectDao;

	public void setEnseignantDao(EnseignantDao EnseignantDao) {
//		System.out.println("setEnseignantDao");
		this.EnseignantDao = EnseignantDao;
		this.EnseignantDao.setMediator(this);
	}
	
	public void setEtudiantDao(EtudiantDao etudiantDao) {
//		System.out.println("setEtudiantDao");
		this.etudiantDao = etudiantDao;
		this.etudiantDao.setMediator(this);
	}
	
	public void setTeamDao(TeamDao teamDao) {
//		System.out.println("setTeamDao");
		this.teamDao = teamDao;
		this.teamDao.setMediator(this);
	}
	
	public void setFileDao(FileDao fileDao) {
//		System.out.println("setFileDao");
		this.fileDao = fileDao;
		this.fileDao.setMediator(this);
	}
	
	public void setLiverableDao(LiverableDao liverableDao) {
//		System.out.println("setLiverableDao");
		this.liverableDao = liverableDao;
		this.liverableDao.setMediator(this);
	}
	
	public void setMatiereDao(MatiereDao matiereDao) {
//		System.out.println("setMatiereDao");
		this.matiereDao = matiereDao;
		this.matiereDao.setMediator(this);
	}
	
	public void setProjectDao(ProjectDao projectDao) {
//		System.out.println("setProjectDao");
		this.projectDao = projectDao;
		this.projectDao.setMediator(this);
	}
	
	
	public long addEnseignant(Enseignant Enseignant) {
		return EnseignantDao.addEnseignant(Enseignant);
	}
	public Enseignant deleteEnseignant(long idEnseignant) {
		return EnseignantDao.deleteEnseignant(idEnseignant);
	}
	public List<Enseignant> selectAllEnseignant() {
		return EnseignantDao.selectAllEnseignant();
	}
	public Enseignant selectEnseignantById(long id) {
		return EnseignantDao.selectEnseignantById(id);
	}
	public long updateEnseignant(int idEnseignant, Enseignant Enseignant) {
		return EnseignantDao.updateEnseignant(idEnseignant, Enseignant);
	}
	public long addEtudiant(Etudiant etudiant) {
		return etudiantDao.addEtudiant(etudiant);
	}
	public Etudiant deleteEtudiant(long id) {
		return etudiantDao.deleteEtudiant(id);
	}
	public List<Etudiant> selectAllEtudiant() {
		return etudiantDao.selectAllEtudiant();
	}
	
	public long updateEtudiant(long idEtudiant, Etudiant etudiant) {
		return etudiantDao.updateEtudiant(idEtudiant, etudiant);
	}
	public long updateEnseignant(long idEnseignant, Enseignant Enseignant) {
		return EnseignantDao.updateEnseignant(idEnseignant, Enseignant);
	}

	

	public Etudiant selectEtudiantById(long id) {
		return etudiantDao.selectEtudiantById(id);
	}

	public Team deleteTeam(long idTeam) {
		return teamDao.deleteTeam(idTeam);
	}


	public long addTeam(Team team) {
		return teamDao.addTeam(team);
	}
	public Team deleteTeam(int idTeam) {
		return teamDao.deleteTeam(idTeam);
	}
	public List<Team> selectAllTeam() {
		return teamDao.selectAllTeam();
	}
	public Team selectTeamById(long id) {
		return teamDao.selectTeamById(id);
	}

	public long updateTeam(long teamId , Team team) {
		return teamDao.updateTeam(teamId,team);
	}
	
	public List<Etudiant> selectEtudinatsInTeams(long teamId) {
		return  teamDao.selectEtudinatsInTeams(teamId);
	}

	public int removeEtudiantFromTeam(long studentId, long team_id) {
		return teamDao.removeEtudiantFromTeam(studentId, team_id);
	}
	
	public int addProjectToTeam(long projectId, long teamId) {
		return teamDao.addProjectToTeam(projectId, teamId);
	}
	public int removeProjectFromTeam(long projectId, long teamId) {
		return teamDao.removeProjectFromTeam(projectId, teamId);
	}
	public int addEtudiantToTeam(long idEtudiant, long teamId) {
		return teamDao.addEtudiantToTeam(idEtudiant, teamId);
	}
	public int addFile(File file) {
		return fileDao.addFile(file);
	}
	public File deleteFile(long idFile) {
		return fileDao.deleteFile(idFile);
	}
	public List<File> selectAllFile() {
		return fileDao.selectAllFile();
	}
	public File selectFileById(long id) {// Modified by YcDev, to see it again !!
		return fileDao.selectFileById(id);
	}
	public int updateFile(long idFile, File file) {
		return fileDao.updateFile(idFile, file);
	}
	public int addLiverable(Liverable liverable) {
		return liverableDao.addLiverable(liverable);
	}
	public Liverable deleteLiverable(long idLiverable) {
		return liverableDao.deleteLiverable(idLiverable);
	}
	public List<Liverable> selectAllLiverable() {
		return liverableDao.selectAllLiverable();
	}
	public Liverable selectLiverableById(long id) {
		return liverableDao.selectLiverableById(id);
	}
	public int updateLiverable(long idLiverable, Liverable liverable) {
		return liverableDao.updateLiverable(idLiverable, liverable);
	}
	public int addMatiere(Matiere matiere) {
		return matiereDao.addMatiere(matiere);
	}
	public Matiere deleteMatiere(long idMatiere) {
		return matiereDao.deleteMatiere(idMatiere);
	}
	public List<Matiere> selectAllMatiere() {
		return matiereDao.selectAllMatiere();
	}
	public Matiere selectMatiereById(long id) {
		return matiereDao.selectMatierById(id);
	}
	public int updateMatiere(long idMatiere, Matiere matiere) {
		return matiereDao.updateMatiere(idMatiere, matiere);
	}
	public int addProjet(Project projet) {
		return projectDao.addProjet(projet);
	}
	public Project deleteProjet(long idProjet) {
		return projectDao.deleteProjet(idProjet);
	}
	public List<Project> selectAllProjet() {
		return projectDao.selectAllProjet();
	}
	public Project selectProjetById(long id) {
		return projectDao.selectProjetById(id);
	}
	public int updateProjet(long idProjet, Project projet) {
		return projectDao.updateProjet(idProjet, projet);
	}

	public void print() {
		System.out.println("Hello From DaoMediator");
		
	}
	
}