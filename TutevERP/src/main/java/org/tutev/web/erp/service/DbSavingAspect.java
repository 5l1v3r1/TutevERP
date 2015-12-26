package org.tutev.web.erp.service;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DbSavingAspect {
	
	  @Before("execution(* org.tutev.web.erp.service.BaseDao.save(..))")
      public void beforeInsert(JoinPoint joinPoint) {
		  if(joinPoint.getArgs()!=null &&  joinPoint.getArgs().length>0 && joinPoint.getArgs()[0] != null){
			  try {
				UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				BeanUtils.setProperty(joinPoint.getArgs()[0],"ekleyen",userDetails.getUsername());
				BeanUtils.setProperty(joinPoint.getArgs()[0],"eklemeTarihi",new Date());
				BeanUtils.setProperty(joinPoint.getArgs()[0],"durum",Boolean.TRUE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
      }
	  
	  @Before("execution(* org.tutev.web.erp.service.BaseDao.update(..)) || execution(* org.tutev.web.erp.service.BaseDao.saveOrUpdate(..))")
      public void beforeUpdate(JoinPoint joinPoint) {
		  if(joinPoint.getArgs()!=null &&  joinPoint.getArgs().length>0 && joinPoint.getArgs()[0] != null){
			  try {
				UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				BeanUtils.setProperty(joinPoint.getArgs()[0],"guncelleyen",userDetails.getUsername());
				BeanUtils.setProperty(joinPoint.getArgs()[0],"guncellemeTarihi",new Date());
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
      }
     
      @After("execution(* org.tutev.web.erp.service.BaseDao.*(..))")
      public void logAfter(JoinPoint joinPoint) {
             System.out.println("logAfter() Triggered");
      }
      
}
