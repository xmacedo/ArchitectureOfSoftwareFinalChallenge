package br.com.xmacedo.architectureofsoftwarefinalchallenge.controller;

import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.Cliente;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        List<Cliente> clientes = clienteService.listarTodos();
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorID(Long id) {
        return clienteService.buscarPorID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(String nome) {
        List<Cliente> clientes = clienteService.buscarPorNome(nome);
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<?> salvarCliente(Cliente cliente) {
        Cliente clienteSalvo = clienteService.salvar(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @GetMapping("/contar")
    public ResponseEntity<?> contarClientes() {
        return ResponseEntity.ok(clienteService.contarClientes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
