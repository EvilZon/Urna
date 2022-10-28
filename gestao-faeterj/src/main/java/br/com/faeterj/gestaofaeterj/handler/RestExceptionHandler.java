package br.com.faeterj.gestaofaeterj.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.faeterj.gestaofaeterj.exception.ResourceBadRequestException;
import br.com.faeterj.gestaofaeterj.exception.ResourceNotFoundException;
import br.com.faeterj.gestaofaeterj.model.error.MensagemError;
import br.com.faeterj.gestaofaeterj.utils.ConversorDeData;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MensagemError> handlerResourceNotFoundException(ResourceNotFoundException ex){
		
		String dataHora = ConversorDeData.converterDateParaDataEHora(new Date());
		
		// Constroi o objeto de erro com base na exception.
		MensagemError erro =  new MensagemError(dataHora, 404, "Not Found", ex.getMessage());
		
		// Aqui eu estou devolvendo o objeto de erro montado com o status especifico que desejo, neste caso é o not found 404
		return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceBadRequestException.class)
	public ResponseEntity<MensagemError> handlerBadRequestException(ResourceBadRequestException ex){
		
		String dataHora  = ConversorDeData.converterDateParaDataEHora(new Date());
		MensagemError erro =  new MensagemError(dataHora, 400, "Bad Request", ex.getMessage());
				
		return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
	}
	
	// Tratamento geral que estamos fazendo para qualquer excption não tratada.
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MensagemError> handlerBadRequestException(Exception ex){
		String dataHora  = ConversorDeData.converterDateParaDataEHora(new Date());
		MensagemError erro =  new MensagemError(dataHora, 500, "Internal Server Error", ex.getMessage());
				
		return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
