/**
 * 
 */
package org.tutev.web.erp.service.stokhareket;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.erp.service.ServiceBase;
import org.tutev.web.erp.util.PageingModel;
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.entity.stokhareket.Irsaliye;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mehmet Emin IŞIK
 * 
 * @param <Irsaliye>
 * 
 */
@Service("irsaliyeService")
public class IrsaliyeService implements ServiceBase<Irsaliye> {

	@Autowired
	private transient BaseDao baseDao;
	
	@Override
	public Irsaliye save(Irsaliye entity) {
		if (entity==null)
			return null;
		baseDao.save(entity);
		return entity;
	}

	@Override
	public Irsaliye update(Irsaliye entity) {
		baseDao.saveOrUpdate(entity);
		return entity;
	}

	@Override
	public Boolean delete(Irsaliye entity) {
		try {
			baseDao.delete(entity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Irsaliye getById(Long id) {
		Session session = getSession();
		Irsaliye irsaliye = (Irsaliye) session.get(Irsaliye.class, id);
		return irsaliye;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Irsaliye> getAll() {
		Criteria criteria = getSession().createCriteria(Irsaliye.class);
		criteria.addOrder(Order.desc("tarih"));
		return (List<Irsaliye>) criteria.list();
	}

	@Override
	public Session getSession() {
		return baseDao.getSession();
	}

	@SuppressWarnings("unchecked")
	public PageingModel<Irsaliye> getByPageing(int first, int pageSize, Map<String, Object> filters) {
		Criteria criteria = getSession().createCriteria(Irsaliye.class);
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(first);
		criteria.addOrder(Order.desc("id"));
		List<Irsaliye> list= criteria.list();
		int kayitSayisi=((Long)getSession().createCriteria(Irsaliye.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
		return new PageingModel<Irsaliye>(list, kayitSayisi);
	}
}
