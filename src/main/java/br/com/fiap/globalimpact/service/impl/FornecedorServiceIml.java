package br.com.fiap.globalimpact.service.impl;

import br.com.fiap.globalimpact.model.Fornecedor;
import br.com.fiap.globalimpact.model.Produto;
import br.com.fiap.globalimpact.repository.FornecedorRepository;
import br.com.fiap.globalimpact.service.FornecedorService;
import br.com.fiap.globalimpact.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorServiceIml implements FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public void create(Fornecedor fornecedor) {
        Produto produto = null;
        if (hasProduto(fornecedor.getProdutos())) {
            produto = fornecedor.getProdutos();
            produtoService.create(produto);
            produto = produtoService.findByNome(fornecedor.getProdutos().getDescricaoResumida());
            fornecedor.getProdutos().setCodigo(produto.getCodigo());
        } else {
            fornecedor.setProdutos(null);
        }

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

    private boolean hasProduto(Produto produto) {
        if (produto.getDescricaoResumida().equals("") &&
            produto.getDescricao().equals("")) {
            return false;
        }
        return true;
    }
}
