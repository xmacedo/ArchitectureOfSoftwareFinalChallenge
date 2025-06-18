package br.com.xmacedo.architectureofsoftwarefinalchallenge.controller;

import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.DTO.ClienteRequestDTO;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.DTO.ClienteResponseDTO;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        List<ClienteResponseDTO> clientes = clienteService.findAll();
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorID(@PathVariable Long id) {
        return clienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .notFound()
                        .build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String nome) {
        List<ClienteResponseDTO> clientes = clienteService.findByName(nome);
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody ClienteRequestDTO clientRequestDTO) {
        ClienteResponseDTO clienteSalvo = clienteService.createOrSave(clientRequestDTO);
        return ResponseEntity.ok(clienteSalvo);
    }

    @GetMapping("/contar")
    public ResponseEntity<?> contarClientes() {
        return ResponseEntity.ok(clienteService.countingClients());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id) {
        if (clienteService.findById(id).isPresent()) {
            clienteService.deleteClientById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
