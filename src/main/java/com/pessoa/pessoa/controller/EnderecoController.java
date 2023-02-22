package com.pessoa.pessoa.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pessoa.pessoa.dtos.EnderecoDTO;
import com.pessoa.pessoa.entity.Endereco;
import com.pessoa.pessoa.service.EnderecoService;

@Controller
@Transactional
@RequestMapping(value = "enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService service;

//	@GetMapping
//	public ResponseEntity<List<Endereco>> findAll() {
//		List<Endereco> list = enderecoService.findAll();
//		List<EnderecoDTO> listDTO = list.stream().map(obj -> new EnderecoDTO(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(list);
//	}

	@GetMapping(value = "/todos")
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> findAll(@RequestParam(value = "pessoa", defaultValue = "0") Long id_end) {
		List<Endereco> list = service.findAll(id_end);
		List<EnderecoDTO> listDto = list.stream().map(obj -> new EnderecoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id) {
		Endereco obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@PostMapping
	public ResponseEntity<Endereco> insert(@RequestBody Endereco obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
