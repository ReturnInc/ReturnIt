package br.sc.senac.returnit.entidade.usuario;
import Contato;
import Endereco;

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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Contato getContato() {
		return contato;
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
