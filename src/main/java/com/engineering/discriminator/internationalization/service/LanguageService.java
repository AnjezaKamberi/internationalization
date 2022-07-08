package com.engineering.discriminator.internationalization.service;

import org.springframework.stereotype.Service;

import com.engineering.discriminator.internationalization.domain.Language;
import com.engineering.discriminator.internationalization.dto.LanguageDTO;
import com.engineering.discriminator.internationalization.repository.LanguageRepository;
import com.engineering.discriminator.internationalization.service.converter.LanguageConverter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguageService {

	private final LanguageRepository languageRepo;
	private final LanguageConverter languageConverter;

	public LanguageDTO getLanguageByCode(String code) {
		Language language = languageRepo.findById(code)
				.orElseThrow(() -> new RuntimeException("do not support this language"));
		return languageConverter.toDto(language);
	}

}
