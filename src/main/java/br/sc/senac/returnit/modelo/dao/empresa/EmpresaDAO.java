package br.sc.senac.returnit.modelo.dao.empresa;
import java.util.List;
import br.sc.senac.returnit.modelo.entidade.empresa.*;
public interface EmpresaDAO {

		void inserirEmpresa(Empresa Empresa);

		void deletarEmpresa(Empresa Empresa);

		void atualizarCnpjEmpresa(Empresa Empresa, String novoCnpj);

		void atualizarIdUsuario(Empresa Empresa, long novoIdUsuario);

		List<Empresa> recuperarEmpresas();

		Empresa recuperarEmpresaIdUsuario(long IdUsuario);
		
		Empresa recuperarCnpjEmpresa(String cnpjEmpresa);
		
}

