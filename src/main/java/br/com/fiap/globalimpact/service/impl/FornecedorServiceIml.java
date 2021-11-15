package br.com.fiap.globalimpact.service.impl;

import br.com.fiap.globalimpact.model.Fornecedor;
import br.com.fiap.globalimpact.repository.FornecedorRepository;
import br.com.fiap.globalimpact.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorServiceIml implements FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Override
    public void create(Fornecedor fornecedor) {
        repository.save(fornecedor);

    }

    @Override
    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Fornecedor> remove(Long id) {
        Optional<Fornecedor> fornecedorOptional = repository.findById(id);
        Fornecedor fornecedor = fornecedorOptional.get();

        if (Optional.ofNullable(fornecedor).isPresent()) {
            repository.delete(fornecedor);
        }

        List<Fornecedor> fornecedores = findAll();

        return fornecedores;
    }

    @Override
    public Optional<Fornecedor> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Fornecedor> findByNome(String nome) {
        return repository.findByNomeContaining(nome);
    }
}
