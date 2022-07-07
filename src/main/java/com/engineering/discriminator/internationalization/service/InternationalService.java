package com.engineering.discriminator.internationalization.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public abstract class InternationalService {

	@PersistenceContext
	public EntityManager entityManager;
}
