public class Retornável {

	private String marca;
	private String modelo;
	private Empresa empresa;
	private String material;
	private int ponto;
	private float preço;

	private Retornável(String marca, String modelo, String material, int ponto, float preço) {
		setMarca(marca);
		setMaterial(material);
		setPonto(ponto);
		setPreço(preço);
		setModelo(modelo);
	}

	private Retornável() {
	}

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

	public float getPreço() {
		return preço;
	}

	public void setPreço(float preço) {
		this.preço = preço;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
