package br.sc.senac.returnit.modelo.entidade.agendamentoRetornavel;



public class AgendamentoRetornavel {



   private int quantidade;
    private long idRetornavel;
    private long idAgendamento;
    
    public AgendamentoRetornavel(int quantidade, long idRetornavel, long idAgendamento) {
        setQuantidade(quantidade);
        setIdRetornavel(idRetornavel);
        setIdAgendamento(idAgendamento);
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public long getIdRetornavel() {
        return idRetornavel;
    }
    public void setIdRetornavel(long idRetornavel) {
        this.idRetornavel = idRetornavel;
    }
    public long getIdAgendamento() {
        return idAgendamento;
    }
    public void setIdAgendamento(long idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
}