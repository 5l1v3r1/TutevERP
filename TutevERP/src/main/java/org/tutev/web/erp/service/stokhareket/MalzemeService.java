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
import org.tutev.web.erp.entity.stokhareket.StokHrkMalzeme;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.erp.service.ServiceBase;
import org.tutev.web.erp.util.PageingModel;

/**
 * @author gemini
 *
 */
@Service("malzemeService")
public class MalzemeService implements ServiceBase<StokHrkMalzeme> {

	@Autowired
	private transient BaseDao baseDao;

	@Override
	public StokHrkMalzeme save(StokHrkMalzeme entity) {
		if (entity == null || entity.getId()==null)
			return null;
		baseDao.save(entity);
		return entity;
	}

	@Override
	public StokHrkMalzeme update(StokHrkMalzeme entity) {
		baseDao.saveOrUpdate(entity);
		return entity;
	}

	@Override
	public Boolean delete(StokHrkMalzeme entity) {
		try {
			baseDao.delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return (false);
		}
		return (true);
	}

	@Override
	public StokHrkMalzeme getById(Long id) {
		StokHrkMalzeme stokHrkMalzeme = (StokHrkMalzeme) getSession().get(StokHrkMalzeme.class, id);
		return stokHrkMalzeme;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StokHrkMalzeme> getAll() {
		Criteria criteria = getSession().createCriteria(StokHrkMalzeme.class);
		criteria.addOrder(Order.desc("id"));
		return (List<StokHrkMalzeme>) criteria.list();
	}

	@Override
	public Session getSession() {
		return baseDao.getSession();
	}

	@SuppressWarnings({ "null" })
	public PageingModel getByPageing(int firstRecord, int pageSize, Map<String, Object> filters) {
		Criteria criteria = getSession().createCriteria(StokHrkMalzeme.class);
		if(filters!=null || filters.size()>0){
			if(filters.get("adi")!=null){
				criteria.add(Restrictions.ilike("adi", (String) filters.get("adi"),MatchMode.ANYWHERE));
			}
			
			if(filters.get("aktif")!=null){
				criteria.add(Restrictions.eq("aktif", (String) filters.get("aktif")));
			}
		}

		return baseDao.getByPageing(firstRecord, pageSize, criteria);
	}
}
