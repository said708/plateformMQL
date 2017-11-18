package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.p1.EnsignantDao;
import org.java.mql.dao.p1.EtudiantDao;
import org.java.mql.dao.p1.TeamDao;
import org.java.mql.dao.p2.FileDao;
import org.java.mql.dao.p2.LiverableDao;
import org.java.mql.dao.p2.MatiereDao;
import org.java.mql.dao.p2.ProjectDao;
import org.java.mql.models.p01.Ensignant;
import org.java.mql.models.p01.Etudiant;
import org.java.mql.models.p01.Team;
import org.java.mql.models.p02.File;
import org.java.mql.models.p02.Liverable;
import org.java.mql.models.p02.Matiere;
import org.java.mql.models.p02.Project;


public class DaoMediator {
	
	private EnsignantDao ensignantDao;
	private EtudiantDao etudiantDao;
	private TeamDao teamDao;
	private FileDao fileDao;
	private LiverableDao liverableDao;
	private MatiereDao matiereDao;
	private ProjectDao projectDao;

	public void setEnsignantDao(EnsignantDao ensignantDao) {
//		System.out.println("setEnsignantDao");
		this.ensignantDao = ensignantDao;
		this.ensignantDao.setMediator(this);
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
	
	
	public int addEnsignant(Ensignant ensignant) {
		return ensignantDao.addEnsignant(ensignant);
	}
	public Ensignant deleteEnsignant(long idEnsignant) {
		return ensignantDao.deleteEnsignant(idEnsignant);
	}
	public List<Ensignant> selectAllEnsignant() {
		return ensignantDao.selectAllEnsignant();
	}
	public Ensignant selectEnsignantById(long id) {
		return ensignantDao.selectEnsignantById(id);
	}
	public int updateEnsignant(int idEnsignant, Ensignant ensignant) {
		return ensignantDao.updateEnsignant(idEnsignant, ensignant);
	}
	public int addEtudiant(Etudiant etudiant) {
		return etudiantDao.addEtudiant(etudiant);
	}
	public Etudiant deleteEtudiant(int idEtudiant) {
		return etudiantDao.deleteEtudiant(idEtudiant);
	}
	public List<Etudiant> selectAllEtudiant() {
		return etudiantDao.selectAllEtudiant();
	}
	public Etudiant selectEtudiantById(int id) {
		return etudiantDao.selectEtudiantById(id);
	}
	public int updateEtudiant(long idEtudiant, Etudiant etudiant) {
		return etudiantDao.updateEtudiant(idEtudiant, etudiant);
	}
	public int updateEnsignant(long idEnsignant, Ensignant ensignant) {
		return ensignantDao.updateEnsignant(idEnsignant, ensignant);
	}

	public Etudiant deleteEtudiant(long id) {
		return etudiantDao.deleteEtudiant(id);
	}

	public Etudiant selectEtudiantById(long id) {
		return etudiantDao.selectEtudiantById(id);
	}

	public Team deleteTeam(long idTeam) {
		return teamDao.deleteTeam(idTeam);
	}

	public Team selectTeamById(long id) {
		return teamDao.selectTeamById(id);
	}

	public int addTeam(Team team) {
		return teamDao.addTeam(team);
	}
	public Team deleteTeam(int idTeam) {
		return teamDao.deleteTeam(idTeam);
	}
	public List<Team> selectAllTeam() {
		return teamDao.selectAllTeam();
	}
	public Team selectTeamById(int id) {
		return teamDao.selectTeamById(id);
	}

	public int updateTeam(long teamId , Team team) {
		return teamDao.updateTeam(teamId,team);
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
	public List<File> selectFileById(long id) {
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
	public List<Liverable> selectLiverableById(long id) {
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
	public List<Matiere> selectMatiereById(long id) {
		return matiereDao.selectMatiereById(id);
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
