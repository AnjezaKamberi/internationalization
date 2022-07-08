package com.engineering.discriminator.internationalization.service.converter;

import org.springframework.stereotype.Component;

import com.engineering.discriminator.internationalization.domain.Tipologia;
import com.engineering.discriminator.internationalization.dto.TipologiaDTO;

@Component
public class TipologiaConverter implements BasicConverter<TipologiaDTO, Tipologia> {

	@Override
	public Tipologia toEntity(TipologiaDTO dto) {
		return null;
	}

	@Override
	public TipologiaDTO toDto(Tipologia entity) {
		TipologiaDTO tipologia = new TipologiaDTO();
		tipologia.setCode(entity.getCode());
		tipologia.setDescription(entity.getTipologiaI18N().iterator().next().getDescription());
		return tipologia;
	}

}
