
package com.engineering.discriminator.internationalization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.engineering.discriminator.internationalization.dto.DitaDTO;
import com.engineering.discriminator.internationalization.service.DitaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DitaController {

	private final DitaService ditaService;

	@GetMapping("/dita/{id}")
	public ResponseEntity<DitaDTO> getDitaById(@PathVariable("id") Long ditaId) {
		return new ResponseEntity<>(ditaService.getDitaById(ditaId), HttpStatus.OK);
	}
}
