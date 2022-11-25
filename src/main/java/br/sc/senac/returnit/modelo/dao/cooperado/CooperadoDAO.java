package br.sc.senac.returnit.modelo.dao.cooperado;

import br.sc.senac.returnit.modelo.entidade.cooperado.Cooperado;

public interface CooperadoDAO {

void inserirCooperado(Cooperado cooperado);

void deletarCooperado(Cooperado cooperado);

void atualizarcnpj(String novoCnpj,Cooperado cooperado);


	

}
