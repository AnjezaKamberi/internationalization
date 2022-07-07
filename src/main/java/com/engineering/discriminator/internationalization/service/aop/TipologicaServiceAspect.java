package com.engineering.discriminator.internationalization.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.engineering.discriminator.internationalization.config.LanguageContext;
import com.engineering.discriminator.internationalization.service.TipologicaService;

@Aspect
@Component
public class TipologicaServiceAspect {

	@Before("execution(* com.engineering.discriminator.internationalization.service..*(..)) && target(tipologiaService)")
	public void setFilter(JoinPoint jp, TipologicaService tipologiaService) {
		Filter filter = tipologiaService.entityManager.unwrap(Session.class).enableFilter("languageFilter");
		filter.setParameter("language", LanguageContext.getCurrentLanguage());
		filter.validate();
	}
}
