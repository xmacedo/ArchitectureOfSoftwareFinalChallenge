package br.com.xmacedo.architectureofsoftwarefinalchallenge.service;

import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.Cliente;
import br.com.xmacedo.architectureofsoftwarefinalchallenge.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
    //buscarporID
    public Optional<Cliente> buscarPorID(Long id) {
        return clienteRepository.findById(id);
    }
    //buscarPorNome
    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }
    //salvar
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    //deletar
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
    //contarClientes
    public Long contarClientes() {
        return clienteRepository.count();
    }
}
