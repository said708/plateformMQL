package org.java.mql.web.actions;

import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;

import org.java.mql.business.Module2Business;
import org.java.mql.models.File;
import org.java.mql.models.Liverable;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LiverableAction {

	private List<File> list;
	
	
	private TreeNode root;
	
	
	@Autowired
	private Module2Business business;
	
	
	
	public LiverableAction() {
		list = new Vector<>();
	}
	
	
	@PostConstruct 
	void init(){
		List<Liverable> ls =  business.listLiverables();
		for(Liverable liv:ls){
			list = business.listFilesInLiverable(liv);
		}
		load();
	}
	
	
	private void load(){
		root = new DefaultTreeNode(new File("root"), null);
		String mat = list.get(0).getLiverable().getProject().getMatiere().getName();
		TreeNode t = new DefaultTreeNode(new File(mat),root);
		construire1(0, t);
		for (int i = 1; i < list.size(); i++) {
			mat = list.get(i).getLiverable().getProject().getMatiere().getName();
			if(!mat.equals(t.getData())){
				t = new DefaultTreeNode(new File(mat),root);
			}
			construire1(i, t);
		}
		
	}
	

	private void construire1(int i,TreeNode matiere){
		File f = list.get(i);
		String p = "Projet :"+f.getLiverable().getProject().getName();
		String e  = f.getLiverable().getProject().getTeam().getName();
		String l = f.getLiverable().getName();
		TreeNode projet = new DefaultTreeNode(new File(p), matiere);
		TreeNode equipe =  new DefaultTreeNode(new File(e) , projet);
		TreeNode livrable =  new DefaultTreeNode(new File(l), equipe);
		new DefaultTreeNode(new File(f.getName(),f.getPath(),f.getUploadDate(),f.getSize(),f.getType()), livrable);
		
		
	}

	public TreeNode getRoot() {
		return root;
	}
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	public List<File> getList() {
		return list;
	}
	public void setList(List<File> list) {
		this.list = list;
	}
}
