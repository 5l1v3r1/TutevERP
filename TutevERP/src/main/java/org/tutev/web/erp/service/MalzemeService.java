/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.web.erp.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tutev.web.erp.entity.uretim.Malzeme;

/**
 *
 * @author Erhan Kose
 */
public class MalzemeService implements ServiceBase<Malzeme> {


    @Override
    public Malzeme save(Malzeme entity) {
        Session session = getSession();
        Transaction t= session.getTransaction();
        t.begin();
        entity.setDurum(Boolean.TRUE);
        entity.setEklemeTarihi(new Date());
        entity.setEkleyen("CURR_USER");
        session.save(entity);
        t.commit();
        return entity;
    }

    @Override
    public Malzeme update(Malzeme entity) {
        Session session = getSession();
        Transaction t= session.getTransaction();
        t.begin();
        entity.setGuncellemeTarihi(new Date());
        entity.setGuncelleyen("CURR_USER");
        session.saveOrUpdate(entity);
        t.commit();
        return entity;
    }

    @Override
    public Boolean delete(Malzeme entity) {
        try {
            Session session = getSession();
            Transaction t= session.getTransaction();
            t.begin();
            session.delete(entity);
            t.commit();
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Malzeme getById(Long id) {
        Session session = getSession();
        Malzeme malzeme = (Malzeme) session.get(Malzeme.class, id);
        return malzeme;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Malzeme> getAll() {
        //Criteria Where �?artı oluşturmayı sağlar
        Criteria criteria=getSession().createCriteria(Malzeme.class);
        return (List<Malzeme>) criteria.list();
    }

    @Override
    public Session getSession() {
        return null;
    }
}
