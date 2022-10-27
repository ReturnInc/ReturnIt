import java.util.List;

public class Empresa {

	private long ID;
	private String cpnj;
	private String marca;
	private Endereço Endereço;
	private List<Retornável> retornáveis;

	public Empresa(long id, String cnpj, String marca, Endereço Endereço, List<Retornável> retornáveis) {
		setID(id);
		setCpnj(cnpj);
		setMarca(marca);
		setEndereço(Endereço);
		setRetornáveis(retornáveis);
	}

	private Empresa() {
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getCpnj() {
		return cpnj;
	}

	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}

	public String getMarca() {
		return marca;
	} 

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Endereço getEndereço() {
		return Endereço;
	}

	public void setEndereço(Endereço endereço) {
		Endereço = endereço;
	}

	public List<Retornável> getRetornáveis() {
		return retornáveis;
	}

	public void setRetornáveis(List<Retornável> retornáveis) {
		this.retornáveis = retornáveis;
	}

	public boolean addRetornável(Retornável Retornável) {
		return retornáveis.add(Retornável);
	}

	public boolean removeRetornável(Retornável Retornável) {
		return retornáveis.remove(Retornável);
	}
}