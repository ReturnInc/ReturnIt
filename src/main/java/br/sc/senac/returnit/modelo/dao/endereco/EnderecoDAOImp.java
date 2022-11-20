package br.sc.senac.returnit.modelo.dao.endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.sc.senac.returnit.modelo.entidade.contato.Contato;
import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;

public class EnderecoDAOImp {
	public void inserirEndereco(Endereco endereco) {

	    Connection conexao = null;
	    PreparedStatement insert = null;

	    try {

	        conexao = conectarBanco();
	        insert = conexao.prepareStatement("INSERT INTO endereco (numero_casa_endereco, logradouro_endereco, complemento_endereco,bairro_endereco) VALUES (?,?,?,?)",
	        		PreparedStatement.RETURN_GENERATED_KEYS);
	        
	        insert.setShort(1, endereco.getNumero());
	        insert.setString(2, endereco.getLogradouro());
	        insert.setString(3, endereco.getComplemento());
	        insert.setString(4, endereco.getBairro());

	        insert.execute();
	        ResultSet chavePrimaria = insert.getGeneratedKeys();

			if (chavePrimaria.next())
				endereco.setIdEndereco(chavePrimaria.getLong(1));
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
	        update = conexao.prepareStatement("UPDATE endereco SET numero_casa_endereco = ? WHERE id_endereco = ?");
	        
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
 	        consulta = conexao.prepareStatement("SELECT * FROM endereco where id_contato = ?");
 	       consulta.setLong(1, idEndereco);
 	       String aux = "SELECT * FROM endereco where id_endereco = "+idEndereco;
 	        resultado = consulta.executeQuery(aux);
 	       if(resultado.next()){
	        
 	    	   short numero = resultado.getShort("numero_casa_endereco");
	        String logradouro = resultado.getString("logradouro_endereco");
	        String complemento = resultado.getString("complemento_endereco");
	        String bairro = resultado.getString("bairro_endereco");
	        endereco = new Endereco(bairro,idEndereco, numero, logradouro, complemento);
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

	    return endereco;
	
}
    
    private Connection conectarBanco() throws SQLException {
    	return DriverManager.getConnection("jdbc:mysql://localhost/returnit?user=root&password=root");
}}
