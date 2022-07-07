
package com.engineering.discriminator.internationalization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.engineering.discriminator.internationalization.dto.TipologiaDTO;
import com.engineering.discriminator.internationalization.service.TipologicaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TipologicaController {

	private final TipologicaService tipologicaService;

	@GetMapping("/{id}")
	public ResponseEntity<TipologiaDTO> getTruckDataById(@PathVariable("id") Long tipologiaCode) {
		return new ResponseEntity<>(tipologicaService.getTipologiaById(tipologiaCode), HttpStatus.OK);
	}
}
