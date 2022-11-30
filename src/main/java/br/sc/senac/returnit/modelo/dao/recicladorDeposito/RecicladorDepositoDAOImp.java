package br.sc.senac.returnit.modelo.dao.recicladorDeposito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.sc.senac.returnit.modelo.entidade.RecicladorDeposito.RecicladorDeposito;


public class RecicladorDepositoDAOImp implements RecicladorDepositoDAO{

	@Override
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
	@Override
	public void deletarRecicladorDeposito(RecicladorDeposito recicladorDeposito) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<RecicladorDeposito> recuperarDepositosRealizados() {
		// TODO Auto-generated method stub
		return null;
	}

}
