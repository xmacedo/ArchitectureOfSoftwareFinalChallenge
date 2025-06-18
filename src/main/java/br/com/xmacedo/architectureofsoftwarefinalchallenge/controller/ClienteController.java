package br.com.xmacedo.architectureofsoftwarefinalchallenge.controller;

import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.DTO.ClienteRequestDTO;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.DTO.ClienteResponseDTO;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
@Tag(name = "Clientes", description = "API para gerenciamento de clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Listar todos os clientes",
            description = "Retorna uma lista com todos os clientes cadastrados no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clientes encontrados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum cliente encontrado")
    })
    @GetMapping
    public ResponseEntity<?> listarTodos() {
        List<ClienteResponseDTO> clientes = clienteService.findAll();
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Buscar cliente por ID",
            description = "Retorna um cliente específico baseado no ID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorID(
            @Parameter(description = "ID do cliente") @PathVariable Long id) {
        return clienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .notFound()
                        .build());
    }

    @Operation(summary = "Buscar clientes por nome",
            description = "Retorna uma lista de clientes que possuem o nome especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clientes encontrados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum cliente encontrado com o nome especificado")
    })
    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(
            @Parameter(description = "Nome do cliente") @PathVariable String nome) {
        List<ClienteResponseDTO> clientes = clienteService.findByName(nome);
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Criar novo cliente",
            description = "Cria um novo cliente no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente criado com sucesso")
    })
    @PostMapping
    public ResponseEntity<?> createClient(
            @Parameter(description = "Dados do cliente") @RequestBody ClienteRequestDTO clientRequestDTO) {
        ClienteResponseDTO clienteSalvo = clienteService.createOrSave(clientRequestDTO);
        return ResponseEntity.ok(clienteSalvo);
    }

    @Operation(summary = "Contar total de clientes",
            description = "Retorna o número total de clientes cadastrados no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contagem realizada com sucesso")
    })
    @GetMapping("/contar")
    public ResponseEntity<?> contarClientes() {
        return ResponseEntity.ok(clienteService.countingClients());
    }

    @Operation(summary = "Deletar cliente",
            description = "Remove um cliente do sistema baseado no ID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(
            @Parameter(description = "ID do cliente") @PathVariable Long id) {
        if (clienteService.findById(id).isPresent()) {
            clienteService.deleteClientById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}