
public class Coleta {

	public Coleta(Empresa empresa, Colaborador colaborador, Retornavel retornavel, Agendamento agendamento) {
		super();
		this.empresa = empresa;
		this.colaborador = colaborador;
		this.retornavel = retornavel;
		this.agendamento = agendamento;
	}
	private Empresa empresa;
	private Colaborador colaborador;
	private Retornavel retornavel;
	private Agendamento agendamento;
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	public Retornavel getRetornavel() {
		return retornavel;
	}
	public void setRetornavel(Retornavel retornavel) {
		this.retornavel = retornavel;
	}
	public Agendamento getAgendamento() {
		return agendamento;
	}
	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	
}
