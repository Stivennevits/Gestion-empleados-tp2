package com.neoris.turnosrotativos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.turnosrotativos.entities.Concepto;
import com.neoris.turnosrotativos.repository.ConceptoRepository;

@Service
public class ConceptoService {
	
	@Autowired
	ConceptoRepository conceptoRepository;
	
	// get para todos los conceptos
	public List<Concepto> getConceptos(){
		return conceptoRepository.findAll();
	}
	
	// get para conceptos por id 
	public Optional<Concepto> getConcepto(Integer id){
		return conceptoRepository.findById(id);
	}
	
	// push o put para concepto
	public void saveOrUpdate(Concepto concepto) {
		conceptoRepository.save(concepto);
	}
	
	// borrar concepto por id 
	public void delete(Integer id) {
		conceptoRepository.deleteById(id);
	}
	
	
	
}
