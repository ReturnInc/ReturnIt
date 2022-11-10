package br.sc.senac.returnit.modelo.dao.usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.sc.senac.returnit.entidade.usuario.Usuario;

public class USuarioDAO1 implements UsuarioDAO {
	public void inserirUsuario(Usuario usuario) {

	    Connection conexao = null;
	    PreparedStatement insert = null;

	    try {

	        conexao = conectarBanco();
	        insert = conexao.prepareStatement("INSERT INTO usuario (id,nome,cpf,genero,endereco) VALUES (?,?,?,?,?)");
	        
	        insert.setLong(1, usuario.getId());
	        insert.setString(2, usuario.getNome());
	        insert.setString(3, usuario.getCpf());
	      //  insert.setEnum(4, usuario.getGenero());
	        // como inserir a classe endereço? 
	        

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

	public void atualizarCpfUsuario1(Usuario usuario, String novoCpf) {
	    
	    Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET cpf = ? WHERE id = ?");
	        
	        update.setString(1, novoCpf);
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

	public void atualizarCpfUsuario(Usuario usuario, String novoCpf) {
	    
	    Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET cpf = ? WHERE id = ?");
	        
	        update.setString(1, novoCpf);
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

	public void atualizarGeneroUsuario1(Usuario usuario, String novoGenero) {
	    
	    Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET genero = ? WHERE id = ?");
	        
	        update.setString(1, novoGenero);
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

	public void atualizarEnderecoUsuario1(Usuario usuario, String novoEndereco) {
	    
	    Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET endereco = ? WHERE id = ?");
	        
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

	public List<Usuario> recuperarUsuarios1() {

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
	            String cpf = resultado.getString("cpf");
	            // como fazer este? enum genero = resultado.getEnum("genero");
	            // nao sei se esta correto Endereco endereco = resultado.getClass("endereco");
	            String genero = resultado.getString("genero");
	            String endereco = resultado.getString("endereco");


	            

	         
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

public void atualizarGeneroUsuario(Usuario usuario, String novoGenero) {
	// TODO Auto-generated method stub
	
}

public void atualizarEnderecoUsuario(Usuario usuario, String novoEndereco) {
	// TODO Auto-generated method stub
	
}

public List<Usuario> recuperarUsuarios() {
	// TODO Auto-generated method stub
	return null;
}

public List<Usuario> recuperarDepositosRealizados() {
	// TODO Auto-generated method stub
	return null;
}

public List<Usuario> recuperarDepositosRealizadosPeriodo() {
	// TODO Auto-generated method stub
	return null;
}

}