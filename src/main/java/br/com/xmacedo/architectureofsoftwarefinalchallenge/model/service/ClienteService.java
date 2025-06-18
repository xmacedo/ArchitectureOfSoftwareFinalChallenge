package br.com.xmacedo.architectureofsoftwarefinalchallenge.model.service;

import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.DTO.ClienteRequestDTO;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.DTO.ClienteResponseDTO;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.entity.Cliente;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.mapper.ClienteMapper;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteResponseDTO> findAll() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteMapper::entityToDTO)
                .toList();
    }

    //buscarporID
    public Optional<ClienteResponseDTO> findById(Long id) {
        return clienteRepository.findById(id)
                .map(ClienteMapper::entityToDTO);
    }

    //buscarPorNome
    public List<ClienteResponseDTO> findByName(String name) {
        return clienteRepository.findByNome(name)
                .stream()
                .map(ClienteMapper::entityToDTO)
                .toList();
    }

    public ClienteResponseDTO createOrSave(ClienteRequestDTO clienteRequestDTO) {

        if (null != clienteRequestDTO && !clienteRequestDTO.getCpf().isEmpty()) {
            Cliente newCliente = ClienteMapper.dtoToEntity(clienteRequestDTO);
            Optional<Cliente> optionalCliente = clienteRepository.findByCpf(clienteRequestDTO.getCpf());

            if (optionalCliente.isPresent()) {
                newCliente.setId(optionalCliente.get().getId());
            }

            clienteRepository.save(newCliente);
            return ClienteMapper.entityToDTO(newCliente);
        }
        return null;
    }

    //deletar
    public void deleteClientById(Long id) {
        clienteRepository.deleteById(id);
    }

    //contarClientes
    public Long countingClients() {
        return clienteRepository.count();
    }
}
