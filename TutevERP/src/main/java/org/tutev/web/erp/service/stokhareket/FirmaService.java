/**
 * 
 */
package org.tutev.web.erp.service.stokhareket;

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
import org.tutev.web.erp.entity.stokhareket.Firma;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.erp.service.ServiceBase;
import org.tutev.web.erp.util.PageingModel;

/**
 * @author gemini
 *
 */
@Service("firmaService")
public class FirmaService implements ServiceBase<Firma> {
	
	@Autowired
	private transient BaseDao baseDao;

	@Override
	public Firma save(Firma entity) {
		if(entity==null || entity.getId() == null)
			return null;
//			throw new NameNotNullException();
		baseDao.save(entity);
		return entity;
	}

	@Override
	public Firma update(Firma entity) {
		baseDao.saveOrUpdate(entity);
		return entity;
	}

	@Override
	public Boolean delete(Firma entity) {
		try {
			baseDao.delete(entity);
		} catch(Exception e) {
			e.printStackTrace();
			return (false);
		};
		return (true);
	}

	@Override
	public Firma getById(Long id) {
		Firma firma = (Firma) getSession().get(Firma.class, id);
		return firma;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Firma> getAll() {
		Criteria criteria = getSession().createCriteria(Firma.class);
		criteria.addOrder(Order.desc("id"));
		return (List<Firma>) criteria.list();
	}

	@Override
	public Session getSession() {
		return baseDao.getSession();
	}

	@SuppressWarnings({ "unchecked", "null" })
	public PageingModel<Firma> getByPageing(int firstRecord, int pageSize, Map<String, Object> filters) {
		Criteria criteria = getSession().createCriteria(Firma.class);
		if(filters!=null || filters.size()>0){
			if(filters.get("name")!=null){
				criteria.add(Restrictions.ilike("name", (String) filters.get("name"),MatchMode.ANYWHERE));
			}
			
			if(filters.get("yetkili")!=null){
				criteria.add(Restrictions.ilike("yetkili", (String) filters.get("yetkili"),MatchMode.ANYWHERE));
			}
		}

		int kayitSayisi=((Long)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(firstRecord);
		criteria.addOrder(Order.desc("id"));
		List<Firma> list= criteria.list();
		return new PageingModel<Firma>(list,kayitSayisi );
	}

}
