package br.com.Locacoes.Exception;

import org.springframework.http.HttpStatus;

public class ClienteNotFound extends RuntimeException implements ApiExceptionContrato {

    private final String code = "CLIENTE_NOT_FOUND";
    private String mensagem;

    public ClienteNotFound(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMensagem() {
        return mensagem;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
