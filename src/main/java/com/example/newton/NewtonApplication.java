package com.example.newton;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.newton.domain.Chamado;
import com.example.newton.domain.Cliente;
import com.example.newton.domain.Tecnico;
import com.example.newton.domain.enums.Perfil;
import com.example.newton.domain.enums.Prioridade;
import com.example.newton.domain.enums.Status;
import com.example.newton.repositories.ChamadoRepository;
import com.example.newton.repositories.ClienteRepository;
import com.example.newton.repositories.TecnicoRepository;

@SpringBootApplication
public class NewtonApplication implements CommandLineRunner{

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(NewtonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico tec1 = new Tecnico(null, "Vinicius Lopes", "57537395047", "viniciusg10@hotmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Carvalho", "36619627013", "betinho12@hotmail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
