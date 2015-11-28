/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.web.erp.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author win7
 */
@Repository("baseService")
public class BaseDao {
	
	public BaseDao() {
		System.out.println("Base Dao Yüklendi");
	}

	@Autowired
	private transient SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Object o) {
		getSession().save(o);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void update(Object o) {
		getSession().update(o);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveOrUpdate(Object o) {
		getSession().saveOrUpdate(o);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Object o) {
		getSession().delete(o);
	}

	public Object getById(Long id, @SuppressWarnings("rawtypes") Class cls) {
		return getSession().get(cls, id);
	}
}
