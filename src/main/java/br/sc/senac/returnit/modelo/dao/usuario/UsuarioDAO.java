package br.sc.senac.returnit.modelo.dao.usuario;



import java.util.List;

import br.sc.senac.returnit.entidade.usuario.Usuario;

	public interface UsuarioDAO {
	    void inserirUsuario(Usuario usuario);

	    void deletarUsuario(Usuario usuario);

	    void atualizarNomeUsuario(Usuario usuario, String novoNome);

	    void atualizarCpfUsuario(Usuario usuario, String novoCpfUsuario);
	    
	    void atualizarGeneroUsuario(Usuario usuario, String novoGenero);

	    void atualizarEnderecoUsuario(Usuario usuario, String novoEndereco);


	    List<Usuario> recuperarUsuarios();

	    List<Usuario> recuperarDepositosRealizados();
	    
	    List<Usuario> recuperarDepositosRealizadosPeriodo();
	    
	    
}
