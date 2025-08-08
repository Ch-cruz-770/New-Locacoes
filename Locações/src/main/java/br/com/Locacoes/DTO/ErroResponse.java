package br.com.Locacoes.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErroResponse {
    private String code;
    private String mensagem;
    private int status;


}
