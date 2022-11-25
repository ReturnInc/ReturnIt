package br.sc.senac.returnit.modelo.entidade.cooperado;

import br.sc.senac.returnit.modelo.entidade.contato.Contato;
import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;
import br.sc.senac.returnit.modelo.entidade.usuario.Usuario;

public class Cooperado extends Usuario {

private String cnpj_cooperado;

public Cooperado() 
{
	super();
	}

public Cooperado(long idUsuario, String nome, Endereco endereco, Contato contato, String senha, String cnpj_cooperado) {
	super(idUsuario, nome, endereco, contato, senha);
	this.cnpj_cooperado = cnpj_cooperado;
}

public String getCnpj_cooperado() {
	return cnpj_cooperado;
}

public void setCnpj_cooperado(String cnpj_cooperado) {
	this.cnpj_cooperado = cnpj_cooperado;
}

	
	
}
