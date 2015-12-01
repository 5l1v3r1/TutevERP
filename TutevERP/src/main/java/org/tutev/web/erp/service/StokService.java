package org.tutev.web.erp.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.entity.stok.StokKart;
import org.tutev.web.erp.util.PageingModel;

@Service("stokService")
public class StokService implements ServiceBase<StokKart>{

	
	 @Autowired
	 private transient BaseDao baseDao;
	  
	 @Override
	    public StokKart save(StokKart entity) {
		   if(entity==null && entity.getUrunAd().trim().equals(""))
				return null;
//				throw new NameNotNullException();
		 	baseDao.save(entity);
	        return entity;
	 }
	 
	 @Override
	    public StokKart update(StokKart entity) {
		    baseDao.saveOrUpdate(entity);
	        return entity;
	 }       
	 
	 @Override
	 public Boolean delete(StokKart entity) {
		 try {
	        	baseDao.delete(entity);
	        } catch (Exception ex) {
	            return false;
	        }
	        return true;
	    }

	 
	    @Override
	    public StokKart getById(Long id) {
	        Session session = getSession();
	        StokKart stokKart=(StokKart) session.get(StokKart.class, id);
	        return stokKart;
	    }
	    @SuppressWarnings("unchecked")
	    @Override
	    public List<StokKart> getAll() {
	        Criteria criteria=getSession().createCriteria(StokKart.class);        
			criteria.addOrder(Order.desc("id"));	        
	        return (List<StokKart>) criteria.list();
	    } 
		

		@SuppressWarnings("unchecked")
		public PageingModel<StokKart> getByPageing(int firstRecord, int pageSize, Map<String, Object> filters) {
			Criteria criteria = getSession().createCriteria(StokKart.class);
			criteria.setMaxResults(pageSize);
			criteria.setFirstResult(firstRecord);
			criteria.addOrder(Order.desc("id"));
			List<StokKart> list= criteria.list();
			int kayitSayisi=((Long)getSession().createCriteria(StokKart.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
			return new PageingModel<StokKart>(list,kayitSayisi );
		}
		
		
	           
	    @Override
	    public Session getSession() {
	    	return baseDao.getSession();
	    }
	 
	 
}
