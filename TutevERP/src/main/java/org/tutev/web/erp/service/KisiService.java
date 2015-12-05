/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.web.erp.service;

import java.util.List;
import java.util.Map;

import org.bouncycastle.asn1.isismtt.x509.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.util.PageingModel;

/**
 * 
 * @author Bilisim-Hoca
 */
@Service("kisiService")
public class KisiService implements ServiceBase<Kisi> {
	

	@Autowired
	private transient BaseDao baseDao;

	@SuppressWarnings("null")
	@Override
	public Kisi save(Kisi entity)  {
		if(entity==null && entity.getAd().trim().equals(""))
			return null;
//			throw new NameNotNullException();
		baseDao.save(entity);
		return entity;
	}

	@Override
	public Kisi update(Kisi entity) {
		baseDao.saveOrUpdate(entity);
		return entity;
	}

	@Override
	public Boolean delete(Kisi entity) {
		try {
			baseDao.delete(entity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Kisi getById(Long id) {
		Session session = getSession();
		Kisi kisi = (Kisi) session.get(Kisi.class, id);
		return kisi;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kisi> getAll() {
		Criteria criteria = getSession().createCriteria(Kisi.class);
		criteria.addOrder(Order.desc("id"));
		return (List<Kisi>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public PageingModel<Kisi> getByPageing(int firstRecord, int pageSize, Map<String, Object> filters) {
		Criteria criteria = getSession().createCriteria(Kisi.class);
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
		List<Kisi> list= criteria.list();
		return new PageingModel<Kisi>(list,kayitSayisi );
	}
	

	@Override
	public Session getSession() {
		return baseDao.getSession();
	}
}
