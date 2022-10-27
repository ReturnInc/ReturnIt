package Principal;

public class Cooperado {

	private int ID;
	private String cnpj;
	private String nomeFantasia;
	private Endereço Endereço;
	
	private Cooperado(int iD, String cnpj, String nomeFantasia, Principal.Endereço endereço) {
	
		ID = iD;
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		Endereço = endereço;
	}

	public long getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Endereço getEndereço() {
		return Endereço;
	}

	public void setEndereço(Endereço endereço) {
		Endereço = endereço;
	}
	
}
