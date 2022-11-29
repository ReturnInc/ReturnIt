package br.sc.senac.returnit.modelo.dao.agendamentoRetornavel;



import br.sc.senac.returnit.modelo.entidade.agendamentoRetornavel.AgendamentoRetornavel;



public interface AgendamentoRetornavelDAO {
    
    void inserirAgendamentoRetornavel(AgendamentoRetornavel agendamentoRetornavel);
    
    void deletarAgendamentoRetornavel(AgendamentoRetornavel agendamentoRetornavel);
    
    void atualizarQuantidade(AgendamentoRetornavel agendamentoRetornavel, int novaQuantidade);
    
    void atualizarIdRetornavel(AgendamentoRetornavel agendamentoRetornavel, long novoIdRetornavel);
    
    void atualizarIdAgendamento(AgendamentoRetornavel agendamentoRetornavel, long novoIdAgendamento);
    
    boolean verificarDeleteAgendamento(long idAgendamento);
}