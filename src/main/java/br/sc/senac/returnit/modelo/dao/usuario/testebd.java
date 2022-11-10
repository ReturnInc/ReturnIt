package br.sc.senac.returnit.modelo.dao.usuario;
import br.sc.senac.returnit.entidade.usuario.Usuario;
public class testebd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario allan = new Usuario((long) 9, "etsw", "12345671", "Masculino", (long)1);
		UsuarioDAO dao = new UsuarioDAOImpl();	
		dao.inserirUsuario(allan);
	
	
	}

	

	
}

