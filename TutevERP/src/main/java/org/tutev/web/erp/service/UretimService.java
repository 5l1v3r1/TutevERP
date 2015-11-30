/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.web.erp.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.entity.uretim.Uretim;
import org.tutev.web.erp.util.PageingModel;

/**
 * 
 * @author Bilisim-Hoca
 * 
 * 
 * 
 * 
 */
@Service("uretimService")
public class UretimService implements ServiceBase<Uretim> {
	

	@Autowired
	private transient BaseDao baseDao;

	@Override
	public Uretim save(Uretim entity)  {
		if(entity==null && entity.getUretimNo().trim().equals(""))
			return null;
//			throw new NameNotNullException();
		baseDao.save(entity);
		return entity;
	}

	@Override
	public Uretim update(Uretim entity) {
		baseDao.saveOrUpdate(entity);
		return entity;
	}

	@Override
	public Boolean delete(Uretim entity) {
		try {
			baseDao.delete(entity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Uretim getById(Long id) {
		Session session = getSession();
		Uretim uretim = (Uretim) session.get(Uretim.class, id);
		return uretim;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Uretim> getAll() {
		Criteria criteria = getSession().createCriteria(Uretim.class);
		criteria.addOrder(Order.desc("id"));
		return (List<Uretim>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public PageingModel<Uretim> getByPageing(int firstRecord, int pageSize, Map<String, Object> filters) {
		Criteria criteria = getSession().createCriteria(Uretim.class);
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(firstRecord);
		criteria.addOrder(Order.desc("id"));
		List<Uretim> list= criteria.list();
		int kayitSayisi=((Long)getSession().createCriteria(Uretim.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
		return new PageingModel<Uretim>(list,kayitSayisi );
	}
	

	@Override
	public Session getSession() {
		return baseDao.getSession();
	}
}
