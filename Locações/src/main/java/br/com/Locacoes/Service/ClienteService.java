package br.com.Locacoes.Service;

import br.com.Locacoes.Entity.Cliente;
import br.com.Locacoes.Exception.ClienteNotFound;
import br.com.Locacoes.Repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarCliente(Long id) {
        Optional<Cliente> clienteOp = clienteRepository.findById(id);
        return clienteOp.orElseThrow(() -> new ClienteNotFound("Cliente com o ID "+id+" não encontrado"));
    }

    public Cliente adicionarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {
        Optional <Cliente> clienteOp = clienteRepository.findById(id);
        if (clienteOp.isPresent()){
            cliente.setId(id);
            return clienteRepository.save(cliente);
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
