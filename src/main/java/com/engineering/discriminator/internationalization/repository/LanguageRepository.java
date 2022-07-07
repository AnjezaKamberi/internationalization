package com.engineering.discriminator.internationalization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engineering.discriminator.internationalization.domain.Language;

public interface LanguageRepository extends JpaRepository<Language, String> {

}
