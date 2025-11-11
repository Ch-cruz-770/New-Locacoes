package br.com.Locacoes.Mapper;

import br.com.Locacoes.DTO.ClienteDTO;
import br.com.Locacoes.Entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {
    ClienteDTO toDTO(Cliente cliente);
    Cliente toEntity(ClienteDTO dto);

    List<ClienteDTO> toDTOList(List<Cliente> clientes);
    List<Cliente> toEntityList(List<ClienteDTO> dtos);
}

