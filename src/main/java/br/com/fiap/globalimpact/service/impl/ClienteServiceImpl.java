package br.com.fiap.globalimpact.service.impl;

import br.com.fiap.globalimpact.model.Cliente;
import br.com.fiap.globalimpact.repository.ClienteRepository;
import br.com.fiap.globalimpact.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;


    @Override
    public void create(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = repository.findAll();
        return clientes;
    }

    @Override
    public List<Cliente> remove(Long id) {
        Optional<Cliente> clienteOptional = repository.findById(id);
        Cliente cliente = clienteOptional.get();

        if (Optional.ofNullable(cliente).isPresent()) {
            repository.delete(cliente);
        }

        List<Cliente> clientes = findAll();

        return clientes;
    }
}
