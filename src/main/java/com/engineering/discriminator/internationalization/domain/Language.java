package com.engineering.discriminator.internationalization.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "language")
@Data
public class Language {

	@Id
	private String code;
	private String name;

}
