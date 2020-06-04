package com.controle.controledegastos.services;

import com.controle.controledegastos.domain.Cliente;
import com.controle.controledegastos.repositories.ClienteRepository;
import com.controle.controledegastos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id) {
        Optional<Cliente> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + ", tipo: " + Cliente.class.getName()));
    }


}
