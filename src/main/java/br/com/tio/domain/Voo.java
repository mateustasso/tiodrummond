package br.com.tio.domain;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="voo")

public class Voo {
	
	@Id
	@Column(name="codigovoo")
	private Integer codigovoo;
	@Column(name="classe")
	private String classe;
	@Column(name="poltrona")
	private String poltrona;
	
	public Voo() {

		

	}

	

	public int getcdgVoo() {

		return codigovoo;

	}

	public void setcdgVoo(int codigovoo) {

		this.codigovoo = codigovoo;

	}

	public String getClasse() {

		return classe;

	}

	public void setClasse(String classe) {

		this.classe = classe;

	}

	public String getPoltrona() {

		return poltrona;

	}

	public void setPoltrona(String poltrona) {

		this.poltrona = poltrona;

	}
	


}
