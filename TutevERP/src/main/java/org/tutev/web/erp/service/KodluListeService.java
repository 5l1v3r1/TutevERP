package org.tutev.web.erp.service;

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
import org.springframework.transaction.annotation.Transactional;
import org.tutev.web.erp.controller.DataController;
import org.tutev.web.erp.entity.genel.KodluListe;
import org.tutev.web.erp.util.PageingModel;

@Service("kodluListeService")
public class KodluListeService {
	
	@Autowired
	private transient DataController controller;

	@Autowired
	private transient BaseDao baseDao;

	@SuppressWarnings("null")
	public KodluListe save(KodluListe entity)  {
		if(entity==null && entity.getKod().trim().equals(""))
			return null;
		baseDao.save(entity);
		controller.dataGuncelle();
		return entity;
	}

	public KodluListe update(KodluListe entity) {
		baseDao.saveOrUpdate(entity);
		controller.dataGuncelle();
		return entity;
	}

	public Boolean delete(KodluListe entity) {
		try {
			baseDao.delete(entity);
			controller.dataGuncelle();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public KodluListe getById(Long id) {
		Session session = getSession();
		KodluListe kodluListe = (KodluListe) session.get(KodluListe.class, id);
		return kodluListe;
	}

	@SuppressWarnings("unchecked")
	public List<KodluListe> getAll() {
		Criteria criteria = getSession().createCriteria(KodluListe.class);
		criteria.addOrder(Order.desc("id"));
		return (List<KodluListe>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public PageingModel<KodluListe> getByPageing(int firstRecord, int pageSize, Map<String, Object> filters) {
		Criteria criteria = getSession().createCriteria(KodluListe.class);
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(firstRecord);
		criteria.addOrder(Order.desc("id"));
		List<KodluListe> list= criteria.list();
		int kayitSayisi=((Long)getSession().createCriteria(KodluListe.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
		return new PageingModel<KodluListe>(list,kayitSayisi );
	}
	

	public Session getSession() {
		return baseDao.getSession();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<KodluListe> acomp(String query) {
		Criteria criteria = getSession().createCriteria(KodluListe.class);
		criteria.add(Restrictions.ilike("tanim", query,MatchMode.ANYWHERE));
		criteria.addOrder(Order.desc("id"));
		List<KodluListe> list= criteria.list();
		return list;
	}
	
	
}
