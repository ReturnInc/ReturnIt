package br.sc.senac.returnit.modelo.entidade.empresa;


public class Empresa {
	private long id;
	private String cnpj;

	public Empresa() {
		 
	}
	
	public Empresa(long id,String cnpj) {
		super();
		this.id= id;
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
