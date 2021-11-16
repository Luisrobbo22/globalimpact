package br.com.fiap.globalimpact.service.impl;

import br.com.fiap.globalimpact.model.Produto;
import br.com.fiap.globalimpact.repository.ProdutoRepository;
import br.com.fiap.globalimpact.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public void create(Produto produto) {
        repository.save(produto);
    }

    @Override
    public List<Produto> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Produto> remove(Long id) {
        Optional<Produto> optionalProduto = repository.findById(id);
        Produto produto = optionalProduto.get();

        if (Optional.ofNullable(produto).isPresent()) {
            repository.delete(produto);
        }

        List<Produto> produtos = repository.findAll();
        return produtos;
    }

    public Produto findByNome(String descricaoResumida) {
        return repository.findByDescricaoResumidaContaining(descricaoResumida);
    }
}
