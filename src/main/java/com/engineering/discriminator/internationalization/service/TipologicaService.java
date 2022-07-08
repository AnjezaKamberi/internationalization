package com.engineering.discriminator.internationalization.service;

import org.springframework.stereotype.Service;

import com.engineering.discriminator.internationalization.domain.Tipologia;
import com.engineering.discriminator.internationalization.dto.TipologiaDTO;
import com.engineering.discriminator.internationalization.repository.TipologicaRepository;
import com.engineering.discriminator.internationalization.service.converter.TipologiaConverter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipologicaService extends InternationalService {

	private final TipologicaRepository tipologicaRepository;
	private final TipologiaConverter tipologiaConverter;

	public TipologiaDTO getTipologiaById(String tipologiaCode) {
		Tipologia tipologia = tipologicaRepository.findById(tipologiaCode)
				.orElseThrow(() -> new RuntimeException("there is not translation for this language"));

		return tipologiaConverter.toDto(tipologia);
	}

}
