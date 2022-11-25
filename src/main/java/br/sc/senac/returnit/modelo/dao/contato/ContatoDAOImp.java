package br.sc.senac.returnit.modelo.dao.contato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.sc.senac.returnit.modelo.entidade.contato.Contato;

public class ContatoDAOImp implements ContatoDAO{
	
	public void inserirContato(Contato contato){

	    Connection conexao = null;
	    PreparedStatement insert = null;

	    try {

	        conexao = conectarBanco();
	        insert = conexao.prepareStatement("INSERT INTO contato (telefone_contato, email_contato) VALUES (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
	        insert.setString(1, contato.getTelefone());
	        insert.setString(2,contato.getEmail());

	        insert.execute();


			ResultSet chavePrimaria = insert.getGeneratedKeys();

			if (chavePrimaria.next())
				contato.setIdContato(chavePrimaria.getLong(1));
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
	public void deletarContato(Contato contato) {
	    
	    Connection conexao = null;
	    PreparedStatement delete = null;

	    try {

	        conexao = conectarBanco();
	        delete = conexao.prepareStatement("DELETE FROM contato WHERE id_contato = ?");

	        delete.setLong(1, contato.getIdContato());

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
    
	public void atualizarTelefoneContato(Contato contato, String novoTelefoneContato) {
		Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE contato SET telefone_contato = ? WHERE id_contato = ?");
	        
	        update.setString(1, novoTelefoneContato);
	        update.setLong(2, contato.getIdContato());

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

	public void atualizarEmail(Contato contato, String novoEmailContato) {
		Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE contato SET email_contato = ? WHERE id_contato = ?");
	        
	        update.setString(1, novoEmailContato);
	        update.setLong(2, contato.getIdContato());

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

    public Contato recuperarContatoId(long idContato){
    	Connection conexao = null;
    	PreparedStatement consulta = null;
 	    ResultSet resultado = null;

 	    Contato contato = null;

 	    try {

 	        conexao = conectarBanco();
 	        consulta = conexao.prepareStatement("SELECT * FROM contato where id_contato = ?");
 	       consulta.setLong(1, idContato);
 	       String aux = "SELECT * FROM contato where id_contato = "+idContato;
 	        resultado = consulta.executeQuery(aux);
 	       if(resultado.next()){
 	        
 	        String telefoneContato = resultado.getString("telefone_contato");
 	        String emailContato = resultado.getString("email_contato");
 	       contato = new Contato(idContato, telefoneContato, emailContato);
 	       
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

 	    return contato;
    	
    }
    private Connection conectarBanco() throws SQLException {
    	return DriverManager.getConnection("jdbc:mysql://localhost/returnit?user=root&password=root");
    }
}
