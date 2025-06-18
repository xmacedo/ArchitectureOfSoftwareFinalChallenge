package br.com.xmacedo.architectureofsoftwarefinalchallenge.model.mapper;

import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.DTO.ClienteRequestDTO;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.entity.Cliente;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.DTO.ClienteResponseDTO;

public class ClienteMapper {
    public static ClienteResponseDTO entityToDTO(Cliente cliente) {
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        clienteResponseDTO.setId(cliente.getId());
        clienteResponseDTO.setNome(cliente.getNome());
        clienteResponseDTO.setCpf(cliente.getCpf());
        clienteResponseDTO.setEmail(cliente.getEmail());
        clienteResponseDTO.setTelefone(cliente.getTelefone());
        clienteResponseDTO.setEndereco(cliente.getEndereco());
        clienteResponseDTO.setComplemento(cliente.getComplemento());
        clienteResponseDTO.setCidade(cliente.getCidade());
        clienteResponseDTO.setEstado(cliente.getEstado());
        clienteResponseDTO.setCep(cliente.getCep());

        return clienteResponseDTO;
    }

    public static Cliente dtoToEntity(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteRequestDTO.getId());
        cliente.setNome(clienteRequestDTO.getNome());
        cliente.setCpf(clienteRequestDTO.getCpf());
        cliente.setEmail(clienteRequestDTO.getEmail());
        cliente.setTelefone(clienteRequestDTO.getTelefone());
        cliente.setEndereco(clienteRequestDTO.getEndereco());
        cliente.setComplemento(clienteRequestDTO.getComplemento());
        cliente.setCidade(clienteRequestDTO.getCidade());
        cliente.setEstado(clienteRequestDTO.getEstado());
        cliente.setCep(clienteRequestDTO.getCep());
        return cliente;
    }
}
