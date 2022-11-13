package br.sc.senac.returnit.modelo.dao.contato;

import br.sc.senac.returnit.modelo.entidade.contato.Contato;

public interface ContatoDAO {
	   
		void inserirContato(Contato contato);

	    void deletarContato(Contato contato);
	    
	    void atualizarTelefoneContato(Contato contato, String novotelefoneContato);

	    void atualizarEmail(Contato contato, String novoEmailContato);

	    Contato recuperarContatoId(long idContato);
	   
}
