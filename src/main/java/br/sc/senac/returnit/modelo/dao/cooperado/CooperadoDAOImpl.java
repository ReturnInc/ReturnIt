package br.sc.senac.returnit.modelo.dao.cooperado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.sc.senac.returnit.modelo.dao.usuario.UsuarioDAOImpl;
import br.sc.senac.returnit.modelo.entidade.contato.Contato;
import br.sc.senac.returnit.modelo.entidade.cooperado.Cooperado;
import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;
import br.sc.senac.returnit.modelo.entidade.usuario.Usuario;

public class CooperadoDAOImpl implements CooperadoDAO {

	@Override
	public void inserirCooperado(Cooperado cooperado) {
		
		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO cooperado (cnpj_cooperado, id_usuario ) VALUES (?,?)",

					PreparedStatement.RETURN_GENERATED_KEYS);

			insert.setString(1, cooperado.getCnpj_cooperado());
			insert.setLong(2, cooperado.getId());
			

			insert.execute();


			ResultSet chavePrimaria = insert.getGeneratedKeys();
					if (chavePrimaria.next())
					cooperado.setId(chavePrimaria.getLong(1));
						// inseridas linhas 32 a 35 para trazer o resultado do generated_keys

			
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

	@Override
	public void deletarCooperado(Cooperado cooperado) {
		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM cooperado WHERE cnpj_cooperado = ?");

			delete.setString(1, cooperado.getCnpj_cooperado());
	
	
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

	@Override
	public void atualizarCnpj(String novoCnpj,Cooperado cooperado) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cooperado SET cnpj_cooperado = ? WHERE cnpj_cooperado = ?");
			
			update.setString(1, novoCnpj);
			update.setString(2, cooperado.getCnpj_cooperado());

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
	public Cooperado recuperarCooperadoIdUsuario(long idUsuario) {
		
		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Cooperado cooperado = null;
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT * FROM cooperado where id_usuario = ?");
			consulta.setLong(1, idUsuario);
			resultado = consulta.executeQuery();

			String cnpj = resultado.getString("cnpj_cooperado");
			long idEmpresa = resultado.getLong("id_cooperado");
			Usuario usuario = usuarioDAO.recuperarIdUsuario(idUsuario);
			Endereco endereco = usuario.getEndereco();
			Contato contato = usuario.getContato();
			cooperado = new Cooperado(idEmpresa, idUsuario, usuario.getNome(), endereco, contato, cnpj, usuario.getSenha());
			
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

		return cooperado;
	}
	
	
	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/returnit?user=root&password=root");
	}


	@Override
	public List<Cooperado> recuperarCooperados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cooperado recuperarCooperadoCnpj(String CooperadoCnpj) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
