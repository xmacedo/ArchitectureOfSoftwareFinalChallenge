package br.com.xmacedo.architectureofsoftwarefinalchallenge.model.repository;

import br.com.xmacedo.architectureofsoftwarefinalchallenge.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);

    Optional<Cliente> findByCpf(String cpf);
}
