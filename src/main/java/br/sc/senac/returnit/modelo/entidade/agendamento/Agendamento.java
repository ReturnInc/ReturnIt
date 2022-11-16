package br.sc.senac.returnit.modelo.entidade.agendamento;

import java.util.Date;



public class Agendamento {
	
	private long idAgendamento;
	private boolean realizadoAgendamento;
	private Date dataAgendamento;
	private long idEmpresa;
	private long idCooperado;
	
	
	public Agendamento(long idAgendamento, boolean realizadoAgendamento, Date dataAgendamento, long idEmpresa, long idCooperado) {
		super();
		this.idAgendamento = idAgendamento;
		this.realizadoAgendamento = realizadoAgendamento;
		this.dataAgendamento = dataAgendamento;
		this.idEmpresa = idEmpresa;
		this.idCooperado = idCooperado;
	}
	
	public long getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(long id) {
		this.idAgendamento = id;
	}
	public boolean getRealizadoAgendamento() {
		return realizadoAgendamento;
	}

	public void setRealizadoAgendamento(boolean realizadoAgendamento) {
		this.realizadoAgendamento = realizadoAgendamento;
	}
	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Date novaDataAgendamento) {
		this.dataAgendamento = novaDataAgendamento;
	}
	public long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(long novoIdEmpresa) {
		this.idEmpresa = novoIdEmpresa;
	}

	public long getIdCooperado() {
		return idCooperado;
	}

	public void setIdCooperado(long novoIdCooperado) {
		this.idCooperado = novoIdCooperado;
	}
}
