package org.tutev.web.erp.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.entity.genel.KodluListe;
import org.tutev.web.erp.entity.genel.KodluListeTip;

@Service("dataService")
public class DataService {

	@Autowired
	private transient BaseDao baseDao;

	public Kisi getById(Long id) {
		Session session = getSession();
		Kisi kisi = (Kisi) session.get(Kisi.class, id);
		return kisi;
	}

	@SuppressWarnings("rawtypes")
	public List getAll(Class cls) {
		Criteria criteria = getSession().createCriteria(cls);
		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")	
	@Transactional
	public List<KodluListe> getByType(KodluListeTip type) {
		Criteria criteria = getSession().createCriteria(KodluListe.class);
		criteria.add(Restrictions.eq("kodluListeTip",type));
		criteria.addOrder(Order.asc("id"));
		return (List<KodluListe>)criteria.list();
	}
	

	public Session getSession() {
		return baseDao.getSession();
	}
}
