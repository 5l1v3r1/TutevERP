package org.tutev.web.erp.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.web.erp.entity.genel.Yerlesim;
import org.tutev.web.erp.util.PageingModel;

@Service("yerlesimService")
public class YerlesimService {


	@Autowired
	private transient BaseDao baseDao;

	@SuppressWarnings("null")
	public Yerlesim save(Yerlesim entity)  {
		if(entity==null && entity.getKod().trim().equals(""))
			return null;
		baseDao.save(entity);
		return entity;
	}

	public Yerlesim update(Yerlesim entity) {
		baseDao.saveOrUpdate(entity);
		return entity;
	}

	public Boolean delete(Yerlesim entity) {
		try {
			baseDao.delete(entity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Yerlesim getById(Long id) {
		Session session = getSession();
		Yerlesim kodluListe = (Yerlesim) session.get(Yerlesim.class, id);
		return kodluListe;
	}

	@SuppressWarnings("unchecked")
	public List<Yerlesim> getAll() {
		Criteria criteria = getSession().createCriteria(Yerlesim.class);
		criteria.addOrder(Order.desc("id"));
		return (List<Yerlesim>) criteria.list();
	}
	
	public PageingModel getByPageing(int firstRecord, int pageSize, Map<String, Object> filters) {
		Criteria criteria = getSession().createCriteria(Yerlesim.class);
		return baseDao.getByPageing(firstRecord, pageSize, criteria);
	}
	

	public Session getSession() {
		return baseDao.getSession();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Yerlesim> acomp(String query) {
		Criteria criteria = getSession().createCriteria(Yerlesim.class);
		criteria.add(Restrictions.ilike("tanim", query,MatchMode.ANYWHERE));
		criteria.addOrder(Order.desc("id"));
		List<Yerlesim> list= criteria.list();
		return list;
	}

	@Transactional
	public List<Yerlesim> getNullYerlesim() {
		Criteria criteria = getSession().createCriteria(Yerlesim.class);
		criteria.add(Restrictions.isNull("ustYerlesim.id"));
		criteria.addOrder(Order.asc("id"));
		@SuppressWarnings("unchecked")
		List<Yerlesim> list= criteria.list();
		return list;		
	}
	
	
}
