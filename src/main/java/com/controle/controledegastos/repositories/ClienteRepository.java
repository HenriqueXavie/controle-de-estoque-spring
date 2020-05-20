package com.controle.controledegastos.repositories;

import com.controle.controledegastos.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Serializable> {
}
