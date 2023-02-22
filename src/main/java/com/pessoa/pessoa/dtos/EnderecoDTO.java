package com.pessoa.pessoa.dtos;

import java.io.Serializable;

import com.pessoa.pessoa.entity.Endereco;

public class EnderecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;

	public EnderecoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnderecoDTO(Endereco obj) {
		super();
		this.id = obj.getId();
		this.logradouro = obj.getLogradouro();
		this.cep = obj.getCep();
		this.numero = obj.getNumero();
		this.cidade = obj.getCidade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
