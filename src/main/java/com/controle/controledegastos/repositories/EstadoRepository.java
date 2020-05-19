package com.controle.controledegastos.repositories;

import com.controle.controledegastos.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Serializable> {
}
