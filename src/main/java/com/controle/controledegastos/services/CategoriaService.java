package com.controle.controledegastos.services;

import com.controle.controledegastos.domain.Categoria;
import com.controle.controledegastos.exceptions.ObjectNotFoundException;
import com.controle.controledegastos.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + ", tipo: " + Categoria.class.getName()));
    }


}
