package com.engineering.discriminator.internationalization.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.engineering.discriminator.internationalization.config.LanguageContext;
import com.engineering.discriminator.internationalization.domain.Tipologia;
import com.engineering.discriminator.internationalization.domain.TipologiaI18N;
import com.engineering.discriminator.internationalization.dto.TipologiaDTO;
import com.engineering.discriminator.internationalization.repository.TipologicaI18NRepository;
import com.engineering.discriminator.internationalization.repository.TipologicaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipologicaService {

	private final TipologicaRepository tipologicaRepository;
	private final TipologicaI18NRepository tipologicaI18Nrepository;

	private static final String NATIVE_LANGUAGE = "it";
	@PersistenceContext
	public EntityManager entityManager;

	public TipologiaDTO getTipologiaById(Long tipologiaCode) {
		// TODO use TipologiaConverter
		TipologiaDTO dto = new TipologiaDTO();
		if (LanguageContext.getCurrentLanguage().equals(NATIVE_LANGUAGE)) {
			Tipologia res = tipologicaRepository.findById(tipologiaCode)
					.orElseThrow(() -> new RuntimeException("tipologica not registered"));
			dto.setCode(res.getCode());
			dto.setDescription(res.getDescription());
		} else {

			TipologiaI18N res = tipologicaI18Nrepository.findByTipologiaCode(tipologiaCode)
					.orElseThrow(() -> new RuntimeException("there is not translation for this language"));
			dto.setCode(res.getTipologia().getCode());
			dto.setDescription(res.getDescription());

		}
		return dto;
	}

}
