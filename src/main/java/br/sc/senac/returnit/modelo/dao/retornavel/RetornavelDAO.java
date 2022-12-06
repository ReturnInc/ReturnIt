package br.sc.senac.returnit.modelo.dao.retornavel;
import java.util.List;
import br.sc.senac.returnit.modelo.entidade.retornavel.*;
public interface RetornavelDAO {

		void inserirRetornavel(Retornavel retornavel);

		void deletarRetornavel(Retornavel retornavel);

		void atualizarMaterial(Retornavel retornavel, String novoMaterial);

		void atualizarModeloRetornavel(Retornavel retornavel, String novoModeloRetornavel);

		void atualizarMarcaRetornavel(Retornavel retornavel, String novaMarcaRetornavel);

		void atualizarCnpjEmpresa(Retornavel retornavel, String novoCnpjEmpresa);

		List<Retornavel> recuperarRetornaveis();

		Retornavel recuperarRetornavelId(long idRetornavel);
		
		List<Retornavel> recuperarRetornaveisCnpj(String cnpjEmpresa);
	}
