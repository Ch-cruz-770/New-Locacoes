package br.com.Locacoes.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class ValidateError {

    private  String campo;
    private String mensagem;

}
