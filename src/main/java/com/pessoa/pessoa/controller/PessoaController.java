package com.pessoa.pessoa.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pessoa.pessoa.dtos.PessoaDTO;
import com.pessoa.pessoa.entity.Pessoa;
import com.pessoa.pessoa.service.PessoaService;

@Controller
@Transactional
@RequestMapping(value = "pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> list = service.findAll();
		List<PessoaDTO> listDTO = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}

//	@GetMapping(value = "/", produces = "application/Json")
//	public ResponseEntity<List<Pessoa>> pessoa() {
//		List<Pessoa> list = pessoaRepository.findAll();
//		return new ResponseEntity<List<Pessoa>>(list, HttpStatus.OK);
//	}

//	@GetMapping
//	public ResponseEntity<List<PessoaDTO>> findAll() {
//		List<Pessoa> list = service.findAll();
//		List<PessoaDTO> listDTO = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDTO);
//	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
		Pessoa obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

//	@PostMapping
//	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa obj) {
//		obj = service.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).body(obj);
//	}
	
	@PostMapping(value = "/", produces = "application/Json")
	public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa){
		
		for (int pos = 0; pos < pessoa.getEnderecos().size(); pos++) {
			pessoa.getEnderecos().get(pos).setPessoa(pessoa);
		}
		Pessoa pessoasalvo = service.insert(pessoa);
		return new ResponseEntity<Pessoa>(pessoasalvo,HttpStatus.OK);
			
	}
	

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
