package br.sc.senac.returnit.modelo.dao.reciclador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.sc.senac.returnit.modelo.dao.usuario.UsuarioDAOImpl;
import br.sc.senac.returnit.modelo.entidade.contato.Contato;
import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;
import br.sc.senac.returnit.modelo.entidade.reciclador.Reciclador;
import br.sc.senac.returnit.modelo.entidade.usuario.Usuario;

public class RecicladorDAOImpl implements RecicladorDAO{
	public void inserirReciclador(Reciclador reciclador) {

	    Connection conexao = null;
	    PreparedStatement insert = null;

	    try {

	        conexao = conectarBanco();
	        insert = conexao.prepareStatement("INSERT INTO reciclador (cpf_reciclador, genero_reciclador, id_usuario) VALUES (?,?,?)");
	        
	        insert.setString(1, reciclador.getCpf_reciclador());
	        insert.setString(2, reciclador.getGenero_reciclador());
	        insert.setLong(3, reciclador.getId_usuario());
	        
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
	public void deletarReciclador(Reciclador reciclador) {
	    
	    Connection conexao = null;
	    PreparedStatement delete = null;
	    
	    try {

	        conexao = conectarBanco();
	        delete = conexao.prepareStatement("DELETE FROM reciclador WHERE id_usuario = ?");
	        
	        delete.setLong(1, reciclador.getId_usuario());
	        
	        delete.execute();
	        
			UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
			Usuario usuario = usuarioDAO.recuperarIdUsuario(reciclador.getId_usuario());
			usuarioDAO.deletarUsuario(usuario);
			
	        
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
	public void atualizarCpfReciclador(Reciclador reciclador, String novoCpfReciclador) {
	    
	    Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE reciclador SET cpf_reciclador = ? WHERE id_usuario = ?");
	        
	        update.setString(1, novoCpfReciclador);
	        update.setLong(2, reciclador.getId_usuario());

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
	public void atualizarGenero(Reciclador reciclador, String novoGenero) {
	    
	    Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET cpf_reciclador = ? WHERE id_usuario = ?");
	        
	        update.setString(1, novoGenero);
	        update.setLong(2, reciclador.getId_usuario());

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
	public void atualizarIdUsuario(Reciclador reciclador, long novoIdUsuario) {
	    
	    Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET cpf_reciclador = ? WHERE id_usuario = ?");
	        
	        update.setLong(1, novoIdUsuario);
	        update.setLong(2, reciclador.getId_usuario());

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
	public Reciclador recuperarRecicladorIdUsuario(long idUsuario) {
		
		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Reciclador reciclador = null;
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT * FROM reciclador where id_usuario = ?");
			consulta.setLong(1, idUsuario);
			resultado = consulta.executeQuery();

			String cpfReciclador = resultado.getString("cpf_reciclador");
			String generoReciclador = resultado.getString("genero_reciclador");
			long idReciclador = resultado.getLong("id_Reciclador");
			Usuario usuario = usuarioDAO.recuperarIdUsuario(idUsuario);
			Endereco endereco = usuario.getEndereco();
			Contato contato = usuario.getContato();
			reciclador = new Reciclador(idReciclador, idUsuario, cpfReciclador, generoReciclador, usuario.getNome(), endereco, contato, usuario.getSenha());
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

		return reciclador;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/returnit?user=root&password=Root");
	}
	@Override
	public List<Reciclador> recuperarRecicladores() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Reciclador recuperarRecicladorCPF(String CPF) {
		// TODO Auto-generated method stub
		return null;
	}

}