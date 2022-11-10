
public class Endereco {

	public Endereco(short numero, String logradouro, String complemento) {
		super();
		this.numero = numero;
		this.logradouro = logradouro;
		this.complemento = complemento;
	}
	private short numero;
	private String logradouro;
	private String complemento;
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
	
	
}
