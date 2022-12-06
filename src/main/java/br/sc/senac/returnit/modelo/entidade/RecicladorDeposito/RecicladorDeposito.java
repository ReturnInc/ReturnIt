package br.sc.senac.returnit.modelo.entidade.RecicladorDeposito;

public class RecicladorDeposito {

	private long idReciclador;
	private long idDeposito;
	public long getIdReciclador() {
		return idReciclador;
	}
	
	public RecicladorDeposito(long idReciclador, long idDeposito) {
		super();
		this.idReciclador = idReciclador;
		this.idDeposito = idDeposito;
	}
	
	public void setIdReciclador(long idReciclador) {
		this.idReciclador = idReciclador;
	}
	public long getIdDeposito() {
		return idDeposito;
	}
	public void setIdDeposito(long idDeposito) {
		this.idDeposito = idDeposito;
	}
	
}
