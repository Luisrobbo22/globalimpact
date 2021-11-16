package br.com.fiap.globalimpact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 3260812449027538479L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String descricao;

    private String tipoFornecedor;

    private String nome;

    private String contato;

    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produtos;

}
