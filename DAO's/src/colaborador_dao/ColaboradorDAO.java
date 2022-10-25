package colaborador_dao;

import java.util.List;
import Principal.Colaborador;

public interface ColaboradorDAO {

	void cadastrarColaborador(Colaborador colaborador);

	void editarColaborador(Colaborador colaborador);
	
	void deletarColaborador(Colaborador colaborador);
	
	List<Colaborador> recuperarColaborador();
}
