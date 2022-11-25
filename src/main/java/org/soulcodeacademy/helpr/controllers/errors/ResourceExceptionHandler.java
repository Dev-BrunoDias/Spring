package org.soulcodeacademy.helpr.controllers.errors;

import org.soulcodeacademy.helpr.services.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.helpr.services.errors.RecursoNãoEncontradoError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

// Quando acontece um erro, essa classe decide como retornar a mensagem pro cliente.
@ControllerAdvice // Capacidade de gerenciar os erros que acontecem.
public class ResourceExceptionHandler {
    @ExceptionHandler(RecursoNãoEncontradoError.class)
    public ResponseEntity<CustomErrorResponse> recursoNaoEncontratoError(RecursoNãoEncontradoError erro, HttpServletRequest request) {
        CustomErrorResponse response = new CustomErrorResponse();
        response.setTimestamp(LocalDateTime.now()); // Define a data e hora em que o erro ocorreu
        response.setStatus(HttpStatus.NOT_FOUND.value()); // Define com 404 o codigo de status
        response.setMessage(erro.getMessage()); // Define a mensagem di erro vinda do service
        response.setPath(request.getRequestURI()); // Define qual endpoint ocorreu a requisição

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ParametrosInsuficientesError.class)
    public ResponseEntity<CustomErrorResponse> ParametrosInsufucientesError(ParametrosInsuficientesError error, HttpServletRequest request) {
        CustomErrorResponse response = new CustomErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(error.getMessage());
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<CustomErrorResponse> badCredentialsException(BadCredentialsException erro, HttpServletRequest request) {
        CustomErrorResponse response = new CustomErrorResponse();

        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setMessage("Email/senha inválidos!");
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
}
