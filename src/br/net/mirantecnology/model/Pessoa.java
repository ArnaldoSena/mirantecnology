package br.net.mirantecnology.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Pessoa {

@Id
@Column(name = "id_pessoa")
@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	

@NotNull
@Size(min = 8, max = 10)
@Column(nullable=false)
	private String nome = "";

@NotNull
@Column(nullable=false, name = "dt_cadastro")
@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

@NotNull
@Column(nullable=false)
	private TipoPessoa tipoPessoa;
}
