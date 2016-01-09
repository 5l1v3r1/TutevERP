package org.tutev.web.erp.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.web.erp.entity.genel.Kullanici;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private transient BaseDao baseDao;
	 
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
//		SecurityContextHolder.
//        final List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
//
//        for(final Object principal : allPrincipals) {
//            if(principal instanceof UserDetails) {
//            	UserDetails ob= (UserDetails) principal;
//            	if(ob.getUsername().equals(arg0))
//            		return null;
//            }
//        }
		Criteria criteria = baseDao.getSession().createCriteria(Kullanici.class);
		criteria.add(Restrictions.eq("username", arg0));
		Kullanici kullanici = (Kullanici) criteria.uniqueResult();

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("USER"));
		authorities.add(new SimpleGrantedAuthority("ADMIN"));

		// enabled=kullanici.getDurum()
		User user =null;
		if(kullanici!=null){
			user= new User(kullanici.getUsername(), kullanici.getPassword(),true, true, true, true, authorities);
			
			System.out.println(user.toString());
		}		
		return user;
	}
	
}








