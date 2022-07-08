package com.engineering.discriminator.internationalization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engineering.discriminator.internationalization.domain.Tipologia;

public interface TipologicaRepository extends JpaRepository<Tipologia, String> {

}
