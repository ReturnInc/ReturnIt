package br.sc.senac.returnit.modelo.entidade.empresa;
import br.sc.senac.returnit.modelo.entidade.usuario.*;


public class Empresa {

	public Empresa(String cnpj, Usuario usuario) {
		super();
		this.cnpj = cnpj;
		this.usuario = usuario;
	}
	private long id;
	private String cnpj;
	private Usuario usuario;
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
	public long getUsuario() {
		
		return usuario.getId();
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
