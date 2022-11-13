package br.sc.senac.returnit.modelo.entidade.usuario;
import br.sc.senac.returnit.modelo.entidade.contato.*;
import br.sc.senac.returnit.modelo.entidade.endereco.*;

public abstract class Usuario {

	private long id;
	private String nome;
	private Endereco endereco;
	private Contato contato;
	private String senha;
	
	
	
	public Usuario(long id, String nome, Endereco endereco, Contato contato, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.senha = senha;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getEndereco() {
		return endereco.getIdEndereco();
	}
	public void setEndereco(Endereco novoEndereco) {
		this.endereco = novoEndereco;
	}
	public long getContato() {
		return contato.getIdContato();
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
