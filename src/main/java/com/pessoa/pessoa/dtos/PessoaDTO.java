package com.pessoa.pessoa.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.pessoa.pessoa.entity.Endereco;
import com.pessoa.pessoa.entity.Pessoa;

public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private LocalDate dataDeNascimento;
	private List<Endereco> enderecos;

	public PessoaDTO(Pessoa obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.dataDeNascimento = obj.getDataDeNascimento();
		this.enderecos = obj.getEnderecos();
	}

	public PessoaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
