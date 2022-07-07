package com.engineering.discriminator.internationalization.service;

import org.springframework.stereotype.Service;

import com.engineering.discriminator.internationalization.domain.Language;
import com.engineering.discriminator.internationalization.dto.LanguageDTO;
import com.engineering.discriminator.internationalization.repository.LanguageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguageService {

	private final LanguageRepository languageRepo;

	public LanguageDTO getLanguageByCode(String code) {
		Language language = languageRepo.findById(code)
				.orElseThrow(() -> new RuntimeException("do not support this language"));
		// TODO to use LanguageConverter
		LanguageDTO dto = new LanguageDTO();
		dto.setCode(language.getCode());
		dto.setName(language.getName());
		return dto;
	}

}
