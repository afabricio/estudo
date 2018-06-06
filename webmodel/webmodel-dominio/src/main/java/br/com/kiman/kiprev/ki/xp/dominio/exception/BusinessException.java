package br.com.kiman.kiprev.ki.xp.dominio.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -2748345296426348562L;


	public BusinessException(String message) {
		super(message);
	}


	public BusinessException(String message, Exception e) {
		super(message, e);
	}

	public BusinessException(Exception e) {
		super(e);
	}


}
