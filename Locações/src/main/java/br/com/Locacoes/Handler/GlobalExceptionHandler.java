package br.com.Locacoes.Handler;

import br.com.Locacoes.DTO.ErrorResponse;
import br.com.Locacoes.DTO.ValidateError;
import br.com.Locacoes.Exception.ApiExceptionContrato;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handlerApiException(ApiExceptionContrato contrato) {
        HttpStatus status = contrato.getHttpStatus();

        ErrorResponse error = new ErrorResponse(
                contrato.getCode(),
                contrato.getMensagem(),
                status.value()
        );
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlerValidationException(MethodArgumentNotValidException validException) {
        List<ValidateError> errors = validException.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new ValidateError(fieldError.getField(), fieldError.getDefaultMessage()))
                .toList();
        ErrorResponse errorResponse = new ErrorResponse(
                "FIELD_VALIDATE_ERROR",
                "Existem campos não preenchidos corretamente!",
                HttpStatus.BAD_REQUEST.value(),
                errors
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerGenericExcepion(Exception ex) {
        log.error("Ocorreu um erro interno: " + ex.getMessage());
        log.error("Ocorreu um erro interno causa: " + ex.getCause());
        ErrorResponse error = new ErrorResponse("INTERNL_SERVER_ERROR", "Ocorreu um erro inesperado", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
