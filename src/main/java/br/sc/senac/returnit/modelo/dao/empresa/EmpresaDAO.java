package br.sc.senac.returnit.modelo.dao.empresa;
import java.util.List;
import br.sc.senac.returnit.modelo.entidade.empresa.*;
public interface EmpresaDAO {

		void inserirEmpresa(Empresa Empresa);

		void deletarEmpresa(Empresa Empresa);

		void atualizarNomeEmpresa(Empresa Empresa, String novoNome);

		void atualizarCpfEmpresa(Empresa Empresa, String novoCpf);

		void atualizarIdadeEmpresa(Empresa Empresa, int novaIdade);

		void atualizarDividaEmpresa(Empresa Empresa, double novaDivida);

		List<Empresa> recuperarEmpresas();

		List<Empresa> recuperarEmpresasOrdenadosNomeAscendente();

		List<Empresa> recuperarEmpresasOrdenadosNomeDescendente();

		List<Empresa> recuperarEmpresasOrdenadosCpfAscendente();

		List<Empresa> recuperarEmpresasOrdenadosCpfDescendente();
		
		List<Empresa> recuperarEmpresasOrdenadosIdadeAscendente();

		List<Empresa> recuperarEmpresasOrdenadosIdadeDescendente();
		
		List<Empresa> recuperarEmpresasOrdenadosDividaAscendente();

		List<Empresa> recuperarEmpresasOrdenadosDividaDescendente();
		
		Empresa recuperarEmpresaPorCnpj(String cnpjEmpresa);
}

