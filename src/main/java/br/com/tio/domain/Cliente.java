package br.com.tio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")

public class Cliente {
	

	@Id
	@Column(name="codigocliente")
	private Integer codigocliente;
	@Column(name="cpf")
	private double cpf;
	@Column(name="nome")
	private String nome;
	
	
	
	public Cliente() {

		

	}

	

	public int getcdgCliente() {

		return codigocliente;

	}

	public void setcdgCliente(int codigocliente) {

		this.codigocliente = codigocliente;

	}

	public double getCPF() {

		return cpf;

	}

	public void setCPF(double cpf) {

		this.cpf = cpf;

	}

	public String getNome() {

		return nome;

	}

	public void setNome(String nome) {

		this.nome = nome;

	}
	

	



}
