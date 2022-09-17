package com.example.newton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newton.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
