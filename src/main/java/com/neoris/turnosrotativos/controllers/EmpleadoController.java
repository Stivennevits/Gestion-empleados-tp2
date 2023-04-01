package com.neoris.turnosrotativos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neoris.turnosrotativos.entities.Empleados;
import com.neoris.turnosrotativos.exceptions.MessageUtil;
import com.neoris.turnosrotativos.exceptions.MyException;
import com.neoris.turnosrotativos.exceptions.NoteNotFoundException;
import com.neoris.turnosrotativos.exceptions.ResourceNotFoundException;
import com.neoris.turnosrotativos.repository.EmpleadoRepository;
import com.neoris.turnosrotativos.services.EmpleadoService;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping
@CrossOrigin(	"http://localhost:4200/")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository repo;
	
	@GetMapping("/empleado")
	public List<Empleados> ObtenerEmpleados(){
		return repo.findAll();
	}
	
	@GetMapping("/empleado/{empleadoId}")
	public ResponseEntity<Empleados> getEmpleado(@PathVariable("empleadoId") Long empleadoId){
		Empleados empleado = repo.findById(empleadoId)
				.orElseThrow(()-> new ResourceNotFoundException("No se encontró un empleado con id " + empleadoId));
		return ResponseEntity.ok(empleado);
		
	}
	
	@PostMapping("/empleado")
	public void saveUpdate(@Valid @RequestBody Empleados empleados){
		repo.save(empleados);;
	}
	
	@PutMapping("/empleado/{empleadoId}") 
	public ResponseEntity<Empleados> actualizarEmpleado(@RequestBody Empleados newEmp, @PathVariable("empleadoId") Long empleadoId){
		Empleados Empleado = repo.findById(empleadoId)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + empleadoId));
			
		Empleado.setNro_documento(newEmp.getNro_documento());
		Empleado.setNombre(newEmp.getNombre());
		Empleado.setApellido(newEmp.getApellido());
		Empleado.setEmail(newEmp.getEmail());
		Empleado.setFecha_nacimiento(newEmp.getFecha_nacimiento());
		Empleado.setFecha_ingreso(newEmp.getFecha_ingreso());
		Empleado.setFecha_creacion(newEmp.getFecha_creacion());
		Empleados EmpleadoOk = repo.save(Empleado);
		return ResponseEntity.ok(EmpleadoOk);
	}
	
	@DeleteMapping("/empleado/{empleadoId}")
	public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long empleadoId){
		Empleados Empleado = repo.findById(empleadoId)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + empleadoId));
		
		repo.delete(Empleado);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
	

}


/*
@Autowired
private EmpleadoService empleadoService;

@GetMapping
public List<Empleados> getAll(){
	return empleadoService.getEmpleados();
}

@PostMapping
public void saveUpdate(@RequestBody Empleados empleados){
	empleadoService.saveOrUpdate(empleados);;
}

@PutMapping("/{empleadoId}")
public void 

@DeleteMapping("/{empleadoId}")
public void delete(@PathVariable("empleadoId") Integer empleadoId){
	empleadoService.delete(empleadoId);;
}

@GetMapping("/{empleadoId}") 
public Optional<Empleados>  getById(@PathVariable("empleadoId") Integer empleadoId){
	return empleadoService.getEmpleado(empleadoId);
}

*/

/*
@GetMapping("/empleado/{empleadoId}") 
public Optional<Empleados>  getById(@PathVariable("empleadoId") Long empleadoId){
	return repo.findById(empleadoId);
}
*/
/*
@PutMapping("/empleado/{empleadoId}") 
Empleados updateE(@RequestBody Empleados newEmp, @PathVariable("empleadoId") Long empleadoId) {
	return repo.findById(empleadoId)
			.map(Empleado -> {
				Empleado.setNro_documento(newEmp.getNro_documento());
				Empleado.setNombre(newEmp.getNombre());
				Empleado.setApellido(newEmp.getApellido());
				Empleado.setEmail(newEmp.getEmail());
				Empleado.setFecha_nacimiento(newEmp.getFecha_nacimiento());
				Empleado.setFecha_ingreso(newEmp.getFecha_ingreso());
				Empleado.setFecha_creacion(newEmp.getFecha_creacion());
				return repo.save(Empleado);
			}).orElseThrow(()-> new ResourceNotFoundException("No se encontró un empleado con id " + empleadoId));
	
}
*/
/*
@DeleteMapping("/empleado/{empleadoId}")
public void delete(@PathVariable("empleadoId") Long empleadoId ){
	repo.deleteById(empleadoId);;
}
*/
