package br.com.Locacoes.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    private Long id;

    @NotBlank(message = "O Nome é obrigatório!")
    @Size(min = 3, max = 30, message = "O tamanho minimo é de 3 caracteres e no máximo 30 caracteres")
    private String nome;

    @NotBlank(message = "O email é obrigatório!")
    private String email;

    @NotBlank(message = "O telefone é obrigatório!")
    private String telefone;

    @NotBlank(message = "O CPF é obrigatório!")
    @Size(min = 11, max = 14, message = "Permitido o Minimo de 11 caracteres!")
    private String cpf;

}
