package br.net.mirantecnology.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity(name="Juridica")
@Table(name="tb_pessoa_juridica")
public class Juridica extends Pessoa implements Serializable {

	
	private static final long serialVersionUID = 1L;

		@Id
		@Column(name = "id_pessoa_juridica")
		@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		@NotNull
		@Column(nullable = false)
	private String cnpj;
		
	
			
	public Juridica(@NotNull @Size(min = 2, max = 100) String nome, @NotNull TipoPessoa tipoPessoa,
				List<Telefone> telefones, @NotNull String cnpj) {
			super(nome, tipoPessoa, telefones);
			this.cnpj = cnpj;
		}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
