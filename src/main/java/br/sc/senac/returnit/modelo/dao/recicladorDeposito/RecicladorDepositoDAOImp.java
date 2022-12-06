package br.sc.senac.returnit.modelo.dao.recicladorDeposito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import br.sc.senac.returnit.modelo.dao.reciclador.RecicladorDAO;
import br.sc.senac.returnit.modelo.dao.usuario.UsuarioDAO;
import br.sc.senac.returnit.modelo.entidade.RecicladorDeposito.RecicladorDeposito;
import br.sc.senac.returnit.modelo.entidade.reciclador.Reciclador;
import br.sc.senac.returnit.modelo.entidade.usuario.Usuario;


public class RecicladorDepositoDAOImp implements RecicladorDepositoDAO{
	private RecicladorDAO recicladorDAO;
	private UsuarioDAO usuarioDAO;

	public void inserirRecicladorDeposito(RecicladorDeposito recicladorDeposito) {
		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO Reciclador_Deposito (id_reciclador, id_deposito ) VALUES (?,?)");


			insert.setLong(1, recicladorDeposito.getIdReciclador());
			insert.setLong(2, recicladorDeposito.getIdDeposito()) ;
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
	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/returnit?user=root&password=root");
	}
	
	public void deletarRecicladorDeposito(RecicladorDeposito recicladorDeposito) {
		// TODO Auto-generated method stub
		
	}

	public List<RecicladorDeposito> recuperarDepositosIdReciclador(long idReciclador) {
		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		List<RecicladorDeposito> recicladorDeposito = null;
		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT * FROM reciclador_deposito where id_reciclador = ?");
			consulta.setLong(1, idReciclador);
			resultado = consulta.executeQuery();
			while(resultado.next()) {

				long idDeposito = resultado.getLong("id_deposito");
				recicladorDeposito.add(new RecicladorDeposito(idReciclador, idDeposito));
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

		return recicladorDeposito;
	}
	public List<RecicladorDeposito> recuperarDepositosCpfReciclador(String cpf) {
		Reciclador reciclador = recicladorDAO.recuperarRecicladorCPF(cpf);
		long idReciclador = reciclador.getIdReciclador();
		List<RecicladorDeposito> recicladorDeposito = this.recuperarDepositosIdReciclador(idReciclador);
		return recicladorDeposito;
	}
	public List<RecicladorDeposito> recuperarDepositosNomeReciclador(String nome) {
		Usuario usuario = usuarioDAO.recuperarNome(nome);
		long id = usuario.getId(); 
		Reciclador reciclador = recicladorDAO.recuperarRecicladorIdUsuario(id);
		long idReciclador = reciclador.getIdReciclador();
		List<RecicladorDeposito> recicladorDeposito = this.recuperarDepositosIdReciclador(idReciclador);
		return recicladorDeposito;
	}

}
