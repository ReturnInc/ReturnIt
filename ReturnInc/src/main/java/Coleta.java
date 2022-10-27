public class Coleta {

	private Empresa empresa;
	private Cooperado cooperado;
	private Retornável retornável;
	private Agendamento Agendamento;

	private Coleta(Empresa empresa, Cooperado cooperado, Retornável retornável, Agendamento agendamento) {

		setEmpresa(empresa);
		setCooperado(cooperado);
		setRetornável(retornável);
		setAgendamento(agendamento);

	}

	private Coleta() {
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Cooperado getCooperado() {
		return cooperado;
	}

	public void setCooperado(Cooperado cooperado) {
		this.cooperado = cooperado;
	}

	public Retornável getRetornável() {
		return retornável;
	}

	public void setRetornável(Retornável retornável) {
		this.retornável = retornável;
	}

	public Agendamento getAgentamento() {
		return Agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		Agendamento = agendamento;
	}

}
