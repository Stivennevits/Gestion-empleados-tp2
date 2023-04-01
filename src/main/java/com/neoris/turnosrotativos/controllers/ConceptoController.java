package com.neoris.turnosrotativos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neoris.turnosrotativos.entities.Concepto;
import com.neoris.turnosrotativos.services.ConceptoService;

@RestController
public class ConceptoController {
	
	@Autowired
	private ConceptoService conceptoService;
	
	@GetMapping("/concepto")
	public List<Concepto> getAll(){
		return conceptoService.getConceptos();
	}
	
	@PostMapping("/concepto")
	public void saveUpdate(@RequestBody Concepto concepto){
		conceptoService.saveOrUpdate(concepto);;
	}
	
	@DeleteMapping("/concepto/{conceptoId}")
	public void delete(@PathVariable("conceptoId") Integer conceptoId){
		conceptoService.delete(conceptoId);;
	}
	
	@GetMapping("/concepto/{conceptoId}")
	public Optional<Concepto>  getById(@PathVariable("conceptoId") Integer conceptoId){
		return conceptoService.getConcepto(conceptoId);
	}
	
}
