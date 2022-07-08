package com.engineering.discriminator.internationalization.service.converter;

import org.springframework.stereotype.Component;

import com.engineering.discriminator.internationalization.domain.Ditta;
import com.engineering.discriminator.internationalization.dto.DitaDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DittaConverter implements BasicConverter<DitaDTO, Ditta> {

	private final TipologiaConverter tipologiaConverter;

	@Override
	public Ditta toEntity(DitaDTO dto) {
		return null;
	}

	@Override
	public DitaDTO toDto(Ditta entity) {
		DitaDTO ditta = new DitaDTO();
		ditta.setId(entity.getId());
		ditta.setName(entity.getName());
		ditta.setTipologia(tipologiaConverter.toDto(entity.getTipologia()));
		return ditta;
	}

}
