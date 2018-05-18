package br.com.tio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tio.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}
