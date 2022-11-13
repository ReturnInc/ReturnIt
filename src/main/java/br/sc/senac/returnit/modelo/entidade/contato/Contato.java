package br.sc.senac.returnit.modelo.entidade.contato;
public class Contato {

	public Contato(long idContato,String telefoneContato , String emailContato) {
		super();
		this.idContato = idContato;
		this.telefoneContato = telefoneContato;
		this.emailContato = emailContato;
	}
	private long idContato;
	private String telefoneContato;
	private String emailContato;
	public String getTelefoneContato() {
		return telefoneContato;
	}
	public void setTelefoneContato(String novoTelefoneContato) {
		this.telefoneContato = novoTelefoneContato;
	}
	public String getEmail() {
		return emailContato;
	}
	public void setEmail(String novoEmailContato) {
		this.emailContato = novoEmailContato;
	}
	public long getIdContato() {
		return idContato;
	}
	public void setIdContato(long novoIdContato) {
		this.idContato = novoIdContato;
	}
	
}
