import br.sc.senac.returnit.modelo.dao.contato.ContatoDAOImp;
import br.sc.senac.returnit.modelo.dao.endereco.EnderecoDAOImp;
import br.sc.senac.returnit.modelo.dao.usuario.UsuarioDAOImpl;
import br.sc.senac.returnit.modelo.entidade.contato.Contato;
import br.sc.senac.returnit.modelo.entidade.empresa.Empresa;
import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;
import br.sc.senac.returnit.modelo.entidade.usuario.Usuario;

public class teste {

	public static void main(String[] args) {
		Endereco endereco = new Endereco();
		endereco.setBairro("bairro");
		endereco.setComplemento("complemento");
		endereco.setLogradouro("logradouro");
		endereco.setNumero((short) 123);

		EnderecoDAOImp enderecodao = new EnderecoDAOImp();

		enderecodao.inserirEndereco(endereco);
// criei um objeto endereço e inseri ele, o código automaticamente seta o ID para mim

		Contato contato = new Contato();
		contato.setEmail("email");
		contato.setTelefone("12345667412");

		ContatoDAOImp contatodao = new ContatoDAOImp();
		contatodao.inserirContato(contato);
// inserindo contato

// agora, tendo criado estes dois objetos, utilizarei eles para inserir como chave estrangeira 

		Usuario usuario = new Usuario();
		usuario.setContato(contato); // objeto contato
		usuario.setEndereco(endereco); // objeto endereco
		usuario.setNome("leonardo");
		usuario.setSenha("senha");

		UsuarioDAOImpl usuariodao = new UsuarioDAOImpl();
		usuariodao.inserirUsuario(usuario);

	Empresa empresa = new Empresa();
	empresa.setCnpj("cnpj");
	empresa.setId(usuario.getId());
	
	
	}

}
