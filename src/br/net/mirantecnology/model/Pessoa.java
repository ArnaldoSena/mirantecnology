package br.net.mirantecnology.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Pessoa {

		@NotNull
		@Size(min = 2, max = 100)
		@Column(nullable=false)
	private String nome = "";

		@NotNull
		@Column(nullable=false, name = "dt_cadastro")
		@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

		@NotNull
		@Column(nullable=false)
	private TipoPessoa tipoPessoa;
		@OneToMany(cascade = CascadeType.ALL)
		@Column(nullable=true)
	private List<Telefone> telefones;
	
	public Pessoa(@NotNull @Size(min = 2, max = 100) String nome,
				@NotNull TipoPessoa tipoPessoa, List<Telefone> telefones) {
			super();
			this.nome = nome;
			this.dataCadastro = new Date();
			this.tipoPessoa = tipoPessoa;
			this.telefones = telefones;
		}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

}
