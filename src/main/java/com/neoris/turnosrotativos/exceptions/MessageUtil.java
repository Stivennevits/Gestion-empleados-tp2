package com.neoris.turnosrotativos.exceptions;

import lombok.Getter;

@Getter	
public enum MessageUtil {
	OK("OK", 201),
	CREATED("Registro creado ",200),
	UPDATE(" ",200),
	DELETED(" ",200),
	NOT_FOUND(" ",200),
	BAD_REQUEST(" ", 400),
	CONFLICT(" ", 409),
	;
	
	private String key;
	private int code;
	
	private MessageUtil(String key, int code) {
		this.key = key;
		this.code = code;
	}
}
