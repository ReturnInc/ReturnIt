package br.sc.senac.returnit.test.modelo.usuario;

import java.util.List;

import br.sc.senac.returnit.modelo.dao.usuario.UsuarioDAOImpl;
import br.sc.senac.returnit.modelo.entidade.usuario.*;
import br.sc.senac.returnit.modelo.entidade.contato.*;
import br.sc.senac.returnit.modelo.entidade.endereco.*;

public class TestUsuario {
	public static void main(String [] args) {
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
	
		
		
		
		
		
		
	}
	public static void testInsert(UsuarioDAOImpl usuarioDAO, Usuario usuario){
		usuarioDAO.inserirUsuario(usuario);
	}
	public static void testAtualizarContatoUsuario(UsuarioDAOImpl usuarioDAO) {
		usuarioDAO.atualizarContatoUsuario(null, 0);
	}
	public static void testAtualizarEnderecoUsuario(UsuarioDAOImpl usuarioDAO) {
		usuarioDAO.atualizarEnderecoUsuario(null, 0);
	}
	public static void testAtualizarNomeUsuario(UsuarioDAOImpl usuarioDAO) {
		usuarioDAO.atualizarNomeUsuario(null, null);
	}
	public static void testAtualizarSenhaUsuario(UsuarioDAOImpl usuarioDAO) {
		usuarioDAO.atualizarSenhaUsuario(null, null);
	}
	public static List<Usuario> testRecuperarUsuarios(UsuarioDAOImpl usuarioDAO) {
		return usuarioDAO.recuperarUsuarios();
	}
	public static Usuario testRecuperarNomeUsuario(UsuarioDAOImpl usuarioDAO) {
		return usuarioDAO.recuperarNomeUsuarios(null);
	}
	public static Usuario testRecuperarIdUsuario(UsuarioDAOImpl usuarioDAO, long idUsuario) {
		return usuarioDAO.recuperarIdUsuario(idUsuario);
	}
	public static void testDeletarUsuario(UsuarioDAOImpl usuarioDAO) {
		usuarioDAO.deletarUsuario(null);
	}
	public static boolean primeiraRota (UsuarioDAOImpl usuarioDAO) {
		//primeiraRota(); 
		//Recebe a seguinte entrada: 
		//Uma intancia da Classe UsuarioDAOImpl
		Endereco endereco = new Endereco((long) 1213215,(short) 230, "Rua XV de novembro", "casa");
		// Intanciando a Classe Endereco que é um atributo do Usuario  
		Contato contato = new Contato((long) 1545454,"(47) 992503339","kronergamer@gmail.com" );
		// Intanciando a Classe Contato que é um atributo do Usuario  
		Usuario usuario = new Usuario((long) 12132131, "Paulo", endereco, contato, "1492");
		//Intanciando a Classe Usuario  
		testInsert(usuarioDAO, usuario);
		//Realizando Inserção ira retornar o Erro SQL caso Erro
		Usuario retorno = testRecuperarIdUsuario(usuarioDAO,(long) 12132131);
		// Erro Esperdo pois Endereco e Contato não foram salvos no Banco o que gera um erro pois ele está null 
		if (usuario.equals(retorno)) { 
			// Ao comparar a Original com a Recuparada do bancoo Erro esperado é que não vai ser igual retorna false
			return true;
		}
		return false;
	}

}
