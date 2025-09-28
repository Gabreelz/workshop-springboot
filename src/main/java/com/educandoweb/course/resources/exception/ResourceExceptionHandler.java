package com.educandoweb.course.resources.exception;

import java.time.Instant; // Para trabalhar com timestamp

import javax.servlet.http.HttpServletRequest; // Para acessar informações da requisição HTTP

import org.springframework.http.HttpStatus; // Representa os códigos HTTP (ex: 404, 500)
import org.springframework.http.ResponseEntity; // Para enviar respostas HTTP
import org.springframework.web.bind.annotation.ControllerAdvice; // Para interceptar exceções globalmente
import org.springframework.web.bind.annotation.ExceptionHandler; // Para tratar exceções específicas

import com.educandoweb.course.Services.exceptions.ResourceNotFoundException; // Exceção personalizada

// Anotação que indica que esta classe vai tratar exceções de forma global em todos os controllers
@ControllerAdvice
public class ResourceExceptionHandler {

    // Indica que este método trata exceções do tipo ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        
        // Mensagem curta de erro
        String error = "Resource not found";
        
        // Código HTTP a ser retornado (404 Not Found)
        HttpStatus status = HttpStatus.NOT_FOUND;
        
        // Cria um objeto StandardError com todas as informações do erro
        // Instant.now() -> momento em que ocorreu o erro
        // status.value() -> código HTTP (404)
        // error -> descrição curta
        // e.getMessage() -> mensagem detalhada da exceção lançada
        // request.getRequestURI() -> caminho da requisição que causou o erro
        StandardError err = new StandardError(
                Instant.now(),
                status.value(),
                error,
                e.getMessage(),
                request.getRequestURI()
        );
        
        // Retorna a resposta HTTP com o código de status e o corpo contendo o StandardError
        return ResponseEntity.status(status).body(err);
    }
}
