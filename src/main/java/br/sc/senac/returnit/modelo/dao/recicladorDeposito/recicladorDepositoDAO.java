package br.sc.senac.returnit.modelo.dao.recicladorDeposito;

import java.util.List;

import br.sc.senac.returnit.modelo.entidade.RecicladorDeposito.RecicladorDeposito;

public interface recicladorDepositoDAO {

	public void inserirRecicladorDeposito(RecicladorDeposito recicladorDeposito);

	public void deletarRecicladorDeposito(RecicladorDeposito recicladorDeposito);
	
	List<RecicladorDeposito> recuperarDepositosRealizados();

	
}
