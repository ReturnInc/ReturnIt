package br.sc.senac.returnit.modelo.dao.deposito;

import java.util.List;
import java.util.Date;

import br.sc.senac.returnit.modelo.entidade.deposito.*;

public interface DepositoDAO {
	void inserirDeposito(Deposito deposito);

    void deletarDeposito(Deposito deposito);
    
    void atualizarDataDeposito(Deposito deposito, Date novaDataDeposito);

    void atualizarQuantidadeDeposito(Deposito deposito, int novaQuantidadeDeposito);

    void atualizarRetornavelDeposito(Deposito deposito, long novoRetornavelDeposito);


    List<Deposito> recuperarDepositos();
    
    List<Deposito> recuperarDepositoPeriodo(Date dataInicio, Date dataFim);
    
    List<Deposito> recuperarDepositoData(Date dataDeposito);
    
    List<Deposito> recuperarDepositoDataAtual();

    Deposito recuperarDepositoId(long idDeposito);

}
