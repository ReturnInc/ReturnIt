package br.sc.senac.returnit.modelo.entidade.endereco;

public class Endereco {

	private long idEndereco;
	private short numero;
	private String logradouro;
	private String complemento;
	private String bairro;
	public Endereco() {
	}

	public Endereco(String bairro,long idEndereco, short numero, String logradouro, String complemento) {
		super();
		this.bairro = bairro;
		this.idEndereco = idEndereco;
		this.numero = numero;
		this.logradouro = logradouro;
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(long novoIdEndereco) {
		this.idEndereco = novoIdEndereco;
	}

}
