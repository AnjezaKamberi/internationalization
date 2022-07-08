package com.engineering.discriminator.internationalization.service.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface BasicConverter<DTO, ENTITY> {
	ENTITY toEntity(DTO dto);

	DTO toDto(ENTITY entity);

	default List<ENTITY> toEntities(Collection<DTO> dtos) {
		return dtos != null ? dtos.stream().map(this::toEntity).collect(Collectors.toList()) : new ArrayList<>();
	}

	default List<DTO> toDtos(Collection<ENTITY> entities) {
		return entities != null ? entities.stream().map(this::toDto).collect(Collectors.toList()) : new ArrayList<>();
	}
}
