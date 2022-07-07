package com.engineering.discriminator.internationalization.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.engineering.discriminator.internationalization.config.LanguageContext;
import com.engineering.discriminator.internationalization.service.InternationalService;

@Aspect
@Component
public class TipologicaServiceAspect {

	@Before("execution(* com.engineering.discriminator.internationalization.service..*(..)) && target(internationalService)")
	public void setFilter(JoinPoint jp, InternationalService internationalService) {
		Filter filter = internationalService.entityManager.unwrap(Session.class).enableFilter("languageFilter");
		filter.setParameter("language", LanguageContext.getCurrentLanguage());
		filter.validate();
	}
}
