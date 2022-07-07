package com.engineering.discriminator.internationalization.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engineering.discriminator.internationalization.domain.TipologiaI18N;

public interface TipologicaI18NRepository extends JpaRepository<TipologiaI18N, Long> {

	Optional<TipologiaI18N> findByTipologiaCode(String code);
}
