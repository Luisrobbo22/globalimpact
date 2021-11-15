package br.com.fiap.globalimpact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = -5680914019810165998L;

    @Id
    private Long codigo;

    private String descricao;

    private String descricaoResumida;

    private String tipoProduto;

    private String unidadeMedida;

    @ManyToMany
    @JoinTable(name = "codigo",
            joinColumns = @JoinColumn(name = "codigo_produto"),
            inverseJoinColumns = @JoinColumn(name = "codigo_fornecedor"))
    private List<Fornecedor> fornecedores;

    @ManyToMany(mappedBy = "produtos")
    private List<Cliente> clientes;
}
