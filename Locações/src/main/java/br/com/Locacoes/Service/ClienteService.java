package br.com.Locacoes.Service;

import br.com.Locacoes.DTO.ClienteDTO;
import br.com.Locacoes.Entity.Cliente;
import br.com.Locacoes.Exception.ClienteNotFound;
import br.com.Locacoes.Mapper.ClienteMapper;
import br.com.Locacoes.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteDTO buscarCliente(Long id) {
        Optional<Cliente> clienteOp = clienteRepository.findById(id);

        Cliente cliente = clienteOp.orElseThrow(() -> new ClienteNotFound("Cliente com o ID "+id+" não encontrado"));
        return clienteMapper.toDTO(cliente);
    }

    public ClienteDTO adicionarCliente(ClienteDTO cliente) {
        Cliente clienteEntity = clienteMapper.toEntity(cliente);
        return clienteMapper.toDTO(clienteRepository.save(clienteEntity));
    }

    public List<ClienteDTO> listarClientes() {
        return clienteMapper.toDTOList(clienteRepository.findAll());
    }

    public ClienteDTO atualizarCliente(Long id, ClienteDTO cliente) {
        Cliente clienteEntity = clienteMapper.toEntity(cliente);
        Optional <Cliente> clienteOp = clienteRepository.findById(id);
        if (clienteOp.isPresent()){
            clienteEntity.setId(id);
            return clienteMapper.toDTO(clienteRepository.save(clienteEntity));
        }
        throw new ClienteNotFound("Cliente com o ID "+id+" não encontrado");
    }

    public void deletarCliente(Long id) {
        if (!clienteRepository.existsById(id)){
            throw new ClienteNotFound("Cliente com o ID "+id+" não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
