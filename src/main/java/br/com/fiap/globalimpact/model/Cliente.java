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
public class Cliente implements Serializable {
    private static final long serialVersionUID = 2196147149702990605L;

    @Id
    private Long codigo;

    private String nome;

    private String descricao;

    private String contato;

    private String status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "codigo",
        joinColumns = @JoinColumn(name = "codigo_cliente"),
        inverseJoinColumns = @JoinColumn(name = "codigo_produto"))
    private List<Produto> produtos;
}
