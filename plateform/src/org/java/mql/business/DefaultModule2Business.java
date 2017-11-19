package org.java.mql.business;

import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.java.mql.dao.DaoMediator;
import org.java.mql.models.p01.Etudiant;
import org.java.mql.models.p01.Team;
import org.java.mql.models.p02.AbstractFile;
import org.java.mql.models.p02.File;
import org.java.mql.models.p02.Liverable;
import org.java.mql.models.p02.Project;




public class DefaultModule2Business implements Module2Business{


	private DaoMediator daoMediator;


	private static final Logger log = Logger.getLogger(DefaultModule2Business.class);


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
				Team team = daoMediator.selectTeamById(teamId);
				team.getEtudiants().add(selectEtudiantById(etudiantId));
				return daoMediator.updateTeam(teamId , team);
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
				throw new Exception("team "+id+" not existe");
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
			log.error("DefaultModule2Business.selectTeamById has an error :"+e.getMessage());
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
		return daoMediator.selectAllTeam();
	}



	@Override
	public int addProjectToTeam(long idProject, long teamId) {
		try {
			if(isAnProjectExiste(idProject) && isAnTeamExiste(teamId)) {
				Project project = selectProjectById(idProject);
				Team team = daoMediator.selectTeamById(teamId);
				team.getProjects().add(project);
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
						team.setProjects(projects);
						return projects.remove(i);
					}else {
						throw new Exception("Project  "+idProject + " not found" );
					}
				}
			}
			return null;
		}catch(Exception e) {
			log.fatal("DefaultModule2Business.addListEtudiantsToTeam has an error : "+e.getMessage());
			return null;
		}
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
			log.fatal("error must be resolved in addTeam service : "+ e.getMessage());
			return new Vector<Etudiant>();
		}
	}




	@Override
	public int addProject(Project project) {
		daoMediator.addProjet(project);
		return 0;
	}


	@Override
	public Project removeProject(long idProjet) {
		return daoMediator.deleteProjet(idProjet);
	}


	@Override
	public List<Project> listProjects() {
		return daoMediator.selectAllProjet();
	}


	@Override
	public Team deleteFileFromLiverable(long fileId, long teamId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int addFileToLiverable(File file, long idLiverable) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<Liverable> listLiverables() {
		return daoMediator.selectAllLiverable();
	}


	@Override
	public List<AbstractFile> listFilesInLiverable(long liverableId) {
		return null;
	}



	@Override
	public List<Etudiant> listEtudiantsInTeam(long idTeam) {
		return daoMediator.selectTeamById(idTeam).getEtudiants();
	}





	@Override
	public Etudiant deleteEtudiant(long id) {
		daoMediator.deleteEtudiant(id);
		return null;
	}



	@Override
	public int addEtudiant(Etudiant etudiant) {
		daoMediator.addEtudiant(etudiant);
		return 1;
	}



	@Override
	public Etudiant selectEtudiantById(long id) {
		Etudiant e = daoMediator.selectEtudiantById(id);
		return e;
	}



	@Override
	public int updateEtudiant(long idEtudiant , Etudiant etudiant) {
		daoMediator.updateEtudiant(idEtudiant , etudiant);
		return 1;

	}

	public DaoMediator getDaoMediator() {
		return daoMediator;
	}


	public void setDaoMediator(DaoMediator daoMediator) {
		this.daoMediator = daoMediator;
	}





	@Override
	public Project selectProjectById(long idProject) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAnEtudiantExiste(long idEtudiant) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public int updateProject(long idProject, Project project) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isAnTeamExiste(long idEtudiant) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isAnProjectExiste(long idEtudiant) {
		// TODO Auto-generated method stub
		return false;
	}






}
