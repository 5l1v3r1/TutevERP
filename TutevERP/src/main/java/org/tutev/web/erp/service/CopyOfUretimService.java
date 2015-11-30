/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.web.erp.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.entity.uretim.Uretim;

/**
 * 
 * @author Erhan Kose
 */
public class CopyOfUretimService implements ServiceBase<Uretim> {
	BaseDao service = new BaseDao();

	@Override
	public Uretim save(Uretim entity) {

		if (entity.getUretimNo().trim().equals("")) {
			System.out.println("Uretim kaydý yapýlamadý");
		} else {
			service.save(entity);
		}

		return entity;
	}

	@Override
	public Uretim update(Uretim entity) {
		service.update(entity);
		return entity;
	}

	@Override
	public Boolean delete(Uretim entity) {
		try {
			service.delete(entity);
			
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

	@Override
	public List<Uretim> getAll() {
		// Criteria Where Å?artÄ± oluÅŸturmayÄ± saÄŸlar
		Criteria criteria = getSession().createCriteria(Kisi.class);
		return (List<Uretim>) criteria.list();
	}

	@Override
	public Session getSession() {
		return null;
	}
}
