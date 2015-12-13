package org.tutev.web.erp.service.stok;


import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.entity.stok.SkartMarkaModel;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.erp.service.ServiceBase;
import org.tutev.web.erp.util.PageingModel;

@Service("stokMarkaModelService")
public class StokMarkaModelService implements ServiceBase<SkartMarkaModel>{

	
	 @Autowired
	 private transient BaseDao baseDao;
	  
	 @Override
	    public SkartMarkaModel save(SkartMarkaModel entity) {
		 //TODO
//		   if(entity==null && entity.getUrunAd().trim().equals(""))
//				return null;
//				throw new NameNotNullException();
		 	baseDao.save(entity);
	        return entity;
	 }
	 
	 @Override
	    public SkartMarkaModel update(SkartMarkaModel entity) {
		    baseDao.saveOrUpdate(entity);
	        return entity;
	 }       
	 
	 @Override
	 public Boolean delete(SkartMarkaModel entity) {
		 try {
	        	baseDao.delete(entity);
	        } catch (Exception ex) {
	            return false;
	        }
	        return true;
	    }

	 
	    @Override
	    public SkartMarkaModel getById(Long id) {
	        Session session = getSession();
	        SkartMarkaModel stokKartMarkaModel=(SkartMarkaModel) session.get(SkartMarkaModel.class, id);
	        return stokKartMarkaModel;
	    }
	    @SuppressWarnings("unchecked")
	    @Override
	    public List<SkartMarkaModel> getAll() {
	        Criteria criteria=getSession().createCriteria(SkartMarkaModel.class);        
			criteria.addOrder(Order.desc("id"));	        
	        return (List<SkartMarkaModel>) criteria.list();
	    } 
		

		@SuppressWarnings("null")
		public PageingModel getByPageing(int firstRecord, int pageSize, Map<String, Object> filters) {
			Criteria criteria = getSession().createCriteria(SkartMarkaModel.class);
			if(filters!=null || filters.size()>0){
				if(filters.get("ad")!=null){
					criteria.add(Restrictions.ilike("ad", (String) filters.get("ad"),MatchMode.ANYWHERE));
				}
			}
			return baseDao.getByPageing(firstRecord, pageSize, criteria);		
				
		}
		
		
	           
	    @Override
	    public Session getSession() {
	    	return baseDao.getSession();
	    }
	 
	 
}
