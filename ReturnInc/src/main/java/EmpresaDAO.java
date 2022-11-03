package modelo;
import java.util.List;
//import exemplo.modelo.entidade.cliente.Cliente;
//package exemplo.modelo.dao.cliente;
public class EmpresaDAO {

	

		void inserirEmpresa(Empresa empresa);

		void deletarEmpresa(Empresa empresa);

		void atualizarCnpj(Empresa empresa, String novoCnpj);

		void atualizarMarca(Empresa empresa, String novaMarca);

		void atualizarRetornavel(Empresa empresa,Retornavel retornavel);

		void atualizarEndereco(Empresa empresa,Endereco endereco);

		List<Empresa> recuperarEmpresa();

		List<Empresa> recuperarEmpresaOrdenadosMarcaAscendente();

		List<Empresa> recuperarEmpresaOrdenadosMarcaDescendente();

		List<Empresa> recuperarEmpresaOrdenadosCnpjAscendente();

		List<Empresa> recuperarEmpresaOrdenadosCnpjDescendente();
		
	}


