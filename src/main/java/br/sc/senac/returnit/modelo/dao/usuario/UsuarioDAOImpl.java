package br.sc.senac.returnit.modelo.dao.usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.sc.senac.returnit.modelo.entidade.usuario.*;

public class UsuarioDAOImpl implements UsuarioDAO {
	public void inserirUsuario(Usuario usuario) {

	    Connection conexao = null;
	    PreparedStatement insert = null;

	    try {

	        conexao = conectarBanco();
	        insert = conexao.prepareStatement("INSERT INTO usuario (nome, senha, id_endereco, id_contato) VALUES (?,?,?,?)");
	        
	        insert.setString(1, usuario.getNome());
	        insert.setString(2,usuario.getSenha());
	        insert.setLong(3, usuario.getEndereco());
	        insert.setLong(4, usuario.getContato());

	        insert.execute();

	    } catch (SQLException erro) {
	        erro.printStackTrace();
	    }

	    finally {

	        try {

	            if (insert != null)
	                insert.close();

	            if (conexao != null)
	                conexao.close();

	        } catch (SQLException erro) {

	            erro.printStackTrace();
	        }
	    }
	}

	public void deletarUsuario(Usuario usuario) {
	    
	    Connection conexao = null;
	    PreparedStatement delete = null;

	    try {

	        conexao = conectarBanco();
	        delete = conexao.prepareStatement("DELETE FROM usuario WHERE id = ?");

	        delete.setLong(1, usuario.getId());

	        delete.execute();

	    } catch (SQLException erro) {
	        erro.printStackTrace();
	    }

	    finally {

	        try {

	            if (delete != null)
	                delete.close();

	            if (conexao != null)
	                conexao.close();

	        } catch (SQLException erro) {

	            erro.printStackTrace();
	        }
	    }
	}

	public void atualizarNomeUsuario(Usuario usuario, String novoNome) {
	    
	    Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET nome = ? WHERE id = ?");
	        
	        update.setString(1, novoNome);
	        update.setLong(2, usuario.getId());

	        update.execute();

	    } catch (SQLException erro) {
	        erro.printStackTrace();
	    }

	    finally {

	        try {

	            if (update != null)
	                update.close();

	            if (conexao != null)
	                conexao.close();

	        } catch (SQLException erro) {

	            erro.printStackTrace();
	        }
	    }
	}

	public void atualizarEnderecoUsuario(Usuario usuario, String novoEndereco) {
	    
	    Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET id_endereco = ? WHERE id = ?");
	        
	        update.setString(1, novoEndereco);
	        update.setLong(2, usuario.getId());

	        update.execute();

	    } catch (SQLException erro) {
	        erro.printStackTrace();
	    }

	    finally {

	        try {

	            if (update != null)
	                update.close();

	            if (conexao != null)
	                conexao.close();

	        } catch (SQLException erro) {

	            erro.printStackTrace();
	        }
	    }
	}

	public List<Usuario> recuperarUsuarios() {

	    Connection conexao = null;
	    Statement consulta = null;
	    ResultSet resultado = null;

	    List<Usuario> usuarios = new ArrayList<Usuario>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.createStatement();
	        resultado = consulta.executeQuery("SELECT * FROM usuario");

	        while (resultado.next()) {

	            long id = resultado.getLong("id");
	            String nome = resultado.getString("nome");
	            Endereco endereco = EnderecoDAOImp.recuperarEnderecoresultado.getlong("id_endereco"); 
	            Contato contato = ContatoDAOImp.recuperarContato.resultado.getLong("id_contato");
	            usuarios.add(new Usuario(id, nome, endereco, contato));
	            

	         
	        }

	    } catch (SQLException erro) {
	        erro.printStackTrace();
	    }

	    finally {

	        try {

	            if (resultado != null)
	                resultado.close();

	            if (consulta != null)
	                consulta.close();

	            if (conexao != null)
	                conexao.close();

	        } catch (SQLException erro) {

	            erro.printStackTrace();
	        }
	    }

	    return usuarios;
	}
	public List<Usuario> recuperarIdUsuarios() {

	    Connection conexao = null;
	    Statement consulta = null;
	    ResultSet resultado = null;

	    List<Usuario> usuarios = new ArrayList<Usuario>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.createStatement();
	        resultado = consulta.executeQuery("SELECT * FROM usuario");

	        while (resultado.next()) {

	            long id = resultado.getLong("id");
	            String nome = resultado.getString("nome");
	            Endereco endereco = EnderecoDAOImp.recuperarEnderecoresultado.getlong("id_endereco"); 
	            Contato contato = ContatoDAOImp.recuperarContato.resultado.getLong("id_contato");
	            usuarios.add(new Usuario(id, nome, endereco, contato));
	            

	         
	        }

	    } catch (SQLException erro) {
	        erro.printStackTrace();
	    }

	    finally {

	        try {

	            if (resultado != null)
	                resultado.close();

	            if (consulta != null)
	                consulta.close();

	            if (conexao != null)
	                conexao.close();

	        } catch (SQLException erro) {

	            erro.printStackTrace();
	        }
	    }

	    return usuarios;
	}




private Connection conectarBanco() throws SQLException {
	return DriverManager.getConnection("jdbc:mysql://localhost/returnit?user=root&password=root");
}

}
	