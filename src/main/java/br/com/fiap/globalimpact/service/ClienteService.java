package br.com.fiap.globalimpact.service;

import br.com.fiap.globalimpact.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    void create(Cliente cliente);

    List<Cliente> findAll();

    List<Cliente> remove(Long id);

}
