package com.engineering.discriminator.internationalization.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "tipologia")
@Data
public class Tipologia {

	@Id
	private Long code;
	private String description;
}
