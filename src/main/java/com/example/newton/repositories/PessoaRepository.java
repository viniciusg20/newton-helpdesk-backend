package com.example.newton.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newton.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	Optional<Pessoa>findByCpf(String Cpf);
	Optional<Pessoa>findByEmail(String Cpf);

}
