package com.engineering.discriminator.internationalization.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Filter;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "tipologia")
@Getter
@Setter
public class Tipologia {

	@Id
	private String code;

	@JsonManagedReference
	@OneToMany(mappedBy = "tipologia")
	@Filter(name = "languageFilter", condition = "language = :language")
	private Set<TipologiaI18N> tipologiaI18N;
}
