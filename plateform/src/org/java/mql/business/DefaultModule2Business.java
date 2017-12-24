package org.java.mql.business;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.java.mql.dao.DaoMediator;
import org.java.mql.models.p1.Ensignant;
import org.java.mql.models.p1.Etudiant;
import org.java.mql.models.p1.Team;
import org.java.mql.models.p2.AbstractFile;
import org.java.mql.models.p2.File;
import org.java.mql.models.p2.Liverable;
import org.java.mql.models.p2.Matiere;
import org.java.mql.models.p2.Project;




public class DefaultModule2Business implements Module2Business{


	private DaoMediator daoMediator;

	private static final Logger log = Logger.getLogger(DefaultModule2Business.class);

	public DefaultModule2Business() {
	}
	
	public DaoMediator getDaoMediator() {
		return daoMediator;
	}


	public void setDaoMediator(DaoMediator daoMediator) {
		this.daoMediator = daoMediator;
	}
	
	
	// =============================== Team ==================================
	
	@Override
	public int addTeam(Team team) {
		try {
			if(team != null && !isAnTeamExiste(team.getId())) {
				log.info("team with id="+team.getId()+" added  with success");
				return daoMediator.addTeam(team);
			}
			else
				throw new Exception("team is null or duplicated");
		} catch (Exception e) {
			log.fatal("error must be resolved in addTeam service : "+ e.getMessage());
			return -1;
		}
	}


	@Override
	public Team deleteTeam(long teamId) {
		try {
			if(isAnTeamExiste(teamId)) 
				return daoMediator.deleteTeam(teamId);
			else 
				throw new Exception("team "+teamId+" not existe");
		} catch (Exception e) {
			log.error("DefaultModule2Business.deleteTeam has an error :"+e.getMessage());
			return null;
		}


	}

	@Override
	public int addEtudiantToTeam(long etudiantId, long teamId) {
		try {
			if(isAnEtudiantExiste(etudiantId) && isAnTeamExiste(teamId)) {
				return daoMediator.addEtudiantToTeam( etudiantId,  teamId);
			}else {
				throw new Exception("team "+teamId+"  or  etudiant "+etudiantId+" not existe");
			}
		}catch(Exception e) {
			log.error("DefaultModule2Business.addEtudiantToTeam has an error :"+e.getMessage());
			return -1;
		}

	}


	@Override
	public Team selectTeamById(long id) {
		try {
			if(isAnTeamExiste(id)) {
				Team team = daoMediator.selectTeamById(id);
				return team;
			}else 
				throw new Exception("team "+id+" not exist");
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectTeamById has an error :"+e.getMessage());
			return null;
		}
	}



	@Override
	public int updateTeam(long idTeam , Team team) {
		try {
			if(isAnTeamExiste(idTeam)) {
				daoMediator.updateTeam(idTeam  , team);
				return 1;
			}else 
				throw new Exception("team "+idTeam+" not existe");
		}catch(Exception e) {
			log.error("DefaultModule2Business.updateTeam has an error :"+e.getMessage());
			return -1;
		}
	}


	@Override
	public int removeEtudiantFromTeam(long studentId, long team_id) {
		try {
			if(isAnEtudiantExiste(studentId) && isAnTeamExiste(team_id)) {
				daoMediator.removeEtudiantFromTeam(studentId,  team_id);
		        return 1;
			}else {
				throw new Exception("Etudiant  "+ studentId + " not found" );
			}
		}catch(Exception e) {
			log.fatal("DefaultModule2Business.removeEtudiantFromTeam has an error : "+e.getMessage());
		}
		return 0;		 
	}


	@Override
	public List<Team> listTeams() {
		List<Team> allteams = daoMediator.selectAllTeam();
		try {
			if(allteams != null)
				return allteams;
			else
				throw new Exception("Teams table is empty");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listTeams has an error : "+ e.getMessage());
			return new Vector<Team>();
		}
	}



	@Override
	public int addProjectToTeam(long projectId, long teamId) {
		try {
			if(isAnProjectExiste(projectId) && isAnTeamExiste(teamId)) {
				int team = daoMediator.addProjectToTeam(projectId, teamId);
				return team;
			}else {
				throw new Exception("team "+teamId+" or  project "+projectId+" not exist");
			}
		}catch(Exception e) {
			log.error("DefaultModule2Business.addProjectToTeam has an error :"+e.getMessage());
			return -1;
		}
	}


	@Override
	public void addListEtudiantsToTeam(long teamId , long ...etdsId) {
		try {
			if(isAnTeamExiste(teamId)) {
				for (long etudiant : etdsId) {
					if(isAnEtudiantExiste(etudiant)) {
						this.addEtudiantToTeam(etudiant, teamId);
					}
					else {
						throw new Exception("etudiant "+etudiant+" not exist");
					}
				}
			}else {
				throw new Exception("team "+teamId+" not exist");
			}
		} catch (Exception e) {
			log.error("DefaultModule2Business.addListEtudiantsToTeam has an error :"+e.getMessage());
		}

	}


	@Override
	public int removeProjectFromTeam(long idProject, long teamId) {
		try {
			if(isAnProjectExiste(idProject) && isAnTeamExiste(teamId)) {
				daoMediator.removeProjectFromTeam(idProject, teamId);
						return 1;
			}else {
				throw new Exception("Project  "+idProject + " not found" );
			}
		}catch(Exception e) {
			log.fatal("DefaultModule2Business.removeProjectFromTeam has an error : "+e.getMessage());
		}
		return 0;
	}


	
	@Override
	public List<Etudiant> listEtudiantsInTeam(long idTeam) {
		
		List<Etudiant> etudiants = daoMediator.listEtudiantsInTeam(idTeam);
		try {
			if(isAnTeamExiste(idTeam)) {
				if(etudiants != null)
					return etudiants;
				else
					throw new Exception("team "+idTeam+" has no etudiant");
			}else
				throw new Exception("team "+idTeam+" not existed");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listEtudiantsInTeam has an error : "+ e.getMessage());
			return new Vector<Etudiant>();
		}
	}

	
	@Override
	public boolean isAnTeamExiste(long idTeam) {
		for (Team team : listTeams()) 
			if(idTeam == team.getId())
				return true;
		return false;
	}
	
	
// ============================== etudiant ==================================


	@Override
	public List<Etudiant> listEtudiants() {
		List<Etudiant> allEtds = daoMediator.selectAllEtudiant();
		try {
			if(allEtds != null)
				return allEtds;
			else
				throw new Exception("etudiant table is empty");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listEtudiants has an error : "+ e.getMessage());
			return new Vector<Etudiant>();
		}
	}
	
	
	@Override
	public Etudiant deleteEtudiant(long id) {
		try {
			if(isAnEtudiantExiste(id)) {
				return daoMediator.deleteEtudiant(id);
			}else
				throw new Exception("etudiant "+id+" not existed");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.deleteEtudiant has an error : "+ e.getMessage());
			return null;
		}
	}



	@Override
	public int addEtudiant(Etudiant etudiant) {
		try {
			if(!isAnEtudiantExiste(etudiant.getId()) && etudiant!=null) {
				return daoMediator.addEtudiant(etudiant);
			}else
				throw new Exception("etudiant is already exist or null");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.addEtudiant has an error : "+ e.getMessage());
			return -1;
		}
	}

	
	@Override
	public Etudiant selectEtudiantById(long id) {
		try {
			if(isAnEtudiantExiste(id)) {
				Etudiant etudiant = daoMediator.selectEtudiantById(id);
				return etudiant;
			}else 
				throw new Exception("etudiant "+id+" not exist");
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectEtudiantById has an error :"+e.getMessage());
			return null;
		}
	}



	@Override
	public int updateEtudiant(long idEtudiant , Etudiant etudiant) {
		try {
			if(isAnEtudiantExiste(idEtudiant)) {
				return daoMediator.updateEtudiant(idEtudiant  , etudiant);
			}else 
				throw new Exception("etudiant "+idEtudiant+" not existe");
		}catch(Exception e) {
			log.error("DefaultModule2Business.updateEtudiant has an error :"+e.getMessage());
			return -1;
		}


	}

	@Override
	public void addListEtudiants(List<Etudiant> etudiants) {
		for (Etudiant etudiant : etudiants) {
			this.addEtudiant(etudiant);
		}
	}
	@Override
	public boolean isAnEtudiantExiste(long idEtudiant) {
		for (Etudiant etd : listEtudiants()) 
			if(idEtudiant == etd.getId())
				return true;
		return false;
	}
	// ============================ =Projet ====================================


	@Override
	public List<Project> listProjects() {
		List<Project> allProjects = daoMediator.selectAllProjet();
		try {
			if(allProjects != null)
				return allProjects;
			else
				throw new Exception("Projects table is empty");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listProjects has an error : "+ e.getMessage());
			return new Vector<Project>();
		}
	}


	
	@Override
	public Project selectProjectById(long idProject) {
		try {
			if(isAnProjectExiste(idProject)) {
				Project project = daoMediator.selectProjetById(idProject);
				return project;
			}else 
				throw new Exception("projet "+idProject+" not exist");
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectProjectById has an error :"+e.getMessage());
			return null;
		}	
	}


	@Override
	public int updateProject(long idProject, Project project) {
		try {
			if(isAnProjectExiste(idProject)) {
				return daoMediator.updateProjet(idProject, project);
			}else 
				throw new Exception("project "+idProject+" not existe");
		}catch(Exception e) {
			log.error("DefaultModule2Business.updateProject has an error :"+e.getMessage());
			return -1;
		}
	}
	
	
	@Override
	public int addProject(Project project) {
		try {
			if(!isAnProjectExiste(project.getId()) && project!=null) {
				return daoMediator.addProjet(project);
			}else
				throw new Exception("project is already exist or null");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.addProject has an error : "+ e.getMessage());
			return -1;
		}
	}


	@Override
	public Project deleteProject(long idProjet) {
		try {
			if(isAnEtudiantExiste(idProjet)) {
				return daoMediator.deleteProjet(idProjet);
			}else
				throw new Exception("project "+idProjet+" not existed");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.deleteProject has an error : "+ e.getMessage());
			return null;
		}
	}


	@Override
	public boolean isAnProjectExiste(long idProject) {
		for (Project project : listProjects()) 
			if(idProject == project.getId())
				return true;
		return false;
	}



// =================================  Livrable =======================================

	@Override
	public List<Liverable> listLiverables() {
		List<Liverable> allLiverable = daoMediator.selectAllLiverable();
		try {
			if(allLiverable != null)
				return allLiverable;
			else
				throw new Exception("Liverable table is empty");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listLiverables has an error : "+ e.getMessage());
			return new Vector<Liverable>();
		}
	}

	
	@Override
	public int addLivrable(Liverable livrable) {
		
		try {
			if(!isAnLiverableExiste(livrable.getId()) && livrable!=null) {
				return daoMediator.addLiverable(livrable);
			}else
				throw new Exception("livrable is already exist or null");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.addLivrable has an error : "+ e.getMessage());
			return -1;
		}
		 
		
	}


	@Override
	public Liverable deleteLivrable(long idLivrable) {
		try {
			if(isAnLiverableExiste(idLivrable)) {
				return daoMediator.deleteLiverable(idLivrable);
			}else
				throw new Exception("project "+idLivrable+" not existed");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.deleteLiverable has an error : "+ e.getMessage());
			return null;
		}
	}


	@Override
	public Liverable selectLivrableById(long idLivrable) {
		try {
			if(isAnLiverableExiste(idLivrable)) {
				Liverable livrable = daoMediator.selectLiverableById(idLivrable);
				return livrable;
			}else 
				throw new Exception("livrable "+idLivrable+" not existe");
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectlivrableById has an error :"+e.getMessage());
			return null;
		}
	}


	@Override
	public int updateLiverable(long idLiverable, Liverable liverable) {
		try {
			if(isAnLiverableExiste(idLiverable)) {
				daoMediator.updateLiverable(idLiverable  , liverable);
				return 1;
			}else 
				throw new Exception("Liverable "+idLiverable+" not existe");
		}catch(Exception e) {
			log.error("DefaultModule2Business.updateLiverable has an error :"+e.getMessage());
			return -1;
		}
	}

	@Override
	public List<AbstractFile> listFilesInLiverable(long liverableId) {
		Liverable liverable = daoMediator.selectLiverableById(liverableId);
		List<AbstractFile> allFilesInLverable = liverable.getFiles();
		try {
			if(allFilesInLverable != null)
				return allFilesInLverable;
			else
				throw new Exception("Liverable has no file");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listFilesInLiverable has an error : "+ e.getMessage());
			return new Vector<AbstractFile>();
		}
	}



	





	@Override
	public AbstractFile deleteFileFromLiverable(long fileId, long liverableId) {
		try {
			if(isAnFileExisteInLiverable(fileId , liverableId) && isAnLiverableExiste(liverableId)) {
				Liverable liverable = daoMediator.selectLiverableById(liverableId);
				List<AbstractFile> files = liverable.getFiles();
				for (int i = 0; i < files.size(); i++) {
					if(files.get(i).getId() == fileId) {
						AbstractFile file = files.remove(i);
						liverable.setFiles(files);
						return file;
					}
				}
			}else {
				throw new Exception("File  "+fileId + " or liverable "+liverableId+" not found" );
			}
			return null;
		}catch(Exception e) {
			log.fatal("DefaultModule2Business.deleteFileFromLiverable has an error : "+e.getMessage());
			return null;
		}
	}




	@Override
	public boolean isAnFileExisteInLiverable(long fileId , long liverableId) {
		try {
			if(isAnLiverableExiste(liverableId)) {
				for (AbstractFile file : listFilesInLiverable(liverableId)) {
					if(fileId == file.getId()) {
						return true;
					}
				}
			}else {
				throw new Exception("liverable "+liverableId+" not found" );
			}
			return false;
		}catch(Exception e) {
			log.fatal("DefaultModule2Business.isAnFileExisteInLiverable has an error : "+e.getMessage());
			return false;
		}
	}


	@Override
	public int addFileToLiverable(File file, long liverableId) {
		try {
			if(isAnLiverableExiste(liverableId) && !isAnFileExisteInLiverable(file.getId(), liverableId) && file != null) {
				Liverable liverable = daoMediator.selectLiverableById(liverableId);
				liverable.getFiles().add(file);
				return daoMediator.updateLiverable(liverableId, liverable);
			}else {
				throw new Exception("file "+file.getId()+"  is already existe or null /  liverable "+liverableId+" not existe");
			}
		}catch(Exception e) {
			log.error("DefaultModule2Business.addFileToLiverable has an error :"+e.getMessage());
			return -1;
		}
	}



	@Override
	public boolean isAnLiverableExiste(long liverableId) {
		for (Liverable liverable : listLiverables()) 
			if(liverableId == liverable.getId())
				return true;
		return false;
	}


// ================== Enseignant ========================================



	@Override
	public int addEnseignant(Ensignant enseignant) {
		try {
			if(enseignant != null && !isAnTeamExiste(enseignant.getId())) {
				log.info("enseignant with id="+enseignant.getId()+" added  with success");
				return daoMediator.addEnsignant(enseignant);
			}
			else
				throw new Exception("enseignant is null or duplicated");
		} catch (Exception e) {
			log.fatal("error must be resolved in addenseignant service : "+ e.getMessage());
			return -1;
		}

	}

	
	@Override
	public Ensignant selectEnsignantById(long idEnseignant) {
		
		try {
			if(isAnEnsignantExiste(idEnseignant)) {
				Ensignant enseignant = daoMediator.selectEnsignantById(idEnseignant);
				return enseignant;
			}else 
				throw new Exception("Ensignant "+idEnseignant+" not exist");
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectEnsignantById has an error :"+e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Ensignant> listEnseigants() {
		List<Ensignant> allEnsignants = daoMediator.selectAllEnsignant();
		try {
			if(allEnsignants != null)
				return allEnsignants;
			else
				throw new Exception("Ensignants table is empty");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listProjects has an error : "+ e.getMessage());
			return new Vector<Ensignant>();
		}
	}

	
	@Override
	public boolean isAnEnsignantExiste(long idEnseignant) {
		for (Ensignant ensignant : listEnseigants()) 
			if(idEnseignant == ensignant.getId())
				return true;
		return false;
	}

// ==================================== matiere =========================
	
	@Override
	public int addMatiere(Matiere matiere) {
		try {
			if(matiere != null && !isAnTeamExiste(matiere.getId())) {
				log.info("team with id="+matiere.getId()+" added  with success");
				return daoMediator.addMatiere(matiere);
			}
			else
				throw new Exception("matiere is null or duplicated");
		} catch (Exception e) {
			log.fatal("error must be resolved in addmatiere service : "+ e.getMessage());
			return -1;
		}
	}


	@Override
	public Matiere selectMatiereById(long idMatiere) {
		
		try {
			if(isAnMatiereExiste(idMatiere)) {
				Matiere matiere = daoMediator.selectMatiereById(idMatiere);
				return matiere;
			}else 
				throw new Exception("Matiere "+idMatiere+" not exist");
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectMatiereById has an error :"+e.getMessage());
			return null;
		}
		
	}
	
	@Override
	public boolean isAnMatiereExiste(long idMatiere) {
		for (Matiere matiere : listMatieres()) 
			if(idMatiere == matiere.getId())
				return true;
		return false;
	}

	@Override
	public List<Matiere> listMatieres() {
		List<Matiere> allMatieres = daoMediator.selectAllMatiere();
		try {
			if(allMatieres != null)
				return allMatieres;
			else
				throw new Exception("Matieres table is empty");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listMatieres has an error : "+ e.getMessage());
			return new Vector<Matiere>();
		}
	}

	



	







}
