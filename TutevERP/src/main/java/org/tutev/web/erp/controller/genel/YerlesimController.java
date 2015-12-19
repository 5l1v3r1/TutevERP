package org.tutev.web.erp.controller.genel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.genel.Yerlesim;
import org.tutev.web.erp.service.YerlesimService;
import org.tutev.web.erp.util.PageingModel;

@Controller("yerlesimController")
@Scope("view")
public class YerlesimController implements Serializable {

	/**
	 * Taner TEMEL
	 */
	private static final long serialVersionUID = -3607896108305768125L;

	@Autowired
	private transient YerlesimService yerlesimService;

	private Yerlesim yerlesim;
	private TreeNode root;
	
	LazyDataModel<Yerlesim> lazy;
 
	@PostConstruct
	public void init() {
		generateTree();
	}

	public void generateTree() {
		List<Yerlesim> yerlesimList=yerlesimService.getAll();
		root = new DefaultTreeNode(new Yerlesim(), null);
		for (Yerlesim yerlesim : yerlesimList) {
			if(yerlesim.getUstYerlesim()==null){
				@SuppressWarnings("unused")
				TreeNode node=new DefaultTreeNode(yerlesim, root);
			}
		}
		
		List<TreeNode> parents=root.getChildren();
		for (TreeNode node : parents) {
			Yerlesim y= (Yerlesim) node.getData();
			List<Yerlesim> childs= getListChilds(yerlesimList, y.getId());
			for (Yerlesim yerlesim : childs) {
				@SuppressWarnings("unused")
				TreeNode childNode=new DefaultTreeNode(yerlesim, node);
			}
		}
	}
	
	public List<Yerlesim> getListChilds(List<Yerlesim> yerlesimList, Long parentId) {
		List<Yerlesim> yList=new ArrayList<Yerlesim>();
		for (Yerlesim yerlesim : yerlesimList) {
			if(yerlesim.getUstYerlesim()!=null && parentId.equals(yerlesim.getUstYerlesim().getId())){
				yList.add(yerlesim);
			}
		}
		return yList;
	}	

	public TreeNode getRoot() {
		return root;
	}
	
	public void kaydet() {
		try {
			if(yerlesim.getId()==null)
				yerlesimService.save(yerlesim);
			else
				yerlesimService.update(yerlesim);	
			
			listele();
		} catch (Exception e) {
		}

	}
	
	public List<Yerlesim> acomp(String query) {
		return yerlesimService.acomp(query);
	}
	
	
	public void listele() {
		
		lazy=new LazyDataModel<Yerlesim>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -1117065338221723478L;

			@SuppressWarnings("unchecked")
			@Override
			public List<Yerlesim> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				
				
				PageingModel yrls=yerlesimService.getByPageing(first, pageSize, filters);
				lazy.setRowCount(yrls.getRowCount());
				return yrls.getList();
			}

		};

	}
	
	public void sil(Long id) {
		Yerlesim silinecek = yerlesimService.getById(id);
		yerlesimService.delete(silinecek);
		listele();
	}
	
	public void duzenle(Long id) {
		yerlesim = yerlesimService.getById(id);
	}
	
	public void yeni() {
		yerlesim=null;
	}

	public Yerlesim getYerlesim() {
		if(yerlesim==null){
			yerlesim=new Yerlesim();
		}
		return yerlesim;
	}
	
	public void setYerlesim(Yerlesim yerlesim) {
		this.yerlesim = yerlesim;
	}
	
	public LazyDataModel<Yerlesim> getLazy() {
		return lazy;
	}
	
}
