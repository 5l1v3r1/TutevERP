package org.tutev.web.erp.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.web.erp.entity.genel.Kullanici;

@Service("kullaniciService")
public class KullaniciService implements UserDetailsService {

	@Autowired
	private transient BaseDao baseDao;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		Criteria criteria = baseDao.getSession().createCriteria(Kullanici.class);
		criteria.add(Restrictions.eq("username", arg0));
		Kullanici kullanici = (Kullanici) criteria.uniqueResult();

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("USER"));
		authorities.add(new SimpleGrantedAuthority("ADMIN"));

		// enabled=kullanici.getDurum()
		User user = new User(kullanici.getUsername(), kullanici.getPassword(),true, true, true, true, authorities);
		return user;
	}
	
	public void save(Kullanici kullanici) {
		Md5PasswordEncoder encoder =new Md5PasswordEncoder();
		String encPass = encoder.encodePassword(kullanici.getPassword(), kullanici);
		kullanici.setPassword(encPass);
		baseDao.save(kullanici);
		
	}
	
	

}








