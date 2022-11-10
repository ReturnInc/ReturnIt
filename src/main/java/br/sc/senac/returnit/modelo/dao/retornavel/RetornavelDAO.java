package br.sc.senac.returnit.modelo.dao.retornavel;
import java.util.List;
import br.sc.senac.returnit.modelo.entidade.retornavel.*;
public interface RetornavelDAO {

		void inserirRetornavel(Retornavel retornavel);

		void deletarRetornavel(Retornavel retornavel);

		void atualizar(Retornavel retornavel, String novoNome);

		void atualizar(Retornavel retornavel, String novoCpf);

		void atualizar(Retornavel retornavel, int novaIdade);

		void atualizar(Retornavel retornavel, double novaDivida);

		List<Retornavel> recuperarClientes();

		List<Retornavel> recuperarClientesOrdenadosNomeAscendente();

		List<Retornavel> recuperarClientesOrdenadosNomeDescendente();

		List<Retornavel> recuperarClientesOrdenadosCpfAscendente();

		List<Retornavel> recuperarClientesOrdenadosCpfDescendente();
		
		List<Retornavel> recuperarClientesOrdenadosIdadeAscendente();

		List<Retornavel> recuperarClientesOrdenadosIdadeDescendente();
		
		List<Retornavel> recuperarClientesOrdenadosDividaAscendente();

		List<Retornavel> recuperarClientesOrdenadosDividaDescendente();
	}
