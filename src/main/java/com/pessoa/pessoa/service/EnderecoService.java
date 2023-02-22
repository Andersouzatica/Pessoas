package com.pessoa.pessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.pessoa.pessoa.entity.Endereco;
import com.pessoa.pessoa.exceptions.ResourceNotFoundException;
import com.pessoa.pessoa.service.repository.EnderecoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PessoaService pessoaService;

	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public Endereco findById(Long id) {
		Optional<Endereco> obj = enderecoRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Endereco insert(Endereco obj) {
		return enderecoRepository.save(obj);

	}

	public void delete(Long id) {
		try {
			enderecoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Endereco update(Long id, Endereco obj) {
		try {
			Endereco entity = enderecoRepository.getReferenceById(id);
			updateData(entity, obj);
			return enderecoRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Endereco entity, Endereco obj) {
		entity.setLogradouro(obj.getLogradouro());		
		entity.setCep(obj.getCep());
		entity.setNumero(obj.getNumero());
		entity.setCidade(obj.getCidade());

	}

	public List<Endereco> findAll(Long id_end) {
		pessoaService.findById(id_end);
		return enderecoRepository.findAllByEndereco(id_end);
	}
}
