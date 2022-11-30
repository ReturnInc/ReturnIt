package br.sc.senac.returnit.modelo.dao.cooperado;

import java.util.List;

import br.sc.senac.returnit.modelo.entidade.cooperado.Cooperado;

public interface CooperadoDAO {

void inserirCooperado(Cooperado cooperado);

void deletarCooperado(Cooperado cooperado);

void atualizarCnpj(String novoCnpj,Cooperado cooperado);


List<Cooperado> recuperarCooperados();

Cooperado recuperarCooperadoCnpj(String CooperadoCnpj);
	

}
