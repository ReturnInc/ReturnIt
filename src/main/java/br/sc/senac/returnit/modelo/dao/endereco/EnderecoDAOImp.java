package br.sc.senac.returnit.modelo.dao.endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;

public class EnderecoDAOImp {
	public void inserirEndereco(Endereco endereco) {

	    Connection conexao = null;
	    PreparedStatement insert = null;

	    try {

	        conexao = conectarBanco();
	        insert = conexao.prepareStatement("INSERT INTO endereco (numero_endereco, logradouro_endereco, complemento_endereco) VALUES (?,?,?)");
	        
	        insert.setShort(1, endereco.getNumero());
	        insert.setString(2, endereco.getLogradouro());
	        insert.setString(3, endereco.getComplemento());

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

    public void deletarEndereco(Endereco endereco) {
    	  
	    Connection conexao = null;
	    PreparedStatement delete = null;

	    try {

	        conexao = conectarBanco();
	        delete = conexao.prepareStatement("DELETE FROM endereco WHERE id_endereco = ?");

	        delete.setLong(1, endereco.getIdEndereco());

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
    
    public void atualizarNumero(Endereco endereco, short novoNumero) {
    	Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE endereco SET numero_endereco = ? WHERE id_endereco = ?");
	        
	        update.setShort(1, novoNumero);
	        update.setLong(2, endereco.getIdEndereco());

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

    public void atualizarLogradouro(Endereco endereco, String novoLogradouro){
    	Connection conexao = null;
	    PreparedStatement update = null;

	    try {

	        conexao = conectarBanco();
	        update = conexao.prepareStatement("UPDATE endereco SET logradouro_endereco = ? WHERE id_endereco = ?");
	        
	        update.setString(1, novoLogradouro);
	        update.setLong(2, endereco.getIdEndereco());

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
   public void atualizarComplemento(Endereco endereco, String novoComplemento) {
    Connection conexao = null;
    PreparedStatement update = null;

    try {

        conexao = conectarBanco();
        update = conexao.prepareStatement("UPDATE endereco SET complemento_endereco = ? WHERE id_endereco = ?");
        
        update.setString(1, novoComplemento);
        update.setLong(2, endereco.getIdEndereco());

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
    public Endereco recuperarEnderecoId(long idEndereco) {
 		Connection conexao = null;
 		PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    Endereco endereco = null;

	    try {

	        conexao = conectarBanco();
	        consulta = conexao.prepareStatement("SELECT * FROM endereco where id_endereco == ? ");
	        consulta.setLong(1, idEndereco);
	        resultado = consulta.executeQuery();
	       
	        short numero = resultado.getShort("numero_endereco");
	        String logradouro = resultado.getString("logradouro_endereco");
	        String complemento = resultado.getString("complemento_endereco");
	        endereco = new Endereco(idEndereco, numero, logradouro, complemento);

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

	    return endereco;
	
}
    
    private Connection conectarBanco() throws SQLException {
    	return DriverManager.getConnection("jdbc:mysql://localhost/returnit?user=root&password=root");
}}
