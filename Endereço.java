package Principal;

public class Endereço {

	private Short numero;
	private	String logradouro;
	private	String complemento;
	
	private Endereço(Short numero, String logradouro, String complemento) {
	
		setNumero(numero);
		setLogradouro(logradouro);
		setComplemento(complemento);
	}

	public Short getNumero() {
		return numero;
	}

	public void setNumero(Short numero) {
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
