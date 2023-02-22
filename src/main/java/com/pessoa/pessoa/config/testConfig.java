package com.pessoa.pessoa.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pessoa.pessoa.entity.Endereco;
import com.pessoa.pessoa.entity.Pessoa;
import com.pessoa.pessoa.service.repository.EnderecoRepository;
import com.pessoa.pessoa.service.repository.PessoaRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Pessoa p1 = new Pessoa(null, "Anderson", LocalDate.of(1982, 6, 25), null);
		Pessoa p2 = new Pessoa(null, "Livia", LocalDate.of(2017, 8, 3), null);
		Pessoa p3 = new Pessoa(null, "Eliedna", LocalDate.of(1987, 12, 19), null);

		Endereco e1 = new Endereco(null, "Rua 26 - Jardim Paulista Baixo", "53409700", "3", "Paulista", p1);
		Endereco e2 = new Endereco(null, "Rua 39 - Casa Caiada", "54000000", "6", "Olinda", p1);
		Endereco e3 = new Endereco(null, "Rua 42 - Boa Vista", "55000000", "3", "Recife", p2);
		Endereco e4 = new Endereco(null, "Rua 42 - Centro Igarassu", "59000000", "9", "Igarassu", p3);

		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
	}

}
