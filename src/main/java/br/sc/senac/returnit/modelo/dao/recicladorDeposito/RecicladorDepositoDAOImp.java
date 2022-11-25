package br.sc.senac.returnit.modelo.dao.recicladorDeposito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.sc.senac.returnit.modelo.dao.reciclador.RecicladorDAO;
import br.sc.senac.returnit.modelo.entidade.empresa.Empresa;
import br.sc.senac.returnit.modelo.entidade.reciclador.Reciclador;

public class RecicladorDepositoDAOImp implements RecicladorDAO{

	@Override
	public void inserirReciclador(Reciclador reciclador) {
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
	@Override
	public void deletarReciclador(Reciclador reciclador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarCpfReciclador(Reciclador reciclador, String novoCpfReciclador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarGenero(Reciclador reciclador, String novoGenero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarIdUsuario(Reciclador reciclador, long novoIdUsuario) {
		// TODO Auto-generated method stub
		
	}

}
