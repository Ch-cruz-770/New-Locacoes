package br.com.Locacoes.Exception;

import org.springframework.http.HttpStatus;

public interface ApiExceptionContrato {
    String getCode();
    String getMensagem();
    HttpStatus getHttpStatus();
}
