package br.com.Locacoes.Handler;

import br.com.Locacoes.DTO.ErroResponse;
import br.com.Locacoes.Exception.ApiExceptionContrato;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExcepionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroResponse> handlerApiExcepion(ApiExceptionContrato contrato) {
        HttpStatus status = contrato.getHttpStatus();

        ErroResponse erro = new ErroResponse(contrato.getCode(), contrato.getMensagem(), status.value());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> handlerGenericExcepion(Exception ex) {
        log.error("Ocorreu um erro interno: " + ex.getMessage());
        log.error("Ocorreu um erro interno causa: " + ex.getCause());
        ErroResponse erro = new ErroResponse("INTERNL_SERVER_ERROR", "Ocorreu um erro inesperado", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}
