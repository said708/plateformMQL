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
			if(team != null) {
				log.info("team with id="+team.getId()+" added  with success");
				return daoMediator.addTeam(team);
			}
			else
				throw new Exception("team must be not null");
		} catch (Exception e) {
			log.fatal("error must be resolved in addTeam service : "+ e.getMessage());
			return -1;
		}
		
	}


	@Override
	public Team deleteTeam(long id) {
		try {
			if(id >= 0) {
				log.info("team with id="+id+" deleted  with success");
				return daoMediator.deleteTeam(id);
			}else {
				throw new Exception("team id must be superior of 0");
			}
		} catch (Exception e) {
			log.error("DefaultModule2Business.deleteTeam has an error :"+e.getMessage());
			return null;
		}
		
		
	}

	
	public int addEtudiantToTeam(Etudiant etudiant, long teamId) {
		try {
			Team team = daoMediator.selectTeamById(teamId);
			team.getEtudiants().add(etudiant);
			daoMediator.updateTeam(teamId , team);
			return 1;
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
		daoMediator.updateTeam(idTeam  , team);
		return 1;
	}

	
	@Override
	public Etudiant removeEtudiantFromTeam(long studentId, long teamId) {
		Etudiant etudiant = null;
		try {
			etudiant = daoMediator.selectEtudiantById(studentId);
			Team team = daoMediator.selectTeamById(teamId);
			List<Etudiant> etds = team.getEtudiants();
			
			for (int i = 0; i < etds.size(); i++) {
				if(etds.get(i).getId() == studentId) {
					etds.remove(i);
				}
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
	public int addProjectToTeam(Project project, long teamId) {
		try {
			Team team = daoMediator.selectTeamById(teamId);
			team.getProjects().add(project);
			return 1;
		}catch(Exception e) {
			log.fatal("etudiant or team with specific " + teamId+" are not found");
			return -1;
		}
	}


	@Override
	public void addListEtudiantsToTeam(List<Etudiant> etudiants, long teamId) {
		try {
			for (Etudiant etudiant : etudiants) {
				if(etudiant != null)
					this.addEtudiantToTeam(etudiant, teamId);
				else {
					throw new Exception("etudiant list  has member with  null value");
				}
			}
		} catch (Exception e) {
			log.error("DefaultModule2Business.addListEtudiantsToTeam has an error :"+e.getMessage());
		}
		
	}


	@Override
	public Project removeProjectFromTeam(long projectId, long teamId) {
		try {
			Team team = daoMediator.selectTeamById(teamId);
			List<Project> projects = team.getProjects();
			for (int i = 0; i < projects.size(); i++) {
				if(projects.get(i).getId() == projectId) {
					team.setProjects(projects);
					return projects.remove(i);
				}else {
					throw new Exception("Project with id : "+projectId + " not found" );
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
	public Project removeProject(Project projet) {
		return daoMediator.deleteProjet(projet.getId());
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


	



}
