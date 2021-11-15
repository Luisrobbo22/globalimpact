package br.com.fiap.globalimpact.service;

import br.com.fiap.globalimpact.model.Fornecedor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FornecedorService {

    void create(Fornecedor fornecedor);

    List<Fornecedor> findAll();

    List<Fornecedor> remove(Long id);

    Optional<Fornecedor> findById(Long id);

    List<Fornecedor> findByNome(String nome);
}
