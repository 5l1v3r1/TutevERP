/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.web.erp.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.entity.fatura.Fatura;

/**
 *
 * @author Bilisim-Hoca
 */
@Service("faturaService")
public class FaturaService implements ServiceBase<Fatura> {

	@Autowired
	private transient BaseDao baseDao;
	
    @Override
    public Fatura save(Fatura entity) {
    	baseDao.save(entity);
        return entity;
    }

    @Override
    public Fatura update(Fatura entity) {
    	baseDao.saveOrUpdate(entity);
        return entity;

    }

    @Override
    public Boolean delete(Fatura entity) {
        try {
        	baseDao.delete(entity);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @Override
    public Fatura getById(Long id) {
        Session session=getSession();
        return (Fatura) session.get(Fatura.class, id);
    }

    @Override
    public List<Fatura> getAll() {
        Session session=getSession();
        Criteria criteria=session.createCriteria(Fatura.class);
        return criteria.list();
    }

    @Override
    public Session getSession() {
    	return baseDao.getSession();
    }

}
