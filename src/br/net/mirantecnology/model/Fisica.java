package br.net.mirantecnology.model;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity(name = "Fisica")
@Table(name = "tb_pessoa_fisica")
public class Fisica extends Pessoa{
	
		@Id
		@Column(name = "id_pessoa_fisica")
		@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		@NotNull
		@Column(name="cpf", nullable=false)
	private String cpf;
		@NotNull
		@PastOrPresent
		@Column(name = "dt_aniversario")
		@Temporal(TemporalType.TIMESTAMP)
	private Date dtNiver;
		@NotNull
		@Size(max=50)
		@Column(name="nome_mae", nullable = false)
	private String nomeMae;
		@Size(max=50)
		@Column(name="nome_pai", nullable = true)
	private String nomePai;
		@NotNull
		@Column(name = "dt_cadastro")
		@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	
	public Fisica(@NotNull @Size(min = 3, max = 50) String nome,
			@NotNull TipoPessoa tipoPessoa, List<Telefone> telefones,
			@NotNull @Pattern(regexp = "[0-9] {11}") String cpf, @NotNull @PastOrPresent Date dtNiver,
			@NotNull @Size(max = 50) String nomeMae, @Size(max = 50) String nomePai) {
		super(nome, tipoPessoa, telefones);
		this.cpf = cpf;
		this.dtNiver = dtNiver;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
		dataCadastro = new Date();
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Optional<@PastOrPresent Date> getDtNiver() {
		return Optional.of(dtNiver);
	}
	public void setDtNiver(Date dtNiver) {
		this.dtNiver = dtNiver;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
