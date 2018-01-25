package org.java.mql.business;

import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.java.mql.dao.mediator.DaoMediator;
import org.java.mql.models.File;
import org.java.mql.models.Enseignant;
import org.java.mql.models.Etudiant;
import org.java.mql.models.Liverable;
import org.java.mql.models.Matiere;
import org.java.mql.models.Project;
import org.java.mql.models.Team;




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


	@Override
	public int addTeam(Team team) {
		try {
			if(team != null && !isAnTeamExiste(team.getId())) {
				log.info("team with id="+team.getId()+" added  with success");
				 daoMediator.addTeam(team);
				 return 1;
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
				
				 daoMediator.addEtudiantToTeam(etudiantId, teamId);
				 return 1;
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

		Team team = daoMediator.selectTeamById(id);
		return team;

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
	public int removeEtudiantFromTeam(long studentId, long teamId) {
		
		try {
			if(isAnEtudiantExiste(studentId) && isAnTeamExiste(teamId)) {
				 daoMediator.removeEtudiantFromTeam(studentId, teamId);
				
			}else {
				throw new Exception("team "+teamId+" or  etudiant "+studentId+" not existe");
			}
		}catch(Exception e) {
			log.error("DefaultModule2Business.removeEtudiantFromTeam has an error :"+e.getMessage());
		}
		return 1;
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
	public int addProjectToTeam(long idProject, long teamId) {
		try {
			if(isAnProjectExiste(idProject) && isAnTeamExiste(teamId)) {
			 daoMediator.addProjectToTeam(idProject, teamId);
				
				return 1;
			}else {
				throw new Exception("team "+teamId+" or  project "+idProject+" not existe");
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
						throw new Exception("etudiant "+etudiant+" not existe");
					}
				}
			}else {
				throw new Exception("team "+teamId+" not existe");
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
	public List<Etudiant> listEtudiants() {
		List<Etudiant> allEtds = daoMediator.selectAllEtudiant();
		try {
			if(allEtds != null)
				return allEtds;
			else
				throw new Exception("etudiants table is empty");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listEtudiants has an error : "+ e.getMessage());
			return new Vector<Etudiant>();
		}
	}


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
	public List<File> listFilesInLiverable(long liverableId) {
		Liverable liverable = daoMediator.selectLiverableById(liverableId);
		List<File> allFilesInLiverable = liverable.getFiles();
		try {
			if(allFilesInLiverable != null)
				return allFilesInLiverable;
			else
				throw new Exception("Liverable has no file");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listFilesInLiverable has an error : "+ e.getMessage());
			return new Vector<File>();
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
				daoMediator.addEtudiant(etudiant);
				return 1;
			}else
				throw new Exception("etudiant is already exist or null");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.addEtudiant has an error : "+ e.getMessage());
			e.printStackTrace();// added by YC for test
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
	public Etudiant selectEtudiantById(long id) {
		try {
			if(isAnEtudiantExiste(id)) {
				Etudiant etudiant = daoMediator.selectEtudiantById(id);
				return etudiant;
			}else 
				throw new Exception("etudiant "+id+" not existe");
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectEtudiantById has an error :"+e.getMessage());
			return null;
		}
	}



	@Override
	public int updateEtudiant(long idEtudiant , Etudiant etudiant) {
		try {
			if(isAnEtudiantExiste(idEtudiant)) {
				daoMediator.updateEtudiant(idEtudiant  , etudiant);
				return  1;
			}else 
				throw new Exception("etudiant "+idEtudiant+" not existe");
		}catch(Exception e) {
			log.error("DefaultModule2Business.updateEtudiant has an error :"+e.getMessage());
			return -1;
		}


	}


	@Override
	public Project selectProjectById(long idProject) {
		try {
			if(isAnEtudiantExiste(idProject)) {
				Project project = daoMediator.selectProjetById(idProject);
				return project;
			}else 
				throw new Exception("Project "+idProject+" not existe");
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
	public boolean isAnEtudiantExiste(long idEtudiant) {
		for (Etudiant etd : listEtudiants()) 
			if(idEtudiant == etd.getId())
				return true;
		return false;
	}

	@Override
	public boolean isAnTeamExiste(long idTeam) {
		for (Team team : listTeams()) 
			if(idTeam == team.getId())
				return true;
		return false;
	}


	@Override
	public boolean isAnProjectExiste(long idProject) {
		for (Project project : listProjects()) 
			if(idProject == project.getId())
				return true;
		return false;
	}

	// YcDev
	public int addLiverable(Liverable liverable) {
		try {
			if (!isAnLiverableExiste(liverable.getId()) && liverable != null) {
				daoMediator.addLiverable(liverable);
				log.info("Liverable was added successfully !");
				return 1;
			}
			else {
				throw new Exception("Liverable already exist or it's null");
			}
		} catch (Exception e) {
			log.error("DefaultModule2Business.addLiverable() has encountered an error : " + e.getMessage());
			return 0;
		}
		
	}

	@Override
	public File deleteFileFromLiverable(long fileId, long liverableId) {
		try {
			if(isAnFileExisteInLiverable(fileId , liverableId) && isAnLiverableExiste(liverableId)) {
				Liverable liverable = daoMediator.selectLiverableById(liverableId);
				List<File> files = liverable.getFiles();
				for (int i = 0; i < files.size(); i++) {
					if(files.get(i).getId() == fileId) {
						File file = files.remove(i);
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
	public boolean isAnLiverableExiste(long liverableId) {
		for (Liverable liverable : listLiverables()) 
			if(liverableId == liverable.getId())
				return true;
		return false;
	}


	@Override
	public boolean isAnFileExisteInLiverable(long fileId , long liverableId) {
		try {
			if(isAnLiverableExiste(liverableId)) {
				for (File file : listFilesInLiverable(liverableId)) {
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
				System.out.println("********* File was added successfully! *********");
				return updateLiverable(liverableId, liverable);
			}else {
				throw new Exception("file "+file.getId()+"  is already existe or null /  liverable "+liverableId+" not existe");
			}
		}catch(Exception e) {
			log.error("DefaultModule2Business.addFileToLiverable has an error :"+e.getMessage());
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
	public List<Etudiant> listEtudiantsInTeam(long idTeam) {
		
			List<Etudiant> etudiants = daoMediator.selectEtudinatsInTeams(idTeam);
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
	public List<Matiere> listeMatieres() {
		List<Matiere> allMatiere = daoMediator.selectAllMatiere();
		try {
			if(allMatiere != null)
				return allMatiere;
			else
				throw new Exception("Matiere table is empty");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listMatiere has an error : "+ e.getMessage());
			return new Vector<Matiere>();
		}
	}


	@Override
	public int addMatiere(Matiere matiere) {
		try {
			if(matiere != null && !isAnMatiereExiste(matiere.getId())) {
				log.info("matiere with id="+matiere.getId()+" added  with success");
				 daoMediator.addMatiere(matiere);
				 return 1;
			}
			else
				throw new Exception("matiere is null or duplicated");
		} catch (Exception e) {
			log.fatal("error must be resolved in addmatiere service : "+ e.getMessage());
			return -1;
		}
	}


	@Override
	public boolean isAnMatiereExiste(long matiereId) {
		for (Matiere matiere : listeMatieres()) 
			if(matiereId == matiere.getId())
				return true;
		return false;
	}


	@Override
	public Enseignant selectEnseignantById(long idEnseignant) {
		try {
			if(isAnEnseignantExiste(idEnseignant)) {
				Enseignant enseignant = daoMediator.selectEnseignantById(idEnseignant);
				return enseignant;
			}else 
				throw new Exception("Enseignant "+idEnseignant+" not exist");
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectEnseignantById has an error :"+e.getMessage());
			return null;
		}
	}


	@Override
	public boolean isAnEnseignantExiste(long enseignantId) {
		for (Enseignant enseignant : listeEnseignats()) 
			if(enseignantId == enseignant.getId())
				return true;
		return false;
	}


	@Override
	public List<Enseignant> listeEnseignats() {
		List<Enseignant> allEnseignant = daoMediator.selectAllEnseignant();
		try {
			if(allEnseignant != null)
				return allEnseignant;
			else
				throw new Exception("Enseignant table is empty");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listEnseignant has an error : "+ e.getMessage());
			return new Vector<Enseignant>();
		}
	}


	@Override
	public int addEnseignant(Enseignant Enseignant) {
		try {
			if(Enseignant != null && !isAnEnseignantExiste(Enseignant.getId())) {
				log.info("Enseignant with id="+Enseignant.getId()+" added  with success");
				 daoMediator.addEnseignant(Enseignant);
				 return 1;
			}
			else
				throw new Exception("Enseignant is null or duplicated");
		} catch (Exception e) {
			log.fatal("error must be resolved in addEnseignant service : "+ e.getMessage());
			return -1;
		}
	}


	@Override
	public Liverable selectLivrableById(long idLivrable) {
		try {
			if(isAnLiverableExiste(idLivrable)) {
				Liverable livrable = daoMediator.selectLiverableById(idLivrable);
				return livrable;
			}else 
				throw new Exception("Livrable "+idLivrable+" not exist");
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectLivrableById has an error :"+e.getMessage());
			return null;
		}
	}


	@Override
	public int addLivrable(Liverable livrable) {
		try {
			if(livrable != null && !isAnLiverableExiste(livrable.getId())) {
				log.info("livrable with id="+livrable.getId()+" added  with success");
				 daoMediator.addLiverable(livrable);
				 return 1;
			}
			else
				throw new Exception("livrable is null or duplicated");
		} catch (Exception e) {
			log.fatal("error must be resolved in addlivrable service : "+ e.getMessage());
			return -1;
		}

	}


	@Override
	public int updateLivrable(long idLivrable, Liverable livrable) {
		try {
			if(isAnLiverableExiste(idLivrable)) {
				return daoMediator.updateLiverable(idLivrable, livrable);
			}else 
				throw new Exception("Livrable "+idLivrable+" not exist");
		}catch(Exception e) {
			log.error("DefaultModule2Business.updateLivrable has an error :"+e.getMessage());
			return -1;
		}
	}


	// Added by YcDev
	public int updateLiverable(long liverableId, Liverable liverable) {
		try {
			if (isAnLiverableExiste(liverableId) && liverable != null) {
				daoMediator.updateLiverable(liverableId, liverable);
				log.info("Liverable with id \"" + liverableId + "\" was updated successfully !");
				return 1;
			}
			else {
				throw new Exception("Liverable doesn't exist or it's null !");
			}
		} catch (Exception e) {
			log.error("DefaultModule2Business.updateLiverable() has encountered an error : "+ e.getMessage());
			return 0;
		}
		
	}
	
	@Override
	public String toString() {
		return "bonjour said is work now !";
	}

}