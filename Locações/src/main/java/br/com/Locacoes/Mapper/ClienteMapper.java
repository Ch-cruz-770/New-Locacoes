package br.com.Locacoes.Mapper;

import br.com.Locacoes.DTO.ClienteDTO;
import br.com.Locacoes.Entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "criador", ignore = true)
    Cliente toEntity(ClienteDTO dto);

    ClienteDTO toDTO(Cliente cliente);


    List<ClienteDTO> toDTOList(List<Cliente> clientes);
    List<Cliente> toEntityList(List<ClienteDTO> dtos);
}

