package br.com.fiap.globalimpact.service;


import br.com.fiap.globalimpact.model.Cliente;
import br.com.fiap.globalimpact.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProdutoService {

    void create(Produto produto);

    List<Produto> findAll();

    List<Produto> remove(Long id);

    Produto findByNome(String descricaoResumida);
}
