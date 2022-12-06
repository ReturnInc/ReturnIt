package br.sc.senac.returnit.modelo.entidade.empresa;

import br.sc.senac.returnit.modelo.entidade.contato.Contato;
import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;
import br.sc.senac.returnit.modelo.entidade.usuario.*;

public class Empresa extends Usuario {
	private long id;
	private String cnpj;
	
	public Empresa(long id, long idUsuario, String nome,  Endereco endereco, Contato contato, String cnpj, String senha) {
		super(idUsuario, nome,  endereco, contato, senha);
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
	public Boolean checkSenha(String senha) {
			return senha == this.getSenha();
	}
}
