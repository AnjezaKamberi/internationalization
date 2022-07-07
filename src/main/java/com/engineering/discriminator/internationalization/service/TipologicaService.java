package com.engineering.discriminator.internationalization.service;

import org.springframework.stereotype.Service;

import com.engineering.discriminator.internationalization.domain.TipologiaI18N;
import com.engineering.discriminator.internationalization.dto.TipologiaDTO;
import com.engineering.discriminator.internationalization.repository.TipologicaI18NRepository;
import com.engineering.discriminator.internationalization.repository.TipologicaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipologicaService extends InternationalService {

	private final TipologicaRepository tipologicaRepository;
	private final TipologicaI18NRepository tipologicaI18Nrepository;

	public TipologiaDTO getTipologiaById(String tipologiaCode) {
		// TODO use TipologiaConverter

		TipologiaDTO dto = new TipologiaDTO();
		TipologiaI18N res = tipologicaI18Nrepository.findByTipologiaCode(tipologiaCode)
				.orElseThrow(() -> new RuntimeException("there is not translation for this language"));
		dto.setCode(res.getTipologia().getCode());
		dto.setDescription(res.getDescription());

		return dto;
	}

}
