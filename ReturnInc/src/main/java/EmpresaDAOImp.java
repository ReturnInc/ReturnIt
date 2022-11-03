package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.EnderecoDAOimp;
import modelo.RetornavelDAOimp;
import modelo.EmpresaDAO;


public class EmpresaDAOImp implements EmpresaDAO {

	public void inserirEmpresa(Empresa empresa) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO empresa (marca_empresa, cnpj_empresa) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS );

			insert.setString(1, empresa.getMarca());
			insert.setString(2, empresa.getCnpj());
			insert.execute();
			RetonavelDAOimp.inserirRetornavel(empresa.getCnpj(),empresa.getRetornavel);
			EnderecoDAOimp.inserirEndereco(empresa.getCnpj(), empresa.getEndereco());
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
			delete = conexao.prepareStatement("DELETE FROM empresa WHERE id_empresa = ?");

			delete.setInt(1, empresa.getId());
			delete.execute();
			RetonavelDAOimp.deletarRetornavel(empresa.getCnpj(),empresa.getRetornavel);
			EnderecoDAOimp.deletarEndereco(empresa.getCnpj(), empresa.getEndereco());
			
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

	public void atualizarMarcaEmpresa(Empresa empresa, String novaMarca) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente SET nome_cliente = ? WHERE id_cliente = ?");
			
			update.setString(1, novaMarca);
			update.setInt(2, empresa.getId());

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

	public void atualizarCnpjEmpresa(Empresa empresa, String novoCnpj) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente SET cpf_cliente = ? WHERE id_cliente = ?");
			
			update.setString(1, novoCnpj);
			update.setInt(2, empresa.getId());

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

			while (resultado.next()) {

				int id = resultado.getInt("id_empresa");
				String marca = resultado.getString("marca_empresa");
				String cnpj = resultado.getString("cnpj_empresa");
				Retornavel retornavel = RetonavelDAOimp.recuperarRetornavel();
				Endereco endereco = EnderecoDAOimp.recuperarEndereco();

				empresas.add(new Empresa(id, marca, cnpj, retornavel, endereco));
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

	public List<Empresa> recuperarEmpresasOrdenadosMarcaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Empresa> empresas = new ArrayList<Empresa>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM empresa ORDER BY marca_empresa ASC");

			while (resultado.next()) {

				int id = resultado.getInt("id_empresa");
				String marca = resultado.getString("marca_empresa");
				String cnpj = resultado.getString("cnpj_empresa");
				Retornavel retornavel = RetonavelDAOimp.recuperarRetornavel();
				Endereco endereco = EnderecoDAOimp.recuperarEndereco();

				empresas.add(new Empresa(id, marca, cnpj, retornavel, endereco));
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

	public List<Empresa> recuperarEmpresasOrdenadosMarcaDescendente() {
		
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Empresa> empresas = new ArrayList<Empresa>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM empresa ORDER BY marca_empresa DESC");

			while (resultado.next()) {

				int id = resultado.getInt("id_empresa");
				String marca = resultado.getString("marca_empresa");
				String cnpj = resultado.getString("cnpj_empresa");
				Retornavel retornavel = RetonavelDAOimp.recuperarRetornavel();
				Endereco endereco = EnderecoDAOimp.recuperarEndereco();

				empresas.add(new Empresa(id, marca, cnpj, retornavel, endereco));
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

	public List<Empresa> recuperarEmpresasOrdenadosCnpjAscendente() {
		
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Empresa> empresas = new ArrayList<Empresa>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM empresa ORDER BY cnpj_empresa ASC");

			while (resultado.next()) {

				int id = resultado.getInt("id_empresa");
				String marca = resultado.getString("marca_empresa");
				String cnpj = resultado.getString("cnpj_empresa");
				Retornavel retornavel = RetonavelDAOimp.recuperarRetornavel();
				Endereco endereco = EnderecoDAOimp.recuperarEndereco();

				empresas.add(new Empresa(id, marca, cnpj, retornavel, endereco));
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

	public List<Empresa> recuperarEmpresasOrdenadosCnpjDescendente() {
		
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Empresa> empresas = new ArrayList<Empresa>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM empresa ORDER BY cnpj_empresa ASC");

			while (resultado.next()) {

				int id = resultado.getInt("id_empresa");
				String marca = resultado.getString("marca_empresa");
				String cnpj = resultado.getString("cnpj_empresa");
				Retornavel retornavel = RetonavelDAOimp.recuperarRetornavel();
				Endereco endereco = EnderecoDAOimp.recuperarEndereco();

				empresas.add(new Empresa(id, marca, cnpj, retornavel, endereco));
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


	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}
