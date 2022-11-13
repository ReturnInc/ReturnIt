package br.sc.senac.returnit.modelo.dao.contato;

import java.util.List;

import br.sc.senac.returnit.modelo.entidade.contato.Contato;

public interface ContatoDAO {
	   
		void inserirContato(Contato contato);

	    void deletarContato(Contato contato);

	    void atualizarIdContato(Contato contato, long novoidContato);
	    
	    void atualizarTelefoneContato(Contato contato, String novotelefoneContato);

	    void atualizarEmail(Contato contato, String novoEmailContato);


	    List<Contato> recuperarContato();

	    Contato recuperarContatoId(long idContato);
	   
}
