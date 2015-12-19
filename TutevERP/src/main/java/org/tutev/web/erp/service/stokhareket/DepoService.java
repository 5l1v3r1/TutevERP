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
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.entity.genel.KodluListe;
import org.tutev.web.erp.entity.stokhareket.Depo;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.erp.service.ServiceBase;
import org.tutev.web.erp.util.PageingModel;

/**
 * @author gemini
 *
 */
@Service("depoService")
public class DepoService implements ServiceBase<Depo> {
	
	@Autowired
	private transient BaseDao baseDao;

	@SuppressWarnings("null")
	@Override
	public Depo save(Depo entity) {
		if(entity==null && entity.getId()==null)
			return null;
//			throw new NameNotNullException();
		baseDao.save(entity);
		return entity;
	}

	@Override
	public Depo update(Depo entity) {
		baseDao.saveOrUpdate(entity);
		return entity;
	}

	@Override
	public Boolean delete(Depo entity) {
		try {
			baseDao.delete(entity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Depo getById(Long id) {
		Session session = getSession();
		Depo depo = (Depo) session.get(Depo.class, id);
		return depo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Depo> getAll() {
		Criteria criteria = getSession().createCriteria(Depo.class);
		criteria.addOrder(Order.desc("id"));
		return (List<Depo>) criteria.list();
	}

	@SuppressWarnings({"null" })
	public PageingModel getByPageing(int firstRecord, int pageSize, Map<String, Object> filters) {
		Criteria criteria = getSession().createCriteria(Depo.class);
		if(filters!=null || filters.size()>0){
			if(filters.get("depoAdi")!=null){
				criteria.add(Restrictions.ilike("depoAdi", (String) filters.get("depoAdi"),MatchMode.ANYWHERE));
			}
			
			if(filters.get("depo_turu")!=null){
				KodluListe depoTuru= (KodluListe) filters.get("depo_turu");
				criteria.add(Restrictions.eq("depo_turu.id",depoTuru.getId()));
			}
		}

		return baseDao.getByPageing(firstRecord, pageSize, criteria);
	}

	@Override
	public Session getSession() {
		return baseDao.getSession();
	}
	
}
