package br.sc.senac.returnit.modelo.entidade.usuario;
import br.sc.senac.returnit.modelo.entidade.contato.*;
import br.sc.senac.returnit.modelo.entidade.endereco.*;

public class Usuario {

	private long idUsuario;
	private String nomeUsuario;
	private Endereco endereco;
	private Contato contato;
	private String senha;
	
	public Usuario() {

	}
	
	public Usuario(long idUsuario, String nome, Endereco endereco, Contato contato, String senha) {
		this.idUsuario = idUsuario;
		this.nomeUsuario = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.senha = senha;
	}
	
	

	public long getId() {
		return idUsuario;
	}
	public void setId(long id) {
		this.idUsuario = id;
	}
	public String getNome() {
		return nomeUsuario;
	}
	public void setNome(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco novoEndereco) {
		this.endereco = novoEndereco;
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
