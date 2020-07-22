package com.controle.controledegastos.services;

import com.controle.controledegastos.domain.Categoria;
import com.controle.controledegastos.domain.Pedido;
import com.controle.controledegastos.repositories.CategoriaRepository;
import com.controle.controledegastos.repositories.PedidoRepository;
import com.controle.controledegastos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id) {
        Optional<Pedido> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + ", tipo: " + Categoria.class.getName()));
    }


}
