package br.sc.senac.returnit.modelo.dao.agendamento;

import java.util.List;
import java.util.Date;

import br.sc.senac.returnit.modelo.entidade.agendamento.*;

public interface AgendamentoDAO {
	
	void inserirAgendamento(Agendamento agendamento);

    void deletarAgendamento(Agendamento agendamento);
    
    void atualizarRealizadoAgendamento(Agendamento agendamento, boolean realizado);

    void atualizarDataAgendamento(Agendamento agendamento, Date dataAgendamento);

    void atualizarIdEmpresa(Agendamento agendamento, long novoIdEmpreas);
    
    void atualizarIdCooperado(Agendamento agendamento, long novoIdContato);

    List<Agendamento> recuperarAgendamentos();
    
    List<Agendamento> recuperarAgendamentoIdEmpresa(long idEmpresa);
    
    List<Agendamento> recuperarAgendamentoIdEmpresaDataAtual(long idEmpresa);
    
    List<Agendamento> recuperarAgendamentoIdEmpresaPeriodo(long idEmpresa, Date dataInicio, Date dataFim);
    
    List<Agendamento> recuperarAgendamentoIdEmpresaRealizado(long idEmpresa, boolean realizado);
    
    List<Agendamento> recuperarAgendamentoIdEmpresaRealizadoPeriodo(long idEmpresa, boolean realizado, Date dataIncio, Date dataFim);
    
    List<Agendamento> recuperarAgendamentoDataAtual();
    
    List<Agendamento> recuperarAgendamentoPeriodo(Date dataInicio, Date dataFim);
    
    List<Agendamento> recuperarAgendamentoRealizados(boolean realizado);
    
    List<Agendamento> recuperarAgendamentoRealizadosPeriodo(boolean realizado,  Date dataInicio, Date dataFim);
    
    Agendamento recuperarAgendamentoId(long idAgendamento);

}
