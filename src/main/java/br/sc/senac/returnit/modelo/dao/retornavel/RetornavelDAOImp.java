package br.sc.senac.returnit.modelo.dao.retornavel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.sc.senac.returnit.modelo.entidade.retornavel.*;

public class RetornavelDAOImp implements RetornavelDAO {

	public void inserirRetornavel(Retornavel retornavel) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO retornal (material, marca_retonavel, modelo_retornavel, empresa_cnpj) VALUES (?,?,?,?)");

			insert.setString(1, retornavel.getMaterial());
			insert.setString(2, retornavel.getMarca());
			insert.setString(3, retornavel.getModelo());
			insert.setString(4, retornavel.getCnpjEmpresa());

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

	public void deletarRetornavel(Retornavel retornavel) {
		
		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM retornavel WHERE id = ?");

			delete.setLong(1, retornavel.getIdRetornavel());

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

	public void atualizarMaterial(Retornavel retornavel, String novoMaterial) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE retornavel SET material = ? WHERE id = ?");
			
			update.setString(1, novoMaterial);
			update.setLong(2, retornavel.getIdRetornavel());

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

	public void atualizarModeloRetornavel(Retornavel retornavel, String novoModeloRetornavel) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE retornavel SET modelo_retornavel = ? WHERE id = ?");
			
			update.setString(1, novoModeloRetornavel);
			update.setLong(2, retornavel.getIdRetornavel());

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

	public void atualizarMarcaRetornavel(Retornavel retornavel, String novaMarcaRetornavel) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE retornavel SET marca_retornavel = ? WHERE id = ?");
			
			update.setString(1, novaMarcaRetornavel);
			update.setLong(2, retornavel.getIdRetornavel());

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

	public void atualizarCnpjEmpresa(Retornavel retornavel, String novoCnpjEmpresa) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE retornavel SET empresa_cnpj = ? WHERE id = ?");
			
			update.setString(1, novoCnpjEmpresa);
			update.setLong(2, retornavel.getIdRetornavel());

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

	public List<Retornavel> recuperarRetornaveis() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Retornavel> retornaveis = new ArrayList<Retornavel>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM retornavel");

			while (resultado.next()) {

				int id = resultado.getInt("id");
				String material = resultado.getString("material");
				String marca = resultado.getString("marca_retornavel");
				String  modelo = resultado.getString("modelo_retornavel");
				String cnpjEmpresa = resultado.getString("empresa_cnpj");

				retornaveis.add(new Retornavel(id, material, marca, modelo, cnpjEmpresa));
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

		return retornaveis;
	}

	public Retornavel recuperarRetornavelId(long idRetornavel) {

		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Retornavel retornavel = null;

		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT * FROM retornavel where id = ? ");
			consulta.setLong(1, idRetornavel);
			resultado = consulta.executeQuery();
			
			String material = resultado.getString("material");
			String marca = resultado.getString("marca_retornavel");
			String  modelo = resultado.getString("modelo_retornavel");
			String cnpjEmpresa = resultado.getString("empresa_cnpj");

			retornavel = new Retornavel(idRetornavel, material, marca, modelo, cnpjEmpresa);

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

		return retornavel;
	}

	public List<Retornavel> recuperarRetornaveisCnpj(String cnpjEmpresa) {
		
		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;

		List<Retornavel> retornaveis = new ArrayList<Retornavel>();

		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT * FROM retornavel where cnpjEmpresa = ? ");
			consulta.setString(1, cnpjEmpresa);
			resultado = consulta.executeQuery();
			
			while (resultado.next()) {
			
				int id = resultado.getInt("id");
				String material = resultado.getString("material");
				String marca = resultado.getString("marca_retornavel");
				String  modelo = resultado.getString("modelo_retornavel");


				retornaveis.add(new Retornavel(id, material, marca, modelo, cnpjEmpresa));
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

		return retornaveis;
	}



	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}


}


