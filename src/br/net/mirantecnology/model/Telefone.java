package br.net.mirantecnology.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_telefone")
public class Telefone {

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
@NotNull
@Size(min = 8, max = 10)
@Column(nullable = false )
	private String ddd ="000";
@NotNull
@Size(min = 8, max = 10)
@Column(nullable = false )
	private String numero = null;
@NotNull
@Column(nullable = false)
	private Tipo tipo;
@NotNull
@Column(name = "dt_cadastro")
@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro = new Date();
	
	
	public Telefone(@Min(3) String ddd, @NotNull @Size(min = 8, max = 10) String numero, Tipo tipo) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
	}
	
	//gets and setters
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
