package br.com.tio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tio.domain.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Integer> {

}
