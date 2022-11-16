package br.sc.senac.returnit.modelo.dao.agendamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

import br.sc.senac.returnit.modelo.entidade.agendamento.Agendamento;

public class AgendamentoDAOImp implements AgendamentoDAO{
	
	public void inserirAgendamento(Agendamento agendamento){
		Connection conexao = null;
	    PreparedStatement insert = null;

	    try {

	        conexao = conectarBanco();
	        insert = conexao.prepareStatement("INSERT INTO usuario (nome, senha, id_endereco, id_contato) VALUES (?,date(?),?,?)");
	        
	        insert.setBoolean(1, agendamento.getRealizadoAgendamento());
	        Calendar data = Calendar.getInstance();
	        data.setTime(agendamento.getDataAgendamento());
	        insert.setDate(2, (java.sql.Date) agendamento.getDataAgendamento());
	        insert.setLong(3, agendamento.getIdEmpresa());
	        insert.setLong(4, agendamento.getIdCooperado());

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

	public void deletarAgendamento(Agendamento agendamento) {
		Connection conexao = null;
	    PreparedStatement delete = null;

	    try {

	        conexao = conectarBanco();
	        delete = conexao.prepareStatement("DELETE FROM agendamento WHERE id_agendamento = ?");

	        delete.setLong(1, agendamento.getIdAgendamento());

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
    
	public void atualizarRealizadoAgendamento(Agendamento agendamento, boolean realizado) {
		Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET realizado_agendamento = ? WHERE id_agendamento = ?");
	        
	        update.setBoolean(1, realizado);
	        update.setLong(2, agendamento.getIdAgendamento());

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

	public void atualizarDataAgendamento(Agendamento agendamento, Date dataAgendamento) {
		Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET id_contato = ? WHERE id_agendamento = ?");
	        
	        update.setDate(1, (java.sql.Date) dataAgendamento);
	        update.setLong(2, agendamento.getIdAgendamento());

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

	public void atualizarIdEmpresa(Agendamento agendamento, long novoIdEmpresa) {
		Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET id_empresa = ? WHERE id _agendamento= ?");
	        
	        update.setLong(1, novoIdEmpresa);
	        update.setLong(2, agendamento.getIdAgendamento());

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
    
	public void atualizarIdCooperado(Agendamento agendamento, long novoIdContato) {
		Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE usuario SET nome = ? WHERE id = ?");
	        
	        update.setLong(1, novoIdContato);
	        update.setLong(2, agendamento.getIdAgendamento());

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

	public List<Agendamento> recuperarAgendamentos(){
		
		Connection conexao = null;
	    Statement consulta = null;
	    ResultSet resultado = null;

	    List<Agendamento> agendamentos = new ArrayList<Agendamento>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.createStatement();
	        resultado = consulta.executeQuery("SELECT * FROM usuario");
	        Date dataAgendamento = null;
	          
	        while (resultado.next()) {

	        	long idAgendamento = resultado.getLong("id_agendamento");
	            boolean realizadoAgendamento = resultado.getBoolean("realizada_agendamento");
	            dataAgendamento = resultado.getDate("data_agendamento");
	            long idEmpresa = resultado.getLong("id_empresa");
	            long idCooperado = resultado.getLong("id_cooperado");
	            agendamentos.add(new Agendamento(idAgendamento, realizadoAgendamento, dataAgendamento, idEmpresa, idCooperado));
	            

	         
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

	    return agendamentos;
	}
    
	public List<Agendamento> recuperarAgendamentoIdEmpresa(long idEmpresa){
		
		Connection conexao = null;
		PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    List<Agendamento> agendamentos = new ArrayList<Agendamento>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM agendamento where id_empresa == ? ");
	        consulta.setLong(1, idEmpresa);
	        resultado = consulta.executeQuery();
	        Date dataAgendamento = null;
	        while (resultado.next()) {

	        	long idAgendamento = resultado.getLong("id_agendamento");
	            boolean realizadoAgendamento = resultado.getBoolean("realizado_agendamento");
	            dataAgendamento = resultado.getDate("id_empresa"); 
	            long idCooperado = resultado.getLong("id_cooperado");
	            agendamentos.add(new Agendamento(idAgendamento, realizadoAgendamento, dataAgendamento, idEmpresa, idCooperado));
	            

	         
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

	    return agendamentos;
	}
    
	public List<Agendamento> recuperarAgendamentoIdEmpresaDataAtual(long idEmpresa){
		
		Connection conexao = null;
		PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    List<Agendamento> agendamentos = new ArrayList<Agendamento>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM agendamento where id_empresa == ? DAYOFMONTH(data_agendamento) == ? and MONTH(data_agendamento) == ? and YEAR(data_agendamento) == ? ");
	        consulta.setLong(1, idEmpresa);
	        Calendar dataAtual =  Calendar.getInstance();
	        consulta.setInt(2, dataAtual.get(Calendar.DAY_OF_MONTH));
	        consulta.setInt(3, dataAtual.get(Calendar.MONTH));
	        consulta.setInt(4, dataAtual.get(Calendar.YEAR));
	        resultado = consulta.executeQuery();
	        Date dataAgendamento = null;
	        while (resultado.next()) {

	        	long idAgendamento = resultado.getLong("id_agendamento");
	            boolean realizadoAgendamento = resultado.getBoolean("realizado_agendamento");
	            dataAgendamento = resultado.getDate("data_agendamento");
	            long idCooperado = resultado.getLong("id_cooperado");
	            agendamentos.add(new Agendamento(idAgendamento, realizadoAgendamento, dataAgendamento, idEmpresa, idCooperado));
	            

	         
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

	    return agendamentos;
	}
    
	public List<Agendamento> recuperarAgendamentoIdEmpresaPeriodo(long idEmpresa, Date dataInicio, Date dataFim){
		
		Connection conexao = null;
		PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    List<Agendamento> agendamentos = new ArrayList<Agendamento>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM agendamento where id_empresa == ? and DAYOFMONTH(data_agendamento) <= ? and MONTH(data_agendamento)"
	        		+ " <= ? and YEAR(data_agendamento) <= ? and DAYOFMONTH(data_agendamento) >= ? and MONTH(data_agendamento) >= ? and YEAR(data_agendamento) >= ?");
	        consulta.setLong(1, idEmpresa);
	        resultado = consulta.executeQuery();
	        Date dataAgendamento = null;
	        while (resultado.next()) {
	        	Calendar dataI =  Calendar.getInstance();
		        Calendar dataF =  Calendar.getInstance();
		        dataI.setTime(dataInicio);
		        dataF.setTime(dataFim);
		        consulta.setInt(2, dataI.get(Calendar.DAY_OF_MONTH));
		        consulta.setInt(3, dataI.get(Calendar.MONTH));
		        consulta.setInt(4, dataI.get(Calendar.YEAR));
		        consulta.setInt(5, dataF.get(Calendar.DAY_OF_MONTH));
		        consulta.setInt(6, dataF.get(Calendar.MONTH));
		        consulta.setInt(7, dataF.get(Calendar.YEAR));
	        	long idAgendamento = resultado.getLong("id_agendamento");
	            boolean realizadoAgendamento = resultado.getBoolean("realizado_agendamento");
	            dataAgendamento = resultado.getDate("data_agendamento");
	            long idCooperado = resultado.getLong("id_cooperado");
	            agendamentos.add(new Agendamento(idAgendamento, realizadoAgendamento, dataAgendamento, idEmpresa, idCooperado));
	            

	         
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

	    return agendamentos;
	}
    
	public List<Agendamento> recuperarAgendamentoIdEmpresaRealizado(long idEmpresa, boolean realizado){
		
		Connection conexao = null;
		PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    List<Agendamento> agendamentos = new ArrayList<Agendamento>();

	    try {  
	    	

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM agendamento where id_empresa == ? and realizado_agendamento == ? ");
	        consulta.setLong(1, idEmpresa);
	        consulta.setBoolean(2, realizado);
	        
	        resultado = consulta.executeQuery();
	        Date dataAgendamento = null;
	        while (resultado.next()) {

	        	long idAgendamento = resultado.getLong("id_agendamento");
	            boolean realizadoAgendamento = resultado.getBoolean("realizado_agendamento");
	            dataAgendamento = resultado.getDate("data_agendamento");
	            long idCooperado = resultado.getLong("id_cooperado");
	            agendamentos.add(new Agendamento(idAgendamento, realizadoAgendamento, dataAgendamento, idEmpresa, idCooperado));
	            

	         
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

	    return agendamentos;
	}
    
	public List<Agendamento> recuperarAgendamentoIdEmpresaRealizadoPeriodo(long idEmpresa, boolean realizado, Date dataInicio, Date dataFim){
		
		Connection conexao = null;
		PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    List<Agendamento> agendamentos = new ArrayList<Agendamento>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM agendamento where id_empresa == ? and DAYOFMONTH(data_agendamento) <= ? and MONTH(data_agendamento)"
	        		+ " <= ? and YEAR(data_agendamento) <= ? and DAYOFMONTH(data_agendamento) >= ? and MONTH(data_agendamento) >= ? and YEAR(data_agendamento) >= ?"
	        		+ "realizado_agendamento");
	        consulta.setLong(1, idEmpresa);
	        Calendar dataI =  Calendar.getInstance();
	        Calendar dataF =  Calendar.getInstance();
	        dataI.setTime(dataInicio);
	        dataF.setTime(dataFim);
	        consulta.setInt(2, dataI.get(Calendar.DAY_OF_MONTH));
	        consulta.setInt(3, dataI.get(Calendar.MONTH));
	        consulta.setInt(4, dataI.get(Calendar.YEAR));
	        consulta.setInt(5, dataF.get(Calendar.DAY_OF_MONTH));
	        consulta.setInt(6, dataF.get(Calendar.MONTH));
	        consulta.setInt(7, dataF.get(Calendar.YEAR));
	        consulta.setBoolean(8, realizado);
	        resultado = consulta.executeQuery();
	        Date dataAgendamento = null;
	        while (resultado.next()) {

	        	long idAgendamento = resultado.getLong("id_agendamento");
	            boolean realizadoAgendamento = resultado.getBoolean("realizado_agendamento");
	            dataAgendamento = resultado.getDate("data_agendamento");
	            long idCooperado = resultado.getLong("id_cooperado");
	            agendamentos.add(new Agendamento(idAgendamento, realizadoAgendamento, dataAgendamento, idEmpresa, idCooperado));
	            

	         
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

	    return agendamentos;
	}
    
	public List<Agendamento> recuperarAgendamentoDataAtual(){
		
		Connection conexao = null;
		PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    List<Agendamento> agendamentos = new ArrayList<Agendamento>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM agendamento where DAYOFMONTH(data_agendamento) == ? and MONTH(data_agendamento) == ? and YEAR(data_agendamento) == ? ");
	        Calendar dataAtual =  Calendar.getInstance();
	        consulta.setInt(1, dataAtual.get(Calendar.DAY_OF_MONTH));
	        consulta.setInt(2, dataAtual.get(Calendar.MONTH));
	        consulta.setInt(3, dataAtual.get(Calendar.YEAR));
	        
	        resultado = consulta.executeQuery();
	        Date dataAgendamento = null;
	        while (resultado.next()) {

	        	long idAgendamento = resultado.getLong("id_agendamento");
	            boolean realizadoAgendamento = resultado.getBoolean("realizado_agendamento");
	            dataAgendamento = resultado.getDate("data_agendamento");
	            long idEmpresa = resultado.getLong("id_empresa");
	            long idCooperado = resultado.getLong("id_cooperado");
	            agendamentos.add(new Agendamento(idAgendamento, realizadoAgendamento, dataAgendamento, idEmpresa, idCooperado));
	            

	         
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

	    return agendamentos;
	}
    
	public List<Agendamento> recuperarAgendamentoPeriodo(Date dataInicio, Date dataFim){
		
		Connection conexao = null;
		PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    List<Agendamento> agendamentos = new ArrayList<Agendamento>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM agendamento where DAYOFMONTH(data_agendamento) <= ? and MONTH(data_agendamento) <= ? and YEAR(data_agendamento) <= ? and DAYOFMONTH(data_agendamento) >= ? and MONTH(data_agendamento) >= ? and YEAR(data_agendamento) >= ?");
	        Calendar dataI =  Calendar.getInstance();
	        Calendar dataF =  Calendar.getInstance();
	        dataI.setTime(dataInicio);
	        dataF.setTime(dataFim);
	        consulta.setInt(1, dataI.get(Calendar.DAY_OF_MONTH));
	        consulta.setInt(2, dataI.get(Calendar.MONTH));
	        consulta.setInt(3, dataI.get(Calendar.YEAR));
	        consulta.setInt(4, dataF.get(Calendar.DAY_OF_MONTH));
	        consulta.setInt(5, dataF.get(Calendar.MONTH));
	        consulta.setInt(6, dataF.get(Calendar.YEAR));
	        
	        resultado = consulta.executeQuery();
	        Date dataAgendamento = null;
	        while (resultado.next()) {

	        	long idAgendamento = resultado.getLong("id_agendamento");
	            boolean realizadoAgendamento = resultado.getBoolean("realizado_agendamento");
	            dataAgendamento = resultado.getDate("data_agendamento");
	            long idEmpresa = resultado.getLong("id_empresa");
	            long idCooperado = resultado.getLong("id_cooperado");
	            agendamentos.add(new Agendamento(idAgendamento, realizadoAgendamento, dataAgendamento, idEmpresa, idCooperado));
	            

	         
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

	    return agendamentos;
	}
    
	public List<Agendamento> recuperarAgendamentoRealizados(boolean realizado){
		
		Connection conexao = null;
		PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    List<Agendamento> agendamentos = new ArrayList<Agendamento>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM agendamento where realizado_agendamento == ? ");
	        consulta.setBoolean(1, realizado);
	        resultado = consulta.executeQuery();
	        Date dataAgendamento = null;
	        while (resultado.next()) {

	        	long idAgendamento = resultado.getLong("id_agendamento");
	            boolean realizadoAgendamento = resultado.getBoolean("realizado_agendamento");
	            dataAgendamento = resultado.getDate("data_agendamento"); 
	            long idEmpresa = resultado.getLong("id_empresa");
	            long idCooperado = resultado.getLong("id_cooperado");
	            agendamentos.add(new Agendamento(idAgendamento, realizadoAgendamento, dataAgendamento, idEmpresa, idCooperado));
	            

	         
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

	    return agendamentos;
	}
    
	public Agendamento recuperarAgendamentoId(long idAgendamento) {
		
		Connection conexao = null;
	    PreparedStatement consulta = null;
	    ResultSet resultado = null;
	    Agendamento agendamento = null; 

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM agendamento where id_agendamento == ? ");
	        consulta.setLong(1, idAgendamento);
	        resultado = consulta.executeQuery();
	        Date dataAgendamento = null;

	        
            boolean realizadoAgendamento = resultado.getBoolean("realizado_agendamento");
            dataAgendamento = resultado.getDate("data_agendamento"); 
            long idEmpresa = resultado.getLong("id_empresa");
            long idCooperado = resultado.getLong("id_cooperado");
	        agendamento = new Agendamento(idAgendamento, realizadoAgendamento, dataAgendamento, idEmpresa, idCooperado);
	            

	         
	        

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

	 return agendamento;
	}
		
	
private Connection conectarBanco() throws SQLException {
	return DriverManager.getConnection("jdbc:mysql://localhost/returnit?user=root&password=root");
}
}
