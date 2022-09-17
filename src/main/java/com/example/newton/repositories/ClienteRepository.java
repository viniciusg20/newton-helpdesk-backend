package com.example.newton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newton.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
