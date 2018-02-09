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
	
	
	

	public int addEnseignant(Enseignant Enseignant) {
		return EnseignantDao.addEnseignant(Enseignant);
	}

	public Enseignant deleteEnseignant(Enseignant enseignant) {
		return EnseignantDao.deleteEnseignant(enseignant);
	}

	public List<Enseignant> selectAllEnseignant() {
		return EnseignantDao.selectAllEnseignant();
	}

	public Enseignant selectEnseignantById(long enseignantId) {
		return EnseignantDao.selectEnseignantById(enseignantId);
	}

	public int updateEnseignant(Enseignant enseignant) {
		return EnseignantDao.updateEnseignant(enseignant);
	}

	public int addEtudiant(Etudiant etudiant) {
		return etudiantDao.addEtudiant(etudiant);
	}

	public Etudiant deleteEtudiant(Etudiant etudiant) {
		return etudiantDao.deleteEtudiant(etudiant);
	}

	public List<Etudiant> selectAllEtudiant() {
		return etudiantDao.selectAllEtudiant();
	}

	public Etudiant selectEtudiantById(long id) {
		return etudiantDao.selectEtudiantById(id);
	}

	public int updateEtudiant(Etudiant etudiant) {
		return etudiantDao.updateEtudiant(etudiant);
	}

	public int addTeam(Team team) {
		return teamDao.addTeam(team);
	}

	public Team deleteTeam(Team team) {
		return teamDao.deleteTeam(team);
	}

	public List<Team> selectAllTeam() {
		return teamDao.selectAllTeam();
	}

	public Team selectTeamById(long id) {
		return teamDao.selectTeamById(id);
	}

	public int updateTeam(Team team) {
		return teamDao.updateTeam(team);
	}
	public void setMediator(DaoMediator daoMediator) {
		fileDao.setMediator(daoMediator);
	}

	public int addFile(File file) {
		return fileDao.addFile(file);
	}

	public File deleteFile(File file) {
		return fileDao.deleteFile(file);
	}

	public List<File> selectAllFile() {
		return fileDao.selectAllFile();
	}

	public File selectFileById(long id) {
		return fileDao.selectFileById(id);
	}

	public int updateFile(File file) {
		return fileDao.updateFile(file);
	}

	public int addLiverable(Liverable liverable) {
		return liverableDao.addLiverable(liverable);
	}

	public Liverable deleteLiverable(Liverable liverable) {
		return liverableDao.deleteLiverable(liverable);
	}

	public List<Liverable> selectAllLiverable() {
		return liverableDao.selectAllLiverable();
	}

	public Liverable selectLiverableById(long id) {
		return liverableDao.selectLiverableById(id);
	}

	public int updateLiverable(Liverable liverable) {
		return liverableDao.updateLiverable(liverable);
	}

	public int addMatiere(Matiere matiere) {
		return matiereDao.addMatiere(matiere);
	}

	public Matiere deleteMatiere(Matiere matiere) {
		return matiereDao.deleteMatiere(matiere);
	}

	public List<Matiere> selectAllMatiere() {
		return matiereDao.selectAllMatiere();
	}

	public Matiere selectMatierById(long id) {
		return matiereDao.selectMatierById(id);
	}

	public int updateMatiere(Matiere matiere) {
		return matiereDao.updateMatiere(matiere);
	}

	public int addProjet(Project projet) {
		return projectDao.addProjet(projet);
	}

	public Project deleteProjet(Project project) {
		return projectDao.deleteProjet(project);
	}

	public List<Project> selectAllProjet() {
		return projectDao.selectAllProjet();
	}

	public Project selectProjetById(long id) {
		return projectDao.selectProjetById(id);
	}
	
	public List<Project> selectAllProjectByMatiere(String matiereName) { // YcDev
		return projectDao.selectAllProjectByMatiere(matiereName);
	}

	public int updateProjet(Project projet) {
		return projectDao.updateProjet(projet);
	}

	public void print() {
		System.out.println("Hello From DaoMediator");
		
	}
	
}