package br.com.tio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tio.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
