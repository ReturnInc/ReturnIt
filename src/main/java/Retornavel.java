
public class Retornavel {

	public Retornavel(String marca, String modelo, Empresa empresa, String material, int ponto, int preco) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.empresa = empresa;
		this.material = material;
		this.ponto = ponto;
		this.preco = preco;
	}
	private String marca;
	private String modelo;
	private Empresa empresa;
	private String material;
	private int ponto;
	private int preco;
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getPonto() {
		return ponto;
	}
	public void setPonto(int ponto) {
		this.ponto = ponto;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	
}
