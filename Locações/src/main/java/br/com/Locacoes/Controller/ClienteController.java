package br.com.Locacoes.Controller;

import br.com.Locacoes.DTO.ClienteDTO;
import br.com.Locacoes.Service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarCliente(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarCliente(id));
    }

    @PostMapping
    public ResponseEntity <ClienteDTO> adicionarCliente(@Valid @RequestBody ClienteDTO cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.adicionarCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id,@Valid @RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok(clienteService.atualizarCliente(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDTO> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
