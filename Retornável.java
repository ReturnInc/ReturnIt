package Principal;

public class Retornável {

	private Marca marca;
	private Modelo modelo;
	private String material;
	private int ponto;
	private float preço;
	private Empresa empresa;
	
	private Retornável (Marca marca, Modelo modelo, String material, int ponto, float preço) {
		this.marca = marca;
		this.modelo = modelo;
		this.material = material;
		this.ponto = ponto;
		this.preço = preço;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
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

	public boolean equals(Object objeto) {

		if (objeto == null)
			return false;
		
		if (this == objeto)
			return true;
		
		
		if (getClass() != objeto.getClass())
			return false;
		
		Retornável Retornável = (Retornável) objeto;
		return this.getMarca().equals(Retornável.getMarca()) && this.getModelo().equals(Retornável.getModelo()) && this.getMaterial().equals(Retornável.getMaterial()) && this.getPonto() == Retornável.getPonto() && this.getPreço() == (Retornável.getPreço());
	}
	
 

		
}
