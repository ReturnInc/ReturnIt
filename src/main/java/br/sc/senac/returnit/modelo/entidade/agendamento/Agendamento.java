package br.sc.senac.returnit.entidade.agendamento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Colaborador;
import Empresa;
import Endereco;
import Retornavel;

public class Agendamento {
	private long id;
	private LocalDateTime data;
	private Endereco local;
	private Colaborador colaborador;
	private Empresa empresa;
	private List<Retornavel> retornaveis = new ArrayList<Retornavel>();

	public LocalDateTime getData() {
		return data;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Agendamento(long id, LocalDateTime data, Endereco local, Colaborador colaborador, Empresa empresa) {
		super();
		this.id = id;
		this.data = data;
		this.local = local;
		this.colaborador = colaborador;
		this.empresa = empresa;
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
