package br.sc.senac.returnit.modelo.dao.deposito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.sc.senac.returnit.modelo.entidade.deposito.Deposito;
import br.sc.senac.returnit.modelo.entidade.retornavel.Retornavel;

public class DepositoDAOImp implements DepositoDAO {
	public void inserirDeposito(Deposito deposito) {
		
		Connection conexao = null;
	    PreparedStatement insert = null;

	    try {

	        conexao = conectarBanco();
	        insert = conexao.prepareStatement("INSERT INTO deposito (data_deposito, quantidade_deposito, retornavel_deposito) VALUES (?,?,?)",
	        		PreparedStatement.RETURN_GENERATED_KEYS);
	        insert.setDate(1, (java.sql.Date) deposito.getDataDeposito());
	        insert.setInt(2,deposito.getQuantidadeDeposito());
	       
	        Retornavel retornavel = deposito.getRetornavelDeposito();
	        insert.setLong(3, retornavel.getIdRetornavel() );
	        insert.execute();

	        ResultSet chavePrimaria = insert.getGeneratedKeys();
			if (chavePrimaria.next())
			deposito.setIdDeposito(chavePrimaria.getLong(1));
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

	public void deletarDeposito(Deposito deposito) {
		
		Connection conexao = null;
	    PreparedStatement delete = null;

	    try {

	        conexao = conectarBanco();
	        delete = conexao.prepareStatement("DELETE FROM deposito WHERE id_deposito = ?");

	        delete.setLong(1, deposito.getIdDeposito());

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
    
	public void atualizarDataDeposito(Deposito deposito, Date novaDataDeposito) {
		Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE deposito SET data_deposito = ? WHERE id_deposito = ?");
	        
	        update.setDate(1,  (java.sql.Date) novaDataDeposito);
	        update.setLong(2, deposito.getIdDeposito());

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

	public void atualizarQuantidadeDeposito(Deposito deposito, int novaQuantidadeDeposito) {
		Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE deposito SET quantidade_deposito = ? WHERE id_deposito = ?");
	        
	        update.setInt(1, novaQuantidadeDeposito);
	        update.setLong(2, deposito.getIdDeposito());

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

	public void atualizarRetornavelDeposito(Deposito deposito, long novoRetornavelDeposito) {
		Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE deposito SET retornavel_deposito = ? WHERE id_deposito = ?");
	        
	        update.setLong(1, novoRetornavelDeposito);
	        update.setLong(2, deposito.getIdDeposito());

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


	public List<Deposito> recuperarDepositos(){
		Connection conexao = null;
	    Statement consulta = null;
	    ResultSet resultado = null;

	    List<Deposito> depositos = new ArrayList<Deposito>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.createStatement();
	        resultado = consulta.executeQuery("SELECT * FROM deposito");
	        while (resultado.next()) {

	        	long idDeposito = resultado.getLong("id_deposito");
		        Date dataDeposito = (java.util.Date) resultado.getDate("date_deposito");
		        int quantidadeDeposito = resultado.getInt("quantidade_deposito"); 
		        
		        long retornavel = resultado.getLong("retornavel_deposito");
		        depositos.add(new Deposito( idDeposito, dataDeposito, quantidadeDeposito, retornavel));
	            

	         
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

	    return depositos;
	}
		
    
	public List<Deposito> recuperarDepositoPeriodo(Date dataInicio, Date dataFim){
		Connection conexao = null;
		PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    List<Deposito> depositos = new ArrayList<Deposito>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM deposito where DAYOFMONTH(data_deposito) <= ? and MONTH(data_deposito)"
	        		+ " <= ? and YEAR(data_deposito) <= ? and DAYOFMONTH(data_deposito) >= ? and MONTH(data_deposito) >= ? and YEAR(data_deposito) >= ?"
	        		+ "realizado_deposito");
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
	        resultado = consulta.executeQuery();
	        while (resultado.next()) {

	        	long idDeposito = resultado.getLong("id_deposito");
		        Date dataDeposito = (java.util.Date) resultado.getDate("date_deposito");
		        int quantidadeDeposito = resultado.getInt("quantidade_deposito"); 
		        long retornavel = resultado.getLong("retornavel_deposito");
		        depositos.add(new Deposito( idDeposito, dataDeposito, quantidadeDeposito, retornavel));
	            

	         
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

	    return depositos;
	}
    
	public List<Deposito> recuperarDepositoData(Date dataDeposito){
		Connection conexao = null;
		PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    List<Deposito> depositos = new ArrayList<Deposito>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM deposito where DAYOFMONTH(data_deposito) == ? and MONTH(data_deposito) == ? and YEAR(data_deposito) == ? ");
	        Calendar data =  Calendar.getInstance();
	        data.setTime(dataDeposito);
	        consulta.setInt(1, data.get(Calendar.DAY_OF_MONTH));
	        consulta.setInt(2, data.get(Calendar.MONTH));
	        consulta.setInt(3, data.get(Calendar.YEAR));
	        resultado = consulta.executeQuery();
	        while (resultado.next()) {

	        	long idDeposito = resultado.getLong("id_deposito");
		        int quantidadeDeposito = resultado.getInt("quantidade_deposito"); 
		        long retornavelDeposito = resultado.getLong("retornavel_deposito");
		        depositos.add(new Deposito(idDeposito, dataDeposito, quantidadeDeposito, retornavelDeposito));
	            

	         
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

	    return depositos;
	
	}
    
	public List<Deposito> recuperarDepositoDataAtual(){
		Connection conexao = null;
		PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    List<Deposito> depositos = new ArrayList<Deposito>();

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM deposito where DAYOFMONTH(data_deposito) == ? and MONTH(data_deposito) == ? and YEAR(data_deposito) == ? ");
	        Calendar dataAtual =  Calendar.getInstance();
	        consulta.setInt(1, dataAtual.get(Calendar.DAY_OF_MONTH));
	        consulta.setInt(2, dataAtual.get(Calendar.MONTH));
	        consulta.setInt(3, dataAtual.get(Calendar.YEAR));
	        resultado = consulta.executeQuery();
	        
	        while (resultado.next()) {
	        	
		        	
		        long idDeposito = resultado.getLong("id_deposito");
		        Date dataDeposito = (java.util.Date) resultado.getDate("date_deposito");
		        int quantidadeDeposito = resultado.getInt("quantidade_deposito"); 
		        long retornavelDeposito = resultado.getLong("retornavel_deposito");
		        depositos.add(new Deposito(idDeposito, dataDeposito, quantidadeDeposito, retornavelDeposito));
	            

	         
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

	    return depositos;
	
	}

	public Deposito recuperarDepositoId(long idDeposito) {
		Connection conexao = null;
	    PreparedStatement consulta = null;
	    ResultSet resultado = null;
	    Deposito deposito = null;

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM deposito where id_deposito == ? ");
	        consulta.setLong(1, idDeposito);
	        resultado = consulta.executeQuery();
	   
	            Date dataDeposito = resultado.getDate("date_deposito");
	            int quantidadeDeposito = resultado.getInt("quantidade_deposito"); 
	            long retornavelDeposito = resultado.getLong("retornavel_deposito");
	            deposito = new Deposito( idDeposito, dataDeposito, quantidadeDeposito, retornavelDeposito);
	            

	         
	        

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

	 return deposito;
	}
	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/returnit?user=root&password=root");
	}
}
