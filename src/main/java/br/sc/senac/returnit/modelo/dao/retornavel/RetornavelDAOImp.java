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

	public void inserirCliente(Retornavel retornavel) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO cliente (nome_cliente, cpf_cliente, idade_cliente, divida_cliente) VALUES (?,?,?,?)");

			insert.setString(1, cliente.getNome());
			insert.setString(2, cliente.getCpf());
			insert.setInt(3, cliente.getIdade());
			insert.setDouble(4, cliente.getDivida());

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

	public void deletarCliente(Retornavel retornavel) {
		
		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");

			delete.setInt(1, cliente.getId());

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

	public void atualizarNomeCliente(Retornavel retornavel, String novoNome) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente SET nome_cliente = ? WHERE id_cliente = ?");
			
			update.setString(1, novoNome);
			update.setInt(2, cliente.getId());

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

	public void atualizarCpfCliente(Retornavel retornavel, String novoCpf) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente SET cpf_cliente = ? WHERE id_cliente = ?");
			
			update.setString(1, novoCpf);
			update.setInt(2, cliente.getId());

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

	public void atualizarIdadeCliente(Retornavel retornavele, int novaIdade) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente SET idade_cliente = ? WHERE id_cliente = ?");
			
			update.setInt(1, novaIdade);
			update.setInt(2, cliente.getId());

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

	public void atualizarDividaCliente(Retornavel retornavel, double novaDivida) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente SET divida_cliente = ? WHERE id_cliente = ?");
			
			update.setDouble(1, novaDivida);
			update.setInt(2, cliente.getId());

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

	public List<Cliente> recuperarClientes() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM cliente");

			while (resultado.next()) {

				int id = resultado.getInt("id_cliente");
				String nome = resultado.getString("nome_cliente");
				String cpf = resultado.getString("cpf_cliente");
				int idade = resultado.getInt("idade_cliente");
				double divida = resultado.getDouble("divida_cliente");

				clientes.add(new Cliente(id, nome, cpf, idade, divida));
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

		return clientes;
	}

	public List<Cliente> recuperarClientesOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM cliente ORDER BY nome_cliente ASC");

			while (resultado.next()) {

				int id = resultado.getInt("id_cliente");
				String nome = resultado.getString("nome_cliente");
				String cpf = resultado.getString("cpf_cliente");
				int idade = resultado.getInt("idade_cliente");
				double divida = resultado.getDouble("divida_cliente");

				clientes.add(new Cliente(id, nome, cpf, idade, divida));
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

		return clientes;
	}

	public List<Cliente> recuperarClientesOrdenadosNomeDescendente() {
		
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM cliente ORDER BY nome_cliente DESC");

			while (resultado.next()) {

				int idCliente = resultado.getInt("id_cliente");
				String nome = resultado.getString("nome_cliente");
				String cpf = resultado.getString("cpf_cliente");
				int idade = resultado.getInt("idade_cliente");
				double divida = resultado.getDouble("divida_cliente");

				clientes.add(new Cliente(idCliente, nome, cpf, idade, divida));
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

		return clientes;
	}

	public List<Cliente> recuperarClientesOrdenadosCpfAscendente() {
		
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM cliente ORDER BY cpf_cliente ASC");

			while (resultado.next()) {

				int id = resultado.getInt("id_cliente");
				String nome = resultado.getString("nome_cliente");
				String cpf = resultado.getString("cpf_cliente");
				int idade = resultado.getInt("idade_cliente");
				double divida = resultado.getDouble("divida_cliente");

				clientes.add(new Cliente(id, nome, cpf, idade, divida));
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

		return clientes;
	}

	public List<Cliente> recuperarClientesOrdenadosCpfDescendente() {
		
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM cliente ORDER BY cpf_cliente ASC");

			while (resultado.next()) {

				int id = resultado.getInt("id_cliente");
				String nome = resultado.getString("nome_cliente");
				String cpf = resultado.getString("cpf_cliente");
				int idade = resultado.getInt("idade_cliente");
				double divida = resultado.getDouble("divida_cliente");

				clientes.add(new Cliente(id, nome, cpf, idade, divida));
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

		return clientes;
	}

	public List<Cliente> recuperarClientesOrdenadosIdadeAscendente() {
		
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM cliente ORDER BY idade_cliente ASC");

			while (resultado.next()) {

				int id = resultado.getInt("id_cliente");
				String nome = resultado.getString("nome_cliente");
				String cpf = resultado.getString("cpf_cliente");
				int idade = resultado.getInt("idade_cliente");
				double divida = resultado.getDouble("divida_cliente");

				clientes.add(new Cliente(id, nome, cpf, idade, divida));
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

		return clientes;
	}

	public List<Cliente> recuperarClientesOrdenadosIdadeDescendente() {
		
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM cliente ORDER BY idade_cliente DESC");

			while (resultado.next()) {

				int id = resultado.getInt("id_cliente");
				String nome = resultado.getString("nome_cliente");
				String cpf = resultado.getString("cpf_cliente");
				int idade = resultado.getInt("idade_cliente");
				double divida = resultado.getDouble("divida_cliente");

				clientes.add(new Cliente(id, nome, cpf, idade, divida));
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

		return clientes;
	}

	public List<Cliente> recuperarClientesOrdenadosDividaAscendente() {
		
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM cliente ORDER BY divida_cliente ASC");

			while (resultado.next()) {

				int id = resultado.getInt("id_cliente");
				String nome = resultado.getString("nome_cliente");
				String cpf = resultado.getString("cpf_cliente");
				int idade = resultado.getInt("idade_cliente");
				double divida = resultado.getDouble("divida_cliente");

				clientes.add(new Cliente(id, nome, cpf, idade, divida));
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

		return clientes;
	}

	public List<Cliente> recuperarClientesOrdenadosDividaDescendente() {
		
		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM cliente ORDER BY divida_cliente DESC");

			while (resultado.next()) {

				int id = resultado.getInt("id_cliente");
				String nome = resultado.getString("nome_cliente");
				String cpf = resultado.getString("cpf_cliente");
				int idade = resultado.getInt("idade_cliente");
				double divida = resultado.getDouble("divida_cliente");

				clientes.add(new Cliente(id, nome, cpf, idade, divida));
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

		return clientes;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}


