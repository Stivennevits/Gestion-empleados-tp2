package com.neoris.turnosrotativos.exceptions;

public class NoteNotFoundException extends RuntimeException {
	
	public NoteNotFoundException(Long id) {
		super("Could not found Empleado id " + id );
	}

}
