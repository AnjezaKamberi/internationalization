package com.engineering.discriminator.internationalization.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import lombok.Data;

@Entity(name = "tipologia_i18n")
@Data
@FilterDef(name = "languageFilter", parameters = { @ParamDef(name = "language", type = "string") })
@Filter(name = "languageFilter", condition = "language = :language")
public class TipologiaI18N {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "language")
	private Language language;

	@ManyToOne
	@JoinColumn(name = "tipologia_id")
	private Tipologia tipologia;

	private String description;

}
