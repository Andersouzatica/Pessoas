package com.pessoa.pessoa.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pessoa.pessoa.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
//	@Query(nativeQuery = true, value = "select * from endereco e join tb_pessoa p on e.pessoa_id = p.id where e.pessoa_id = :id_end")
	@Query("SELECT obj FROM Endereco obj WHERE obj.pessoa.id = :id_end")
	List<Endereco> findAllByEndereco(@Param(value = "id_end") Long id_end);

}
