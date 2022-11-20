package br.sc.senac.returnit.modelo.entidade.deposito; 

import java.sql.Date;


import br.sc.senac.returnit.modelo.entidade.retornavel.Retornavel;


public class Deposito {
	
	private long idDeposito;
	private Date dataDeposito;
	private int quantidadeDeposito;
	private Retornavel retornavelDeposito;
	

	public Deposito(long idDeposito, Date dataDeposito, int quantidadeDeposito, Retornavel retornavelDeposito) {
		super();
		this.idDeposito = idDeposito;
		this.dataDeposito = dataDeposito;
		this.quantidadeDeposito = quantidadeDeposito;
		this.retornavelDeposito = retornavelDeposito;
	}
	
	public Deposito() {
		// TODO Auto-generated constructor stub
	}

	public long getIdDeposito() {
		return idDeposito;
	}
	public void setIdDeposito(long novoIdDeposito) {
		this.idDeposito = novoIdDeposito;
	}
	public Date getDataDeposito() {
		return dataDeposito;
	}
	public void setDataDeposito(Date novaDataDeposito) {
		this.dataDeposito = novaDataDeposito;
	}
	public int getQuantidadeDeposito() {
		return quantidadeDeposito;
	}
	public void setQuantidadeDeposito(int novaQuantidadeDeposito) {
		this.quantidadeDeposito = novaQuantidadeDeposito;
	}
	public Retornavel getRetornavelDeposito() {
		return retornavelDeposito;
	}
	public void setRetornavelDeposito(Retornavel novoRetornavelDeposito) {
		this.retornavelDeposito = novoRetornavelDeposito;
	}
	

}
