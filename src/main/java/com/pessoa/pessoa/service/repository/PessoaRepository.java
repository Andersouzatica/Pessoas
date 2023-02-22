package com.pessoa.pessoa.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pessoa.pessoa.entity.Pessoa;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
