package br.com.faeterj.gestaofaeterj.exception;

public class ResourceBadRequestException extends RuntimeException {

	public ResourceBadRequestException(String mensagem) {
		super(mensagem);
	}
}
