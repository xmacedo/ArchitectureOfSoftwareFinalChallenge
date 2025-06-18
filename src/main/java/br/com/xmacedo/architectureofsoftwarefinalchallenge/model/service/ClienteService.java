package br.com.xmacedo.architectureofsoftwarefinalchallenge.model.service;

import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.DTO.ClienteRequestDTO;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.DTO.ClienteResponseDTO;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.entity.Cliente;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.mapper.ClienteMapper;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.repository.ClienteRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    static final Logger logger = LogManager.getLogger(ClienteService.class.getName());

    public List<ClienteResponseDTO> findAll() {
        logger.info("Buscando todos os clientes");
        return clienteRepository.findAll()
                .stream()
                .map(ClienteMapper::entityToDTO)
                .toList();
    }

    //buscarporID
    public Optional<ClienteResponseDTO> findById(Long id) {
        logger.info("Buscando cliente por ID: {}", id);
        return clienteRepository.findById(id)
                .map(ClienteMapper::entityToDTO);
    }

    //buscarPorNome
    public List<ClienteResponseDTO> findByName(String name) {
        logger.info("Buscando cliente por nome={}", name);
        return clienteRepository.findByNome(name)
                .stream()
                .map(ClienteMapper::entityToDTO)
                .toList();
    }

    public ClienteResponseDTO createOrSave(ClienteRequestDTO clienteRequestDTO) {
        logger.info("Criando ou atualizando cliente: {}", clienteRequestDTO);
        if (null != clienteRequestDTO && !clienteRequestDTO.getCpf().isBlank()) {

            Cliente newCliente = ClienteMapper.dtoToEntity(clienteRequestDTO);
            Optional<Cliente> optionalCliente = clienteRepository.findByCpf(clienteRequestDTO.getCpf());

            if (optionalCliente.isPresent()) {
                Long idCliente = optionalCliente.get().getId();
                logger.info("Cliente existe, atualizando, id={}", idCliente);
                newCliente.setId(idCliente);
            }

            clienteRepository.save(newCliente);
            return ClienteMapper.entityToDTO(newCliente);
        }
        return null;
    }

    //deletar
    public void deleteClientById(Long id) {
        logger.info("Deletando cliente por ID: {}", id);
        clienteRepository.deleteById(id);
    }

    //contarClientes
    public Long countingClients() {
        logger.info("Contando clientes");
        return clienteRepository.count();
    }
}
