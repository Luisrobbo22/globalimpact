package br.com.fiap.globalimpact.repository;

import br.com.fiap.globalimpact.model.Cliente;
import br.com.fiap.globalimpact.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    List<Fornecedor> findByNomeContaining(String nome);
}
