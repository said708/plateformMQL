package org.java.mql.business;

import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.java.mql.dao.DaoMediator;
import org.java.mql.models.p1.Etudiant;
import org.java.mql.models.p1.Team;
import org.java.mql.models.p2.AbstractFile;
import org.java.mql.models.p2.File;
import org.java.mql.models.p2.Liverable;
import org.java.mql.models.p2.Project;




public class DefaultModule2Business implements Module2Business{


	private DaoMediator daoMediator;


	private static final Logger log = Logger.getLogger(DefaultModule2Business.class);

	public DefaultModule2Business() {
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
				Team team = daoMediator.selectTeamById(teamId);
				//team.getEtudiants().add(selectEtudiantById(etudiantId));
				 daoMediator.updateTeam(teamId , team);
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
	public Etudiant removeEtudiantFromTeam(long studentId, long teamId) {
		Etudiant etudiant = null;
		try {
			if(isAnEtudiantExiste(studentId) && isAnTeamExiste(teamId)) {
				etudiant = daoMediator.selectEtudiantById(studentId);
				Team team = daoMediator.selectTeamById(teamId);
				List<Etudiant> etds = team.getEtudiants();

				for (int i = 0; i < etds.size(); i++) {
					if(etds.get(i).getId() == studentId) {
						etds.remove(i);
					}
				}
				team.setEtudiants(etds);
			}else {
				throw new Exception("team "+teamId+" or  etudiant "+studentId+" not existe");
			}
		}catch(Exception e) {
			log.error("DefaultModule2Business.removeEtudiantFromTeam has an error :"+e.getMessage());
		}
		return etudiant;
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
				Project project = selectProjectById(idProject);
				Team team = daoMediator.selectTeamById(teamId);
				//team.getProjects().add(project);
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
	public Project removeProjectFromTeam(long idProject, long teamId) {
		try {
			if(isAnProjectExiste(idProject) && isAnTeamExiste(teamId)) {
				Team team = daoMediator.selectTeamById(teamId);
				List<Project> projects = team.getProjects();
				for (int i = 0; i < projects.size(); i++) {
					if(projects.get(i).getId() == idProject) {
						Project project = projects.remove(i);
						team.setProjects(projects);
						return project;
					}
				}
			}else {
				throw new Exception("Project  "+idProject + " not found" );
			}
		}catch(Exception e) {
			log.fatal("DefaultModule2Business.removeProjectFromTeam has an error : "+e.getMessage());
		}
		return null;
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

	//	@Override
	//	public List<Etudiant> listEtudiantsInTeam(long idTeam) {
	//		return null;
	//		List<Etudiant> etudiants = daoMediator.selectTeamById(idTeam).getEtudiants();
	//		try {
	//			if(isAnTeamExiste(idTeam)) {
	//				if(etudiants != null)
	//					return etudiants;
	//				else
	//					throw new Exception("team "+idTeam+" has no etudiant");
	//			}else
	//				throw new Exception("team "+idTeam+" not existed");
	//		} catch (Exception e) {
	//			log.fatal("DefaultModule2Business.listEtudiantsInTeam has an error : "+ e.getMessage());
	//			return new Vector<Etudiant>();
	//		}
	//	}

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

	public DaoMediator getDaoMediator() {
		return daoMediator;
	}


	public void setDaoMediator(DaoMediator daoMediator) {
		this.daoMediator = daoMediator;
	}


	@Override
	public List<Etudiant> listEtudiantsInTeam(long idTeam) {
		// TODO Auto-generated method stub
		return null;
	}

}
