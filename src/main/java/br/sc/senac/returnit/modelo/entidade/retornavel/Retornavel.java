package br.sc.senac.returnit.modelo.entidade.retornavel;
import br.sc.senac.returnit.modelo.entidade.empresa.Empresa;

public class Retornavel {

	public Retornavel()
	{}
	
	public Retornavel(long idRetornavel, String material, String marca, String modelo, String cnpjEmpresa) {
		this.idRetornavel = idRetornavel;
		this.material = material;
		this.marca = marca;
		this.modelo = modelo;
		this.cnpjEmpresa = cnpjEmpresa;
		
	}
	private long idRetornavel;
	private String material;
	private String marca;
	private String modelo;
	private String cnpjEmpresa;
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
	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.cnpjEmpresa = empresa.getCnpj();
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public long getIdRetornavel() {
		return idRetornavel;
	}
	public void setIdRetornavel(long l) {
		this.idRetornavel = l;
	}	
}
