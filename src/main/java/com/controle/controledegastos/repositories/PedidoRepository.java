package com.controle.controledegastos.repositories;

import com.controle.controledegastos.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Serializable> {
}
