package com.engineering.discriminator.internationalization.service;

import org.springframework.stereotype.Service;

import com.engineering.discriminator.internationalization.domain.Ditta;
import com.engineering.discriminator.internationalization.dto.DitaDTO;
import com.engineering.discriminator.internationalization.repository.DitaRepository;
import com.engineering.discriminator.internationalization.service.converter.DittaConverter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DitaService extends InternationalService {

	private final DitaRepository ditaRepository;
	private final DittaConverter dittaConverter;

	public DitaDTO getDitaById(Long ditaId) {
		Ditta res = ditaRepository.findById(ditaId)
				.orElseThrow(() -> new RuntimeException("there is no Ditta for this id"));

		return dittaConverter.toDto(res);
	}

}
