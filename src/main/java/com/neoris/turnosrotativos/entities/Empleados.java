package com.neoris.turnosrotativos.entities;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "empleados")
public class Empleados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nro_documento", unique = true, nullable = false)
	@Digits(integer = 20, fraction = 0)
	private Integer nro_documento;
	
	@Column(name = "nombre", nullable = false)
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String nombre;
	
	@Column(name = "apellido", nullable = false)
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String apellido;
	
	@Column(name = "email", unique = true, nullable = false)
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
	private String email;
	
	@Past
	@Column(name = "fecha_nacimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_nacimiento;
	
	@Column(name = "fecha_ingreso", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_ingreso;
	
	@Column(name = "fecha_creacion",  columnDefinition = "DATETIME", nullable = false)
	private LocalDateTime fecha_creacion;
	
	
	public Empleados() {

	}
	
	@PreUpdate
	@PrePersist
	public void prePersist() {
		fecha_creacion = LocalDateTime.now();
	}	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNro_documento() {
		return nro_documento;
	}
	public void setNro_documento(Integer nro_documento) {
		this.nro_documento = nro_documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public LocalDateTime getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(LocalDateTime fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	
	
	
	
}
