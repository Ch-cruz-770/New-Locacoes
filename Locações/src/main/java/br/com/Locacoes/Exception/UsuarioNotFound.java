package br.com.Locacoes.Exception;

import org.springframework.http.HttpStatus;

public class UsuarioNotFound extends RuntimeException implements ApiExceptionContrato{

    private final String code = "USUARIO_NOT_FOUND";
    private String mensagem;

    public UsuarioNotFound(String mensagem) {
        super(mensagem);
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
