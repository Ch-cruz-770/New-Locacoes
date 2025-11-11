package br.com.Locacoes.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {

    public ErrorResponse(String code, String mensagem, int status){
        this.code = code;
        this.mensagem = mensagem;
        this.status = status;
        validateError = null;
    }

    private String code;
    private String mensagem;
    private int status;
    private List<ValidateError> validateError;
}
