package org.tutev.web.erp.service.personel;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.entity.ik.Personel;
import org.tutev.web.erp.service.ServiceBase;

public class PersonelService implements ServiceBase<Personel> {

	@Override
	public Personel save(Personel entity) {
		Session session = getSession();
		Transaction t = session.getTransaction();
		t.begin();
		entity.setDurum(Boolean.TRUE);
		entity.setEklemeTarihi(new Date());
		entity.setEkleyen("CURR_USER");
		session.save(entity);
		t.commit();
		return entity;
	}

	@Override
	public Personel update(Personel entity) {
		Session session = getSession();
		Transaction t = session.getTransaction();
		t.begin();
		entity.setGuncellemeTarihi(new Date());
		entity.setGuncelleyen("CURR_USER");
		session.saveOrUpdate(entity);
		t.commit();
		return entity;
	}

	@Override
	public Boolean delete(Personel entity) {
		try {
			Session session = getSession();
			Transaction t = session.getTransaction();
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
	public Personel getById(Long id) {
		Session session = getSession();
		Personel personel = (Personel) session.get(Personel.class, id);
		return personel;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personel> getAll() {
		Criteria criteria = getSession().createCriteria(Kisi.class);
		return (List<Personel>) criteria.list();
	}

	@Override
	public Session getSession() {
		return null;
	}

}
