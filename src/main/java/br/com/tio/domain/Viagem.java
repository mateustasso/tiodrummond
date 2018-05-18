package br.com.tio.domain;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="viagem")

public class Viagem {

	

	@Id
	@Column(name="codigoviagem")
	private Integer codigoviagem;
	@Column(name="estado")
	private String estado;
	@Column(name="preco")
	private double preco;
	@Column(name="companhia")
	private String companhia;
	@Column(name="hora")
	private String hora;
	
	
	public Viagem() {

		

	}

	

	public int getcdgViagem() {

		return codigoviagem;

	}

	public void setcdgViagem(int codigoviagem) {

		this.codigoviagem = codigoviagem;

	}

	public String getEstado() {

		return estado;

	}

	public void setEstado(String estado) {

		this.estado = estado;

	}

	public double getPreco() {

		return preco;

	}

	public void setPreco(double preco) {

		this.preco = preco;

	}
	public String getCompanhia() {

		return companhia;

	}

	public void setCompanhia(String companhia) {

		this.companhia = companhia;

	}
	public String getHora() {

		return hora;

	}

	public void setHora(String hora) {

		this.hora = hora;

	}

	



}