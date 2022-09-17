package com.example.newton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newton.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
