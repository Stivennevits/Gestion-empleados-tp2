package com.neoris.turnosrotativos.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neoris.turnosrotativos.entities.Empleados;
import com.neoris.turnosrotativos.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	
	public List<Empleados> getEmpleados(){
		return empleadoRepository.findAll();
	}
	
	public Optional<Empleados> getEmpleado(Long id){
		return empleadoRepository.findById(id);
	}
	
	// push o put para Empleados
	public void saveOrUpdate(Empleados empleados) {
			empleadoRepository.save(empleados);
		}
		
	// borrar Empleado por id 
	public void delete(Long id) {
			empleadoRepository.deleteById(id);
		}
	
	

	
}
