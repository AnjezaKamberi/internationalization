package com.engineering.discriminator.internationalization.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "ditta")
@Getter
@Setter
public class Ditta {

	@Id
	private Long id;
	private String name;
	@JsonManagedReference
	@OneToOne
	@JoinColumn(name = "tipologia_id")
	private Tipologia tipologia;

}
