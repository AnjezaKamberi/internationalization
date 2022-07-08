package com.engineering.discriminator.internationalization.service.converter;

import org.springframework.stereotype.Component;

import com.engineering.discriminator.internationalization.domain.Language;
import com.engineering.discriminator.internationalization.dto.LanguageDTO;

@Component
public class LanguageConverter implements BasicConverter<LanguageDTO, Language> {

	@Override
	public Language toEntity(LanguageDTO dto) {
		Language language = new Language();
		language.setCode(dto.getCode());
		language.setName(dto.getName());
		return language;
	}

	@Override
	public LanguageDTO toDto(Language entity) {
		LanguageDTO language = new LanguageDTO();
		language.setCode(entity.getCode());
		language.setName(entity.getName());
		return language;
	}

}
