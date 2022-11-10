package br.sc.senac.returnit.entidade.usuario;


public class Usuario {

	private Long id;
	private String nome;
	private String cpf;
	private String genero;
	private Long endereco;
	public Long getId() {
		return id;
	}
	public Usuario(Long id, String nome, String cpf, String genero, Long endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;	
		this.genero = genero;
		this.endereco = endereco;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Long getEndereco() {
		return endereco;
	}
	public void setEndereco(Long endereco) {
		this.endereco = endereco;
	}
}
