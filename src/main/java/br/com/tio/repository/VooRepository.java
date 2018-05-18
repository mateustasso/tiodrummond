package br.com.tio.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tio.domain.Voo;

public interface VooRepository extends JpaRepository<Voo, Integer> {

}
