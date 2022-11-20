package br.sc.senac.returnit.modelo.dao.endereco;

import br.sc.senac.returnit.modelo.entidade.endereco.Endereco;

public interface EnderecoDAO {
	
    void inserirEndereco(Endereco endereco);

    void deletarEndereco(Endereco endereco);

    void atualizarNumero(Endereco endereco, short novoNumero);

    void atualizarLogradouro(Endereco endereco, String novoLogradouro);

    void atualizarComplemento(Endereco endereco, String novoComplemento);

    Endereco recuperarEnderecoId();
    
}
 