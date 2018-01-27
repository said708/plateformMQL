package org.java.mql.business;

import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.java.mql.dao.mediator.DaoMediator;
import org.java.mql.models.Enseignant;
import org.java.mql.models.Etudiant;
import org.java.mql.models.File;
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
			if(team != null && !isAnTeamExiste(team)) {
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
	public Team deleteTeam(Team team) {
		try {
			if(isAnTeamExiste(team)) 
				return daoMediator.deleteTeam(team);
			else 
				throw new Exception("team "+team.getId()+" not existe");
		} catch (Exception e) {
			log.error("DefaultModule2Business.deleteTeam has an error :"+e.getMessage());
			return null;
		}


	}

	@Override
	public int addEtudiantToTeam(Etudiant etudiant, Team team) {
		try {
			if(isAnEtudiantExiste(etudiant) && isAnTeamExiste(team)) {
				etudiant.setTeam(team);
				return daoMediator.updateEtudiant(etudiant);
			}else {
				throw new Exception("team "+team.getId()+"  or  etudiant "+etudiant.getId()+" not existe");
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
	public int updateTeam(Team team) {
		try {
			if(isAnTeamExiste(team)) {
				daoMediator.updateTeam(team);
				return 1;
			}else 
				throw new Exception("team "+team.getId()+" not existe");
		}catch(Exception e) {
			log.error("DefaultModule2Business.updateTeam has an error :"+e.getMessage());
			return -1;
		}

	}


	@Override
	public int removeEtudiantFromTeam(Etudiant etudiant, Team team) {

		try {
			if(isAnEtudiantExiste(etudiant) && isAnTeamExiste(team)) {
				etudiant.setTeam(null);
				return daoMediator.updateEtudiant(etudiant);

			}else {
				throw new Exception("team "+team.getId()+" or  etudiant "+etudiant.getId()+" not existe");
			}
		}catch(Exception e) {
			log.error("DefaultModule2Business.removeEtudiantFromTeam has an error :"+e.getMessage());
			return -1;
		}
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
	public int addProjectToTeam(Project project, Team team) {
		try {
			if(isAnProjectExiste(project) && isAnTeamExiste(team)) {
				project.setTeam(team);
				return daoMediator.updateProjet(project);
			}else {
				throw new Exception("team "+team.getId()+" or  project "+project.getId()+" not existe");
			}
		}catch(Exception e) {
			log.error("DefaultModule2Business.addProjectToTeam has an error :"+e.getMessage());
			return -1;
		}
	}


	@Override
	public void addListEtudiantsToTeam(Team team , Etudiant ...etds) {
		try {
			if(isAnTeamExiste(team)) {
				for (Etudiant etudiant : etds) {
					if(isAnEtudiantExiste(etudiant)) {
						this.addEtudiantToTeam(etudiant, team);
					}
					else {
						throw new Exception("etudiant "+etudiant+" not existe");
					}
				}
			}else {
				throw new Exception("team "+team.getId()+" not existe");
			}
		} catch (Exception e) {
			log.error("DefaultModule2Business.addListEtudiantsToTeam has an error :"+e.getMessage());
		}

	}


	@Override
	public int removeProjectFromTeam(Project project, Team team) {
		try {
			if(isAnProjectExiste(project) && isAnTeamExiste(team)) {
				project.setTeam(null);
				return daoMediator.updateProjet(project);

			}else {
				throw new Exception("Project  "+project.getId() + " not found" );
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
	public List<File> listFilesInLiverable(Liverable liverable) {
		List<File> files = new Vector<>();
		try {
			if(isAnLiverableExiste(liverable)) {
				for (File file : daoMediator.selectAllFile()) {
					if(file.getLiverable().equals(liverable))
						files.add(file);
				}
			}else {
				throw new Exception("liverable "+liverable.getName()+" not existe");
			}
		} catch (Exception e) {
			log.error("DefaultModule2Business.addListEtudiantsToTeam has an error :"+e.getMessage());
		}
		return files;
	}



	@Override
	public Etudiant deleteEtudiant(Etudiant etudiant) {
		try {
			if(isAnEtudiantExiste(etudiant)) {
				return daoMediator.deleteEtudiant(etudiant);
			}else
				throw new Exception("etudiant "+etudiant.getId()+" not existed");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.deleteEtudiant has an error : "+ e.getMessage());
			return null;
		}
	}



	@Override
	public int addEtudiant(Etudiant etudiant) {
		try {
			if(!isAnEtudiantExiste(etudiant) && etudiant!=null) {
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
			Etudiant etudiant = daoMediator.selectEtudiantById(id);
			return etudiant;
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectEtudiantById has an error :"+e.getMessage());
			return null;
		}
	}



	@Override
	public int updateEtudiant(Etudiant etudiant) {
		try {
			if(isAnEtudiantExiste(etudiant)) {
				daoMediator.updateEtudiant(etudiant);
				return  1;
			}else 
				throw new Exception("etudiant "+etudiant.getId()+" not existe");
		}catch(Exception e) {
			log.error("DefaultModule2Business.updateEtudiant has an error :"+e.getMessage());
			return -1;
		}


	}


	@Override
	public Project selectProjectById(long idProject) {
		try {
			Project project = daoMediator.selectProjetById(idProject);
			return project;
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectProjectById has an error :"+e.getMessage());
			return null;
		}
	}


	@Override
	public int updateProject(Project project) {
		try {
			if(isAnProjectExiste(project)) {
				return daoMediator.updateProjet( project);
			}else 
				throw new Exception("project "+project.getId()+" not existe");
		}catch(Exception e) {
			log.error("DefaultModule2Business.updateProject has an error :"+e.getMessage());
			return -1;
		}
	}

	@Override
	public boolean isAnEtudiantExiste(Etudiant etudiant) {
		for (Etudiant etd : listEtudiants()) 
			if(etudiant.equals(etd))
				return true;
		return false;
	}

	@Override
	public boolean isAnTeamExiste(Team team) {
		for (Team tm : listTeams()) 
			if(team.equals(tm))
				return true;
		return false;
	}


	@Override
	public boolean isAnProjectExiste(Project project) {
		for (Project p : listProjects()) 
			if(p.equals(project))
				return true;
		return false;
	}

	// YcDev
	@Override
	public int addLiverable(Liverable liverable) {
		try {
			if (!isAnLiverableExiste(liverable) && liverable != null) {
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
	public int deleteFileFromLiverable(File file, Liverable liverable) {
		try {
			if(isAnFileExisteInLiverable(file , liverable) && isAnLiverableExiste(liverable)) {
				file.setLiverable(null);
				daoMediator.updateFile(file);
			}else {
				throw new Exception("File  "+file.getName() + " or liverable "+liverable.getId()+" not found" );
			}
			return 1;
		}catch(Exception e) {
			log.fatal("DefaultModule2Business.deleteFileFromLiverable has an error : "+e.getMessage());
			return -1;
		}
	}


	@Override
	public boolean isAnLiverableExiste(Liverable liverable) {
		for (Liverable l : listLiverables()) 
			if(liverable.equals(l))
				return true;
		return false;
	}


	@Override
	public boolean isAnFileExisteInLiverable(File file , Liverable liverable) {
		try {
			if(isAnLiverableExiste(liverable)) {
				for (File f : listFilesInLiverable(liverable)) {
					if(f.equals(file)) {
						return true;
					}
				}
			}else {
				throw new Exception("liverable "+liverable.getId()+" not found" );
			}
			return false;
		}catch(Exception e) {
			log.fatal("DefaultModule2Business.isAnFileExisteInLiverable has an error : "+e.getMessage());
			return false;
		}
	}


	@Override
	public int addFileToLiverable(File file, Liverable liverable) {
		try {
			if(isAnLiverableExiste(liverable) && !isAnFileExisteInLiverable(file, liverable) && file != null) {
				file.setLiverable(liverable);
				return daoMediator.updateFile(file);
			}else {
				throw new Exception("file "+file.getId()+"  is already existe or null /  liverable "+liverable.getId()+" not existe");
			}
		}catch(Exception e) {
			log.error("DefaultModule2Business.addFileToLiverable has an error :"+e.getMessage());
			return -1;
		}
	}


	@Override
	public int addProject(Project project) {
		try {
			if(!isAnProjectExiste(project) && project!=null) {
				return daoMediator.addProjet(project);
			}else
				throw new Exception("project is already exist or null");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.addProject has an error : "+ e.getMessage());
			return -1;
		}
	}


	@Override
	public Project deleteProject(Project projet) {
		try {
			if(isAnProjectExiste(projet)) {
				return daoMediator.deleteProjet(projet);
			}else
				throw new Exception("project "+projet.getId()+" not existed");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.deleteProject has an error : "+ e.getMessage());
			return null;
		}
	}



	@Override
	public List<Etudiant> listEtudiantsInTeam(Team team) {
		List<Etudiant> etudiants = new Vector<>();
		try {
			if(isAnTeamExiste(team)) {
				for (Etudiant etudiant : daoMediator.selectAllEtudiant()) {
					if(etudiant.getTeam().equals(team))
						etudiants.add(etudiant);
				}
			}else
				throw new Exception("team "+team.getId()+" not existed");
		} catch (Exception e) {
			log.fatal("DefaultModule2Business.listEtudiantsInTeam has an error : "+ e.getMessage());
		}
		return etudiants;
	}



	@Override
	public Matiere selectMatiereById(long idMatiere) {
		try {
			Matiere matiere = daoMediator.selectMatierById(idMatiere);
			return matiere;
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
			if(matiere != null && !isAnMatiereExiste(matiere)) {
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
	public boolean isAnMatiereExiste(Matiere matiere) {
		for (Matiere m : listeMatieres()) 
			if(m.equals(matiere))
				return true;
		return false;
	}


	@Override
	public Enseignant selectEnseignantById(long idEnseignant) {
		try {
			Enseignant enseignant = daoMediator.selectEnseignantById(idEnseignant);
			return enseignant;
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectEnseignantById has an error :"+e.getMessage());
			return null;
		}
	}


	@Override
	public boolean isAnEnseignantExiste(Enseignant enseignant) {
		for (Enseignant e : listeEnseignants()) 
			if(enseignant.equals(e)) 
				return true;
		return false;
	}


	@Override
	public List<Enseignant> listeEnseignants() {
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
	public int addEnseignant(Enseignant enseignant) {
		try {
			if(enseignant != null && !isAnEnseignantExiste(enseignant)) {
				log.info("Enseignant with id="+enseignant.getId()+" added  with success");
				daoMediator.addEnseignant(enseignant);
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
			Liverable livrable = daoMediator.selectLiverableById(idLivrable);
			return livrable;
		}catch(Exception e) {
			log.error("DefaultModule2Business.selectLivrableById has an error :"+e.getMessage());
			return null;
		}
	}


	@Override
	public int addLivrable(Liverable livrable) {
		try {
			if(livrable != null && !isAnLiverableExiste(livrable)) {
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
	public int updateLiverable(Liverable livrable) {
		try {
			if(isAnLiverableExiste(livrable)) {
				return daoMediator.updateLiverable(livrable);
			}else 
				throw new Exception("Livrable "+livrable.getId()+" not exist");
		}catch(Exception e) {
			log.error("DefaultModule2Business.updateLivrable has an error :"+e.getMessage());
			return -1;
		}
	}


	

	@Override
	public String toString() {
		return "bonjour said is work now !";
	}

	@Override
	public Etudiant searchEtudiant(String keyword) {
		List<Etudiant> list = daoMediator.selectAllEtudiant();
		for (Etudiant etudiant : list) {
			if(keyword.equals(etudiant.getNom()) || keyword.equals(etudiant.getPrenom())) {
				return etudiant;
			}
		}
		return null;
	}

	@Override
	public Enseignant deleteEnseignant(Enseignant enseignant) {
		try {
			if(isAnEnseignantExiste(enseignant)) 
				return daoMediator.deleteEnseignant(enseignant);
			else 
				throw new Exception("enseignant "+enseignant.getId()+" not existe");
		} catch (Exception e) {
			log.error("DefaultModule2Business.deleteTeam has an error :"+e.getMessage());
			return null;
		}

	}

	@Override
	public Matiere deleteMatiere(Matiere matiere) {
		try {
			if(isAnMatiereExiste(matiere)) 
				return daoMediator.deleteMatiere(matiere);
			else 
				throw new Exception("matiere "+matiere.getId()+" not existe");
		} catch (Exception e) {
			log.error("DefaultModule2Business.deleteTeam has an error :"+e.getMessage());
			return null;
		}

	}

	@Override
	public int updateMatiere(Matiere matiere) {
		try {
			if(isAnMatiereExiste(matiere)) {
				daoMediator.updateMatiere(matiere);
				return 1;
			}else 
				throw new Exception("team "+matiere.getId()+" not existe");
		}catch(Exception e) {
			log.error("DefaultModule2Business.updateMatiere has an error :"+e.getMessage());
			return -1;
		}
	}

	@Override
	public int updateEnseignant(Enseignant enseignant) {
		try {
			if(isAnEnseignantExiste(enseignant)) {
				daoMediator.updateEnseignant(enseignant);
				return 1;
			}else 
				throw new Exception("team "+enseignant.getId()+" not existe");
		}catch(Exception e) {
			log.error("DefaultModule2Business.updateEnseignant has an error :"+e.getMessage());
			return -1;
		}
	}
	
	@Override
	public List<Etudiant> listEtudiantsPasEncoreAffecter() {
		List<Etudiant> etudiants = new Vector<>();
		for (Etudiant etudiant : listEtudiants()) {
			if(etudiant.getTeam() == null)
				etudiants.add(etudiant);
		}
		return etudiants;
	}
	
	@Override
	public Etudiant teamLeader(Team team) {
		for (Etudiant etudiant : listEtudiantsInTeam(team)) {
			if(etudiant.isTeamLeader())
				return etudiant;
		}
		return null;
	}



}