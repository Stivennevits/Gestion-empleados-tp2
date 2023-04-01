package com.neoris.turnosrotativos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.neoris.turnosrotativos.entities.Empleados;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleados, Long>{

	
	
}
