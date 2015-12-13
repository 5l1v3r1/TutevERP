package org.tutev.web.erp.service;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.web.erp.entity.genel.Kullanici;


@Service("kullaniciService")
public class KullaniciService {
	
	@Autowired
	private transient BaseDao baseDao;
	
	public void save(Kullanici kullanici) {
		Md5PasswordEncoder encoder =new Md5PasswordEncoder();
		String encPass = encoder.encodePassword(kullanici.getPassword(), null);
		kullanici.setPassword(encPass);
		baseDao.save(kullanici);
	}
	
	@Transactional
	public Long getUserCount() {
		Criteria criteria = baseDao.getSession().createCriteria(Kullanici.class);
		return ((Long)criteria.setProjection(Projections.rowCount()).uniqueResult());
	}
}
