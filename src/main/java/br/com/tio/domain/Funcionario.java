package br.com.tio.domain;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="funcionario")

public class Funcionario {
	
	@Id
	@Column(name="codigofunc")
	private Integer codigofunc;
	@Column(name="nomefunc")
	private String nomefunc;
	@Column(name="cargo")
	private String cargo;
	@Column(name="admissao")
	private String admissao;
	
	
	public Funcionario() {

		

	}

	

	public int getcdgFuncionario() {

		return codigofunc;

	}

	public void setcdgFuncionario(int codigofunc) {

		this.codigofunc = codigofunc;

	}

	public String getNomefunc() {

		return nomefunc;

	}

	public void setNomefunc(String nomefunc) {

		this.nomefunc = nomefunc;

	}

	public String getCargo() {

		return cargo;

	}

	public void setCargo(String cargo) {

		this.cargo = cargo;

	}
	public String getAdmissao() {

		return admissao;

	}

	public void setAdmissao(String admissao) {

		this.admissao = admissao;

	}
	

	

}
