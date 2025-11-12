package br.com.Locacoes.Mapper;

import br.com.Locacoes.DTO.UsuarioCreationDTO;
import br.com.Locacoes.DTO.UsuarioResponseDTO;
import br.com.Locacoes.Entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "string")
public interface UsuarioMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "clientesCriados", ignore = true)
    Usuario toEntity (UsuarioCreationDTO dto);

    UsuarioResponseDTO toResponseDTO(Usuario entity);
}
