package br.com.Locacoes.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCreationDTO {

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3, max = 30, message = "O tamanho minimo é de 3 e no maximo 30 caracteres!")
    private String nome;
    @NotBlank(message = "Email é obrigatório!")
    private String email;
    @NotBlank(message = "Senha é obrigatorio!")
    @Size(min = 6, message = "A senha deve conter no miniom 6 caracteres!")
    private String senha;
}
