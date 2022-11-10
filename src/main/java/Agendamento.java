import java.time.LocalDateTime;

public class Agendamento {

	public Agendamento(LocalDateTime data, Endereco local, Colaborador colaborador, Empresa empresa) {
		super();
		this.data = data;
		this.local = local;
		this.colaborador = colaborador;
		this.empresa = empresa;
	}
	private LocalDateTime data;
	private Endereco local;
	private Colaborador colaborador;
	private Empresa empresa;
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Endereco getLocal() {
		return local;
	}
	public void setLocal(Endereco local) {
		this.local = local;
	}
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
