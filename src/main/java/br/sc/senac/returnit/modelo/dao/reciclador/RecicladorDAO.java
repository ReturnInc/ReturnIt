package br.sc.senac.returnit.modelo.dao.reciclador;

import br.sc.senac.returnit.modelo.entidade.reciclador.Reciclador;

public interface RecicladorDAO {
	
	void inserirReciclador(Reciclador reciclador);
	
	void deletarReciclador(Reciclador reciclador);
	
	void atualizarCpfReciclador(Reciclador reciclador, String novoCpfReciclador);
	
	void atualizarGenero(Reciclador reciclador, String novoGenero);
	
	void atualizarIdUsuario(Reciclador reciclador, long novoIdUsuario);
}