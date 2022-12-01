package br.sc.senac.returnit.modelo.dao.usuario;



import java.util.List;

import br.sc.senac.returnit.modelo.entidade.usuario.*;

	public interface UsuarioDAO {
	    void inserirUsuario(Usuario usuario);

	    void deletarUsuario(Usuario usuario);

	    void atualizarNomeUsuario(Usuario usuario, String novoNome);
	    
	    void atualizarSenhaUsuario(Usuario usuario, String novoSenha);

	    void atualizarContatoUsuario(Usuario usuario, long novoIdContato);

	    void atualizarEnderecoUsuario(Usuario usuario, long novoIdEndereco);


	    List<Usuario> recuperarUsuarios();
	    
	    Usuario recuperarIdUsuario(long IdUsuario);
	    
	    Usuario recuperarNome(String nomeUsuario);
}
