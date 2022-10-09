package com.example.newton.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.example.newton.domain.Cliente;
import com.example.newton.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteDTO implements Serializable{//Serializable para tráfico em rede
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//determinando aqui que o ID será chave primária definida automaticamente pelo BANCO
	protected Integer id;
	@NotNull(message = "O campo NOME é requerido!")
	protected String nome;
	
	@CPF
	@Column(unique = true)
	@NotNull(message = "O campo CPF é requerido!")
	protected String cpf;
	
	@Column(unique = true)
	@NotNull(message = "O campo EMAIL é requerido!")
	protected String email;
	@NotNull(message = "O campo SENHA é requerido!")
	protected String senha;
	
	@ElementCollection(fetch = FetchType.EAGER)//assegurando que a lista de perfils virá junto com o usuário
	@CollectionTable(name = "PERFILS")
	protected Set<Integer> perfils = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();

	protected Set<Integer> perfis = new HashSet<>();

	
	public ClienteDTO() {
		super();
		addPerfils(Perfil.CLIENTE);
	}
	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfils = obj.getPerfils().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfils() {
		return perfils.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfils(Perfil perfil) {
		this.perfils.add(perfil.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
	
	

}
