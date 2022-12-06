package br.sc.senac.returnit.modelo.dao.agendamentoRetornavel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.sc.senac.returnit.modelo.dao.agendamento.AgendamentoDAOImp;
import br.sc.senac.returnit.modelo.entidade.agendamento.Agendamento;
import br.sc.senac.returnit.modelo.entidade.agendamentoRetornavel.AgendamentoRetornavel;

public class AgendamentoRetornavelDAOImpl implements AgendamentoRetornavelDAO{
		public void inserirAgendamentoRetornavel(AgendamentoRetornavel agendamentoRetornavel) {

			Connection conexao = null;
			PreparedStatement insert = null;

			try {

				conexao = conectarBanco();
				insert = conexao.prepareStatement("INSERT INTO agendamento_retornavel (quantidade, id_retornavel, id_agendamento ) VALUES (?,?,?)");


				insert.setInt(1, agendamentoRetornavel.getQuantidade());
				insert.setLong(2, agendamentoRetornavel.getIdRetornavel());
				insert.setLong(3, agendamentoRetornavel.getIdAgendamento()) ;
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
		public void deletarAgendamentoRetornavel(AgendamentoRetornavel agendamentoRetornavel) {
			
			Connection conexao = null;
			PreparedStatement delete = null;

			try {

				conexao = conectarBanco();
				delete = conexao.prepareStatement("DELETE FROM agendamento_retornavel WHERE id_agendamento = ?");

				delete.setLong(1, agendamentoRetornavel.getIdAgendamento());

				delete.execute();
				
				if(this.verificarDeleteAgendamento(agendamentoRetornavel.getIdAgendamento())) {
					AgendamentoDAOImp agendamentoDAO = new AgendamentoDAOImp();
					Agendamento agendamento = agendamentoDAO.recuperarAgendamentoId(agendamentoRetornavel.getIdAgendamento());
					agendamentoDAO.deletarAgendamento(agendamento);
				}
					
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
		public void atualizarQuantidade(AgendamentoRetornavel agendamentoRetornavel, int novaQuantidade) {
			
			Connection conexao = null;
			PreparedStatement update = null;

			try {

				conexao = conectarBanco();
				update = conexao.prepareStatement("UPDATE agendamento_retornavel SET quantidade = ? WHERE quantidade = ?");
				
				update.setLong(1, novaQuantidade);
				update.setLong(2, agendamentoRetornavel.getQuantidade());

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
		public void atualizarIdRetornavel(AgendamentoRetornavel agendamentoRetornavel, long novoIdRetornavel) {
			
			Connection conexao = null;
			PreparedStatement update = null;

			try {

				conexao = conectarBanco();
				update = conexao.prepareStatement("UPDATE agendamento_retornavel SET id_retornavel = ? WHERE id_retornavel = ?");
				
				update.setLong(1, novoIdRetornavel);
				update.setLong(2, agendamentoRetornavel.getIdRetornavel());

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
		public void atualizarIdAgendamento(AgendamentoRetornavel agendamentoRetornavel, long novoIdAgendamento) {
			
			Connection conexao = null;
			PreparedStatement update = null;

			try {

				conexao = conectarBanco();
				update = conexao.prepareStatement("UPDATE agendamento_retornavel SET id_agendamento = ? WHERE id_agendamento = ?");
				
				update.setLong(1, novoIdAgendamento);
				update.setLong(2, agendamentoRetornavel.getIdAgendamento());

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
		public boolean verificarDeleteAgendamento(long idAgendamento) {
			
			Connection conexao = null;
			PreparedStatement consulta = null;
			    ResultSet resultado = null;
			    
			    try {

			        conexao = conectarBanco();
			        consulta = conexao.prepareStatement("SELECT * FROM agendamento_retornavel where id_agendamento = ?");
			        consulta.setLong(1, idAgendamento);
			        resultado = consulta.executeQuery();
			     
			       if(resultado.getString ("cnpj_empresa") != "") {
			    	   return true;
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
			    return false;
			}
		public Connection conectarBanco() throws SQLException {
			return DriverManager.getConnection("jdbc:mysql://localhost/returnit?user=root&password=root");
	}
}