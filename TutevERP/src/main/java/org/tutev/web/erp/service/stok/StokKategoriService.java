package org.tutev.web.erp.service.stok;


import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.entity.stok.SkartKategori;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.erp.service.ServiceBase;
import org.tutev.web.erp.util.PageingModel;

@Service("stokKategoriService")
public class StokKategoriService implements ServiceBase<SkartKategori>{

	
	 @Autowired
	 private transient BaseDao baseDao;
	  
	 @Override
	    public SkartKategori save(SkartKategori entity) {
		 //TODO
//		   if(entity==null && entity.getUrunAd().trim().equals(""))
//				return null;
//				throw new NameNotNullException();
		 	baseDao.save(entity);
	        return entity;
	 }
	 
	 @Override
	    public SkartKategori update(SkartKategori entity) {
		    baseDao.saveOrUpdate(entity);
	        return entity;
	 }       
	 
	 @Override
	 public Boolean delete(SkartKategori entity) {
		 try {
	        	baseDao.delete(entity);
	        } catch (Exception ex) {
	            return false;
	        }
	        return true;
	    }

	 
	    @Override
	    public SkartKategori getById(Long id) {
	        Session session = getSession();
	        SkartKategori stokKartKategori=(SkartKategori) session.get(SkartKategori.class, id);
	        return stokKartKategori;
	    }
	    @SuppressWarnings("unchecked")
	    @Override
	    public List<SkartKategori> getAll() {
	        Criteria criteria=getSession().createCriteria(SkartKategori.class);        
			criteria.addOrder(Order.desc("id"));	        
	        return (List<SkartKategori>) criteria.list();
	    } 
		

		@SuppressWarnings("unchecked")
		public PageingModel<SkartKategori> getByPageing(int firstRecord, int pageSize, Map<String, Object> filters) {
			Criteria criteria = getSession().createCriteria(SkartKategori.class);
			if(filters!=null || filters.size()>0){
				if(filters.get("ad")!=null){
					criteria.add(Restrictions.ilike("ad", (String) filters.get("ad"),MatchMode.ANYWHERE));
				}
			}
			criteria.setMaxResults(pageSize);
			criteria.setFirstResult(firstRecord);

			int kayitSayisi=((Long)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			
			criteria.addOrder(Order.desc("id"));
			List<SkartKategori> list= criteria.list();
			return new PageingModel<SkartKategori>(list,kayitSayisi );		
				
		}
		
		
	           
	    @Override
	    public Session getSession() {
	    	return baseDao.getSession();
	    }
	 
	 
}
