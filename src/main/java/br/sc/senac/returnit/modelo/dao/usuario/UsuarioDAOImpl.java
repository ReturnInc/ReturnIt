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
import br.sc.senac.returnit.modelo.dao.contato.ContatoDAOImp;
import br.sc.senac.returnit.modelo.dao.endereco.EnderecoDAOImp;
import br.sc.senac.returnit.modelo.entidade.contato.*;
import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;

public class UsuarioDAOImpl implements UsuarioDAO {
     public void inserirUsuario(Usuario usuario) {

	    Connection conexao = null;
	    PreparedStatement insert = null;

	    try {

	        conexao = conectarBanco();
	        insert = conexao.prepareStatement("INSERT INTO usuario (nome_usuario, senha_usuario, id_endereco, id_contato) VALUES (?,?,?,?)");
	        
	        insert.setString(1, usuario.getNome());
	        insert.setString(2,usuario.getSenha());
	        
	        Endereco endereco = usuario.getEndereco();
	        insert.setLong(3, endereco.getIdEndereco());
	        
	        Contato contato = usuario.getContato();
	        insert.setLong(4, contato.getIdContato());

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
	    ContatoDAOImp contatoDAO = new ContatoDAOImp();
	    EnderecoDAOImp enderecoDAO = new EnderecoDAOImp();

	    try {

	        conexao = conectarBanco();
	        delete = conexao.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");

	        delete.setLong(1, usuario.getId());

	        delete.execute();
	        contatoDAO.deletarContato(usuario.getContato());
	        enderecoDAO.deletarEndereco(usuario.getEndereco());

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
	        update = conexao.prepareStatement("UPDATE usuario SET nome_usuario = ? WHERE id_usuario = ?");
	        
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
public void atualizarContatoUsuario(Usuario usuario, long novoIdContato) {
	   	Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET id_contato = ? WHERE id_usuario = ?");
	        
	        update.setLong(1, novoIdContato);
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
	

public void atualizarEnderecoUsuario(Usuario usuario, long novoIdEndereco) {
	    Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET id_endereco = ? WHERE id_usuario = ?");
	        
	        update.setLong(1, novoIdEndereco);
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
 public void atualizarSenhaUsuario(Usuario usuario, String novoSenha) {
	    
	    Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET senha_usuario = ? WHERE id_usuario = ?");
	        
	        update.setString(1, novoSenha);
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
	        ContatoDAOImp contatoDAO = new ContatoDAOImp();
	        EnderecoDAOImp enderecoDAO = new EnderecoDAOImp();
	        Contato contato = null;
	        Endereco endereco = null;
	        while (resultado.next()) {

	        	long id = resultado.getLong("id_usuario");
	            String nome = resultado.getString("nome_usuario");
	            endereco = enderecoDAO.recuperarEnderecoId(resultado.getLong("id_endereco")); 
	            contato = contatoDAO.recuperarContatoId(resultado.getLong("id_contato"));
	            String senha = resultado.getString("senha_usuario");
	            usuarios.add(new Usuario(id, nome, endereco, contato, senha));
	            

	         
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
public Usuario recuperarNomeUsuarios(String nomeUsuario) {
		
		Connection conexao = null;
		PreparedStatement consulta = null;
	    ResultSet resultado = null;
	    ContatoDAOImp contatoDAO = new ContatoDAOImp();
        EnderecoDAOImp enderecoDAO = new EnderecoDAOImp();
	    Usuario usuario = null;

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM usuario where nome_usuario == ? ");
	        consulta.setString(1, nomeUsuario);
	        resultado = consulta.executeQuery();
	   

	            long id = resultado.getLong("id_usuario");
	            String nome = resultado.getString("nome_usuario");
	            Endereco endereco = enderecoDAO.recuperarEnderecoId(resultado.getLong("id_endereco")); 
	            Contato contato = contatoDAO.recuperarContatoId(resultado.getLong("id_contato"));
	            String senha = resultado.getString("senha_usuario");
	            usuario = new Usuario(id, nome, endereco, contato, senha);
	            

	         
	        

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

	 return usuario;
	}
		
	
public Usuario recuperarIdUsuario(long idUsuario) {

	    Connection conexao = null;
	    PreparedStatement consulta = null;
	    ResultSet resultado = null;
	    ContatoDAOImp contatoDAO = new ContatoDAOImp();
        EnderecoDAOImp enderecoDAO = new EnderecoDAOImp();
	    Usuario usuario = null;

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM usuario where id_usuario == ? ");
	        consulta.setLong(1, idUsuario);
	        resultado = consulta.executeQuery();
	   

	            long id = resultado.getLong("id_usuario");
	            String nome = resultado.getString("nome_usuario");
	            Endereco endereco = enderecoDAO.recuperarEnderecoId(resultado.getLong("id_endereco")); 
	            Contato contato = contatoDAO.recuperarContatoId(resultado.getLong("id_contato"));
	            String senha = resultado.getString("senha_usuario");
	            usuario = new Usuario(id, nome, endereco, contato, senha);
	            

	         
	        

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

	 return usuario;
	}




private Connection conectarBanco() throws SQLException {
	return DriverManager.getConnection("jdbc:mysql://localhost/returnit?user=root&password=root");
}
}
	