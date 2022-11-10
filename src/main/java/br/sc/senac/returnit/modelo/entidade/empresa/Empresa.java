
public class Empresa {

	public Empresa(long id, String cnpj, String marca, Endereco endereco, Retornavel retornavel) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.marca = marca;
		this.endereco = endereco;
		this.retornavel = retornavel;
	}
	private long id;
	private String cnpj;
	private String marca;
	private Endereco endereco;
	private Retornavel retornavel;
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Retornavel getRetornavel() {
		return retornavel;
	}
	public void setRetornavel(Retornavel retornavel) {
		this.retornavel = retornavel;
	}
}
