package br.com.fiap.globalimpact.repository;

import br.com.fiap.globalimpact.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeContaining(String nome);
}
