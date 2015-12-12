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
import org.tutev.web.erp.entity.stokhareket.Malzeme;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.erp.service.ServiceBase;
import org.tutev.web.erp.util.PageingModel;

/**
 * @author gemini
 *
 */
@Service("malzemeService")
public class MalzemeService implements ServiceBase<Malzeme> {

	@Autowired
	private transient BaseDao baseDao;

	@Override
	public Malzeme save(Malzeme entity) {
		if (entity == null || entity.getId()==null)
			return null;
		baseDao.save(entity);
		return entity;
	}

	@Override
	public Malzeme update(Malzeme entity) {
		baseDao.saveOrUpdate(entity);
		return entity;
	}

	@Override
	public Boolean delete(Malzeme entity) {
		try {
			baseDao.delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return (false);
		}
		return (true);
	}

	@Override
	public Malzeme getById(Long id) {
		Malzeme malzeme = (Malzeme) getSession().get(Malzeme.class, id);
		return malzeme;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Malzeme> getAll() {
		Criteria criteria = getSession().createCriteria(Malzeme.class);
		criteria.addOrder(Order.desc("id"));
		return (List<Malzeme>) criteria.list();
	}

	@Override
	public Session getSession() {
		return baseDao.getSession();
	}

	@SuppressWarnings({ "unchecked", "null" })
	public PageingModel<Malzeme> getByPageing(int firstRecord, int pageSize, Map<String, Object> filters) {
		Criteria criteria = getSession().createCriteria(Malzeme.class);
		if(filters!=null || filters.size()>0){
			if(filters.get("adi")!=null){
				criteria.add(Restrictions.ilike("adi", (String) filters.get("adi"),MatchMode.ANYWHERE));
			}
			
			if(filters.get("aktif")!=null){
				criteria.add(Restrictions.eq("aktif", (String) filters.get("aktif")));
			}
		}

		int kayitSayisi=((Long)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(firstRecord);
		criteria.addOrder(Order.desc("id"));
		List<Malzeme> list= criteria.list();
		return new PageingModel<Malzeme>(list,kayitSayisi );
	}
}
