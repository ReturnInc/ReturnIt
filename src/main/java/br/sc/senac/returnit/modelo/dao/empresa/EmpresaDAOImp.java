package br.sc.senac.returnit.modelo.dao.empresa;
import br.sc.senac.returnit.modelo.entidade.empresa.*;
import java.util.List;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.sc.senac.returnit.modelo.dao.usuario.UsuarioDAOImpl;
import br.sc.senac.returnit.modelo.entidade.usuario.*;

public class EmpresaDAOImp implements EmpresaDAO {

	public void inserirEmpresa(Empresa empresa) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO empresa (cnpj_empresa, id_usuario ) VALUES (?,?)");


			insert.setString(1, empresa.getCnpj());
			insert.setLong(2, empresa.getId()) ;
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

	public void deletarEmpresa(Empresa empresa) {
		
		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM empresa WHERE cnpj_empresa = ?");

			delete.setLong(1, empresa.getId());

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

	public void atualizarCnpjEmpresa(Empresa empresa, String novoCnpj) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE empresa SET cnpj_empresa = ? WHERE cnpj_empresa = ?");
			
			update.setString(1, novoCnpj);
			update.setString(2, empresa.getCnpj());

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

	public void atualizarIdUsuario(Empresa empresa, long novoIdUsuario) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE empresa SET id_usuario = ? WHERE cnpj_empresa = ?");
			
			update.setLong(1, novoIdUsuario);
			update.setString(2, empresa.getCnpj());

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

	public List<Empresa> recuperarEmpresas() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Empresa> empresas = new ArrayList<Empresa>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM empresa");
			UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(); 
			while (resultado.next()) {

			
				
				String cnpj = resultado.getString("cnpj_empresa");
				long idUsuario = resultado.getLong("id_usuario");
				empresas.add(new Empresa(idUsuario,cnpj));
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

		return empresas;
	}
	

	public Empresa recuperarEmpresaIdUsuario(long idUsuario) {
		
		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Empresa empresa = null;
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(); 
		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT * FROM empresa where id_usuario = ?");
			consulta.setLong(1, idUsuario);
			resultado = consulta.executeQuery();

			String cnpj = resultado.getString("cnpj_empresa");
		
			empresa = new Empresa();
					empresa.setCnpj(cnpj);

						empresa.setId(idUsuario);
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

		return empresa;
	}


	public Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/returnit?user=root&password=root");
	}
}