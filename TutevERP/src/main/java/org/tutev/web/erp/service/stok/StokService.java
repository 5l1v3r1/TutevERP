package org.tutev.web.erp.service.stok;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.entity.stok.Skart;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.erp.service.ServiceBase;
import org.tutev.web.erp.util.PageingModel;

@Service("stokService")
public class StokService implements ServiceBase<Skart>{

	
	 @Autowired
	 private transient BaseDao baseDao;
	  
	 @Override
	    public Skart save(Skart entity) {
		 //TODO
//		   if(entity==null && entity.getUrunAd().trim().equals(""))
//				return null;
//				throw new NameNotNullException();
		 	baseDao.save(entity);
	        return entity;
	 }
	 
	 @Override
	    public Skart update(Skart entity) {
		    baseDao.saveOrUpdate(entity);
	        return entity;
	 }       
	 
	 @Override
	 public Boolean delete(Skart entity) {
		 try {
	        	baseDao.delete(entity);
	        } catch (Exception ex) {
	            return false;
	        }
	        return true;
	    }

	 
	    @Override
	    public Skart getById(Long id) {
	        Session session = getSession();
	        Skart stokKart=(Skart) session.get(Skart.class, id);
	        return stokKart;
	    }
	    @SuppressWarnings("unchecked")
	    @Override
	    public List<Skart> getAll() {
	        Criteria criteria=getSession().createCriteria(Skart.class);        
			criteria.addOrder(Order.desc("id"));	        
	        return (List<Skart>) criteria.list();
	    } 
		

		@SuppressWarnings("unchecked")
		public PageingModel<Skart> getByPageing(int firstRecord, int pageSize, Map<String, Object> filters) {
			Criteria criteria = getSession().createCriteria(Skart.class);
			criteria.setMaxResults(pageSize);
			criteria.setFirstResult(firstRecord);
			criteria.addOrder(Order.desc("id"));
			List<Skart> list= criteria.list();
			int kayitSayisi=((Long)getSession().createCriteria(Skart.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
			return new PageingModel<Skart>(list,kayitSayisi );
		}
		
		
	           
	    @Override
	    public Session getSession() {
	    	return baseDao.getSession();
	    }
	 
	 
}
