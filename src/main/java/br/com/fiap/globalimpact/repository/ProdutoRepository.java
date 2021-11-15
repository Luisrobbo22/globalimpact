package br.com.fiap.globalimpact.repository;

import br.com.fiap.globalimpact.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
